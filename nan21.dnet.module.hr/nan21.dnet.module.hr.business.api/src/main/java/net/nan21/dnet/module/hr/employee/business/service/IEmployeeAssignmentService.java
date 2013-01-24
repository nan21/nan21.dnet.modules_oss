/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAssignment;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

/**
 * Interface to expose business functions specific for {@link EmployeeAssignment} domain
 * entity.
 */
public interface IEmployeeAssignmentService
		extends
			IEntityService<EmployeeAssignment> {

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeAssignment> findByEmployee(Employee employee);

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeAssignment> findByEmployeeId(Long employeeId);

	/**
	 * Find by reference: type
	 */
	public List<EmployeeAssignment> findByType(EmploymentType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<EmployeeAssignment> findByTypeId(Long typeId);

	/**
	 * Find by reference: position
	 */
	public List<EmployeeAssignment> findByPosition(Position position);

	/**
	 * Find by ID of reference: position.id
	 */
	public List<EmployeeAssignment> findByPositionId(Long positionId);

	/**
	 * Find by reference: job
	 */
	public List<EmployeeAssignment> findByJob(Job job);

	/**
	 * Find by ID of reference: job.id
	 */
	public List<EmployeeAssignment> findByJobId(Long jobId);

	/**
	 * Find by reference: org
	 */
	public List<EmployeeAssignment> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<EmployeeAssignment> findByOrgId(Long orgId);

	/**
	 * Find by reference: grade
	 */
	public List<EmployeeAssignment> findByGrade(Grade grade);

	/**
	 * Find by ID of reference: grade.id
	 */
	public List<EmployeeAssignment> findByGradeId(Long gradeId);

	/**
	 * Find by reference: payroll
	 */
	public List<EmployeeAssignment> findByPayroll(Payroll payroll);

	/**
	 * Find by ID of reference: payroll.id
	 */
	public List<EmployeeAssignment> findByPayrollId(Long payrollId);
}
