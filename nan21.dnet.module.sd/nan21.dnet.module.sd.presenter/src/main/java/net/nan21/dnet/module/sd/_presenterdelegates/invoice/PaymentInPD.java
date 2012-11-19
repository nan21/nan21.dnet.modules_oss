package net.nan21.dnet.module.sd._presenterdelegates.invoice;

import net.nan21.dnet.core.presenter.service.AbstractPresenterBaseService;
import net.nan21.dnet.module.sd.invoice.business.service.IPaymentInService;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentIn;
import net.nan21.dnet.module.sd.invoice.ds.model.PaymentInDs;

public class PaymentInPD extends AbstractPresenterBaseService {

	/**
	 * Confirm document.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void confirm(PaymentInDs ds) throws Exception {
		IPaymentInService srv = ((IPaymentInService) this
				.findEntityService(PaymentIn.class));
		PaymentIn e = srv.findById(ds.getId());
		srv.doConfirm(e);
	}

	/**
	 * Un-Confirm document.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void unConfirm(PaymentInDs ds) throws Exception {
		IPaymentInService srv = ((IPaymentInService) this
				.findEntityService(PaymentIn.class));
		PaymentIn e = srv.findById(ds.getId());
		srv.doUnConfirm(e);
	}

	/**
	 * Post document to accounting.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void post(PaymentInDs ds) throws Exception {
		IPaymentInService srv = ((IPaymentInService) this
				.findEntityService(PaymentIn.class));
		PaymentIn e = srv.findById(ds.getId());
		srv.doPost(e);
	}

	/**
	 * Un-Post document from accounting.<BR>
	 * Delegate to the proper business service.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void unPost(PaymentInDs ds) throws Exception {
		IPaymentInService srv = ((IPaymentInService) this
				.findEntityService(PaymentIn.class));
		PaymentIn e = srv.findById(ds.getId());
		srv.doUnPost(e);
	}
}
