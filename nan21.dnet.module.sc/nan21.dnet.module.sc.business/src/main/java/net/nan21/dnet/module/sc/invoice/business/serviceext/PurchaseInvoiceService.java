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
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.sc._businessdelegates.invoice.PurchaseInvoiceToAccDocBD;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceService;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseTxAmountService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
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
		IPurchaseTxAmountService amountsService = (IPurchaseTxAmountService) this
				.findEntityService(PurchaseTxAmount.class);
		if (amountsService.findByInvoice(invoice).size() == 0) {
			List<PurchaseTxAmount> amounts = this.createTxAmounts(invoice);
			amountsService.insert(amounts);
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
		txAmountsService.deleteByIds(this.collectIds(amounts));
		invoice.setConfirmed(false);
		this.getEntityManager().merge(invoice);

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

		// if (invoice.getSelfPayed()) {
		// txAmount.setDueAmount(0F);
		// txAmount.setPayedAmount(invoice.getTotalAmount());
		// }
		result.add(txAmount);
		return result;
	}

}
