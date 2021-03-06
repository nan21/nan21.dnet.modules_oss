/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceBalanceService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceBalance;

/**
 * Repository functionality for {@link AbsenceBalance} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AbsenceBalanceService
		extends
			AbstractEntityService<AbsenceBalance>
		implements
			IAbsenceBalanceService {

	public AbsenceBalanceService() {
		super();
	}

	public AbsenceBalanceService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AbsenceBalance> getEntityClass() {
		return AbsenceBalance.class;
	}

	/**
	 * Find by reference: employee
	 */
	public List<AbsenceBalance> findByEmployee(Employee employee) {
		return this.findByEmployeeId(employee.getId());
	}

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<AbsenceBalance> findByEmployeeId(Long employeeId) {
		return (List<AbsenceBalance>) this
				.getEntityManager()
				.createQuery(
						"select e from AbsenceBalance e where e.clientId = :pClientId and e.employee.id = :pEmployeeId",
						AbsenceBalance.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEmployeeId", employeeId).getResultList();
	}
}
