/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueTaskStatusService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;

/**
 * Repository functionality for {@link IssueTaskStatus} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssueTaskStatusService
		extends
			AbstractEntityService<IssueTaskStatus>
		implements
			IIssueTaskStatusService {

	public IssueTaskStatusService() {
		super();
	}

	public IssueTaskStatusService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<IssueTaskStatus> getEntityClass() {
		return IssueTaskStatus.class;
	}

	/**
	 * Find by unique key
	 */
	public IssueTaskStatus findByName(String name) {
		return (IssueTaskStatus) this.getEntityManager()
				.createNamedQuery(IssueTaskStatus.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
