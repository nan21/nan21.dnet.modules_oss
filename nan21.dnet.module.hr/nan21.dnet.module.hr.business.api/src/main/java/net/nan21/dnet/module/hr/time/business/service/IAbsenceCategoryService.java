/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceCategory;

/**
 * Interface to expose business functions specific for {@link AbsenceCategory} domain
 * entity.
 */
public interface IAbsenceCategoryService
		extends
			IEntityService<AbsenceCategory> {

	/**
	 * Find by unique key
	 */
	public AbsenceCategory findByName(String name);
}
