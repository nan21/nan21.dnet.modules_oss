/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItemTax;

/**
 * Repository functionality for {@link PurchaseOrderItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PurchaseOrderItemService
		extends
			AbstractEntityService<PurchaseOrderItem> {

	public PurchaseOrderItemService() {
		super();
	}

	public PurchaseOrderItemService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PurchaseOrderItem> getEntityClass() {
		return PurchaseOrderItem.class;
	}

	/**
	 * Find by reference: purchaseOrder
	 */
	public List<PurchaseOrderItem> findByPurchaseOrder(
			PurchaseOrder purchaseOrder) {
		return this.findByPurchaseOrderId(purchaseOrder.getId());
	}

	/**
	 * Find by ID of reference: purchaseOrder.id
	 */
	public List<PurchaseOrderItem> findByPurchaseOrderId(Long purchaseOrderId) {
		return (List<PurchaseOrderItem>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseOrderItem e where e.clientId = :pClientId and e.purchaseOrder.id = :pPurchaseOrderId",
						PurchaseOrderItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPurchaseOrderId", purchaseOrderId)
				.getResultList();
	}

	/**
	 * Find by reference: product
	 */
	public List<PurchaseOrderItem> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}

	/**
	 * Find by ID of reference: product.id
	 */
	public List<PurchaseOrderItem> findByProductId(Long productId) {
		return (List<PurchaseOrderItem>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseOrderItem e where e.clientId = :pClientId and e.product.id = :pProductId",
						PurchaseOrderItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId).getResultList();
	}

	/**
	 * Find by reference: uom
	 */
	public List<PurchaseOrderItem> findByUom(Uom uom) {
		return this.findByUomId(uom.getId());
	}

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<PurchaseOrderItem> findByUomId(Long uomId) {
		return (List<PurchaseOrderItem>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseOrderItem e where e.clientId = :pClientId and e.uom.id = :pUomId",
						PurchaseOrderItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pUomId", uomId).getResultList();
	}

	/**
	 * Find by reference: tax
	 */
	public List<PurchaseOrderItem> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<PurchaseOrderItem> findByTaxId(Long taxId) {
		return (List<PurchaseOrderItem>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseOrderItem e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						PurchaseOrderItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}

	/**
	 * Find by reference: itemTaxes
	 */
	public List<PurchaseOrderItem> findByItemTaxes(
			PurchaseOrderItemTax itemTaxes) {
		return this.findByItemTaxesId(itemTaxes.getId());
	}

	/**
	 * Find by ID of reference: itemTaxes.id
	 */
	public List<PurchaseOrderItem> findByItemTaxesId(Long itemTaxesId) {
		return (List<PurchaseOrderItem>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from PurchaseOrderItem e, IN (e.itemTaxes) c where e.clientId = :pClientId and c.id = :pItemTaxesId",
						PurchaseOrderItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pItemTaxesId", itemTaxesId).getResultList();
	}
}
