/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.ds.serviceext;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.action.IQueryBuilder;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.presenter.service.ds.AbstractEntityDsService;
import net.nan21.dnet.module.sd.invoice.business.service.IPaymentInService;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentIn;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentInAmount;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountPaymentProposalDsFilter;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountPaymentProposalDs;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountPaymentProposalDsParam;

public class SalesTxAmountPaymentProposalDsService
		extends
		AbstractEntityDsService<SalesTxAmountPaymentProposalDs, SalesTxAmountPaymentProposalDsFilter, SalesTxAmountPaymentProposalDsParam, SalesTxAmount>
		implements
		IDsService<SalesTxAmountPaymentProposalDs, SalesTxAmountPaymentProposalDsFilter, SalesTxAmountPaymentProposalDsParam> {

	/**
	 * Instead of update, create payment-amounts from the list of due amounts.
	 * Process only those which specify a not null payment.
	 */
	@Override
	public void update(List<SalesTxAmountPaymentProposalDs> list,
			SalesTxAmountPaymentProposalDsParam params) throws Exception {

		IPaymentInService srv = (IPaymentInService) this
				.findEntityService(PaymentIn.class);
		List<SalesTxAmount> entities = this.getEntityService().findByIds(
				this.collectIds(list));

		List<PaymentInAmount> paymentAmounts = new ArrayList<PaymentInAmount>();
		PaymentIn payment = srv.findById(params.getPaymentId());

		if (payment.getConfirmed()) {
			throw new BusinessException(
					"Cannot add details to a confirmed payment. Un-confirm it first.");
		}
		Float currentPaymentSum = 0F;
		for (SalesTxAmountPaymentProposalDs ds : list) {
			if (ds.getCurrentPayment() != null && ds.getCurrentPayment() != 0) {
				PaymentInAmount pa = new PaymentInAmount();
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
			PaymentInAmount pa = new PaymentInAmount();
			pa.setPayment(payment);
			pa.setAmount(payment.getAmount() - currentPaymentSum);
			paymentAmounts.add(pa);
		}

		this.findEntityService(PaymentInAmount.class).insert(paymentAmounts);
		((IPaymentInService) this.findEntityService(PaymentIn.class))
				.doConfirm(payment);
	}

	@Override
	protected void postFind(
			IQueryBuilder<SalesTxAmountPaymentProposalDs, SalesTxAmountPaymentProposalDsFilter, SalesTxAmountPaymentProposalDsParam> builder,
			List<SalesTxAmountPaymentProposalDs> result) throws Exception {
		SalesTxAmountPaymentProposalDsParam params = builder.getParams();
		Float receivedAmount = params.getReceivedAmount();
		Float unallocated = receivedAmount;
		for (SalesTxAmountPaymentProposalDs ds : result) {
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
