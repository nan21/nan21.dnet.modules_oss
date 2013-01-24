/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.ICountryService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;

/**
 * Repository functionality for {@link Country} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class CountryService extends AbstractEntityService<Country>
		implements
			ICountryService {

	public CountryService() {
		super();
	}

	public CountryService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Country> getEntityClass() {
		return Country.class;
	}

	/**
	 * Find by unique key
	 */
	public Country findByCode(String code) {
		return (Country) this.getEntityManager()
				.createNamedQuery(Country.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Country findByName(String name) {
		return (Country) this.getEntityManager()
				.createNamedQuery(Country.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
