/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;

/**
 * Interface to expose business functions specific for {@link EmploymentType} domain
 * entity.
 */
public interface IEmploymentTypeService extends IEntityService<EmploymentType> {

	/**
	 * Find by unique key
	 */
	public EmploymentType findByName(String name);
}
