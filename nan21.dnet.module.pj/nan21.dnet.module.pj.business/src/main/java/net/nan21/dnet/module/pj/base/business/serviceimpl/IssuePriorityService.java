/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssuePriorityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssuePriority;

/**
 * Repository functionality for {@link IssuePriority} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssuePriorityService extends AbstractEntityService<IssuePriority>
		implements
			IIssuePriorityService {

	public IssuePriorityService() {
		super();
	}

	public IssuePriorityService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<IssuePriority> getEntityClass() {
		return IssuePriority.class;
	}

	/**
	 * Find by unique key
	 */
	public IssuePriority findByName(String name) {
		return (IssuePriority) this.getEntityManager()
				.createNamedQuery(IssuePriority.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
