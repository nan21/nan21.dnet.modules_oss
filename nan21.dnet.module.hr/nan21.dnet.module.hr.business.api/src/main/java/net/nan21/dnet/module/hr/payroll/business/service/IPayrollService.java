/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.payroll.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;
import net.nan21.dnet.module.hr.payroll.domain.entity.Payroll;

/**
 * Interface to expose business functions specific for {@link Payroll} domain
 * entity.
 */
public interface IPayrollService extends IEntityService<Payroll> {

	/**
	 * Find by unique key
	 */
	public Payroll findByName(String name);

	/**
	 * Find by reference: engine
	 */
	public List<Payroll> findByEngine(Engine engine);

	/**
	 * Find by ID of reference: engine.id
	 */
	public List<Payroll> findByEngineId(Long engineId);
}
