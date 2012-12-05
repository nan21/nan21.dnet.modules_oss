/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueStatusService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueStatus;

/**
 * Repository functionality for {@link IssueStatus} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssueStatusService extends AbstractEntityService<IssueStatus>
		implements
			IIssueStatusService {

	public IssueStatusService() {
		super();
	}

	public IssueStatusService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<IssueStatus> getEntityClass() {
		return IssueStatus.class;
	}

	/**
	 * Find by unique key
	 */
	public IssueStatus findByName(String name) {
		return (IssueStatus) this.getEntityManager()
				.createNamedQuery(IssueStatus.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
