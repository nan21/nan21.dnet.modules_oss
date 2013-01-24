/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.md.bp.business.service.IBpBankAccountService;
import net.nan21.dnet.module.md.bp.domain.entity.Bank;
import net.nan21.dnet.module.md.bp.domain.entity.BpBankAccount;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;

/**
 * Repository functionality for {@link BpBankAccount} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BpBankAccountService extends AbstractEntityService<BpBankAccount>
		implements
			IBpBankAccountService {

	public BpBankAccountService() {
		super();
	}

	public BpBankAccountService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<BpBankAccount> getEntityClass() {
		return BpBankAccount.class;
	}

	/**
	 * Find by unique key
	 */
	public BpBankAccount findByAccount(BusinessPartner bpartner,
			String accountNo) {
		return (BpBankAccount) this.getEntityManager()
				.createNamedQuery(BpBankAccount.NQ_FIND_BY_ACCOUNT)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpartner", bpartner)
				.setParameter("pAccountNo", accountNo).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public BpBankAccount findByAccount(Long bpartnerId, String accountNo) {
		return (BpBankAccount) this.getEntityManager()
				.createNamedQuery(BpBankAccount.NQ_FIND_BY_ACCOUNT_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpartnerId", bpartnerId)
				.setParameter("pAccountNo", accountNo).getSingleResult();
	}

	/**
	 * Find by reference: bpartner
	 */
	public List<BpBankAccount> findByBpartner(BusinessPartner bpartner) {
		return this.findByBpartnerId(bpartner.getId());
	}

	/**
	 * Find by ID of reference: bpartner.id
	 */
	public List<BpBankAccount> findByBpartnerId(Long bpartnerId) {
		return (List<BpBankAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpBankAccount e where e.clientId = :pClientId and e.bpartner.id = :pBpartnerId",
						BpBankAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBpartnerId", bpartnerId).getResultList();
	}

	/**
	 * Find by reference: bank
	 */
	public List<BpBankAccount> findByBank(Bank bank) {
		return this.findByBankId(bank.getId());
	}

	/**
	 * Find by ID of reference: bank.id
	 */
	public List<BpBankAccount> findByBankId(Long bankId) {
		return (List<BpBankAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpBankAccount e where e.clientId = :pClientId and e.bank.id = :pBankId",
						BpBankAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBankId", bankId).getResultList();
	}

	/**
	 * Find by reference: currency
	 */
	public List<BpBankAccount> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<BpBankAccount> findByCurrencyId(Long currencyId) {
		return (List<BpBankAccount>) this
				.getEntityManager()
				.createQuery(
						"select e from BpBankAccount e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
						BpBankAccount.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCurrencyId", currencyId).getResultList();
	}
}
