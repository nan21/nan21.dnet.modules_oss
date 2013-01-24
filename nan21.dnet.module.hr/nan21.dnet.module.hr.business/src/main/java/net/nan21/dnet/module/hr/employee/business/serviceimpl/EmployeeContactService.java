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
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeContactService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactType;

/**
 * Repository functionality for {@link EmployeeContact} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class EmployeeContactService
		extends
			AbstractEntityService<EmployeeContact>
		implements
			IEmployeeContactService {

	public EmployeeContactService() {
		super();
	}

	public EmployeeContactService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<EmployeeContact> getEntityClass() {
		return EmployeeContact.class;
	}

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeContact> findByEmployee(Employee employee) {
		return this.findByEmployeeId(employee.getId());
	}

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeContact> findByEmployeeId(Long employeeId) {
		return (List<EmployeeContact>) this
				.getEntityManager()
				.createQuery(
						"select e from EmployeeContact e where e.clientId = :pClientId and e.employee.id = :pEmployeeId",
						EmployeeContact.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEmployeeId", employeeId).getResultList();
	}

	/**
	 * Find by reference: type
	 */
	public List<EmployeeContact> findByType(EmployeeContactType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<EmployeeContact> findByTypeId(Long typeId) {
		return (List<EmployeeContact>) this
				.getEntityManager()
				.createQuery(
						"select e from EmployeeContact e where e.clientId = :pClientId and e.type.id = :pTypeId",
						EmployeeContact.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}

	/**
	 * Find by reference: relationship
	 */
	public List<EmployeeContact> findByRelationship(
			EmployeeContactRelationship relationship) {
		return this.findByRelationshipId(relationship.getId());
	}

	/**
	 * Find by ID of reference: relationship.id
	 */
	public List<EmployeeContact> findByRelationshipId(Long relationshipId) {
		return (List<EmployeeContact>) this
				.getEntityManager()
				.createQuery(
						"select e from EmployeeContact e where e.clientId = :pClientId and e.relationship.id = :pRelationshipId",
						EmployeeContact.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRelationshipId", relationshipId)
				.getResultList();
	}
}
