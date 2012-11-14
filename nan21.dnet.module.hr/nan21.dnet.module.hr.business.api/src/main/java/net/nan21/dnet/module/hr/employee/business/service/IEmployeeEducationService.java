/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeEducation;

/**
 * Interface to expose business functions specific for {@link EmployeeEducation} domain
 * entity.
 */
public interface IEmployeeEducationService
		extends
			IEntityService<EmployeeEducation> {

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeEducation> findByEmployee(Employee employee);

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeEducation> findByEmployeeId(Long employeeId);

	/**
	 * Find by reference: type
	 */
	public List<EmployeeEducation> findByType(EducationType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<EmployeeEducation> findByTypeId(Long typeId);
}
