/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.IRegionService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.geo.domain.entity.Region;

/**
 * Repository functionality for {@link Region} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class RegionService extends AbstractEntityService<Region>
		implements
			IRegionService {

	public RegionService() {
		super();
	}

	public RegionService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Region> getEntityClass() {
		return Region.class;
	}

	/**
	 * Find by unique key
	 */
	public Region findByCodeAndCountry(Country country, String code) {
		return (Region) this.getEntityManager()
				.createNamedQuery(Region.NQ_FIND_BY_CODEANDCOUNTRY)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCountry", country).setParameter("pCode", code)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Region findByCodeAndCountry(Long countryId, String code) {
		return (Region) this.getEntityManager()
				.createNamedQuery(Region.NQ_FIND_BY_CODEANDCOUNTRY_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCountryId", countryId)
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by reference: country
	 */
	public List<Region> findByCountry(Country country) {
		return this.findByCountryId(country.getId());
	}

	/**
	 * Find by ID of reference: country.id
	 */
	public List<Region> findByCountryId(Long countryId) {
		return (List<Region>) this
				.getEntityManager()
				.createQuery(
						"select e from Region e where e.clientId = :pClientId and e.country.id = :pCountryId",
						Region.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCountryId", countryId).getResultList();
	}
}
