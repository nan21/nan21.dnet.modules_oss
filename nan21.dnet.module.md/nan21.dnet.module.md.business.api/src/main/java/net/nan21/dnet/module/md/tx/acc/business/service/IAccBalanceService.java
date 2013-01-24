/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.acc.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccBalance;

/**
 * Interface to expose business functions specific for {@link AccBalance} domain
 * entity.
 */
public interface IAccBalanceService extends IEntityService<AccBalance> {

	/**
	 * Find by reference: org
	 */
	public List<AccBalance> findByOrg(Organization org);

	/**
	 * Find by ID of reference: org.id
	 */
	public List<AccBalance> findByOrgId(Long orgId);

	/**
	 * Find by reference: accSchema
	 */
	public List<AccBalance> findByAccSchema(AccSchema accSchema);

	/**
	 * Find by ID of reference: accSchema.id
	 */
	public List<AccBalance> findByAccSchemaId(Long accSchemaId);

	/**
	 * Find by reference: period
	 */
	public List<AccBalance> findByPeriod(FiscalPeriod period);

	/**
	 * Find by ID of reference: period.id
	 */
	public List<AccBalance> findByPeriodId(Long periodId);
}
