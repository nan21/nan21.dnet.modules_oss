/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

/**
 * Interface to expose business functions specific for {@link SalesTxAmount} domain
 * entity.
 */
public interface ISalesTxAmountService extends IEntityService<SalesTxAmount> {

	/**
	 * Find by reference: order
	 */
	public List<SalesTxAmount> findByOrder(SalesOrder order);

	/**
	 * Find by ID of reference: order.id
	 */
	public List<SalesTxAmount> findByOrderId(Long orderId);

	/**
	 * Find by reference: invoice
	 */
	public List<SalesTxAmount> findByInvoice(SalesInvoice invoice);

	/**
	 * Find by ID of reference: invoice.id
	 */
	public List<SalesTxAmount> findByInvoiceId(Long invoiceId);
}
