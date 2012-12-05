/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.fi.asset.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.fi.asset.business.service.IAssetCategoryAcctService;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategory;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetCategoryAcct;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

/**
 * Repository functionality for {@link AssetCategoryAcct} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AssetCategoryAcctService
		extends
			AbstractEntityService<AssetCategoryAcct>
		implements
			IAssetCategoryAcctService {

	public AssetCategoryAcctService() {
		super();
	}

	public AssetCategoryAcctService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AssetCategoryAcct> getEntityClass() {
		return AssetCategoryAcct.class;
	}

	/**
	 * Find by unique key
	 */
	public AssetCategoryAcct findByAccount_schema(AssetCategory assetCategory,
			AccSchema accSchema) {
		return (AssetCategoryAcct) this.getEntityManager()
				.createNamedQuery(AssetCategoryAcct.NQ_FIND_BY_ACCOUNT_SCHEMA)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAssetCategory", assetCategory)
				.setParameter("pAccSchema", accSchema).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public AssetCategoryAcct findByAccount_schema(Long assetCategoryId,
			Long accSchemaId) {
		return (AssetCategoryAcct) this
				.getEntityManager()
				.createNamedQuery(
						AssetCategoryAcct.NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAssetCategoryId", assetCategoryId)
				.setParameter("pAccSchemaId", accSchemaId).getSingleResult();
	}

	/**
	 * Find by reference: assetCategory
	 */
	public List<AssetCategoryAcct> findByAssetCategory(
			AssetCategory assetCategory) {
		return this.findByAssetCategoryId(assetCategory.getId());
	}

	/**
	 * Find by ID of reference: assetCategory.id
	 */
	public List<AssetCategoryAcct> findByAssetCategoryId(Long assetCategoryId) {
		return (List<AssetCategoryAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from AssetCategoryAcct e where e.clientId = :pClientId and e.assetCategory.id = :pAssetCategoryId",
						AssetCategoryAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAssetCategoryId", assetCategoryId)
				.getResultList();
	}

	/**
	 * Find by reference: accSchema
	 */
	public List<AssetCategoryAcct> findByAccSchema(AccSchema accSchema) {
		return this.findByAccSchemaId(accSchema.getId());
	}

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<AssetCategoryAcct> findByAccSchemaId(Long accSchemaId) {
		return (List<AssetCategoryAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from AssetCategoryAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
						AssetCategoryAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccSchemaId", accSchemaId).getResultList();
	}

	/**
	 * Find by reference: deprecAccount
	 */
	public List<AssetCategoryAcct> findByDeprecAccount(Account deprecAccount) {
		return this.findByDeprecAccountId(deprecAccount.getId());
	}

	/**
	 * Find by ID of reference: deprecAccount.id
	 */
	public List<AssetCategoryAcct> findByDeprecAccountId(Long deprecAccountId) {
		return (List<AssetCategoryAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from AssetCategoryAcct e where e.clientId = :pClientId and e.deprecAccount.id = :pDeprecAccountId",
						AssetCategoryAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDeprecAccountId", deprecAccountId)
				.getResultList();
	}

	/**
	 * Find by reference: acmlDeprecAccount
	 */
	public List<AssetCategoryAcct> findByAcmlDeprecAccount(
			Account acmlDeprecAccount) {
		return this.findByAcmlDeprecAccountId(acmlDeprecAccount.getId());
	}

	/**
	 * Find by ID of reference: acmlDeprecAccount.id
	 */
	public List<AssetCategoryAcct> findByAcmlDeprecAccountId(
			Long acmlDeprecAccountId) {
		return (List<AssetCategoryAcct>) this
				.getEntityManager()
				.createQuery(
						"select e from AssetCategoryAcct e where e.clientId = :pClientId and e.acmlDeprecAccount.id = :pAcmlDeprecAccountId",
						AssetCategoryAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAcmlDeprecAccountId", acmlDeprecAccountId)
				.getResultList();
	}
}
