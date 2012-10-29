/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.sd.invoice.business.service.IPaymentInService;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentIn;

import net.nan21.dnet.module.sd._businessdelegates.invoice.PaymentInToAccDocBD;

public class PaymentInService extends AbstractEntityService<PaymentIn>
		implements IPaymentInService {
 
	public PaymentInService() {
		super();
	}

	public PaymentInService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<PaymentIn> getEntityClass() {
		return PaymentIn.class;
	}
	
	public void doPost(PaymentIn payment) throws Exception {
		this.getBusinessDelegate(PaymentInToAccDocBD.class).post(payment);
	}
	
	public void doUnPost(PaymentIn payment) throws Exception {
		this.getBusinessDelegate(PaymentInToAccDocBD.class).unPost(payment);
	}
}
