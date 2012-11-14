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
import net.nan21.dnet.module.fi.asset.business.service.IAssetAcctService;
import net.nan21.dnet.module.fi.asset.domain.entity.Asset;
import net.nan21.dnet.module.fi.asset.domain.entity.AssetAcct;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.acc.domain.entity.Account;

/**
 * Repository functionality for {@link AssetAcct} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AssetAcctService extends AbstractEntityService<AssetAcct>
		implements
			IAssetAcctService {

	public AssetAcctService() {
		super();
	}

	public AssetAcctService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<AssetAcct> getEntityClass() {
		return AssetAcct.class;
	}

	/**
	 * Find by unique key
	 */
	public AssetAcct findByAccount_schema(Asset asset, AccSchema accSchema) {
		return (AssetAcct) this.em
				.createNamedQuery(AssetAcct.NQ_FIND_BY_ACCOUNT_SCHEMA)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAsset", asset)
				.setParameter("pAccSchema", accSchema).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public AssetAcct findByAccount_schema(Long assetId, Long accSchemaId) {
		return (AssetAcct) this.em
				.createNamedQuery(AssetAcct.NQ_FIND_BY_ACCOUNT_SCHEMA_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAssetId", assetId)
				.setParameter("pAccSchemaId", accSchemaId).getSingleResult();
	}

	/**
	 * Find by reference: asset
	 */
	public List<AssetAcct> findByAsset(Asset asset) {
		return this.findByAssetId(asset.getId());
	}

	/**
	 * Find by ID of reference: asset.id
	 */
	public List<AssetAcct> findByAssetId(Long assetId) {
		return (List<AssetAcct>) this.em
				.createQuery(
						"select e from AssetAcct e where e.clientId = :pClientId and e.asset.id = :pAssetId",
						AssetAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAssetId", assetId).getResultList();
	}

	/**
	 * Find by reference: accSchema
	 */
	public List<AssetAcct> findByAccSchema(AccSchema accSchema) {
		return this.findByAccSchemaId(accSchema.getId());
	}

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<AssetAcct> findByAccSchemaId(Long accSchemaId) {
		return (List<AssetAcct>) this.em
				.createQuery(
						"select e from AssetAcct e where e.clientId = :pClientId and e.accSchema.id = :pAccSchemaId",
						AssetAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccSchemaId", accSchemaId).getResultList();
	}

	/**
	 * Find by reference: deprecAccount
	 */
	public List<AssetAcct> findByDeprecAccount(Account deprecAccount) {
		return this.findByDeprecAccountId(deprecAccount.getId());
	}

	/**
	 * Find by ID of reference: deprecAccount.id
	 */
	public List<AssetAcct> findByDeprecAccountId(Long deprecAccountId) {
		return (List<AssetAcct>) this.em
				.createQuery(
						"select e from AssetAcct e where e.clientId = :pClientId and e.deprecAccount.id = :pDeprecAccountId",
						AssetAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDeprecAccountId", deprecAccountId)
				.getResultList();
	}

	/**
	 * Find by reference: acmlDeprecAccount
	 */
	public List<AssetAcct> findByAcmlDeprecAccount(Account acmlDeprecAccount) {
		return this.findByAcmlDeprecAccountId(acmlDeprecAccount.getId());
	}

	/**
	 * Find by ID of reference: acmlDeprecAccount.id
	 */
	public List<AssetAcct> findByAcmlDeprecAccountId(Long acmlDeprecAccountId) {
		return (List<AssetAcct>) this.em
				.createQuery(
						"select e from AssetAcct e where e.clientId = :pClientId and e.acmlDeprecAccount.id = :pAcmlDeprecAccountId",
						AssetAcct.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAcmlDeprecAccountId", acmlDeprecAccountId)
				.getResultList();
	}
}
