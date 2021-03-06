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
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseInventoryTransactionService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseInventoryTransaction;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

/**
 * Repository functionality for {@link PurchaseInventoryTransaction} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PurchaseInventoryTransactionService
		extends
			AbstractEntityService<PurchaseInventoryTransaction>
		implements
			IPurchaseInventoryTransactionService {

	public PurchaseInventoryTransactionService() {
		super();
	}

	public PurchaseInventoryTransactionService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PurchaseInventoryTransaction> getEntityClass() {
		return PurchaseInventoryTransaction.class;
	}

	/**
	 * Find by reference: supplier
	 */
	public List<PurchaseInventoryTransaction> findBySupplier(
			BusinessPartner supplier) {
		return this.findBySupplierId(supplier.getId());
	}

	/**
	 * Find by ID of reference: supplier.id
	 */
	public List<PurchaseInventoryTransaction> findBySupplierId(Long supplierId) {
		return (List<PurchaseInventoryTransaction>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInventoryTransaction e where e.clientId = :pClientId and e.supplier.id = :pSupplierId",
						PurchaseInventoryTransaction.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSupplierId", supplierId).getResultList();
	}

	/**
	 * Find by reference: purchaseOrder
	 */
	public List<PurchaseInventoryTransaction> findByPurchaseOrder(
			PurchaseOrder purchaseOrder) {
		return this.findByPurchaseOrderId(purchaseOrder.getId());
	}

	/**
	 * Find by ID of reference: purchaseOrder.id
	 */
	public List<PurchaseInventoryTransaction> findByPurchaseOrderId(
			Long purchaseOrderId) {
		return (List<PurchaseInventoryTransaction>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInventoryTransaction e where e.clientId = :pClientId and e.purchaseOrder.id = :pPurchaseOrderId",
						PurchaseInventoryTransaction.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPurchaseOrderId", purchaseOrderId)
				.getResultList();
	}
}
