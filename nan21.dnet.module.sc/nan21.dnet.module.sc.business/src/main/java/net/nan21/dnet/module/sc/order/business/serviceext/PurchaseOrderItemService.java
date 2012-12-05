/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.sc.order.business.serviceext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.sc._businessdelegates.order.PurchaseTaxBD;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderItemService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItemTax;

public class PurchaseOrderItemService
		extends
		net.nan21.dnet.module.sc.order.business.serviceimpl.PurchaseOrderItemService
		implements IPurchaseOrderItemService {

	@Override
	protected void postInsert(PurchaseOrderItem e) throws BusinessException {
		this.calculateTaxes(e);
	}

	@Override
	protected void postUpdate(PurchaseOrderItem e) throws BusinessException {
		this.calculateTaxes(e);
	}

	@Override
	protected void postInsert(List<PurchaseOrderItem> list) {
		this.onItemsChange(list);
	}

	@Override
	protected void postUpdate(List<PurchaseOrderItem> list) {
		this.onItemsChange(list);
	}

	@Override
	protected void postDelete(List<PurchaseOrderItem> list) {
		this.onItemsChange(list);
	}

	@Override
	protected void preDeleteByIds(List<Object> ids, Map<String, Object> context) {
		context.put("docIds", this.findByIds(ids));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void postDeleteByIds(List<Object> ids, Map<String, Object> context) {
		this.onItemsChange((List<PurchaseOrderItem>) context.get("docIds"));
	}

	protected void onItemsChange(List<PurchaseOrderItem> list) {
		List<Long> docIds = new ArrayList<Long>();
		for (PurchaseOrderItem item : list) {
			if (!docIds.contains(item.getPurchaseOrder().getId())) {
				docIds.add(item.getPurchaseOrder().getId());
			}
		}
		for (Long id : docIds) {
			sendMessage("PurchaseOrderService-calculateAmounts", id);
		}
	}

	protected void calculateTaxes(PurchaseOrderItem item)
			throws BusinessException {

		if (item.getTax() != null) {
			PurchaseTaxBD delegate = this
					.getBusinessDelegate(PurchaseTaxBD.class);
			List<PurchaseOrderItemTax> itemTaxes = new ArrayList<PurchaseOrderItemTax>();

			delegate.createItemTax(item, null, itemTaxes);
			Float taxAmount = 0F;
			for (PurchaseOrderItemTax itemTax : itemTaxes) {
				taxAmount += itemTax.getTaxAmount();
			}
			item.setTaxAmount(taxAmount);
			this.getEntityManager().merge(item);

			this.getEntityManager()
					.createQuery(
							"delete from "
									+ PurchaseOrderItemTax.class
											.getSimpleName()
									+ " e where e.purchaseOrderItem.id = :itemId")
					.setParameter("itemId", item.getId()).executeUpdate();

			for (PurchaseOrderItemTax itemTax : itemTaxes) {
				this.getEntityManager().persist(itemTax);
			}
		}
	}

}
