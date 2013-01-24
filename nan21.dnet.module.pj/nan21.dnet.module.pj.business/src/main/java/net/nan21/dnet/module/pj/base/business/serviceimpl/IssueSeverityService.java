/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueSeverityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueSeverity;

/**
 * Repository functionality for {@link IssueSeverity} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssueSeverityService extends AbstractEntityService<IssueSeverity>
		implements
			IIssueSeverityService {

	public IssueSeverityService() {
		super();
	}

	public IssueSeverityService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<IssueSeverity> getEntityClass() {
		return IssueSeverity.class;
	}

	/**
	 * Find by unique key
	 */
	public IssueSeverity findByName(String name) {
		return (IssueSeverity) this.getEntityManager()
				.createNamedQuery(IssueSeverity.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
