/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.serviceext;

import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.module.sc._businessdelegates.invoice.PaymentOutToAccDocBD;
import net.nan21.dnet.module.sc.invoice.business.service.IPaymentOutService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOutAmount;

/**
 * Business extensions specific for {@link PaymentOut} domain entity.
 * 
 */
public class PaymentOutService extends
		net.nan21.dnet.module.sc.invoice.business.serviceimpl.PaymentOutService
		implements IPaymentOutService {

	/**
	 * Confirm document implementation. Just mark the confirmed flag.
	 */
	@Override
	public void doConfirm(PaymentOut payment) throws BusinessException {
		payment.setConfirmed(true);
		this.getEntityManager().merge(payment);
	}

	/**
	 * Un-Confirm document implementation. <br>
	 * Remove the generated payment details.
	 */
	@Override
	public void doUnConfirm(PaymentOut payment) throws BusinessException {

		List<PaymentOutAmount> paymentAmounts = (List<PaymentOutAmount>) this
				.getEntityManager()
				.createQuery(
						"select e from PaymentOutAmount e left join fetch e.txAmount where e.clientId = :pClientId and e.payment.id = :pPaymentId",
						PaymentOutAmount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentId", payment.getId()).getResultList();

		this.findEntityService(PaymentOutAmount.class).delete(paymentAmounts);
		payment.setConfirmed(false);
		this.getEntityManager().merge(payment);
	}

	@Override
	public void doPost(PaymentOut payment) throws BusinessException {
		this.getBusinessDelegate(PaymentOutToAccDocBD.class).post(payment);
	}

	@Override
	public void doUnPost(PaymentOut payment) throws BusinessException {
		this.getBusinessDelegate(PaymentOutToAccDocBD.class).unPost(payment);
	}

}
