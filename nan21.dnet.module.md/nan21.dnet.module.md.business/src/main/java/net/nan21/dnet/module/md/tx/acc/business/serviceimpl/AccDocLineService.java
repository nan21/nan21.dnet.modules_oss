/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.acc.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.res.domain.entity.AssetBase;
import net.nan21.dnet.module.md.tx.acc.business.service.IAccDocLineService;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;

/**
 * Repository functionality for {@link AccDocLine} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccDocLineService extends AbstractEntityService<AccDocLine>
		implements
			IAccDocLineService {

	public AccDocLineService() {
		super();
	}

	public AccDocLineService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AccDocLine> getEntityClass() {
		return AccDocLine.class;
	}

	/**
	 * Find by reference: accDoc
	 */
	public List<AccDocLine> findByAccDoc(AccDoc accDoc) {
		return this.findByAccDocId(accDoc.getId());
	}

	/**
	 * Find by ID of reference: accDoc.id
	 */
	public List<AccDocLine> findByAccDocId(Long accDocId) {
		return (List<AccDocLine>) this
				.getEntityManager()
				.createQuery(
						"select e from AccDocLine e where e.clientId = :pClientId and e.accDoc.id = :pAccDocId",
						AccDocLine.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccDocId", accDocId).getResultList();
	}

	/**
	 * Find by reference: product
	 */
	public List<AccDocLine> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}

	/**
	 * Find by ID of reference: product.id
	 */
	public List<AccDocLine> findByProductId(Long productId) {
		return (List<AccDocLine>) this
				.getEntityManager()
				.createQuery(
						"select e from AccDocLine e where e.clientId = :pClientId and e.product.id = :pProductId",
						AccDocLine.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId).getResultList();
	}

	/**
	 * Find by reference: asset
	 */
	public List<AccDocLine> findByAsset(AssetBase asset) {
		return this.findByAssetId(asset.getId());
	}

	/**
	 * Find by ID of reference: asset.id
	 */
	public List<AccDocLine> findByAssetId(Long assetId) {
		return (List<AccDocLine>) this
				.getEntityManager()
				.createQuery(
						"select e from AccDocLine e where e.clientId = :pClientId and e.asset.id = :pAssetId",
						AccDocLine.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAssetId", assetId).getResultList();
	}
}
