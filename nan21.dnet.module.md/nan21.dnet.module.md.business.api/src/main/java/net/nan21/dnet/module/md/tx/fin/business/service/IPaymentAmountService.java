/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.Payment;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentAmount;

/**
 * Interface to expose business functions specific for {@link PaymentAmount} domain
 * entity.
 */
public interface IPaymentAmountService extends IEntityService<PaymentAmount> {

	/**
	 * Find by reference: payment
	 */
	public List<PaymentAmount> findByPayment(Payment payment);

	/**
	 * Find by ID of reference: payment.id
	 */
	public List<PaymentAmount> findByPaymentId(Long paymentId);
}
