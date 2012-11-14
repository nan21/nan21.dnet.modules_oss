/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.fi.asset.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;

/**
 * Interface to expose business functions specific for {@link Asset} domain
 * entity.
 */
public interface IAssetService extends IEntityService<Asset> {

	/**
	 * Find by unique key
	 */
	public Asset findByCode(String code);

	/**
	 * Find by reference: category
	 */
	public List<Asset> findByCategory(AssetCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<Asset> findByCategoryId(Long categoryId);

	/**
	 * Find by reference: currency
	 */
	public List<Asset> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<Asset> findByCurrencyId(Long currencyId);
}
