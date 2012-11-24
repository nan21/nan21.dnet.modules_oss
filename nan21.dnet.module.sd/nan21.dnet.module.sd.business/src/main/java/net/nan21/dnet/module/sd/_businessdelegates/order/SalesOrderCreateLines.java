package net.nan21.dnet.module.sd._businessdelegates.order;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderItemService;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;

public class SalesOrderCreateLines extends AbstractBusinessDelegate {

	ISalesOrderItemService itemService;
	ISalesOrderService service;

	/**
	 * Create lines for the target order by copying them from the source order
	 * with the given ID
	 * 
	 * @param target
	 * @param sourceCode
	 * @throws BusinessException
	 */
	public void copyLines(SalesOrder target, Long sourceId)
			throws BusinessException {
		if (sourceId == null) {
			throw new BusinessException(
					"Cannot copy lines. No source order specified.");
		}
		SalesOrder source = this.getSalesOrderService().findById(sourceId);
		copyLines(target, source);
	}

	/**
	 * Create lines for the target order by copying them from the source
	 * 
	 * @param target
	 * @param source
	 * @throws BusinessException
	 */
	public void copyLines(SalesOrder target, SalesOrder source)
			throws BusinessException {
		if (source == null) {
			throw new BusinessException(
					"Cannot copy lines. No source order specified.");
		}
		List<SalesOrderItem> targetItems = new ArrayList<SalesOrderItem>();
		List<SalesOrderItem> sourceItems = this.getSalesOrderItemService()
				.findBySalesOrderId(source.getId());

		for (SalesOrderItem si : sourceItems) {
			SalesOrderItem ti = new SalesOrderItem();
			ti.setSalesOrder(target);

			ti.setLineAmount(si.getLineAmount());
			ti.setNetAmount(si.getNetAmount());
			ti.setUnitPrice(si.getUnitPrice());
			ti.setQuantity(si.getQuantity());
			ti.setUom(si.getUom());

			ti.setProduct(si.getProduct());
			ti.setTax(si.getTax());
			targetItems.add(ti);
		}

		this.getSalesOrderItemService().insert(targetItems);
	}

	/**
	 * Get the sales order items service
	 * 
	 * @return
	 * @throws BusinessException
	 */
	protected ISalesOrderItemService getSalesOrderItemService()
			throws BusinessException {

		if (this.itemService == null) {
			this.itemService = (ISalesOrderItemService) this
					.findEntityService(SalesOrderItem.class);
		}
		return this.itemService;
	}

	/**
	 * Get the sales order service
	 * 
	 * @return
	 * @throws BusinessException
	 */
	protected ISalesOrderService getSalesOrderService()
			throws BusinessException {

		if (this.service == null) {
			this.service = (ISalesOrderService) this
					.findEntityService(SalesOrder.class);
		}
		return this.service;
	}

}
