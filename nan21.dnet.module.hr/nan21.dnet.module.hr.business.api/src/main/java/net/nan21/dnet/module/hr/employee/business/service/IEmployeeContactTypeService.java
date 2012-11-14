/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactType;

/**
 * Interface to expose business functions specific for {@link EmployeeContactType} domain
 * entity.
 */
public interface IEmployeeContactTypeService
		extends
			IEntityService<EmployeeContactType> {

	/**
	 * Find by unique key
	 */
	public EmployeeContactType findByName(String name);
}
