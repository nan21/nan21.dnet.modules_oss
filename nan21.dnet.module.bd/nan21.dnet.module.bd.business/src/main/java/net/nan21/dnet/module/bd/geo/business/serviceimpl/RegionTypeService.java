/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.business.service.IRegionTypeService;
import net.nan21.dnet.module.bd.geo.domain.entity.RegionType;

/**
 * Repository functionality for {@link RegionType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class RegionTypeService extends AbstractEntityService<RegionType>
		implements
			IRegionTypeService {

	public RegionTypeService() {
		super();
	}

	public RegionTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<RegionType> getEntityClass() {
		return RegionType.class;
	}

	/**
	 * Find by unique key
	 */
	public RegionType findByName(String name) {
		return (RegionType) this.getEntityManager()
				.createNamedQuery(RegionType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
