/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.res.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.res.business.service.IAssetBaseService;
import net.nan21.dnet.module.md.res.domain.entity.AssetBase;

/**
 * Repository functionality for {@link AssetBase} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AssetBaseService extends AbstractEntityService<AssetBase>
		implements
			IAssetBaseService {

	public AssetBaseService() {
		super();
	}

	public AssetBaseService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AssetBase> getEntityClass() {
		return AssetBase.class;
	}

	/**
	 * Find by unique key
	 */
	public AssetBase findByCode(String code) {
		return (AssetBase) this.getEntityManager()
				.createNamedQuery(AssetBase.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by reference: org
	 */
	public List<AssetBase> findByOrg(Organization org) {
		return this.findByOrgId(org.getId());
	}

	/**
	 * Find by ID of reference: org.id
	 */
	public List<AssetBase> findByOrgId(Long orgId) {
		return (List<AssetBase>) this
				.getEntityManager()
				.createQuery(
						"select e from AssetBase e where e.clientId = :pClientId and e.org.id = :pOrgId",
						AssetBase.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pOrgId", orgId).getResultList();
	}

	/**
	 * Find by reference: product
	 */
	public List<AssetBase> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}

	/**
	 * Find by ID of reference: product.id
	 */
	public List<AssetBase> findByProductId(Long productId) {
		return (List<AssetBase>) this
				.getEntityManager()
				.createQuery(
						"select e from AssetBase e where e.clientId = :pClientId and e.product.id = :pProductId",
						AssetBase.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId).getResultList();
	}
}
