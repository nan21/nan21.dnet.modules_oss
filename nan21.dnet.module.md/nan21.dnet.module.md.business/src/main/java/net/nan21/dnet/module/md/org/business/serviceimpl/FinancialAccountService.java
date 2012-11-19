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
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.md.org.business.service.IFinancialAccountService;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountMethod;

/**
 * Repository functionality for {@link FinancialAccount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class FinancialAccountService
		extends
			AbstractEntityService<FinancialAccount>
		implements
			IFinancialAccountService {

	public FinancialAccountService() {
		super();
	}

	public FinancialAccountService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<FinancialAccount> getEntityClass() {
		return FinancialAccount.class;
	}

	/**
	 * Find by unique key
	 */
	public FinancialAccount findByName(String name) {
		return (FinancialAccount) this.em
				.createNamedQuery(FinancialAccount.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: org
	 */
	public List<FinancialAccount> findByOrg(Organization org) {
		return this.findByOrgId(org.getId());
	}

	/**
	 * Find by ID of reference: org.id
	 */
	public List<FinancialAccount> findByOrgId(Long orgId) {
		return (List<FinancialAccount>) this.em
				.createQuery(
						"select e from FinancialAccount e where e.clientId = :pClientId and e.org.id = :pOrgId",
						FinancialAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrgId", orgId).getResultList();
	}

	/**
	 * Find by reference: currency
	 */
	public List<FinancialAccount> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<FinancialAccount> findByCurrencyId(Long currencyId) {
		return (List<FinancialAccount>) this.em
				.createQuery(
						"select e from FinancialAccount e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
						FinancialAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCurrencyId", currencyId).getResultList();
	}

	/**
	 * Find by reference: journal
	 */
	public List<FinancialAccount> findByJournal(AccJournal journal) {
		return this.findByJournalId(journal.getId());
	}

	/**
	 * Find by ID of reference: journal.id
	 */
	public List<FinancialAccount> findByJournalId(Long journalId) {
		return (List<FinancialAccount>) this.em
				.createQuery(
						"select e from FinancialAccount e where e.clientId = :pClientId and e.journal.id = :pJournalId",
						FinancialAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJournalId", journalId).getResultList();
	}

	/**
	 * Find by reference: methods
	 */
	public List<FinancialAccount> findByMethods(FinancialAccountMethod methods) {
		return this.findByMethodsId(methods.getId());
	}

	/**
	 * Find by ID of reference: methods.id
	 */
	public List<FinancialAccount> findByMethodsId(Long methodsId) {
		return (List<FinancialAccount>) this.em
				.createQuery(
						"select distinct e from FinancialAccount e, IN (e.methods) c where e.clientId = :pClientId and c.id = :pMethodsId",
						FinancialAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pMethodsId", methodsId).getResultList();
	}
}
