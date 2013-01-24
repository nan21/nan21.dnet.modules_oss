/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeEducationService;
import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeEducation;

/**
 * Repository functionality for {@link EmployeeEducation} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class EmployeeEducationService
		extends
			AbstractEntityService<EmployeeEducation>
		implements
			IEmployeeEducationService {

	public EmployeeEducationService() {
		super();
	}

	public EmployeeEducationService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<EmployeeEducation> getEntityClass() {
		return EmployeeEducation.class;
	}

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeEducation> findByEmployee(Employee employee) {
		return this.findByEmployeeId(employee.getId());
	}

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeEducation> findByEmployeeId(Long employeeId) {
		return (List<EmployeeEducation>) this
				.getEntityManager()
				.createQuery(
						"select e from EmployeeEducation e where e.clientId = :pClientId and e.employee.id = :pEmployeeId",
						EmployeeEducation.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEmployeeId", employeeId).getResultList();
	}

	/**
	 * Find by reference: type
	 */
	public List<EmployeeEducation> findByType(EducationType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<EmployeeEducation> findByTypeId(Long typeId) {
		return (List<EmployeeEducation>) this
				.getEntityManager()
				.createQuery(
						"select e from EmployeeEducation e where e.clientId = :pClientId and e.type.id = :pTypeId",
						EmployeeEducation.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}
}
