/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

/**
 * Interface to expose business functions specific for {@link PayrollPeriod} domain
 * entity.
 */
public interface IPayrollPeriodService extends IEntityService<PayrollPeriod> {

	public void doProcess(PayrollPeriod period) throws BusinessException;

	public void doOpen(PayrollPeriod period) throws BusinessException;

	public void doClose(PayrollPeriod period) throws BusinessException;

	public void doClear(PayrollPeriod period) throws BusinessException;

	/**
	 * Find by unique key
	 */
	public PayrollPeriod findByName(String name);

	/**
	 * Find by reference: payroll
	 */
	public List<PayrollPeriod> findByPayroll(Payroll payroll);

	/**
	 * Find by ID of reference: payroll.id
	 */
	public List<PayrollPeriod> findByPayrollId(Long payrollId);
}
