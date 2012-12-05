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
import net.nan21.dnet.module.bd.attr.domain.entity.Attribute;
import net.nan21.dnet.module.md.mm.prod.business.service.IProductAttributeValueService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeValue;

/**
 * Repository functionality for {@link ProductAttributeValue} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductAttributeValueService
		extends
			AbstractEntityService<ProductAttributeValue>
		implements
			IProductAttributeValueService {

	public ProductAttributeValueService() {
		super();
	}

	public ProductAttributeValueService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProductAttributeValue> getEntityClass() {
		return ProductAttributeValue.class;
	}

	/**
	 * Find by unique key
	 */
	public ProductAttributeValue findByName(Product product, Attribute attribute) {
		return (ProductAttributeValue) this.getEntityManager()
				.createNamedQuery(ProductAttributeValue.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProduct", product)
				.setParameter("pAttribute", attribute).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ProductAttributeValue findByName(Long productId, Long attributeId) {
		return (ProductAttributeValue) this
				.getEntityManager()
				.createNamedQuery(
						ProductAttributeValue.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId)
				.setParameter("pAttributeId", attributeId).getSingleResult();
	}

	/**
	 * Find by reference: product
	 */
	public List<ProductAttributeValue> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}

	/**
	 * Find by ID of reference: product.id
	 */
	public List<ProductAttributeValue> findByProductId(Long productId) {
		return (List<ProductAttributeValue>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductAttributeValue e where e.clientId = :pClientId and e.product.id = :pProductId",
						ProductAttributeValue.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId).getResultList();
	}

	/**
	 * Find by reference: attribute
	 */
	public List<ProductAttributeValue> findByAttribute(Attribute attribute) {
		return this.findByAttributeId(attribute.getId());
	}

	/**
	 * Find by ID of reference: attribute.id
	 */
	public List<ProductAttributeValue> findByAttributeId(Long attributeId) {
		return (List<ProductAttributeValue>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductAttributeValue e where e.clientId = :pClientId and e.attribute.id = :pAttributeId",
						ProductAttributeValue.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAttributeId", attributeId).getResultList();
	}
}
