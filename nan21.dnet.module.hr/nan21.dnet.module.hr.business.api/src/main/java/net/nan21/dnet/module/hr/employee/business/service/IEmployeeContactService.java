/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactType;

/**
 * Interface to expose business functions specific for {@link EmployeeContact} domain
 * entity.
 */
public interface IEmployeeContactService
		extends
			IEntityService<EmployeeContact> {

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeContact> findByEmployee(Employee employee);

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeContact> findByEmployeeId(Long employeeId);

	/**
	 * Find by reference: type
	 */
	public List<EmployeeContact> findByType(EmployeeContactType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<EmployeeContact> findByTypeId(Long typeId);

	/**
	 * Find by reference: relationship
	 */
	public List<EmployeeContact> findByRelationship(
			EmployeeContactRelationship relationship);

	/**
	 * Find by ID of reference: relationship.id
	 */
	public List<EmployeeContact> findByRelationshipId(Long relationshipId);
}
