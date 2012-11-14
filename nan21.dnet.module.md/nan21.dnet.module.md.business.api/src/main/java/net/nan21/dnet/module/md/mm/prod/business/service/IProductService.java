/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.service;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeValue;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductCategory;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductManufacturer;

/**
 * Interface to expose business functions specific for {@link Product} domain
 * entity.
 */
public interface IProductService extends IEntityService<Product> {

	public String getExpenseAcct(Product product, Organization organization,
			AccSchema schema) throws BusinessException;

	public String getRevenueAcct(Product product, Organization organization,
			AccSchema schema) throws BusinessException;

	/**
	 * Find by unique key
	 */
	public Product findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Product findByName(String name);

	/**
	 * Find by reference: defaultUom
	 */
	public List<Product> findByDefaultUom(Uom defaultUom);

	/**
	 * Find by ID of reference: defaultUom.id
	 */
	public List<Product> findByDefaultUomId(Long defaultUomId);

	/**
	 * Find by reference: weightUom
	 */
	public List<Product> findByWeightUom(Uom weightUom);

	/**
	 * Find by ID of reference: weightUom.id
	 */
	public List<Product> findByWeightUomId(Long weightUomId);

	/**
	 * Find by reference: volumeUom
	 */
	public List<Product> findByVolumeUom(Uom volumeUom);

	/**
	 * Find by ID of reference: volumeUom.id
	 */
	public List<Product> findByVolumeUomId(Long volumeUomId);

	/**
	 * Find by reference: dimUom
	 */
	public List<Product> findByDimUom(Uom dimUom);

	/**
	 * Find by ID of reference: dimUom.id
	 */
	public List<Product> findByDimUomId(Long dimUomId);

	/**
	 * Find by reference: manufacturer
	 */
	public List<Product> findByManufacturer(ProductManufacturer manufacturer);

	/**
	 * Find by ID of reference: manufacturer.id
	 */
	public List<Product> findByManufacturerId(Long manufacturerId);

	/**
	 * Find by reference: attributeSet
	 */
	public List<Product> findByAttributeSet(AttributeSet attributeSet);

	/**
	 * Find by ID of reference: attributeSet.id
	 */
	public List<Product> findByAttributeSetId(Long attributeSetId);

	/**
	 * Find by reference: categories
	 */
	public List<Product> findByCategories(ProductCategory categories);

	/**
	 * Find by ID of reference: categories.id
	 */
	public List<Product> findByCategoriesId(Long categoriesId);

	/**
	 * Find by reference: attributeValues
	 */
	public List<Product> findByAttributeValues(
			ProductAttributeValue attributeValues);

	/**
	 * Find by ID of reference: attributeValues.id
	 */
	public List<Product> findByAttributeValuesId(Long attributeValuesId);
}
