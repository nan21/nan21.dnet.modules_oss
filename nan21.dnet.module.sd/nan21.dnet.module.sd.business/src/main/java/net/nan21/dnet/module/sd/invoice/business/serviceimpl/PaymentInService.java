/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentIn;

/**
 * Repository functionality for {@link PaymentIn} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PaymentInService extends AbstractEntityService<PaymentIn> {

	public PaymentInService() {
		super();
	}

	public PaymentInService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PaymentIn> getEntityClass() {
		return PaymentIn.class;
	}
}
