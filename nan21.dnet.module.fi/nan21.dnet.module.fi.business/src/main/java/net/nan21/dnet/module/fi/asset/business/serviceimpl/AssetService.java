/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.fi.asset.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.fi.asset.business.service.IAssetService;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;

/**
 * Repository functionality for {@link Asset} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AssetService extends AbstractEntityService<Asset>
		implements
			IAssetService {

	public AssetService() {
		super();
	}

	public AssetService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Asset> getEntityClass() {
		return Asset.class;
	}

	/**
	 * Find by unique key
	 */
	public Asset findByCode(String code) {
		return (Asset) this.getEntityManager()
				.createNamedQuery(Asset.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by reference: category
	 */
	public List<Asset> findByCategory(AssetCategory category) {
		return this.findByCategoryId(category.getId());
	}

	/**
	 * Find by ID of reference: category.id
	 */
	public List<Asset> findByCategoryId(Long categoryId) {
		return (List<Asset>) this
				.getEntityManager()
				.createQuery(
						"select e from Asset e where e.clientId = :pClientId and e.category.id = :pCategoryId",
						Asset.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCategoryId", categoryId).getResultList();
	}

	/**
	 * Find by reference: currency
	 */
	public List<Asset> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<Asset> findByCurrencyId(Long currencyId) {
		return (List<Asset>) this
				.getEntityManager()
				.createQuery(
						"select e from Asset e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
						Asset.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCurrencyId", currencyId).getResultList();
	}
}
