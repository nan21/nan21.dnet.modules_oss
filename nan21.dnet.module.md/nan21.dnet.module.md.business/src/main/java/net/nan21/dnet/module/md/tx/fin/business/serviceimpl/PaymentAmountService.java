/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.fin.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentAmount;

/**
 * Repository functionality for {@link PaymentAmount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PaymentAmountService extends AbstractEntityService<PaymentAmount> {

	public PaymentAmountService() {
		super();
	}

	public PaymentAmountService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PaymentAmount> getEntityClass() {
		return PaymentAmount.class;
	}

	/**
	 * Find by reference: payment
	 */
	public List<PaymentAmount> findByPayment(Payment payment) {
		return this.findByPaymentId(payment.getId());
	}

	/**
	 * Find by ID of reference: payment.id
	 */
	public List<PaymentAmount> findByPaymentId(Long paymentId) {
		return (List<PaymentAmount>) this
				.getEntityManager()
				.createQuery(
						"select e from PaymentAmount e where e.clientId = :pClientId and e.payment.id = :pPaymentId",
						PaymentAmount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentId", paymentId).getResultList();
	}
}
