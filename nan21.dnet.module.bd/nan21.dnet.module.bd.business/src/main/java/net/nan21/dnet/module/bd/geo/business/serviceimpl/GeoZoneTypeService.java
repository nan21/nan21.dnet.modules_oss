/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.IGeoZoneTypeService;
import net.nan21.dnet.module.bd.geo.domain.entity.GeoZoneType;

/**
 * Repository functionality for {@link GeoZoneType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class GeoZoneTypeService extends AbstractEntityService<GeoZoneType>
		implements
			IGeoZoneTypeService {

	public GeoZoneTypeService() {
		super();
	}

	public GeoZoneTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<GeoZoneType> getEntityClass() {
		return GeoZoneType.class;
	}

	/**
	 * Find by unique key
	 */
	public GeoZoneType findByName(String name) {
		return (GeoZoneType) this.getEntityManager()
				.createNamedQuery(GeoZoneType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
