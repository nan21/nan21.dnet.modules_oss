/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccount;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAccountGroup;

/**
 * Interface to expose business functions specific for {@link ProductAccount} domain
 * entity.
 */
public interface IProductAccountService extends IEntityService<ProductAccount> {

	/**
	 * Find by unique key
	 */
	public ProductAccount findByProd_org(Product product, Organization org);

	/**
	 * Find by unique key
	 */
	public ProductAccount findByProd_org(Long productId, Long orgId);

	/**
	 * Find by reference: org
	 */
	public List<ProductAccount> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<ProductAccount> findByOrgId(Long orgId);

	/**
	 * Find by reference: group
	 */
	public List<ProductAccount> findByGroup(ProductAccountGroup group);

	/**
	 * Find by ID of reference: group.id
	 */
	public List<ProductAccount> findByGroupId(Long groupId);

	/**
	 * Find by reference: product
	 */
	public List<ProductAccount> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<ProductAccount> findByProductId(Long productId);
}
