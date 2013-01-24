/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.time.domain.entity.Absence;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

/**
 * Interface to expose business functions specific for {@link Absence} domain
 * entity.
 */
public interface IAbsenceService extends IEntityService<Absence> {

	/**
	 * Find by reference: employee
	 */
	public List<Absence> findByEmployee(Employee employee);

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<Absence> findByEmployeeId(Long employeeId);

	/**
	 * Find by reference: type
	 */
	public List<Absence> findByType(AbsenceType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Absence> findByTypeId(Long typeId);

	/**
	 * Find by reference: reason
	 */
	public List<Absence> findByReason(AbsenceReason reason);

	/**
	 * Find by ID of reference: reason.id
	 */
	public List<Absence> findByReasonId(Long reasonId);
}
