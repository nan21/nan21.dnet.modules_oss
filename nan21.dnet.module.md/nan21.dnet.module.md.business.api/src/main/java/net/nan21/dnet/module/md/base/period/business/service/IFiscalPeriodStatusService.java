/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.base.period.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriodStatus;

/**
 * Interface to expose business functions specific for {@link FiscalPeriodStatus} domain
 * entity.
 */
public interface IFiscalPeriodStatusService
		extends
			IEntityService<FiscalPeriodStatus> {

	/**
	 * Find by unique key
	 */
	public FiscalPeriodStatus findByOrg_period(Organization org,
			FiscalPeriod period);

	/**
	 * Find by unique key
	 */
	public FiscalPeriodStatus findByOrg_period(Long orgId, Long periodId);

	/**
	 * Find by reference: period
	 */
	public List<FiscalPeriodStatus> findByPeriod(FiscalPeriod period);

	/**
	 * Find by ID of reference: period.id
	 */
	public List<FiscalPeriodStatus> findByPeriodId(Long periodId);

	/**
	 * Find by reference: org
	 */
	public List<FiscalPeriodStatus> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<FiscalPeriodStatus> findByOrgId(Long orgId);
}
