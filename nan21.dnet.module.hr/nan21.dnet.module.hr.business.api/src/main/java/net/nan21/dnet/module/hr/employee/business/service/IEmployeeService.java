/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContact;

public interface IEmployeeService extends IEntityService<Employee> {
	
	public Employee findByCode(String code);
	
	public List<Employee> findByContacts(EmployeeContact contacts);
	
	public List<Employee> findByContactsId(Long contactsId);
	
}
