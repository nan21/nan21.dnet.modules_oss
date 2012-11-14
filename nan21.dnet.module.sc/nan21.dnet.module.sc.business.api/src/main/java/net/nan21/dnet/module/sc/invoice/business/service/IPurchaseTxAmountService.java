/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

/**
 * Interface to expose business functions specific for {@link PurchaseTxAmount} domain
 * entity.
 */
public interface IPurchaseTxAmountService
		extends
			IEntityService<PurchaseTxAmount> {

	/**
	 * Find by reference: order
	 */
	public List<PurchaseTxAmount> findByOrder(PurchaseOrder order);

	/**
	 * Find by ID of reference: order.id
	 */
	public List<PurchaseTxAmount> findByOrderId(Long orderId);

	/**
	 * Find by reference: invoice
	 */
	public List<PurchaseTxAmount> findByInvoice(PurchaseInvoice invoice);

	/**
	 * Find by ID of reference: invoice.id
	 */
	public List<PurchaseTxAmount> findByInvoiceId(Long invoiceId);
}
