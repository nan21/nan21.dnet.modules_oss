/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.order.business.serviceext;

import java.util.Date;
import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;
import net.nan21.dnet.module.sd._businessdelegates.order.SalesOrderCreateLines;
import net.nan21.dnet.module.sd._businessdelegates.order.SalesOrderToDeliveryBD;
import net.nan21.dnet.module.sd._businessdelegates.order.SalesOrderToInvoiceBD;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderTax;

/**
 * Business extensions specific for {@link SalesOrder} domain entity.
 * 
 */
public class SalesOrderService extends
		net.nan21.dnet.module.sd.order.business.serviceimpl.SalesOrderService
		implements ISalesOrderService {

	@Override
	public void doConfirm(SalesOrder order) throws BusinessException {
		order.setConfirmed(true);
		this.getEntityManager().merge(order);
	}

	@Override
	public void doUnConfirm(SalesOrder order) throws BusinessException {
		order.setConfirmed(false);
		this.getEntityManager().merge(order);
	}

	@Override
	public void doCopyLines(SalesOrder target, Long sourceId)
			throws BusinessException {
		this.getBusinessDelegate(SalesOrderCreateLines.class).copyLines(target,
				sourceId);
	}

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

	@Override
	public void calculateAmounts(Long orderId) {
		this.getEntityManager().flush();
		Object[] x = (Object[]) this
				.getEntityManager()
				.createQuery(
						"select sum(i.netAmount), sum(i.taxAmount) from SalesOrderItem i where i.salesOrder.id = :orderId")
				.setParameter("orderId", orderId).getSingleResult();
		SalesOrder order = this.getEntityManager().find(SalesOrder.class,
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

		// re-create taxes
		// delete existing
		this.getEntityManager()
				.createQuery(
						"delete from " + SalesOrderTax.class.getSimpleName()
								+ " t " + " where t.salesOrder.id = :orderId")
				.setParameter("orderId", orderId).executeUpdate();

		// create new

		@SuppressWarnings("unchecked")
		List<Object[]> taxes = (List<Object[]>) this
				.getEntityManager()
				.createQuery(
						"select i.tax,  sum(i.baseAmount), sum(i.taxAmount) from "
								+ SalesOrderItemTax.class.getSimpleName()
								+ " i "
								+ " where i.salesOrderItem.salesOrder.id = :orderId "
								+ " group by i.tax ")
				.setParameter("orderId", orderId).getResultList();
		for (Object[] tax : taxes) {
			Tax t = (Tax) tax[0];
			Double baseval = (Double) tax[1];
			Double taxval = (Double) tax[2];
			if (baseval == null) {
				baseval = 0D;
			}
			if (taxval == null) {
				taxval = 0D;
			}

			SalesOrderTax ordTax = new SalesOrderTax();
			ordTax.setSalesOrder(order);
			ordTax.setTax(t);
			ordTax.setBaseAmount(baseval.floatValue());
			ordTax.setTaxAmount(taxval.floatValue());
			order.addToTaxes(ordTax);
		}

		this.getEntityManager().merge(order);
	}

}
