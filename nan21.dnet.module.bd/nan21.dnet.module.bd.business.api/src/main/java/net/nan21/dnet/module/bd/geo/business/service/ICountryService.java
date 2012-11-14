/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;

/**
 * Interface to expose business functions specific for {@link Country} domain
 * entity.
 */
public interface ICountryService extends IEntityService<Country> {

	/**
	 * Find by unique key
	 */
	public Country findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Country findByName(String name);
}
