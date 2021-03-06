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
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeWorkExperienceService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeWorkExperience;

/**
 * Repository functionality for {@link EmployeeWorkExperience} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class EmployeeWorkExperienceService
		extends
			AbstractEntityService<EmployeeWorkExperience>
		implements
			IEmployeeWorkExperienceService {

	public EmployeeWorkExperienceService() {
		super();
	}

	public EmployeeWorkExperienceService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<EmployeeWorkExperience> getEntityClass() {
		return EmployeeWorkExperience.class;
	}

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeWorkExperience> findByEmployee(Employee employee) {
		return this.findByEmployeeId(employee.getId());
	}

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeWorkExperience> findByEmployeeId(Long employeeId) {
		return (List<EmployeeWorkExperience>) this
				.getEntityManager()
				.createQuery(
						"select e from EmployeeWorkExperience e where e.clientId = :pClientId and e.employee.id = :pEmployeeId",
						EmployeeWorkExperience.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEmployeeId", employeeId).getResultList();
	}
}
