package net.nan21.dnet.module.sc._businessdelegates.order;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderItemService;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

public class PurchaseOrderCreateLines extends AbstractBusinessDelegate {

	IPurchaseOrderItemService itemService;
	IPurchaseOrderService service;

	/**
	 * Create lines for the target order by copying them from the source order
	 * with the given ID
	 * 
	 * @param target
	 * @param sourceCode
	 * @throws BusinessException
	 */
	public void copyLines(PurchaseOrder target, Long sourceId)
			throws BusinessException {
		if (sourceId == null) {
			throw new BusinessException(
					"Cannot copy lines. No source order specified.");
		}
		PurchaseOrder source = this.getPurchaseOrderService()
				.findById(sourceId);
		copyLines(target, source);
	}

	/**
	 * Create lines for the target order by copying them from the source
	 * 
	 * @param target
	 * @param source
	 * @throws BusinessException
	 */
	public void copyLines(PurchaseOrder target, PurchaseOrder source)
			throws BusinessException {
		if (source == null) {
			throw new BusinessException(
					"Cannot copy lines. No source order specified.");
		}
		List<PurchaseOrderItem> targetItems = new ArrayList<PurchaseOrderItem>();
		List<PurchaseOrderItem> sourceItems = this
				.getPurchaseOrderItemService().findByPurchaseOrderId(
						source.getId());

		for (PurchaseOrderItem si : sourceItems) {
			PurchaseOrderItem ti = new PurchaseOrderItem();
			ti.setPurchaseOrder(target);

			ti.setLineAmount(si.getLineAmount());
			ti.setNetAmount(si.getNetAmount());
			ti.setUnitPrice(si.getUnitPrice());
			ti.setQuantity(si.getQuantity());
			ti.setUom(si.getUom());

			ti.setProduct(si.getProduct());
			ti.setTax(si.getTax());
			targetItems.add(ti);
		}

		this.getPurchaseOrderItemService().insert(targetItems);
	}

	/**
	 * Get the purchase order items service
	 * 
	 * @return
	 * @throws BusinessException
	 */
	protected IPurchaseOrderItemService getPurchaseOrderItemService()
			throws BusinessException {

		if (this.itemService == null) {
			this.itemService = (IPurchaseOrderItemService) this
					.findEntityService(PurchaseOrderItem.class);
		}
		return this.itemService;
	}

	/**
	 * Get the purchase order service
	 * 
	 * @return
	 * @throws BusinessException
	 */
	protected IPurchaseOrderService getPurchaseOrderService()
			throws BusinessException {

		if (this.service == null) {
			this.service = (IPurchaseOrderService) this
					.findEntityService(PurchaseOrder.class);
		}
		return this.service;
	}

}
