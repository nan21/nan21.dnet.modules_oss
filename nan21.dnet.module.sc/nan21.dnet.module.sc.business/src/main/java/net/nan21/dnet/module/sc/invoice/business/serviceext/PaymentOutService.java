/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.serviceext;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.sc._businessdelegates.invoice.PaymentOutToAccDocBD;
import net.nan21.dnet.module.sc.invoice.business.service.IPaymentOutService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;

/**
 * Business extensions specific for {@link PaymentOut} domain entity.
 * 
 */
public class PaymentOutService extends
		net.nan21.dnet.module.sc.invoice.business.serviceimpl.PaymentOutService
		implements IPaymentOutService {

	@Override
	public void doPost(PaymentOut payment) throws BusinessException {
		this.getBusinessDelegate(PaymentOutToAccDocBD.class).post(payment);
	}

	@Override
	public void doUnPost(PaymentOut payment) throws BusinessException {
		this.getBusinessDelegate(PaymentOutToAccDocBD.class).unPost(payment);
	}

}
