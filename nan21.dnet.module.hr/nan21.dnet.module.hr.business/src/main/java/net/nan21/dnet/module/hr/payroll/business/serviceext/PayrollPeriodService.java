/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.payroll.business.serviceext;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.hr._businessdelegates.payroll.PayrollPeriodProcessorBD;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollPeriodService;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

/**
 * Business extensions specific for {@link PayrollPeriod} domain entity.
 * 
 */
public class PayrollPeriodService
		extends
		net.nan21.dnet.module.hr.payroll.business.serviceimpl.PayrollPeriodService
		implements IPayrollPeriodService {

	@Override
	public void doProcess(PayrollPeriod period) throws BusinessException {
		this.getBusinessDelegate(PayrollPeriodProcessorBD.class)
				.process(period);
	}

	@Override
	public void doOpen(PayrollPeriod period) throws BusinessException {
		this.getBusinessDelegate(PayrollPeriodProcessorBD.class).open(period);
	}

	@Override
	public void doClose(PayrollPeriod period) throws BusinessException {
		this.getBusinessDelegate(PayrollPeriodProcessorBD.class).close(period);
	}

	@Override
	public void doClear(PayrollPeriod period) throws BusinessException {
		this.getBusinessDelegate(PayrollPeriodProcessorBD.class).clear(period);
	}

}
