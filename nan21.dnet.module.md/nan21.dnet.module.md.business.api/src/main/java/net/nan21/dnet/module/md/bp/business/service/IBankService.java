/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.bp.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.bp.domain.entity.Bank;

/**
 * Interface to expose business functions specific for {@link Bank} domain
 * entity.
 */
public interface IBankService extends IEntityService<Bank> {

	/**
	 * Find by unique key
	 */
	public Bank findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Bank findByName(String name);
}
