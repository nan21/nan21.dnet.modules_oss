/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.fi.asset.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategoryAcct;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

/**
 * Interface to expose business functions specific for {@link AssetCategoryAcct} domain
 * entity.
 */
public interface IAssetCategoryAcctService
		extends
			IEntityService<AssetCategoryAcct> {

	/**
	 * Find by unique key
	 */
	public AssetCategoryAcct findByAccount_schema(AssetCategory assetCategory,
			AccSchema accSchema);

	/**
	 * Find by unique key
	 */
	public AssetCategoryAcct findByAccount_schema(Long assetCategoryId,
			Long accSchemaId);

	/**
	 * Find by reference: assetCategory
	 */
	public List<AssetCategoryAcct> findByAssetCategory(
			AssetCategory assetCategory);

	/**
	 * Find by ID of reference: assetCategory.id
	 */
	public List<AssetCategoryAcct> findByAssetCategoryId(Long assetCategoryId);

	/**
	 * Find by reference: accSchema
	 */
	public List<AssetCategoryAcct> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<AssetCategoryAcct> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: deprecAccount
	 */
	public List<AssetCategoryAcct> findByDeprecAccount(Account deprecAccount);

	/**
	 * Find by ID of reference: deprecAccount.id
	 */
	public List<AssetCategoryAcct> findByDeprecAccountId(Long deprecAccountId);

	/**
	 * Find by reference: acmlDeprecAccount
	 */
	public List<AssetCategoryAcct> findByAcmlDeprecAccount(
			Account acmlDeprecAccount);

	/**
	 * Find by ID of reference: acmlDeprecAccount.id
	 */
	public List<AssetCategoryAcct> findByAcmlDeprecAccountId(
			Long acmlDeprecAccountId);
}
