/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;

/**
 * Interface to expose business functions specific for {@link Employee} domain
 * entity.
 */
public interface IEmployeeService extends IEntityService<Employee> {

	/**
	 * Find by unique key
	 */
	public Employee findByCode(String code);

	/**
	 * Find by reference: contacts
	 */
	public List<Employee> findByContacts(EmployeeContact contacts);

	/**
	 * Find by ID of reference: contacts.id
	 */
	public List<Employee> findByContactsId(Long contactsId);
}
