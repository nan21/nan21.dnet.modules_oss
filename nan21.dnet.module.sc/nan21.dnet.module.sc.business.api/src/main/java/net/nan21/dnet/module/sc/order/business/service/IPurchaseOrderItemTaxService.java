/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItemTax;

/**
 * Interface to expose business functions specific for {@link PurchaseOrderItemTax} domain
 * entity.
 */
public interface IPurchaseOrderItemTaxService
		extends
			IEntityService<PurchaseOrderItemTax> {

	/**
	 * Find by reference: purchaseOrderItem
	 */
	public List<PurchaseOrderItemTax> findByPurchaseOrderItem(
			PurchaseOrderItem purchaseOrderItem);

	/**
	 * Find by ID of reference: purchaseOrderItem.id
	 */
	public List<PurchaseOrderItemTax> findByPurchaseOrderItemId(
			Long purchaseOrderItemId);

	/**
	 * Find by reference: tax
	 */
	public List<PurchaseOrderItemTax> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<PurchaseOrderItemTax> findByTaxId(Long taxId);
}
