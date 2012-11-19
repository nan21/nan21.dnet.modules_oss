/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.serviceext;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.module.sd._businessdelegates.invoice.PaymentInToAccDocBD;
import net.nan21.dnet.module.sd.invoice.business.service.IPaymentInService;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentIn;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentInAmount;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;

/**
 * Business extensions specific for {@link PaymentIn} domain entity.
 * 
 */
public class PaymentInService extends
		net.nan21.dnet.module.sd.invoice.business.serviceimpl.PaymentInService
		implements IPaymentInService {

	@Override
	public void doConfirm(PaymentIn payment) throws BusinessException {
		payment.setConfirmed(true);
		this.getEntityManager().merge(payment);
	}

	@Override
	public void doUnConfirm(PaymentIn payment) throws BusinessException {

		List<Object> ids = new ArrayList<Object>();

		List<PaymentInAmount> paymentAmounts = (List<PaymentInAmount>) this.em
				.createQuery(
						"select e from PaymentInAmount e left join fetch e.txAmount where e.clientId = :pClientId and e.payment.id = :pPaymentId",
						PaymentInAmount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentId", payment.getId()).getResultList();

		List<SalesTxAmount> txAmounts = new ArrayList<SalesTxAmount>();
		for (PaymentInAmount payAmount : paymentAmounts) {
			ids.add(payAmount.getId());
			SalesTxAmount txAmount = payAmount.getTxAmount();
			if (txAmount != null) {
				txAmount.setPayedAmount(txAmount.getPayedAmount()
						- payAmount.getAmount());
				txAmount.setAmount(txAmount.getAmount() + payAmount.getAmount());
				txAmounts.add(txAmount);
			}
		}

		this.findEntityService(SalesTxAmount.class).update(txAmounts);
		this.findEntityService(PaymentInAmount.class).deleteByIds(ids);

		payment.setConfirmed(false);
		this.getEntityManager().merge(payment);
	}

	@Override
	public void doPost(PaymentIn payment) throws BusinessException {
		this.getBusinessDelegate(PaymentInToAccDocBD.class).post(payment);
	}

	@Override
	public void doUnPost(PaymentIn payment) throws BusinessException {
		this.getBusinessDelegate(PaymentInToAccDocBD.class).unPost(payment);
	}

}
