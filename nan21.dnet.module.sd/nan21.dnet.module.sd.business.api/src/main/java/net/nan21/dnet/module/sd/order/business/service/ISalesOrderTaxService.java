/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderTax;

/**
 * Interface to expose business functions specific for {@link SalesOrderTax} domain
 * entity.
 */
public interface ISalesOrderTaxService extends IEntityService<SalesOrderTax> {

	/**
	 * Find by reference: salesOrder
	 */
	public List<SalesOrderTax> findBySalesOrder(SalesOrder salesOrder);

	/**
	 * Find by ID of reference: salesOrder.id
	 */
	public List<SalesOrderTax> findBySalesOrderId(Long salesOrderId);

	/**
	 * Find by reference: tax
	 */
	public List<SalesOrderTax> findByTax(Tax tax);

	/**
	 * Find by ID of reference: tax.id
	 */
	public List<SalesOrderTax> findByTaxId(Long taxId);
}
