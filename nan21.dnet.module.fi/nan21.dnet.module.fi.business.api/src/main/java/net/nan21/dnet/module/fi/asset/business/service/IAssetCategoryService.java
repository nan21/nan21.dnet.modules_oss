/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.fi.asset.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;

/**
 * Interface to expose business functions specific for {@link AssetCategory} domain
 * entity.
 */
public interface IAssetCategoryService extends IEntityService<AssetCategory> {

	/**
	 * Find by unique key
	 */
	public AssetCategory findByCode(String code);

	/**
	 * Find by unique key
	 */
	public AssetCategory findByName(String name);
}
