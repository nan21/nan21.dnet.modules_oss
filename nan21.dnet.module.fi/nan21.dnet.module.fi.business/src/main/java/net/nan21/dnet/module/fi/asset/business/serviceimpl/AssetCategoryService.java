/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.fi.asset.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.fi.asset.business.service.IAssetCategoryService;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;

/**
 * Repository functionality for {@link AssetCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AssetCategoryService extends AbstractEntityService<AssetCategory>
		implements
			IAssetCategoryService {

	public AssetCategoryService() {
		super();
	}

	public AssetCategoryService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<AssetCategory> getEntityClass() {
		return AssetCategory.class;
	}

	/**
	 * Find by unique key
	 */
	public AssetCategory findByCode(String code) {
		return (AssetCategory) this.em
				.createNamedQuery(AssetCategory.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public AssetCategory findByName(String name) {
		return (AssetCategory) this.em
				.createNamedQuery(AssetCategory.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
