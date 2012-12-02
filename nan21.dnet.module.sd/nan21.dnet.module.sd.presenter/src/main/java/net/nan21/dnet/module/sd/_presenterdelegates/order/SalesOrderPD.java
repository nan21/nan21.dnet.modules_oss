package net.nan21.dnet.module.sd._presenterdelegates.order;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;
import net.nan21.dnet.module.sd.order.business.service.ISalesOrderService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs;
import net.nan21.dnet.module.sd.order.ds.model.SalesOrderDsParam;

public class SalesOrderPD extends AbstractPresenterBaseService {

	/**
	 * Confirm document.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void confirm(SalesOrderDs ds) throws Exception {
		ISalesOrderService srv = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		SalesOrder e = srv.findById(ds.getId());
		srv.doConfirm(e);
	}

	/**
	 * Un-Confirm document.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void unConfirm(SalesOrderDs ds) throws Exception {
		ISalesOrderService srv = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		SalesOrder e = srv.findById(ds.getId());
		srv.doUnConfirm(e);
	}

	/**
	 * Generate invoice from the given sales order.
	 * 
	 * @param ds
	 * @param params
	 * @throws Exception
	 */
	public void generateInvoice(SalesOrderDs ds, SalesOrderDsParam params)
			throws Exception {
		ISalesOrderService service = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		TxDocType docType = service.getEntityManager().find(TxDocType.class,
				params.getInvDocTypeId());
		SalesOrder e = service.findById(ds.getId());
		service.doGenerateInvoice(e, docType);
	}

	/**
	 * Generate delivery document from the given sales order.
	 * 
	 * @param ds
	 * @param params
	 * @throws Exception
	 */
	public void generateDelivery(SalesOrderDs ds, SalesOrderDsParam params)
			throws Exception {
		ISalesOrderService service = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		TxDocType docType = service.getEntityManager().find(TxDocType.class,
				params.getDelivDocTypeId());
		InvTransactionType txType = service.getEntityManager().find(
				InvTransactionType.class, params.getDelivTxTypeId());

		SalesOrder e = service.findById(ds.getId());
		service.doGenerateDelivery(e, docType, txType,
				params.getDelivEventData());
	}

	/**
	 * Copy lines from another document. Delegate to the proper business
	 * service.
	 * 
	 * @param ds
	 * @param params
	 * @throws Exception
	 */
	public void copyLines(SalesOrderDs ds, SalesOrderDsParam params)
			throws Exception {
		ISalesOrderService srv = ((ISalesOrderService) this
				.findEntityService(SalesOrder.class));
		SalesOrder e = srv.findById(ds.getId());
		srv.doCopyLines(e, params.getCopyFromId());
	}

}
