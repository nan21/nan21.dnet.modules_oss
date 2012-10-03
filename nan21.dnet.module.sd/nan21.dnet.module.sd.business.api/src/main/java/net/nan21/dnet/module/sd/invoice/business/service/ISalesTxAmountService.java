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

public interface ISalesTxAmountService extends IEntityService<SalesTxAmount> {
	
	public List<SalesTxAmount> findByOrder(SalesOrder order);
	
	public List<SalesTxAmount> findByOrderId(Long orderId);
	
	public List<SalesTxAmount> findByInvoice(SalesInvoice invoice);
	
	public List<SalesTxAmount> findByInvoiceId(Long invoiceId);
	
}
