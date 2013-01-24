/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueResolutionService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueResolution;

/**
 * Repository functionality for {@link IssueResolution} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssueResolutionService
		extends
			AbstractEntityService<IssueResolution>
		implements
			IIssueResolutionService {

	public IssueResolutionService() {
		super();
	}

	public IssueResolutionService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<IssueResolution> getEntityClass() {
		return IssueResolution.class;
	}

	/**
	 * Find by unique key
	 */
	public IssueResolution findByName(String name) {
		return (IssueResolution) this.getEntityManager()
				.createNamedQuery(IssueResolution.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
