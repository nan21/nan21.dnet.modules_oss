/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.prod.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductCategoryService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductCategory;

/**
 * Repository functionality for {@link ProductCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductCategoryService
		extends
			AbstractEntityService<ProductCategory>
		implements
			IProductCategoryService {

	public ProductCategoryService() {
		super();
	}

	public ProductCategoryService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProductCategory> getEntityClass() {
		return ProductCategory.class;
	}

	/**
	 * Find by unique key
	 */
	public ProductCategory findByCode(String code) {
		return (ProductCategory) this.getEntityManager()
				.createNamedQuery(ProductCategory.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ProductCategory findByName(String name) {
		return (ProductCategory) this.getEntityManager()
				.createNamedQuery(ProductCategory.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: category
	 */
	public List<ProductCategory> findByCategory(ProductCategory category) {
		return this.findByCategoryId(category.getId());
	}

	/**
	 * Find by ID of reference: category.id
	 */
	public List<ProductCategory> findByCategoryId(Long categoryId) {
		return (List<ProductCategory>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductCategory e where e.clientId = :pClientId and e.category.id = :pCategoryId",
						ProductCategory.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCategoryId", categoryId).getResultList();
	}

	/**
	 * Find by reference: products
	 */
	public List<ProductCategory> findByProducts(Product products) {
		return this.findByProductsId(products.getId());
	}

	/**
	 * Find by ID of reference: products.id
	 */
	public List<ProductCategory> findByProductsId(Long productsId) {
		return (List<ProductCategory>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from ProductCategory e, IN (e.products) c where e.clientId = :pClientId and c.id = :pProductsId",
						ProductCategory.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductsId", productsId).getResultList();
	}
}
