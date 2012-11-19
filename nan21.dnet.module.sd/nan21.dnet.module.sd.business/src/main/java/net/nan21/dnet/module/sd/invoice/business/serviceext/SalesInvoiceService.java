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
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.sd._businessdelegates.invoice.SalesInvoiceToAccDocBD;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceService;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesTxAmountService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
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
		invoice.setConfirmed(true);
		ISalesTxAmountService amountsService = (ISalesTxAmountService) this
				.findEntityService(SalesTxAmount.class);
		if (amountsService.findByInvoice(invoice).size() == 0) {
			List<SalesTxAmount> amounts = this.createTxAmounts(invoice);
			amountsService.insert(amounts);
		}
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
