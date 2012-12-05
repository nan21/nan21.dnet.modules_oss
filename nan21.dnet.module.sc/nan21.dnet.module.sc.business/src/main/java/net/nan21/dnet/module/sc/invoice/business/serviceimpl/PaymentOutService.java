/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;

/**
 * Repository functionality for {@link PaymentOut} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PaymentOutService extends AbstractEntityService<PaymentOut> {

	public PaymentOutService() {
		super();
	}

	public PaymentOutService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PaymentOut> getEntityClass() {
		return PaymentOut.class;
	}
}
