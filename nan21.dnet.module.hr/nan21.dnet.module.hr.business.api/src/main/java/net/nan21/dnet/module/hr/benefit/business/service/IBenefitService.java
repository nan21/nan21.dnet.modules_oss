/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.benefit.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.benefit.domain.entity.Benefit;

/**
 * Interface to expose business functions specific for {@link Benefit} domain
 * entity.
 */
public interface IBenefitService extends IEntityService<Benefit> {

	/**
	 * Find by unique key
	 */
	public Benefit findByName(String name);
}
