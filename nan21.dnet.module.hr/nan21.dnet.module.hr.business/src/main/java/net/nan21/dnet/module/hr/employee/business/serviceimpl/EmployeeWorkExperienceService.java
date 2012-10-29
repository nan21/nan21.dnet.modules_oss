/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
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


public class EmployeeWorkExperienceService extends AbstractEntityService<EmployeeWorkExperience>
		implements IEmployeeWorkExperienceService {
 
	public EmployeeWorkExperienceService() {
		super();
	}

	public EmployeeWorkExperienceService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<EmployeeWorkExperience> getEntityClass() {
		return EmployeeWorkExperience.class;
	}
	
	public List<EmployeeWorkExperience> findByEmployee(Employee employee) {
		return this.findByEmployeeId(employee.getId()); 
	}
	
	public List<EmployeeWorkExperience> findByEmployeeId(Long employeeId) {
		return (List<EmployeeWorkExperience>) this.em
			.createQuery("select e from EmployeeWorkExperience e where e.clientId = :pClientId and e.employee.id = :pEmployeeId", EmployeeWorkExperience.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pEmployeeId", employeeId)			 	
			.getResultList(); 
	}
}
