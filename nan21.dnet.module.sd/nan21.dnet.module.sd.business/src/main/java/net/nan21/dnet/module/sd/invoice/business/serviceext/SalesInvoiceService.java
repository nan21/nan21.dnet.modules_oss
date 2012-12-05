/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.serviceext;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.sd._businessdelegates.invoice.SalesInvoiceCreateLines;
import net.nan21.dnet.module.sd._businessdelegates.invoice.SalesInvoiceToAccDocBD;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceService;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesTxAmountService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;

/**
 * Business extensions specific for {@link SalesInvoice} domain entity.
 * 
 */
public class SalesInvoiceService
		extends
		net.nan21.dnet.module.sd.invoice.business.serviceimpl.SalesInvoiceService
		implements ISalesInvoiceService {

	@Override
	public void doConfirm(SalesInvoice invoice) throws BusinessException {

		ISalesTxAmountService amountsService = (ISalesTxAmountService) this
				.findEntityService(SalesTxAmount.class);
		if (amountsService.findByInvoice(invoice).size() == 0) {
			List<SalesTxAmount> amounts = this.createTxAmounts(invoice);
			amountsService.insert(amounts);
		}
		invoice.setConfirmed(true);
		this.getEntityManager().merge(invoice);
	}

	@Override
	public void doUnConfirm(SalesInvoice invoice) throws BusinessException {
		ISalesTxAmountService txAmountsService = (ISalesTxAmountService) this
				.findEntityService(SalesTxAmount.class);
		List<SalesTxAmount> amounts = txAmountsService.findByInvoiceId(invoice
				.getId());
		txAmountsService.deleteByIds(this.collectIds(amounts));
		invoice.setConfirmed(false);
		this.getEntityManager().merge(invoice);
	}

	@Override
	public void doPost(SalesInvoice invoice) throws BusinessException {
		this.getBusinessDelegate(SalesInvoiceToAccDocBD.class).post(invoice);
	}

	@Override
	public void doUnPost(SalesInvoice invoice) throws BusinessException {
		this.getBusinessDelegate(SalesInvoiceToAccDocBD.class).unPost(invoice);
	}

	@Override
	public void doCopyLines(SalesInvoice target, Long sourceId)
			throws BusinessException {

		this.getBusinessDelegate(SalesInvoiceCreateLines.class).copyLines(
				target, sourceId);
	}

	@Override
	public void calculateAmounts(Long invoiceId) {
		this.getEntityManager().flush();
		Object[] x = (Object[]) this
				.getEntityManager()
				.createQuery(
						"select sum(i.netAmount), sum(i.taxAmount) from SalesInvoiceItem i where i.salesInvoice.id = :invoiceId")
				.setParameter("invoiceId", invoiceId).getSingleResult();
		SalesInvoice invoice = this.getEntityManager().find(SalesInvoice.class,
				invoiceId);

		Double totalNet = (Double) x[0];
		Double totalTax = (Double) x[1];
		if (totalNet == null) {
			totalNet = 0D;
		}
		if (totalTax == null) {
			totalTax = 0D;
		}
		invoice.setTotalNetAmount(totalNet.floatValue());
		invoice.setTotalTaxAmount(totalTax.floatValue());

		// re-create taxes
		// delete existing
		this.getEntityManager()
				.createQuery(
						"delete from " + SalesInvoiceTax.class.getSimpleName()
								+ " t "
								+ " where t.salesInvoice.id = :invoiceId")
				.setParameter("invoiceId", invoiceId).executeUpdate();

		// create new

		@SuppressWarnings("unchecked")
		List<Object[]> taxes = (List<Object[]>) this
				.getEntityManager()
				.createQuery(
						"select i.tax,  sum(i.baseAmount), sum(i.taxAmount) from "
								+ SalesInvoiceItemTax.class.getSimpleName()
								+ " i "
								+ " where i.salesInvoiceItem.salesInvoice.id = :invoiceId "
								+ " group by i.tax ")
				.setParameter("invoiceId", invoiceId).getResultList();
		for (Object[] tax : taxes) {
			Tax t = (Tax) tax[0];
			Double baseval = (Double) tax[1];
			Double taxval = (Double) tax[2];
			if (baseval == null) {
				baseval = 0D;
			}
			if (taxval == null) {
				taxval = 0D;
			}

			SalesInvoiceTax invTax = new SalesInvoiceTax();
			invTax.setSalesInvoice(invoice);
			invTax.setTax(t);
			invTax.setBaseAmount(baseval.floatValue());
			invTax.setTaxAmount(taxval.floatValue());
			invoice.addToTaxes(invTax);
		}

		this.getEntityManager().merge(invoice);
	}

	protected List<SalesTxAmount> createTxAmounts(SalesInvoice invoice) {
		PaymentTerm paymentTerm = invoice.getPaymentTerm();
		List<SalesTxAmount> result = new ArrayList<SalesTxAmount>();
		if (paymentTerm != null) {
			DateTime dueDate = new DateTime(invoice.getDocDate())
					.plusDays(paymentTerm.getDays());

			SalesTxAmount txAmount = new SalesTxAmount();

			txAmount.setBpartner(invoice.getCustomer());
			txAmount.setOrg(invoice.getSupplier());
			txAmount.setInvoice(invoice);
			txAmount.setSales(true);
			txAmount.setCurrency(invoice.getCurrency());
			txAmount.setPaymentMethod(invoice.getPaymentMethod());
			txAmount.setDueDate(dueDate.toDate());

			txAmount.setAmount(invoice.getTotalAmount());
			txAmount.setDueAmount(invoice.getTotalAmount());
			txAmount.setPayedAmount(0F);

			result.add(txAmount);
		}
		return result;
	}
}
