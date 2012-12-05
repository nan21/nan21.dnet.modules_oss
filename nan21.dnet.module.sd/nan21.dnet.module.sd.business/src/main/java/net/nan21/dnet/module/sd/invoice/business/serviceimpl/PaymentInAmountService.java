/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentInAmount;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;

/**
 * Repository functionality for {@link PaymentInAmount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PaymentInAmountService
		extends
			AbstractEntityService<PaymentInAmount> {

	public PaymentInAmountService() {
		super();
	}

	public PaymentInAmountService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PaymentInAmount> getEntityClass() {
		return PaymentInAmount.class;
	}

	/**
	 * Find by reference: txAmount
	 */
	public List<PaymentInAmount> findByTxAmount(SalesTxAmount txAmount) {
		return this.findByTxAmountId(txAmount.getId());
	}

	/**
	 * Find by ID of reference: txAmount.id
	 */
	public List<PaymentInAmount> findByTxAmountId(Long txAmountId) {
		return (List<PaymentInAmount>) this
				.getEntityManager()
				.createQuery(
						"select e from PaymentInAmount e where e.clientId = :pClientId and e.txAmount.id = :pTxAmountId",
						PaymentInAmount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTxAmountId", txAmountId).getResultList();
	}
}
