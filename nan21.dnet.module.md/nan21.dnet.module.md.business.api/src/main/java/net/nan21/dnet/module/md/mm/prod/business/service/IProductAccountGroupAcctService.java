/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroupAcct;

/**
 * Interface to expose business functions specific for {@link ProductAccountGroupAcct} domain
 * entity.
 */
public interface IProductAccountGroupAcctService
		extends
			IEntityService<ProductAccountGroupAcct> {

	/**
	 * Find by unique key
	 */
	public ProductAccountGroupAcct findByGroup_schema(
			ProductAccountGroup group, AccSchema accSchema);

	/**
	 * Find by unique key
	 */
	public ProductAccountGroupAcct findByGroup_schema(Long groupId,
			Long accSchemaId);

	/**
	 * Find by reference: group
	 */
	public List<ProductAccountGroupAcct> findByGroup(ProductAccountGroup group);

	/**
	 * Find by ID of reference: group.id
	 */
	public List<ProductAccountGroupAcct> findByGroupId(Long groupId);

	/**
	 * Find by reference: accSchema
	 */
	public List<ProductAccountGroupAcct> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<ProductAccountGroupAcct> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: expenseAccount
	 */
	public List<ProductAccountGroupAcct> findByExpenseAccount(
			Account expenseAccount);

	/**
	 * Find by ID of reference: expenseAccount.id
	 */
	public List<ProductAccountGroupAcct> findByExpenseAccountId(
			Long expenseAccountId);

	/**
	 * Find by reference: revenueAccount
	 */
	public List<ProductAccountGroupAcct> findByRevenueAccount(
			Account revenueAccount);

	/**
	 * Find by ID of reference: revenueAccount.id
	 */
	public List<ProductAccountGroupAcct> findByRevenueAccountId(
			Long revenueAccountId);
}
