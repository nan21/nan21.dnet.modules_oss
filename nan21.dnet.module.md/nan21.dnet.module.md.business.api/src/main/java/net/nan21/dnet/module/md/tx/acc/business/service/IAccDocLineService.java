/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.acc.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.res.domain.entity.AssetBase;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;

/**
 * Interface to expose business functions specific for {@link AccDocLine} domain
 * entity.
 */
public interface IAccDocLineService extends IEntityService<AccDocLine> {

	/**
	 * Find by reference: accDoc
	 */
	public List<AccDocLine> findByAccDoc(AccDoc accDoc);

	/**
	 * Find by ID of reference: accDoc.id
	 */
	public List<AccDocLine> findByAccDocId(Long accDocId);

	/**
	 * Find by reference: product
	 */
	public List<AccDocLine> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<AccDocLine> findByProductId(Long productId);

	/**
	 * Find by reference: asset
	 */
	public List<AccDocLine> findByAsset(AssetBase asset);

	/**
	 * Find by ID of reference: asset.id
	 */
	public List<AccDocLine> findByAssetId(Long assetId);
}
