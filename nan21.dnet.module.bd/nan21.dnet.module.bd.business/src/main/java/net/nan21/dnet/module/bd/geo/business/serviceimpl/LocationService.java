/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.ILocationService;
import net.nan21.dnet.module.bd.geo.domain.entity.City;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

/**
 * Repository functionality for {@link Location} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class LocationService extends AbstractEntityService<Location>
		implements
			ILocationService {

	public LocationService() {
		super();
	}

	public LocationService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Location> getEntityClass() {
		return Location.class;
	}

	/**
	 * Find by reference: country
	 */
	public List<Location> findByCountry(Country country) {
		return this.findByCountryId(country.getId());
	}

	/**
	 * Find by ID of reference: country.id
	 */
	public List<Location> findByCountryId(Long countryId) {
		return (List<Location>) this
				.getEntityManager()
				.createQuery(
						"select e from Location e where e.clientId = :pClientId and e.country.id = :pCountryId",
						Location.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCountryId", countryId).getResultList();
	}

	/**
	 * Find by reference: region
	 */
	public List<Location> findByRegion(Region region) {
		return this.findByRegionId(region.getId());
	}

	/**
	 * Find by ID of reference: region.id
	 */
	public List<Location> findByRegionId(Long regionId) {
		return (List<Location>) this
				.getEntityManager()
				.createQuery(
						"select e from Location e where e.clientId = :pClientId and e.region.id = :pRegionId",
						Location.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRegionId", regionId).getResultList();
	}

	/**
	 * Find by reference: city
	 */
	public List<Location> findByCity(City city) {
		return this.findByCityId(city.getId());
	}

	/**
	 * Find by ID of reference: city.id
	 */
	public List<Location> findByCityId(Long cityId) {
		return (List<Location>) this
				.getEntityManager()
				.createQuery(
						"select e from Location e where e.clientId = :pClientId and e.city.id = :pCityId",
						Location.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCityId", cityId).getResultList();
	}
}
