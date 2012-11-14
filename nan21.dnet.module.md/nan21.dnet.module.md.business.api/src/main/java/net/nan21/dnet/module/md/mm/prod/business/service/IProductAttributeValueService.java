/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeValue;

/**
 * Interface to expose business functions specific for {@link ProductAttributeValue} domain
 * entity.
 */
public interface IProductAttributeValueService
		extends
			IEntityService<ProductAttributeValue> {

	/**
	 * Find by unique key
	 */
	public ProductAttributeValue findByName(Product product, Attribute attribute);

	/**
	 * Find by unique key
	 */
	public ProductAttributeValue findByName(Long productId, Long attributeId);

	/**
	 * Find by reference: product
	 */
	public List<ProductAttributeValue> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<ProductAttributeValue> findByProductId(Long productId);

	/**
	 * Find by reference: attribute
	 */
	public List<ProductAttributeValue> findByAttribute(Attribute attribute);

	/**
	 * Find by ID of reference: attribute.id
	 */
	public List<ProductAttributeValue> findByAttributeId(Long attributeId);
}
