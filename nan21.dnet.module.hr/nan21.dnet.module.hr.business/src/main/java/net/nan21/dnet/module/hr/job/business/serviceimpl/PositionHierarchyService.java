/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.job.business.service.IPositionHierarchyService;
import net.nan21.dnet.module.hr.job.domain.entity.PositionHierarchy;

/**
 * Repository functionality for {@link PositionHierarchy} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PositionHierarchyService
		extends
			AbstractEntityService<PositionHierarchy>
		implements
			IPositionHierarchyService {

	public PositionHierarchyService() {
		super();
	}

	public PositionHierarchyService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PositionHierarchy> getEntityClass() {
		return PositionHierarchy.class;
	}

	/**
	 * Find by unique key
	 */
	public PositionHierarchy findByName(String name) {
		return (PositionHierarchy) this.getEntityManager()
				.createNamedQuery(PositionHierarchy.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
