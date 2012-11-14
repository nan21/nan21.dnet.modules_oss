/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceBalance;

/**
 * Interface to expose business functions specific for {@link AbsenceBalance} domain
 * entity.
 */
public interface IAbsenceBalanceService extends IEntityService<AbsenceBalance> {

	/**
	 * Find by reference: employee
	 */
	public List<AbsenceBalance> findByEmployee(Employee employee);

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<AbsenceBalance> findByEmployeeId(Long employeeId);
}
