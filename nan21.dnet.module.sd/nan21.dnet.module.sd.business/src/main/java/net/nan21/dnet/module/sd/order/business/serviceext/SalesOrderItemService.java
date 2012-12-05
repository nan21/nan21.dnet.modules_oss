/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sd.order.business.serviceext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.sd._businessdelegates.order.SalesTaxBD;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderItemService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

public class SalesOrderItemService
		extends
		net.nan21.dnet.module.sd.order.business.serviceimpl.SalesOrderItemService
		implements ISalesOrderItemService {

	@Override
	protected void postUpdate(SalesOrderItem e) throws BusinessException {
		this.calculateTaxes(e);
	}

	@Override
	protected void postInsert(SalesOrderItem e) throws BusinessException {
		this.calculateTaxes(e);
	}

	@Override
	protected void postInsert(List<SalesOrderItem> list) {
		this.onItemsChange(list);
	}

	@Override
	protected void postUpdate(List<SalesOrderItem> list) {
		this.onItemsChange(list);
	}

	@Override
	protected void postDelete(List<SalesOrderItem> list) {
		this.onItemsChange(list);
	}

	@Override
	protected void preDeleteByIds(List<Object> ids, Map<String, Object> context) {
		context.put("docIds", this.findByIds(ids));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void postDeleteByIds(List<Object> ids, Map<String, Object> context) {
		this.onItemsChange((List<SalesOrderItem>) context.get("docIds"));
	}

	protected void onItemsChange(List<SalesOrderItem> list) {
		List<Long> docIds = new ArrayList<Long>();
		for (SalesOrderItem item : list) {
			if (!docIds.contains(item.getSalesOrder().getId())) {
				docIds.add(item.getSalesOrder().getId());
			}
		}
		for (Long id : docIds) {
			sendMessage("SalesOrderService-calculateAmounts", id);
		}
	}

	protected void calculateTaxes(SalesOrderItem item) throws BusinessException {

		if (item.getTax() != null) {
			SalesTaxBD delegate = this.getBusinessDelegate(SalesTaxBD.class);
			List<SalesOrderItemTax> itemTaxes = new ArrayList<SalesOrderItemTax>();

			delegate.createItemTax(item, null, itemTaxes);
			Float taxAmount = 0F;
			for (SalesOrderItemTax itemTax : itemTaxes) {
				taxAmount += itemTax.getTaxAmount();
			}
			item.setTaxAmount(taxAmount);
			this.getEntityManager().merge(item);
			this.getEntityManager()
					.createQuery(
							"delete from "
									+ SalesOrderItemTax.class.getSimpleName()
									+ " e where e.salesOrderItem.id = :itemId")
					.setParameter("itemId", item.getId()).executeUpdate();

			for (SalesOrderItemTax itemTax : itemTaxes) {
				this.getEntityManager().persist(itemTax);
			}
		}
	}

}
