/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountAcct;

/**
 * Interface to expose business functions specific for {@link ProductAccountAcct} domain
 * entity.
 */
public interface IProductAccountAcctService
		extends
			IEntityService<ProductAccountAcct> {

	/**
	 * Find by unique key
	 */
	public ProductAccountAcct findByAccount_schema(ProductAccount prodAccount,
			AccSchema accSchema);

	/**
	 * Find by unique key
	 */
	public ProductAccountAcct findByAccount_schema(Long prodAccountId,
			Long accSchemaId);

	/**
	 * Find by reference: prodAccount
	 */
	public List<ProductAccountAcct> findByProdAccount(ProductAccount prodAccount);

	/**
	 * Find by ID of reference: prodAccount.id
	 */
	public List<ProductAccountAcct> findByProdAccountId(Long prodAccountId);

	/**
	 * Find by reference: accSchema
	 */
	public List<ProductAccountAcct> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<ProductAccountAcct> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: expenseAccount
	 */
	public List<ProductAccountAcct> findByExpenseAccount(Account expenseAccount);

	/**
	 * Find by ID of reference: expenseAccount.id
	 */
	public List<ProductAccountAcct> findByExpenseAccountId(Long expenseAccountId);

	/**
	 * Find by reference: revenueAccount
	 */
	public List<ProductAccountAcct> findByRevenueAccount(Account revenueAccount);

	/**
	 * Find by ID of reference: revenueAccount.id
	 */
	public List<ProductAccountAcct> findByRevenueAccountId(Long revenueAccountId);
}
