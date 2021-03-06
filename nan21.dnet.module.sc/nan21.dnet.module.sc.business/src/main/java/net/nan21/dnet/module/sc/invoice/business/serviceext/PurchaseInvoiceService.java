/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.serviceext;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountMethod;
import net.nan21.dnet.module.sc._businessdelegates.invoice.PurchaseInvoiceCreateLines;
import net.nan21.dnet.module.sc._businessdelegates.invoice.PurchaseInvoiceToAccDocBD;
import net.nan21.dnet.module.sc.invoice.business.service.IPaymentOutAmountService;
import net.nan21.dnet.module.sc.invoice.business.service.IPaymentOutService;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceService;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseTxAmountService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOutAmount;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceTax;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;

/**
 * Business extensions specific for {@link PurchaseInvoice} domain entity.
 * 
 */
public class PurchaseInvoiceService
		extends
		net.nan21.dnet.module.sc.invoice.business.serviceimpl.PurchaseInvoiceService
		implements IPurchaseInvoiceService {

	/**
	 * Confirm document. Generate transaction amounts information.
	 */
	@Override
	public void doConfirm(PurchaseInvoice invoice) throws BusinessException {

		IPurchaseTxAmountService txAmountsService = (IPurchaseTxAmountService) this
				.findEntityService(PurchaseTxAmount.class);

		List<PurchaseTxAmount> txAmounts = null;

		// create tx-amounts
		if (txAmountsService.findByInvoice(invoice).size() == 0) {
			txAmounts = this.createTxAmounts(invoice);
			txAmountsService.insert(txAmounts);
		}

		// create payment
		if (invoice.getSelfPayed().booleanValue() == true) {

			if (invoice.getFromAccount() == null) {
				throw new BusinessException(
						"Financial account must be specified for self-payed document `"
								+ invoice.getCode() + "`");
			}

			IPaymentOutService paymentService = (IPaymentOutService) this
					.findEntityService(PaymentOut.class);

			IPaymentOutAmountService paymentAmountsService = (IPaymentOutAmountService) this
					.findEntityService(PaymentOutAmount.class);

			List<PaymentOutAmount> paymentAmounts = new ArrayList<PaymentOutAmount>();

			PaymentOut payment = this.createPayment(invoice);
			paymentService.insert(payment);

			PaymentOutAmount pa = new PaymentOutAmount();
			pa.setPayment(payment);
			pa.setAmount(payment.getAmount());
			pa.setTxAmount(txAmounts.get(0));
			paymentAmounts.add(pa);

			paymentAmountsService.insert(paymentAmounts);

			payment.setConfirmed(true);
			paymentService.update(payment);

		}
		invoice.setConfirmed(true);
		this.getEntityManager().merge(invoice);
	}

	/**
	 * Un-confirm document. Remove the transaction amounts information.
	 */
	@Override
	public void doUnConfirm(PurchaseInvoice invoice) throws BusinessException {
		IPurchaseTxAmountService txAmountsService = (IPurchaseTxAmountService) this
				.findEntityService(PurchaseTxAmount.class);
		List<PurchaseTxAmount> amounts = txAmountsService
				.findByInvoiceId(invoice.getId());
		List<Object> txAmountIds = this.collectIds(amounts);
		txAmountsService.deleteByIds(txAmountIds);

		// remove generated payment
		if (invoice.getSelfPayed().booleanValue() == true) {
			IPaymentOutService paymentService = (IPaymentOutService) this
					.findEntityService(PaymentOut.class);
			List<PaymentOut> payments = this
					.getEntityManager()
					.createQuery(
							"select p from PaymentOut p where p.id in (select e.payment.id from PaymentOutAmount e where e.txAmount.id in :pIds ) ",
							PaymentOut.class).setParameter("pIds", txAmountIds)
					.getResultList();

			for (PaymentOut payment : payments) {
				paymentService.doUnConfirm(payment);
			}
			paymentService.deleteByIds(this.collectIds(payments));
		}
		invoice.setConfirmed(false);
		this.getEntityManager().merge(invoice);
	}

	@Override
	public void doPost(PurchaseInvoice invoice) throws BusinessException {
		this.getBusinessDelegate(PurchaseInvoiceToAccDocBD.class).post(invoice);
	}

	@Override
	public void doUnPost(PurchaseInvoice invoice) throws BusinessException {
		this.getBusinessDelegate(PurchaseInvoiceToAccDocBD.class).unPost(
				invoice);
	}

	protected List<PurchaseTxAmount> createTxAmounts(PurchaseInvoice invoice) {
		PaymentTerm paymentTerm = invoice.getPaymentTerm();
		List<PurchaseTxAmount> result = new ArrayList<PurchaseTxAmount>();

		PurchaseTxAmount txAmount = new PurchaseTxAmount();

		txAmount.setBpartner(invoice.getSupplier());
		txAmount.setOrg(invoice.getCustomer());
		txAmount.setInvoice(invoice);
		txAmount.setCurrency(invoice.getCurrency());
		txAmount.setSales(false);
		txAmount.setAmount(invoice.getTotalAmount());
		txAmount.setDueAmount(invoice.getTotalAmount());
		txAmount.setPayedAmount(0F);

		if (paymentTerm != null) {
			DateTime dueDate = new DateTime(invoice.getDocDate())
					.plusDays(paymentTerm.getDays());
			txAmount.setPaymentMethod(invoice.getPaymentMethod());
			txAmount.setDueDate(dueDate.toDate());
		} else {
			txAmount.setDueDate(invoice.getDocDate());
		}

		result.add(txAmount);
		return result;
	}

	protected PaymentOut createPayment(PurchaseInvoice invoice)
			throws BusinessException {

		PaymentOut payment = new PaymentOut();

		payment.setBpartner(invoice.getSupplier());
		payment.setCurrency(invoice.getCurrency());
		payment.setFromOrg(invoice.getCustomer());
		payment.setDocDate(invoice.getDocDate());
		payment.setDocNo(invoice.getDocNo());
		payment.setAmount(invoice.getTotalAmount());
		payment.setFromAccount(invoice.getFromAccount());
		if (invoice.getPaymentMethod() != null) {
			payment.setPaymentMethod(invoice.getPaymentMethod());
		} else {

			for (FinancialAccountMethod m : invoice.getFromAccount()
					.getMethods()) {
				if (m.getAllowPayOut()) {
					payment.setPaymentMethod(m.getPayMethod());
				}
			}
			if (payment.getPaymentMethod() == null) {
				throw new BusinessException("Financial account `"
						+ invoice.getFromAccount().getName()
						+ "` doesn't allow out-payment transactions.");
			}
		}

		payment.setGenerated(true);

		return payment;
	}

	@Override
	public void doCopyLines(PurchaseInvoice target, Long sourceId)
			throws BusinessException {
		this.getBusinessDelegate(PurchaseInvoiceCreateLines.class).copyLines(
				target, sourceId);
	}

	@Override
	public void calculateAmounts(Long invoiceId) {
		this.getEntityManager().flush();
		Object[] x = (Object[]) this
				.getEntityManager()
				.createQuery(
						"select sum(i.netAmount), sum(i.taxAmount) from PurchaseInvoiceItem i "
								+ "where i.purchaseInvoice.id = :invoiceId")
				.setParameter("invoiceId", invoiceId).getSingleResult();
		PurchaseInvoice invoice = this.getEntityManager().find(
				PurchaseInvoice.class, invoiceId);

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
						"delete from PurchaseInvoiceTax t "
								+ " where t.purchaseInvoice.id = :invoiceId")
				.setParameter("invoiceId", invoiceId).executeUpdate();

		// create new

		@SuppressWarnings("unchecked")
		List<Object[]> taxes = (List<Object[]>) this
				.getEntityManager()
				.createQuery(
						"select i.tax,  sum(i.baseAmount), sum(i.taxAmount) from PurchaseInvoiceItemTax i "
								+ " where i.purchaseInvoiceItem.purchaseInvoice.id = :invoiceId "
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

			PurchaseInvoiceTax invTax = new PurchaseInvoiceTax();
			invTax.setPurchaseInvoice(invoice);
			invTax.setTax(t);
			invTax.setBaseAmount(baseval.floatValue());
			invTax.setTaxAmount(taxval.floatValue());
			invoice.addToTaxes(invTax);
		}

		this.getEntityManager().merge(invoice);
	}

}
