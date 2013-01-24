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
import net.nan21.dnet.module.hr.time.business.service.IAbsenceService;
import net.nan21.dnet.module.hr.time.domain.entity.Absence;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceReason;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceType;

/**
 * Repository functionality for {@link Absence} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AbsenceService extends AbstractEntityService<Absence>
		implements
			IAbsenceService {

	public AbsenceService() {
		super();
	}

	public AbsenceService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Absence> getEntityClass() {
		return Absence.class;
	}

	/**
	 * Find by reference: employee
	 */
	public List<Absence> findByEmployee(Employee employee) {
		return this.findByEmployeeId(employee.getId());
	}

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<Absence> findByEmployeeId(Long employeeId) {
		return (List<Absence>) this
				.getEntityManager()
				.createQuery(
						"select e from Absence e where e.clientId = :pClientId and e.employee.id = :pEmployeeId",
						Absence.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEmployeeId", employeeId).getResultList();
	}

	/**
	 * Find by reference: type
	 */
	public List<Absence> findByType(AbsenceType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Absence> findByTypeId(Long typeId) {
		return (List<Absence>) this
				.getEntityManager()
				.createQuery(
						"select e from Absence e where e.clientId = :pClientId and e.type.id = :pTypeId",
						Absence.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}

	/**
	 * Find by reference: reason
	 */
	public List<Absence> findByReason(AbsenceReason reason) {
		return this.findByReasonId(reason.getId());
	}

	/**
	 * Find by ID of reference: reason.id
	 */
	public List<Absence> findByReasonId(Long reasonId) {
		return (List<Absence>) this
				.getEntityManager()
				.createQuery(
						"select e from Absence e where e.clientId = :pClientId and e.reason.id = :pReasonId",
						Absence.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pReasonId", reasonId).getResultList();
	}
}
