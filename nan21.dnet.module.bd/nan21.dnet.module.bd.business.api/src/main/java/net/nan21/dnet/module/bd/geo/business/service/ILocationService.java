/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.City;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

/**
 * Interface to expose business functions specific for {@link Location} domain
 * entity.
 */
public interface ILocationService extends IEntityService<Location> {

	/**
	 * Find by reference: country
	 */
	public List<Location> findByCountry(Country country);

	/**
	 * Find by ID of reference: country.id
	 */
	public List<Location> findByCountryId(Long countryId);

	/**
	 * Find by reference: region
	 */
	public List<Location> findByRegion(Region region);

	/**
	 * Find by ID of reference: region.id
	 */
	public List<Location> findByRegionId(Long regionId);

	/**
	 * Find by reference: city
	 */
	public List<Location> findByCity(City city);

	/**
	 * Find by ID of reference: city.id
	 */
	public List<Location> findByCityId(Long cityId);
}
