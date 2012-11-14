/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.res.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.res.domain.entity.AssetBase;

/**
 * Interface to expose business functions specific for {@link AssetBase} domain
 * entity.
 */
public interface IAssetBaseService extends IEntityService<AssetBase> {

	/**
	 * Find by unique key
	 */
	public AssetBase findByCode(String code);

	/**
	 * Find by reference: org
	 */
	public List<AssetBase> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<AssetBase> findByOrgId(Long orgId);

	/**
	 * Find by reference: product
	 */
	public List<AssetBase> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<AssetBase> findByProductId(Long productId);
}
