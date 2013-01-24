/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.training.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.training.business.service.IEmployeeCourseService;
import net.nan21.dnet.module.hr.training.domain.entity.Course;
import net.nan21.dnet.module.hr.training.domain.entity.EmployeeCourse;

/**
 * Repository functionality for {@link EmployeeCourse} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class EmployeeCourseService
		extends
			AbstractEntityService<EmployeeCourse>
		implements
			IEmployeeCourseService {

	public EmployeeCourseService() {
		super();
	}

	public EmployeeCourseService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<EmployeeCourse> getEntityClass() {
		return EmployeeCourse.class;
	}

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeCourse> findByEmployee(Employee employee) {
		return this.findByEmployeeId(employee.getId());
	}

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeCourse> findByEmployeeId(Long employeeId) {
		return (List<EmployeeCourse>) this
				.getEntityManager()
				.createQuery(
						"select e from EmployeeCourse e where e.clientId = :pClientId and e.employee.id = :pEmployeeId",
						EmployeeCourse.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEmployeeId", employeeId).getResultList();
	}

	/**
	 * Find by reference: course
	 */
	public List<EmployeeCourse> findByCourse(Course course) {
		return this.findByCourseId(course.getId());
	}

	/**
	 * Find by ID of reference: course.id
	 */
	public List<EmployeeCourse> findByCourseId(Long courseId) {
		return (List<EmployeeCourse>) this
				.getEntityManager()
				.createQuery(
						"select e from EmployeeCourse e where e.clientId = :pClientId and e.course.id = :pCourseId",
						EmployeeCourse.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCourseId", courseId).getResultList();
	}
}
