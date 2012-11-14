/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeLicense;
import net.nan21.dnet.module.hr.employee.domain.entity.LicenseType;

/**
 * Interface to expose business functions specific for {@link EmployeeLicense} domain
 * entity.
 */
public interface IEmployeeLicenseService
		extends
			IEntityService<EmployeeLicense> {

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeLicense> findByEmployee(Employee employee);

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeLicense> findByEmployeeId(Long employeeId);

	/**
	 * Find by reference: licenseType
	 */
	public List<EmployeeLicense> findByLicenseType(LicenseType licenseType);

	/**
	 * Find by ID of reference: licenseType.id
	 */
	public List<EmployeeLicense> findByLicenseTypeId(Long licenseTypeId);
}
