/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.fi.asset.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetAcct;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

/**
 * Interface to expose business functions specific for {@link AssetAcct} domain
 * entity.
 */
public interface IAssetAcctService extends IEntityService<AssetAcct> {

	/**
	 * Find by unique key
	 */
	public AssetAcct findByAccount_schema(Asset asset, AccSchema accSchema);

	/**
	 * Find by unique key
	 */
	public AssetAcct findByAccount_schema(Long assetId, Long accSchemaId);

	/**
	 * Find by reference: asset
	 */
	public List<AssetAcct> findByAsset(Asset asset);

	/**
	 * Find by ID of reference: asset.id
	 */
	public List<AssetAcct> findByAssetId(Long assetId);

	/**
	 * Find by reference: accSchema
	 */
	public List<AssetAcct> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<AssetAcct> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: deprecAccount
	 */
	public List<AssetAcct> findByDeprecAccount(Account deprecAccount);

	/**
	 * Find by ID of reference: deprecAccount.id
	 */
	public List<AssetAcct> findByDeprecAccountId(Long deprecAccountId);

	/**
	 * Find by reference: acmlDeprecAccount
	 */
	public List<AssetAcct> findByAcmlDeprecAccount(Account acmlDeprecAccount);

	/**
	 * Find by ID of reference: acmlDeprecAccount.id
	 */
	public List<AssetAcct> findByAcmlDeprecAccountId(Long acmlDeprecAccountId);
}
