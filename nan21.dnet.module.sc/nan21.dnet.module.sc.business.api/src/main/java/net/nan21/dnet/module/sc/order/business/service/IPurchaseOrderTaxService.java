/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderTax;

/**
 * Interface to expose business functions specific for {@link PurchaseOrderTax} domain
 * entity.
 */
public interface IPurchaseOrderTaxService
		extends
			IEntityService<PurchaseOrderTax> {

	/**
	 * Find by reference: purchaseOrder
	 */
	public List<PurchaseOrderTax> findByPurchaseOrder(
			PurchaseOrder purchaseOrder);

	/**
	 * Find by ID of reference: purchaseOrder.id
	 */
	public List<PurchaseOrderTax> findByPurchaseOrderId(Long purchaseOrderId);

	/**
	 * Find by reference: tax
	 */
	public List<PurchaseOrderTax> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<PurchaseOrderTax> findByTaxId(Long taxId);
}
