/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.mm.price.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceListVersion;
import net.nan21.dnet.module.md.mm.price.domain.entity.ProductPrice;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;

/**
 * Repository functionality for {@link ProductPrice} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProductPriceService extends AbstractEntityService<ProductPrice> {

	public ProductPriceService() {
		super();
	}

	public ProductPriceService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProductPrice> getEntityClass() {
		return ProductPrice.class;
	}

	/**
	 * Find by unique key
	 */
	public ProductPrice findByName(PriceListVersion priceListVersion,
			Product product) {
		return (ProductPrice) this.getEntityManager()
				.createNamedQuery(ProductPrice.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPriceListVersion", priceListVersion)
				.setParameter("pProduct", product).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ProductPrice findByName(Long priceListVersionId, Long productId) {
		return (ProductPrice) this.getEntityManager()
				.createNamedQuery(ProductPrice.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPriceListVersionId", priceListVersionId)
				.setParameter("pProductId", productId).getSingleResult();
	}

	/**
	 * Find by reference: priceListVersion
	 */
	public List<ProductPrice> findByPriceListVersion(
			PriceListVersion priceListVersion) {
		return this.findByPriceListVersionId(priceListVersion.getId());
	}

	/**
	 * Find by ID of reference: priceListVersion.id
	 */
	public List<ProductPrice> findByPriceListVersionId(Long priceListVersionId) {
		return (List<ProductPrice>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductPrice e where e.clientId = :pClientId and e.priceListVersion.id = :pPriceListVersionId",
						ProductPrice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPriceListVersionId", priceListVersionId)
				.getResultList();
	}

	/**
	 * Find by reference: product
	 */
	public List<ProductPrice> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}

	/**
	 * Find by ID of reference: product.id
	 */
	public List<ProductPrice> findByProductId(Long productId) {
		return (List<ProductPrice>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductPrice e where e.clientId = :pClientId and e.product.id = :pProductId",
						ProductPrice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId).getResultList();
	}

	/**
	 * Find by reference: uom
	 */
	public List<ProductPrice> findByUom(Uom uom) {
		return this.findByUomId(uom.getId());
	}

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<ProductPrice> findByUomId(Long uomId) {
		return (List<ProductPrice>) this
				.getEntityManager()
				.createQuery(
						"select e from ProductPrice e where e.clientId = :pClientId and e.uom.id = :pUomId",
						ProductPrice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pUomId", uomId).getResultList();
	}
}
