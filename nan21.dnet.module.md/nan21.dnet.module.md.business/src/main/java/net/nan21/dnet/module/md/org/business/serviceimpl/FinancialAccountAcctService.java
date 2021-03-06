/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.org.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountAcct;

/**
 * Repository functionality for {@link FinancialAccountAcct} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class FinancialAccountAcctService
		extends
			AbstractEntityService<FinancialAccountAcct> {

	public FinancialAccountAcctService() {
		super();
	}

	public FinancialAccountAcctService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<FinancialAccountAcct> getEntityClass() {
		return FinancialAccountAcct.class;
	}

	/**
	 * Find by unique key
	 */
	public FinancialAccountAcct findByAccount_schema(
			FinancialAccount financialAccount, AccSchema accSchema) {
		return (FinancialAccountAcct) this
				.getEntityManager()
				.createNamedQuery(
						FinancialAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFinancialAccount", financialAccount)
				.setParameter("pAccSchema", accSchema).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public FinancialAccountAcct findByAccount_schema(Long financialAccountId,
			Long accSchemaId) {
		return (FinancialAccountAcct) this
				.getEntityManager()
				.createNamedQuery(
						FinancialAccountAcct.NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFinancialAccountId", financialAccountId)
				.setParameter("pAccSchemaId", accSchemaId).getSingleResult();
	}

	/**
	 * Find by reference: financialAccount
	 */
	public List<FinancialAccountAcct> findByFinancialAccount(
			FinancialAccount financialAccount) {
		return this.findByFinancialAccountId(financialAccount.getId());
	}

	/**
	 * Find by ID of reference: financialAccount.id
	 */
	public List<FinancialAccountAcct> findByFinancialAccountId(
			Long financialAccountId) {
		return (List<FinancialAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from FinancialAccountAcct e where e.clientId = :pClientId and e.financialAccount.id = :pFinancialAccountId",
						FinancialAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFinancialAccountId", financialAccountId)
				.getResultList();
	}

	/**
	 * Find by reference: accSchema
	 */
	public List<FinancialAccountAcct> findByAccSchema(AccSchema accSchema) {
		return this.findByAccSchemaId(accSchema.getId());
	}

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<FinancialAccountAcct> findByAccSchemaId(Long accSchemaId) {
		return (List<FinancialAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from FinancialAccountAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
						FinancialAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccSchemaId", accSchemaId).getResultList();
	}

	/**
	 * Find by reference: depositAccount
	 */
	public List<FinancialAccountAcct> findByDepositAccount(
			Account depositAccount) {
		return this.findByDepositAccountId(depositAccount.getId());
	}

	/**
	 * Find by ID of reference: depositAccount.id
	 */
	public List<FinancialAccountAcct> findByDepositAccountId(
			Long depositAccountId) {
		return (List<FinancialAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from FinancialAccountAcct e where e.clientId = :pClientId and e.depositAccount.id = :pDepositAccountId",
						FinancialAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDepositAccountId", depositAccountId)
				.getResultList();
	}

	/**
	 * Find by reference: withdrawalAccount
	 */
	public List<FinancialAccountAcct> findByWithdrawalAccount(
			Account withdrawalAccount) {
		return this.findByWithdrawalAccountId(withdrawalAccount.getId());
	}

	/**
	 * Find by ID of reference: withdrawalAccount.id
	 */
	public List<FinancialAccountAcct> findByWithdrawalAccountId(
			Long withdrawalAccountId) {
		return (List<FinancialAccountAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from FinancialAccountAcct e where e.clientId = :pClientId and e.withdrawalAccount.id = :pWithdrawalAccountId",
						FinancialAccountAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pWithdrawalAccountId", withdrawalAccountId)
				.getResultList();
	}
}
