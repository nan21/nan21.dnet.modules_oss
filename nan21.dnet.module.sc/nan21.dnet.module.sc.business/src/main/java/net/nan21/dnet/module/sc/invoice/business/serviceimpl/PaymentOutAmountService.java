/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.sc.invoice.business.service.IPaymentOutAmountService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOutAmount;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;

/**
 * Repository functionality for {@link PaymentOutAmount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PaymentOutAmountService
		extends
			AbstractEntityService<PaymentOutAmount>
		implements
			IPaymentOutAmountService {

	public PaymentOutAmountService() {
		super();
	}

	public PaymentOutAmountService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<PaymentOutAmount> getEntityClass() {
		return PaymentOutAmount.class;
	}

	/**
	 * Find by reference: txAmount
	 */
	public List<PaymentOutAmount> findByTxAmount(PurchaseTxAmount txAmount) {
		return this.findByTxAmountId(txAmount.getId());
	}

	/**
	 * Find by ID of reference: txAmount.id
	 */
	public List<PaymentOutAmount> findByTxAmountId(Long txAmountId) {
		return (List<PaymentOutAmount>) this.em
				.createQuery(
						"select e from PaymentOutAmount e where e.clientId = :pClientId and e.txAmount.id = :pTxAmountId",
						PaymentOutAmount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTxAmountId", txAmountId).getResultList();
	}
}
