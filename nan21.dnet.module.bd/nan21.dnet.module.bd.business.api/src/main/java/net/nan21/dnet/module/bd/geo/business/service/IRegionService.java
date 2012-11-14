/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

/**
 * Interface to expose business functions specific for {@link Region} domain
 * entity.
 */
public interface IRegionService extends IEntityService<Region> {

	/**
	 * Find by unique key
	 */
	public Region findByCodeAndCountry(Country country, String code);

	/**
	 * Find by unique key
	 */
	public Region findByCodeAndCountry(Long countryId, String code);

	/**
	 * Find by reference: country
	 */
	public List<Region> findByCountry(Country country);

	/**
	 * Find by ID of reference: country.id
	 */
	public List<Region> findByCountryId(Long countryId);
}
