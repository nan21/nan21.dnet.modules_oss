/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItemTax;

/**
 * Interface to expose business functions specific for {@link PurchaseOrderItem} domain
 * entity.
 */
public interface IPurchaseOrderItemService
		extends
			IEntityService<PurchaseOrderItem> {

	/**
	 * Find by reference: purchaseOrder
	 */
	public List<PurchaseOrderItem> findByPurchaseOrder(
			PurchaseOrder purchaseOrder);

	/**
	 * Find by ID of reference: purchaseOrder.id
	 */
	public List<PurchaseOrderItem> findByPurchaseOrderId(Long purchaseOrderId);

	/**
	 * Find by reference: product
	 */
	public List<PurchaseOrderItem> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<PurchaseOrderItem> findByProductId(Long productId);

	/**
	 * Find by reference: uom
	 */
	public List<PurchaseOrderItem> findByUom(Uom uom);

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<PurchaseOrderItem> findByUomId(Long uomId);

	/**
	 * Find by reference: tax
	 */
	public List<PurchaseOrderItem> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<PurchaseOrderItem> findByTaxId(Long taxId);

	/**
	 * Find by reference: itemTaxes
	 */
	public List<PurchaseOrderItem> findByItemTaxes(
			PurchaseOrderItemTax itemTaxes);

	/**
	 * Find by ID of reference: itemTaxes.id
	 */
	public List<PurchaseOrderItem> findByItemTaxesId(Long itemTaxesId);
}
