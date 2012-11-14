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
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.tx.fin.business.service.ITxAmountService;
import net.nan21.dnet.module.md.tx.fin.domain.entity.TxAmount;

/**
 * Repository functionality for {@link TxAmount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class TxAmountService extends AbstractEntityService<TxAmount>
		implements
			ITxAmountService {

	public TxAmountService() {
		super();
	}

	public TxAmountService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<TxAmount> getEntityClass() {
		return TxAmount.class;
	}

	/**
	 * Find by reference: bpartner
	 */
	public List<TxAmount> findByBpartner(BusinessPartner bpartner) {
		return this.findByBpartnerId(bpartner.getId());
	}

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<TxAmount> findByBpartnerId(Long bpartnerId) {
		return (List<TxAmount>) this.em
				.createQuery(
						"select e from TxAmount e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
						TxAmount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpartnerId", bpartnerId).getResultList();
	}

	/**
	 * Find by reference: org
	 */
	public List<TxAmount> findByOrg(Organization org) {
		return this.findByOrgId(org.getId());
	}

	/**
	 * Find by ID of reference: org.id
	 */
	public List<TxAmount> findByOrgId(Long orgId) {
		return (List<TxAmount>) this.em
				.createQuery(
						"select e from TxAmount e where e.clientId = :pClientId and e.org.id = :pOrgId",
						TxAmount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrgId", orgId).getResultList();
	}

	/**
	 * Find by reference: paymentMethod
	 */
	public List<TxAmount> findByPaymentMethod(PaymentMethod paymentMethod) {
		return this.findByPaymentMethodId(paymentMethod.getId());
	}

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<TxAmount> findByPaymentMethodId(Long paymentMethodId) {
		return (List<TxAmount>) this.em
				.createQuery(
						"select e from TxAmount e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
						TxAmount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentMethodId", paymentMethodId)
				.getResultList();
	}
}
