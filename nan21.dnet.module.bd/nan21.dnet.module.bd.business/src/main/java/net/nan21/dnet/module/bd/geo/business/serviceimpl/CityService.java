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
import net.nan21.dnet.module.bd.geo.business.service.ICityService;
import net.nan21.dnet.module.bd.geo.domain.entity.City;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

/**
 * Repository functionality for {@link City} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CityService extends AbstractEntityService<City>
		implements
			ICityService {

	public CityService() {
		super();
	}

	public CityService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<City> getEntityClass() {
		return City.class;
	}

	/**
	 * Find by reference: country
	 */
	public List<City> findByCountry(Country country) {
		return this.findByCountryId(country.getId());
	}

	/**
	 * Find by ID of reference: country.id
	 */
	public List<City> findByCountryId(Long countryId) {
		return (List<City>) this.em
				.createQuery(
						"select e from City e where e.clientId = :pClientId and e.country.id = :pCountryId",
						City.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCountryId", countryId).getResultList();
	}

	/**
	 * Find by reference: region
	 */
	public List<City> findByRegion(Region region) {
		return this.findByRegionId(region.getId());
	}

	/**
	 * Find by ID of reference: region.id
	 */
	public List<City> findByRegionId(Long regionId) {
		return (List<City>) this.em
				.createQuery(
						"select e from City e where e.clientId = :pClientId and e.region.id = :pRegionId",
						City.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRegionId", regionId).getResultList();
	}
}
