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

	@Override
	public void calculateAmounts(Long orderId) {
		this.getEntityManager().flush();
		Object[] x = (Object[]) this
				.getEntityManager()
				.createQuery(
						"select sum(i.netAmount), sum(i.taxAmount) from PurchaseOrderItem i where i.purchaseOrder.id = :orderId")
				.setParameter("orderId", orderId).getSingleResult();

		PurchaseOrder order = this.getEntityManager().find(PurchaseOrder.class,
				orderId);

		Double totalNet = (Double) x[0];
		Double totalTax = (Double) x[1];
		if (totalNet == null) {
			totalNet = 0D;
		}
		if (totalTax == null) {
			totalTax = 0D;
		}
		order.setTotalNetAmount(totalNet.floatValue());
		order.setTotalTaxAmount(totalTax.floatValue());

		this.getEntityManager().merge(order);
	}

}
