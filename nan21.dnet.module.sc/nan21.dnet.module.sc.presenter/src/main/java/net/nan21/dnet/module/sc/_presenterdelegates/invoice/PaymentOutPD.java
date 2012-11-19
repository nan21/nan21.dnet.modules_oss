package net.nan21.dnet.module.sc._presenterdelegates.invoice;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.sc.invoice.business.service.IPaymentOutService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;
import net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutDs;

public class PaymentOutPD extends AbstractPresenterBaseService {

	/**
	 * Confirm document.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void confirm(PaymentOutDs ds) throws Exception {
		IPaymentOutService srv = ((IPaymentOutService) this
				.findEntityService(PaymentOut.class));
		PaymentOut e = srv.findById(ds.getId());
		srv.doConfirm(e);

	}

	/**
	 * Un-Confirm document.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void unConfirm(PaymentOutDs ds) throws Exception {
		IPaymentOutService srv = ((IPaymentOutService) this
				.findEntityService(PaymentOut.class));
		PaymentOut e = srv.findById(ds.getId());
		srv.doUnConfirm(e);
	}

	/**
	 * Post document to accounting.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void post(PaymentOutDs ds) throws Exception {
		IPaymentOutService srv = ((IPaymentOutService) this
				.findEntityService(PaymentOut.class));
		PaymentOut e = srv.findById(ds.getId());
		srv.doPost(e);
	}

	/**
	 * Un-Post document from accounting.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void unPost(PaymentOutDs ds) throws Exception {
		IPaymentOutService srv = ((IPaymentOutService) this
				.findEntityService(PaymentOut.class));
		PaymentOut e = srv.findById(ds.getId());
		srv.doUnPost(e);
	}
}
