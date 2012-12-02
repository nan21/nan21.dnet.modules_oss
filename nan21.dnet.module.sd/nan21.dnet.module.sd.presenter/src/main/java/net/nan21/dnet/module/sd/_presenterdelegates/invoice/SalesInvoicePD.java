package net.nan21.dnet.module.sd._presenterdelegates.invoice;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.sd.invoice.business.service.ISalesInvoiceService;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs;
import net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDsParam;

public class SalesInvoicePD extends AbstractPresenterBaseService {

	/**
	 * Confirm document.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void confirm(SalesInvoiceDs ds) throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice e = srv.findById(ds.getId());
		srv.doConfirm(e);
	}

	/**
	 * Un-Confirm document.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void unConfirm(SalesInvoiceDs ds) throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice e = srv.findById(ds.getId());
		srv.doUnConfirm(e);
	}

	/**
	 * Post document to accounting.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void post(SalesInvoiceDs ds) throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice e = srv.findById(ds.getId());
		srv.doPost(e);
	}

	/**
	 * Un-Post document from accounting.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void unPost(SalesInvoiceDs ds) throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice e = srv.findById(ds.getId());
		srv.doUnPost(e);
	}

	/**
	 * Copy lines from another document. Delegate to the proper business
	 * service.
	 * 
	 * @param ds
	 * @param params
	 * @throws Exception
	 */
	public void copyLines(SalesInvoiceDs ds, SalesInvoiceDsParam params)
			throws Exception {
		ISalesInvoiceService srv = ((ISalesInvoiceService) this
				.findEntityService(SalesInvoice.class));
		SalesInvoice e = srv.findById(ds.getId());
		srv.doCopyLines(e, params.getCopyFromId());
	}

}
