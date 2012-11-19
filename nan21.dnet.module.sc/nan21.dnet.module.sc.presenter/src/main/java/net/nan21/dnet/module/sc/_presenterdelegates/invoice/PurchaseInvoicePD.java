package net.nan21.dnet.module.sc._presenterdelegates.invoice;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.sc.invoice.business.service.IPurchaseInvoiceService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDs;

public class PurchaseInvoicePD extends AbstractPresenterBaseService {

	/**
	 * Confirm document.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void confirm(PurchaseInvoiceDs ds) throws Exception {
		IPurchaseInvoiceService srv = ((IPurchaseInvoiceService) this
				.findEntityService(PurchaseInvoice.class));
		PurchaseInvoice e = srv.findById(ds.getId());
		srv.doConfirm(e);
	}

	/**
	 * Un-Confirm document.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void unConfirm(PurchaseInvoiceDs ds) throws Exception {
		IPurchaseInvoiceService srv = ((IPurchaseInvoiceService) this
				.findEntityService(PurchaseInvoice.class));
		PurchaseInvoice e = srv.findById(ds.getId());
		srv.doUnConfirm(e);
	}

	/**
	 * Post document to accounting.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void post(PurchaseInvoiceDs ds) throws Exception {
		IPurchaseInvoiceService srv = ((IPurchaseInvoiceService) this
				.findEntityService(PurchaseInvoice.class));
		PurchaseInvoice e = srv.findById(ds.getId());
		srv.doPost(e);
	}

	/**
	 * Un-Post document from accounting.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void unPost(PurchaseInvoiceDs ds) throws Exception {
		IPurchaseInvoiceService srv = ((IPurchaseInvoiceService) this
				.findEntityService(PurchaseInvoice.class));
		PurchaseInvoice e = srv.findById(ds.getId());
		srv.doUnPost(e);
	}

}
