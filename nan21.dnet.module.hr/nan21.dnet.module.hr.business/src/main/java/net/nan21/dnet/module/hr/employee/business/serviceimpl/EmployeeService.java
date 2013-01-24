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
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;

/**
 * Repository functionality for {@link Employee} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class EmployeeService extends AbstractEntityService<Employee>
		implements
			IEmployeeService {

	public EmployeeService() {
		super();
	}

	public EmployeeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Employee> getEntityClass() {
		return Employee.class;
	}

	/**
	 * Find by unique key
	 */
	public Employee findByCode(String code) {
		return (Employee) this.getEntityManager()
				.createNamedQuery(Employee.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by reference: contacts
	 */
	public List<Employee> findByContacts(EmployeeContact contacts) {
		return this.findByContactsId(contacts.getId());
	}

	/**
	 * Find by ID of reference: contacts.id
	 */
	public List<Employee> findByContactsId(Long contactsId) {
		return (List<Employee>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Employee e, IN (e.contacts) c where e.clientId = :pClientId and c.id = :pContactsId",
						Employee.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pContactsId", contactsId).getResultList();
	}
}
