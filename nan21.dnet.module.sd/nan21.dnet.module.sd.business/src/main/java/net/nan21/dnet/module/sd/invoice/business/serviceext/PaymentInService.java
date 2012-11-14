/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.serviceext;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.sd._businessdelegates.invoice.PaymentInToAccDocBD;
import net.nan21.dnet.module.sd.invoice.business.service.IPaymentInService;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentIn;

/**
 * Business extensions specific for {@link PaymentIn} domain entity.
 * 
 */
public class PaymentInService extends
		net.nan21.dnet.module.sd.invoice.business.serviceimpl.PaymentInService
		implements IPaymentInService {

	@Override
	public void doPost(PaymentIn payment) throws BusinessException {
		this.getBusinessDelegate(PaymentInToAccDocBD.class).post(payment);
	}

	@Override
	public void doUnPost(PaymentIn payment) throws BusinessException {
		this.getBusinessDelegate(PaymentInToAccDocBD.class).unPost(payment);
	}

}
