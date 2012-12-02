package net.nan21.dnet.module.sc._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.sc.order.business.service.IPurchaseOrderService;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDs;
import net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDsParam;

public class PurchaseOrderPD extends AbstractPresenterBaseService {

	/**
	 * Confirm document.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void confirm(PurchaseOrderDs ds) throws Exception {

		IPurchaseOrderService srv = ((IPurchaseOrderService) this
				.findEntityService(PurchaseOrder.class));
		PurchaseOrder e = srv.findById(ds.getId());
		srv.doConfirm(e);

	}

	/**
	 * Un-Confirm document.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void unConfirm(PurchaseOrderDs ds) throws Exception {

		IPurchaseOrderService srv = ((IPurchaseOrderService) this
				.findEntityService(PurchaseOrder.class));
		PurchaseOrder e = srv.findById(ds.getId());
		srv.doUnConfirm(e);
	}

	/**
	 * Copy lines from another document. Delegate to the proper business
	 * service.
	 * 
	 * @param ds
	 * @param params
	 * @throws Exception
	 */
	public void copyLines(PurchaseOrderDs ds, PurchaseOrderDsParam params)
			throws Exception {
		IPurchaseOrderService srv = ((IPurchaseOrderService) this
				.findEntityService(PurchaseOrder.class));
		PurchaseOrder e = srv.findById(ds.getId());
		srv.doCopyLines(e, params.getCopyFromId());
	}

}