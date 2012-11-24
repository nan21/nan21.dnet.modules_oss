/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.business.serviceext;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.sc._businessdelegates.order.PurchaseOrderCreateLines;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

/**
 * Business extensions specific for {@link PurchaseOrder} domain entity.
 * 
 */
public class PurchaseOrderService
		extends
		net.nan21.dnet.module.sc.order.business.serviceimpl.PurchaseOrderService
		implements IPurchaseOrderService {

	/**
	 * Confirm document
	 */
	@Override
	public void doConfirm(PurchaseOrder order) throws BusinessException {
		order.setConfirmed(true);
		this.getEntityManager().merge(order);
	}

	/**
	 * Un-confirm document
	 */
	@Override
	public void doUnConfirm(PurchaseOrder order) throws BusinessException {
		order.setConfirmed(false);
		this.getEntityManager().merge(order);
	}

	@Override
	public void doCopyLines(PurchaseOrder target, Long sourceId)
			throws BusinessException {
		this.getBusinessDelegate(PurchaseOrderCreateLines.class).copyLines(
				target, sourceId);

	}

}
