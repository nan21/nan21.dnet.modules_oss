/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.ds.serviceext;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.action.IQueryBuilder;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.presenter.service.ds.AbstractEntityDsService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;
import net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountPaymentProposalDsFilter;
import net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountPaymentProposalDs;
import net.nan21.dnet.module.sc.invoice.ds.model.PurchaseTxAmountPaymentProposalDsParam;
import net.nan21.dnet.module.sc.invoice.business.service.IPaymentOutService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOutAmount;

public class PurchaseTxAmountPaymentProposalDsService
		extends
		AbstractEntityDsService<PurchaseTxAmountPaymentProposalDs, PurchaseTxAmountPaymentProposalDsFilter, PurchaseTxAmountPaymentProposalDsParam, PurchaseTxAmount>
		implements
		IDsService<PurchaseTxAmountPaymentProposalDs, PurchaseTxAmountPaymentProposalDsFilter, PurchaseTxAmountPaymentProposalDsParam> {

	/**
	 * Instead of update, create payment-amounts from the list of due amounts.
	 * Process only those which specify a not null payment.
	 */
	@Override
	public void update(List<PurchaseTxAmountPaymentProposalDs> list,
			PurchaseTxAmountPaymentProposalDsParam params) throws Exception {

		IPaymentOutService srv = (IPaymentOutService) this
				.findEntityService(PaymentOut.class);
		List<PurchaseTxAmount> entities = this.getEntityService().findByIds(
				this.collectIds(list));

		List<PaymentOutAmount> paymentAmounts = new ArrayList<PaymentOutAmount>();
		PaymentOut payment = srv.findById(params.getPaymentId());

		if (payment.getConfirmed()) {
			throw new BusinessException(
					"Cannot add details to a confirmed payment. Un-confirm it first.");
		}
		Float currentPaymentSum = 0F;
		for (PurchaseTxAmountPaymentProposalDs ds : list) {
			if (ds.getCurrentPayment() != null && ds.getCurrentPayment() != 0) {
				PaymentOutAmount pa = new PaymentOutAmount();
				pa.setPayment(payment);
				pa.setAmount(ds.getCurrentPayment());
				pa.setTxAmount(lookupEntityById(entities, ds.getId()));
				paymentAmounts.add(pa);
				currentPaymentSum += ds.getCurrentPayment();
			}
		}
		// do not use more than is received
		if (currentPaymentSum > payment.getAmount()) {
			throw new BusinessException(
					"Cannot process payment details. Payed amount ("
							+ payment.getAmount()
							+ ") is less than the sum of distributed amounts ( "
							+ currentPaymentSum + ").");
		}
		// leave the unused difference as a prepayment
		if (currentPaymentSum < payment.getAmount()) {
			PaymentOutAmount pa = new PaymentOutAmount();
			pa.setPayment(payment);
			pa.setAmount(payment.getAmount() - currentPaymentSum);
			paymentAmounts.add(pa);
		}

		this.findEntityService(PaymentOutAmount.class).insert(paymentAmounts);
		((IPaymentOutService) this.findEntityService(PaymentOut.class))
				.doConfirm(payment);
	}

	@Override
	protected void postFind(
			IQueryBuilder<PurchaseTxAmountPaymentProposalDs, PurchaseTxAmountPaymentProposalDsFilter, PurchaseTxAmountPaymentProposalDsParam> builder,
			List<PurchaseTxAmountPaymentProposalDs> result) throws Exception {
		PurchaseTxAmountPaymentProposalDsParam params = builder.getParams();
		Float receivedAmount = params.getReceivedAmount();
		Float unallocated = receivedAmount;
		for (PurchaseTxAmountPaymentProposalDs ds : result) {
			ds.setCurrentPayment(0F);
			// ds.setRemainingAmount(0F);
			// Float outstanding = ds.getOutstandingAmount();
			// if (unallocated <= outstanding) {
			// ds.setCurrentPayment(unallocated);
			// unallocated = 0F;
			// } else {
			// ds.setCurrentPayment(outstanding);
			// unallocated = unallocated - outstanding;
			// }
		}
		params.setUnAllocatedAmount(unallocated);
	}

}
