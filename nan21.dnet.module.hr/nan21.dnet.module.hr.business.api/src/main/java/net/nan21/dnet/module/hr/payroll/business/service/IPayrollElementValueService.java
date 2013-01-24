/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAssignment;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElementValue;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

/**
 * Interface to expose business functions specific for {@link PayrollElementValue} domain
 * entity.
 */
public interface IPayrollElementValueService
		extends
			IEntityService<PayrollElementValue> {

	/**
	 * Find by reference: element
	 */
	public List<PayrollElementValue> findByElement(PayrollElement element);

	/**
	 * Find by ID of reference: element.id
	 */
	public List<PayrollElementValue> findByElementId(Long elementId);

	/**
	 * Find by reference: period
	 */
	public List<PayrollElementValue> findByPeriod(PayrollPeriod period);

	/**
	 * Find by ID of reference: period.id
	 */
	public List<PayrollElementValue> findByPeriodId(Long periodId);

	/**
	 * Find by reference: assignment
	 */
	public List<PayrollElementValue> findByAssignment(
			EmployeeAssignment assignment);

	/**
	 * Find by ID of reference: assignment.id
	 */
	public List<PayrollElementValue> findByAssignmentId(Long assignmentId);

	/**
	 * Find by reference: org
	 */
	public List<PayrollElementValue> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<PayrollElementValue> findByOrgId(Long orgId);
}
