/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.period.business.service;

import java.util.Date;
import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;

/**
 * Interface to expose business functions specific for {@link FiscalPeriod} domain
 * entity.
 */
public interface IFiscalPeriodService extends IEntityService<FiscalPeriod> {

	public FiscalPeriod getPostingPeriod(Date date, Organization org)
			throws BusinessException;

	/**
	 * Find by unique key
	 */
	public FiscalPeriod findByCode(String code);

	/**
	 * Find by unique key
	 */
	public FiscalPeriod findByName(String name);

	/**
	 * Find by reference: year
	 */
	public List<FiscalPeriod> findByYear(FiscalYear year);

	/**
	 * Find by ID of reference: year.id
	 */
	public List<FiscalPeriod> findByYearId(Long yearId);
}
