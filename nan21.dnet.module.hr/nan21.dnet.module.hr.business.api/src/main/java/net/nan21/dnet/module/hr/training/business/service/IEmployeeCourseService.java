/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.training.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.training.domain.entity.Course;
import net.nan21.dnet.module.hr.training.domain.entity.EmployeeCourse;

/**
 * Interface to expose business functions specific for {@link EmployeeCourse} domain
 * entity.
 */
public interface IEmployeeCourseService extends IEntityService<EmployeeCourse> {

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeCourse> findByEmployee(Employee employee);

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeCourse> findByEmployeeId(Long employeeId);

	/**
	 * Find by reference: course
	 */
	public List<EmployeeCourse> findByCourse(Course course);

	/**
	 * Find by ID of reference: course.id
	 */
	public List<EmployeeCourse> findByCourseId(Long courseId);
}
