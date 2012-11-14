/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

/**
 * Interface to expose business functions specific for {@link SalesOrderItem} domain
 * entity.
 */
public interface ISalesOrderItemService extends IEntityService<SalesOrderItem> {

	/**
	 * Find by reference: salesOrder
	 */
	public List<SalesOrderItem> findBySalesOrder(SalesOrder salesOrder);

	/**
	 * Find by ID of reference: salesOrder.id
	 */
	public List<SalesOrderItem> findBySalesOrderId(Long salesOrderId);

	/**
	 * Find by reference: product
	 */
	public List<SalesOrderItem> findByProduct(Product product);

	/**
	 * Find by ID of reference: product.id
	 */
	public List<SalesOrderItem> findByProductId(Long productId);

	/**
	 * Find by reference: uom
	 */
	public List<SalesOrderItem> findByUom(Uom uom);

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<SalesOrderItem> findByUomId(Long uomId);

	/**
	 * Find by reference: tax
	 */
	public List<SalesOrderItem> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<SalesOrderItem> findByTaxId(Long taxId);

	/**
	 * Find by reference: itemTaxes
	 */
	public List<SalesOrderItem> findByItemTaxes(SalesOrderItemTax itemTaxes);

	/**
	 * Find by ID of reference: itemTaxes.id
	 */
	public List<SalesOrderItem> findByItemTaxesId(Long itemTaxesId);
}
