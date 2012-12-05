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
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeLicenseService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeLicense;
import net.nan21.dnet.module.hr.employee.domain.entity.LicenseType;

/**
 * Repository functionality for {@link EmployeeLicense} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class EmployeeLicenseService
		extends
			AbstractEntityService<EmployeeLicense>
		implements
			IEmployeeLicenseService {

	public EmployeeLicenseService() {
		super();
	}

	public EmployeeLicenseService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<EmployeeLicense> getEntityClass() {
		return EmployeeLicense.class;
	}

	/**
	 * Find by reference: employee
	 */
	public List<EmployeeLicense> findByEmployee(Employee employee) {
		return this.findByEmployeeId(employee.getId());
	}

	/**
	 * Find by ID of reference: employee.id
	 */
	public List<EmployeeLicense> findByEmployeeId(Long employeeId) {
		return (List<EmployeeLicense>) this
				.getEntityManager()
				.createQuery(
						"select e from EmployeeLicense e where e.clientId = :pClientId and e.employee.id = :pEmployeeId",
						EmployeeLicense.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pEmployeeId", employeeId).getResultList();
	}

	/**
	 * Find by reference: licenseType
	 */
	public List<EmployeeLicense> findByLicenseType(LicenseType licenseType) {
		return this.findByLicenseTypeId(licenseType.getId());
	}

	/**
	 * Find by ID of reference: licenseType.id
	 */
	public List<EmployeeLicense> findByLicenseTypeId(Long licenseTypeId) {
		return (List<EmployeeLicense>) this
				.getEntityManager()
				.createQuery(
						"select e from EmployeeLicense e where e.clientId = :pClientId and e.licenseType.id = :pLicenseTypeId",
						EmployeeLicense.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLicenseTypeId", licenseTypeId).getResultList();
	}
}
