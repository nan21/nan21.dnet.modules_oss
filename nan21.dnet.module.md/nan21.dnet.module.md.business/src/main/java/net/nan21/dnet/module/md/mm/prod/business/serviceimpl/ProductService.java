/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeValue;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductCategory;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductManufacturer;

/**
 * Repository functionality for {@link Product} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductService extends AbstractEntityService<Product> {

	public ProductService() {
		super();
	}

	public ProductService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Product> getEntityClass() {
		return Product.class;
	}

	/**
	 * Find by unique key
	 */
	public Product findByCode(String code) {
		return (Product) this.getEntityManager()
				.createNamedQuery(Product.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Product findByName(String name) {
		return (Product) this.getEntityManager()
				.createNamedQuery(Product.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: defaultUom
	 */
	public List<Product> findByDefaultUom(Uom defaultUom) {
		return this.findByDefaultUomId(defaultUom.getId());
	}

	/**
	 * Find by ID of reference: defaultUom.id
	 */
	public List<Product> findByDefaultUomId(Long defaultUomId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :pClientId and e.defaultUom.id = :pDefaultUomId",
						Product.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDefaultUomId", defaultUomId).getResultList();
	}

	/**
	 * Find by reference: weightUom
	 */
	public List<Product> findByWeightUom(Uom weightUom) {
		return this.findByWeightUomId(weightUom.getId());
	}

	/**
	 * Find by ID of reference: weightUom.id
	 */
	public List<Product> findByWeightUomId(Long weightUomId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :pClientId and e.weightUom.id = :pWeightUomId",
						Product.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pWeightUomId", weightUomId).getResultList();
	}

	/**
	 * Find by reference: volumeUom
	 */
	public List<Product> findByVolumeUom(Uom volumeUom) {
		return this.findByVolumeUomId(volumeUom.getId());
	}

	/**
	 * Find by ID of reference: volumeUom.id
	 */
	public List<Product> findByVolumeUomId(Long volumeUomId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :pClientId and e.volumeUom.id = :pVolumeUomId",
						Product.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pVolumeUomId", volumeUomId).getResultList();
	}

	/**
	 * Find by reference: dimUom
	 */
	public List<Product> findByDimUom(Uom dimUom) {
		return this.findByDimUomId(dimUom.getId());
	}

	/**
	 * Find by ID of reference: dimUom.id
	 */
	public List<Product> findByDimUomId(Long dimUomId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :pClientId and e.dimUom.id = :pDimUomId",
						Product.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDimUomId", dimUomId).getResultList();
	}

	/**
	 * Find by reference: manufacturer
	 */
	public List<Product> findByManufacturer(ProductManufacturer manufacturer) {
		return this.findByManufacturerId(manufacturer.getId());
	}

	/**
	 * Find by ID of reference: manufacturer.id
	 */
	public List<Product> findByManufacturerId(Long manufacturerId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :pClientId and e.manufacturer.id = :pManufacturerId",
						Product.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pManufacturerId", manufacturerId)
				.getResultList();
	}

	/**
	 * Find by reference: attributeSet
	 */
	public List<Product> findByAttributeSet(AttributeSet attributeSet) {
		return this.findByAttributeSetId(attributeSet.getId());
	}

	/**
	 * Find by ID of reference: attributeSet.id
	 */
	public List<Product> findByAttributeSetId(Long attributeSetId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select e from Product e where e.clientId = :pClientId and e.attributeSet.id = :pAttributeSetId",
						Product.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAttributeSetId", attributeSetId)
				.getResultList();
	}

	/**
	 * Find by reference: categories
	 */
	public List<Product> findByCategories(ProductCategory categories) {
		return this.findByCategoriesId(categories.getId());
	}

	/**
	 * Find by ID of reference: categories.id
	 */
	public List<Product> findByCategoriesId(Long categoriesId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Product e, IN (e.categories) c where e.clientId = :pClientId and c.id = :pCategoriesId",
						Product.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCategoriesId", categoriesId).getResultList();
	}

	/**
	 * Find by reference: attributeValues
	 */
	public List<Product> findByAttributeValues(
			ProductAttributeValue attributeValues) {
		return this.findByAttributeValuesId(attributeValues.getId());
	}

	/**
	 * Find by ID of reference: attributeValues.id
	 */
	public List<Product> findByAttributeValuesId(Long attributeValuesId) {
		return (List<Product>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Product e, IN (e.attributeValues) c where e.clientId = :pClientId and c.id = :pAttributeValuesId",
						Product.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAttributeValuesId", attributeValuesId)
				.getResultList();
	}
}
