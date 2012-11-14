/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccountMethod;

/**
 * Interface to expose business functions specific for {@link FinancialAccountMethod} domain
 * entity.
 */
public interface IFinancialAccountMethodService
		extends
			IEntityService<FinancialAccountMethod> {

	/**
	 * Find by unique key
	 */
	public FinancialAccountMethod findByAccount_mtd(
			FinancialAccount financialAccount, PaymentMethod payMethod);

	/**
	 * Find by unique key
	 */
	public FinancialAccountMethod findByAccount_mtd(Long financialAccountId,
			Long payMethodId);

	/**
	 * Find by reference: financialAccount
	 */
	public List<FinancialAccountMethod> findByFinancialAccount(
			FinancialAccount financialAccount);

	/**
	 * Find by ID of reference: financialAccount.id
	 */
	public List<FinancialAccountMethod> findByFinancialAccountId(
			Long financialAccountId);

	/**
	 * Find by reference: payMethod
	 */
	public List<FinancialAccountMethod> findByPayMethod(PaymentMethod payMethod);

	/**
	 * Find by ID of reference: payMethod.id
	 */
	public List<FinancialAccountMethod> findByPayMethodId(Long payMethodId);
}
