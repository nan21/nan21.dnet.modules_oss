/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountAcct;

/**
 * Interface to expose business functions specific for {@link FinancialAccountAcct} domain
 * entity.
 */
public interface IFinancialAccountAcctService
		extends
			IEntityService<FinancialAccountAcct> {

	public String getPostingDepositAcct(FinancialAccount financialAccount,
			AccSchema schema) throws BusinessException;

	public String getPostingWithdrawalAcct(FinancialAccount financialAccount,
			AccSchema schema) throws BusinessException;

	/**
	 * Find by unique key
	 */
	public FinancialAccountAcct findByAccount_schema(
			FinancialAccount financialAccount, AccSchema accSchema);

	/**
	 * Find by unique key
	 */
	public FinancialAccountAcct findByAccount_schema(Long financialAccountId,
			Long accSchemaId);

	/**
	 * Find by reference: financialAccount
	 */
	public List<FinancialAccountAcct> findByFinancialAccount(
			FinancialAccount financialAccount);

	/**
	 * Find by ID of reference: financialAccount.id
	 */
	public List<FinancialAccountAcct> findByFinancialAccountId(
			Long financialAccountId);

	/**
	 * Find by reference: accSchema
	 */
	public List<FinancialAccountAcct> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<FinancialAccountAcct> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: depositAccount
	 */
	public List<FinancialAccountAcct> findByDepositAccount(
			Account depositAccount);

	/**
	 * Find by ID of reference: depositAccount.id
	 */
	public List<FinancialAccountAcct> findByDepositAccountId(
			Long depositAccountId);

	/**
	 * Find by reference: withdrawalAccount
	 */
	public List<FinancialAccountAcct> findByWithdrawalAccount(
			Account withdrawalAccount);

	/**
	 * Find by ID of reference: withdrawalAccount.id
	 */
	public List<FinancialAccountAcct> findByWithdrawalAccountId(
			Long withdrawalAccountId);
}
