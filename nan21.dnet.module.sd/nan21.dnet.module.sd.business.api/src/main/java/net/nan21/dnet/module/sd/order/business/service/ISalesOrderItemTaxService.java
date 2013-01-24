/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

/**
 * Interface to expose business functions specific for {@link SalesOrderItemTax} domain
 * entity.
 */
public interface ISalesOrderItemTaxService
		extends
			IEntityService<SalesOrderItemTax> {

	/**
	 * Find by reference: salesOrderItem
	 */
	public List<SalesOrderItemTax> findBySalesOrderItem(
			SalesOrderItem salesOrderItem);

	/**
	 * Find by ID of reference: salesOrderItem.id
	 */
	public List<SalesOrderItemTax> findBySalesOrderItemId(Long salesOrderItemId);

	/**
	 * Find by reference: tax
	 */
	public List<SalesOrderItemTax> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<SalesOrderItemTax> findByTaxId(Long taxId);
}
