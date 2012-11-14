/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;

/**
 * Interface to expose business functions specific for {@link EducationType} domain
 * entity.
 */
public interface IEducationTypeService extends IEntityService<EducationType> {

	/**
	 * Find by unique key
	 */
	public EducationType findByName(String name);
}
