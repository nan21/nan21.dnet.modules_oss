/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.tx.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;

/**
 * Interface to expose business functions specific for {@link DeliveryMethod} domain
 * entity.
 */
public interface IDeliveryMethodService extends IEntityService<DeliveryMethod> {

	/**
	 * Find by unique key
	 */
	public DeliveryMethod findByName(String name);
}
