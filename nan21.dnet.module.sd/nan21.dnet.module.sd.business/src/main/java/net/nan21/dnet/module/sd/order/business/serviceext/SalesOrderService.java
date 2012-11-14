/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.order.business.serviceext;

import java.util.Date;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;
import net.nan21.dnet.module.sd._businessdelegates.order.SalesOrderToDeliveryBD;
import net.nan21.dnet.module.sd._businessdelegates.order.SalesOrderToInvoiceBD;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

/**
 * Business extensions specific for {@link SalesOrder} domain entity.
 * 
 */
public class SalesOrderService extends
		net.nan21.dnet.module.sd.order.business.serviceimpl.SalesOrderService
		implements ISalesOrderService {

	@Override
	public void doGenerateInvoice(SalesOrder salesOrder, TxDocType invDocType)
			throws BusinessException {
		this.getBusinessDelegate(SalesOrderToInvoiceBD.class).generateInvoice(
				salesOrder, invDocType);
	}

	@Override
	public void doGenerateDelivery(SalesOrder salesOrder,
			TxDocType deliveryDocType, InvTransactionType delivTxType,
			Date delivEventDate) throws BusinessException {
		this.getBusinessDelegate(SalesOrderToDeliveryBD.class)
				.generateDelivery(salesOrder, deliveryDocType, delivTxType,
						delivEventDate);

	}

}
