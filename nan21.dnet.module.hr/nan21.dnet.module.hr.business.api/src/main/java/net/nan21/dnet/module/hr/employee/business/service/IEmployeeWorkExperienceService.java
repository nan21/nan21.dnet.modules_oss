/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeWorkExperience;

/**
 * Interface to expose business functions specific for {@link EmployeeWorkExperience} domain
 * entity.
 */
public interface IEmployeeWorkExperienceService
		extends
			IEntityService<EmployeeWorkExperience> {

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeWorkExperience> findByEmployee(Employee employee);

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeWorkExperience> findByEmployeeId(Long employeeId);
}
