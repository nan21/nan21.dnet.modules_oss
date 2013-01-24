/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.IGeoZoneService;
import net.nan21.dnet.module.bd.geo.domain.entity.GeoZone;

/**
 * Repository functionality for {@link GeoZone} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class GeoZoneService extends AbstractEntityService<GeoZone>
		implements
			IGeoZoneService {

	public GeoZoneService() {
		super();
	}

	public GeoZoneService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<GeoZone> getEntityClass() {
		return GeoZone.class;
	}

	/**
	 * Find by unique key
	 */
	public GeoZone findByName(String name) {
		return (GeoZone) this.getEntityManager()
				.createNamedQuery(GeoZone.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
