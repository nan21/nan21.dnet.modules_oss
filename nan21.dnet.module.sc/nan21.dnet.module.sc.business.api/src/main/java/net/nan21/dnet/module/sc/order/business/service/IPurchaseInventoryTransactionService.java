/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseInventoryTransaction;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

/**
 * Interface to expose business functions specific for {@link PurchaseInventoryTransaction} domain
 * entity.
 */
public interface IPurchaseInventoryTransactionService
		extends
			IEntityService<PurchaseInventoryTransaction> {

	/**
	 * Find by reference: supplier
	 */
	public List<PurchaseInventoryTransaction> findBySupplier(
			BusinessPartner supplier);

	/**
	 * Find by ID of reference: supplier.id
	 */
	public List<PurchaseInventoryTransaction> findBySupplierId(Long supplierId);

	/**
	 * Find by reference: purchaseOrder
	 */
	public List<PurchaseInventoryTransaction> findByPurchaseOrder(
			PurchaseOrder purchaseOrder);

	/**
	 * Find by ID of reference: purchaseOrder.id
	 */
	public List<PurchaseInventoryTransaction> findByPurchaseOrderId(
			Long purchaseOrderId);
}
