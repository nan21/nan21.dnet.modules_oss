/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tx.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.md.base.tx.business.service.IPaymentTermService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;


public class PaymentTermService extends AbstractEntityService<PaymentTerm>
		implements IPaymentTermService {
 
	public PaymentTermService() {
		super();
	}

	public PaymentTermService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<PaymentTerm> getEntityClass() {
		return PaymentTerm.class;
	}
	
	public PaymentTerm findByName(String name) {		 
		return (PaymentTerm) this.em
			.createNamedQuery(PaymentTerm.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
