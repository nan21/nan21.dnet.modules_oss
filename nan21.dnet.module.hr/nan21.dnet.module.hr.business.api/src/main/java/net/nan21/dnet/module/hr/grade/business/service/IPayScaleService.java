/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.PayScale;

/**
 * Interface to expose business functions specific for {@link PayScale} domain
 * entity.
 */
public interface IPayScaleService extends IEntityService<PayScale> {

	/**
	 * Find by unique key
	 */
	public PayScale findByCode(String code);

	/**
	 * Find by unique key
	 */
	public PayScale findByName(String name);
}
