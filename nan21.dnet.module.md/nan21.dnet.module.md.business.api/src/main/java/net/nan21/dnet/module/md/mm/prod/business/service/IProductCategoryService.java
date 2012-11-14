/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductCategory;

/**
 * Interface to expose business functions specific for {@link ProductCategory} domain
 * entity.
 */
public interface IProductCategoryService
		extends
			IEntityService<ProductCategory> {

	/**
	 * Find by unique key
	 */
	public ProductCategory findByCode(String code);

	/**
	 * Find by unique key
	 */
	public ProductCategory findByName(String name);

	/**
	 * Find by reference: category
	 */
	public List<ProductCategory> findByCategory(ProductCategory category);

	/**
	 * Find by ID of reference: category.id
	 */
	public List<ProductCategory> findByCategoryId(Long categoryId);

	/**
	 * Find by reference: products
	 */
	public List<ProductCategory> findByProducts(Product products);

	/**
	 * Find by ID of reference: products.id
	 */
	public List<ProductCategory> findByProductsId(Long productsId);
}
