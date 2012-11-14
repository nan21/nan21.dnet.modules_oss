/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.org.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.org.business.service.IFinancialAccountMethodService;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountMethod;

/**
 * Repository functionality for {@link FinancialAccountMethod} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class FinancialAccountMethodService
		extends
			AbstractEntityService<FinancialAccountMethod>
		implements
			IFinancialAccountMethodService {

	public FinancialAccountMethodService() {
		super();
	}

	public FinancialAccountMethodService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<FinancialAccountMethod> getEntityClass() {
		return FinancialAccountMethod.class;
	}

	/**
	 * Find by unique key
	 */
	public FinancialAccountMethod findByAccount_mtd(
			FinancialAccount financialAccount, PaymentMethod payMethod) {
		return (FinancialAccountMethod) this.em
				.createNamedQuery(FinancialAccountMethod.NQ_FIND_BY_ACCOUNT_MTD)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFinancialAccount", financialAccount)
				.setParameter("pPayMethod", payMethod).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public FinancialAccountMethod findByAccount_mtd(Long financialAccountId,
			Long payMethodId) {
		return (FinancialAccountMethod) this.em
				.createNamedQuery(
						FinancialAccountMethod.NQ_FIND_BY_ACCOUNT_MTD_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFinancialAccountId", financialAccountId)
				.setParameter("pPayMethodId", payMethodId).getSingleResult();
	}

	/**
	 * Find by reference: financialAccount
	 */
	public List<FinancialAccountMethod> findByFinancialAccount(
			FinancialAccount financialAccount) {
		return this.findByFinancialAccountId(financialAccount.getId());
	}

	/**
	 * Find by ID of reference: financialAccount.id
	 */
	public List<FinancialAccountMethod> findByFinancialAccountId(
			Long financialAccountId) {
		return (List<FinancialAccountMethod>) this.em
				.createQuery(
						"select e from FinancialAccountMethod e where e.clientId = :pClientId and e.financialAccount.id = :pFinancialAccountId",
						FinancialAccountMethod.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFinancialAccountId", financialAccountId)
				.getResultList();
	}

	/**
	 * Find by reference: payMethod
	 */
	public List<FinancialAccountMethod> findByPayMethod(PaymentMethod payMethod) {
		return this.findByPayMethodId(payMethod.getId());
	}

	/**
	 * Find by ID of reference: payMethod.id
	 */
	public List<FinancialAccountMethod> findByPayMethodId(Long payMethodId) {
		return (List<FinancialAccountMethod>) this.em
				.createQuery(
						"select e from FinancialAccountMethod e where e.clientId = :pClientId and e.payMethod.id = :pPayMethodId",
						FinancialAccountMethod.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPayMethodId", payMethodId).getResultList();
	}
}
