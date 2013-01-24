/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.order.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

/**
 * Repository functionality for {@link SalesOrderItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SalesOrderItemService
		extends
			AbstractEntityService<SalesOrderItem> {

	public SalesOrderItemService() {
		super();
	}

	public SalesOrderItemService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SalesOrderItem> getEntityClass() {
		return SalesOrderItem.class;
	}

	/**
	 * Find by reference: salesOrder
	 */
	public List<SalesOrderItem> findBySalesOrder(SalesOrder salesOrder) {
		return this.findBySalesOrderId(salesOrder.getId());
	}

	/**
	 * Find by ID of reference: salesOrder.id
	 */
	public List<SalesOrderItem> findBySalesOrderId(Long salesOrderId) {
		return (List<SalesOrderItem>) this
				.getEntityManager()
				.createQuery(
						"select e from SalesOrderItem e where e.clientId = :pClientId and e.salesOrder.id = :pSalesOrderId",
						SalesOrderItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSalesOrderId", salesOrderId).getResultList();
	}

	/**
	 * Find by reference: product
	 */
	public List<SalesOrderItem> findByProduct(Product product) {
		return this.findByProductId(product.getId());
	}

	/**
	 * Find by ID of reference: product.id
	 */
	public List<SalesOrderItem> findByProductId(Long productId) {
		return (List<SalesOrderItem>) this
				.getEntityManager()
				.createQuery(
						"select e from SalesOrderItem e where e.clientId = :pClientId and e.product.id = :pProductId",
						SalesOrderItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProductId", productId).getResultList();
	}

	/**
	 * Find by reference: uom
	 */
	public List<SalesOrderItem> findByUom(Uom uom) {
		return this.findByUomId(uom.getId());
	}

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<SalesOrderItem> findByUomId(Long uomId) {
		return (List<SalesOrderItem>) this
				.getEntityManager()
				.createQuery(
						"select e from SalesOrderItem e where e.clientId = :pClientId and e.uom.id = :pUomId",
						SalesOrderItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pUomId", uomId).getResultList();
	}

	/**
	 * Find by reference: tax
	 */
	public List<SalesOrderItem> findByTax(Tax tax) {
		return this.findByTaxId(tax.getId());
	}

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<SalesOrderItem> findByTaxId(Long taxId) {
		return (List<SalesOrderItem>) this
				.getEntityManager()
				.createQuery(
						"select e from SalesOrderItem e where e.clientId = :pClientId and e.tax.id = :pTaxId",
						SalesOrderItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxId", taxId).getResultList();
	}

	/**
	 * Find by reference: itemTaxes
	 */
	public List<SalesOrderItem> findByItemTaxes(SalesOrderItemTax itemTaxes) {
		return this.findByItemTaxesId(itemTaxes.getId());
	}

	/**
	 * Find by ID of reference: itemTaxes.id
	 */
	public List<SalesOrderItem> findByItemTaxesId(Long itemTaxesId) {
		return (List<SalesOrderItem>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from SalesOrderItem e, IN (e.itemTaxes) c where e.clientId = :pClientId and c.id = :pItemTaxesId",
						SalesOrderItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pItemTaxesId", itemTaxesId).getResultList();
	}
}
