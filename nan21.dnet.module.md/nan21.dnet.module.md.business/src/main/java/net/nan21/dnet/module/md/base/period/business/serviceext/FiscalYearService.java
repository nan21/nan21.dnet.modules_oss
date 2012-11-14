/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.period.business.serviceext;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.md._businessdelegates.base.period.PeriodBD;
import net.nan21.dnet.module.md.base.period.business.service.IFiscalYearService;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;

/**
 * Business extensions specific for {@link FiscalYear} domain entity.
 * 
 */
public class FiscalYearService
		extends
		net.nan21.dnet.module.md.base.period.business.serviceimpl.FiscalYearService
		implements IFiscalYearService {

	@Override
	public void doCreateMonths(FiscalYear year) throws BusinessException {
		this.getBusinessDelegate(PeriodBD.class).createMonths(year);

	}

	@Override
	public void doCreateQuarters(FiscalYear year) throws BusinessException {
		this.getBusinessDelegate(PeriodBD.class).createQuarters(year);
	}

	@Override
	public void doCreateHalfYears(FiscalYear year) throws BusinessException {
		this.getBusinessDelegate(PeriodBD.class).createHalfYears(year);
	}

}
