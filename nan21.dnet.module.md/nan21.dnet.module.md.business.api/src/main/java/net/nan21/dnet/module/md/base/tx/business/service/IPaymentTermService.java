/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tx.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;

/**
 * Interface to expose business functions specific for {@link PaymentTerm} domain
 * entity.
 */
public interface IPaymentTermService extends IEntityService<PaymentTerm> {

	/**
	 * Find by unique key
	 */
	public PaymentTerm findByName(String name);
}
