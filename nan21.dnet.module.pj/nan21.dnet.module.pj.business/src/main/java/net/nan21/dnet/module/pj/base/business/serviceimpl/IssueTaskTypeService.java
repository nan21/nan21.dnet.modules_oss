/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueTaskTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskType;

/**
 * Repository functionality for {@link IssueTaskType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssueTaskTypeService extends AbstractEntityService<IssueTaskType>
		implements
			IIssueTaskTypeService {

	public IssueTaskTypeService() {
		super();
	}

	public IssueTaskTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<IssueTaskType> getEntityClass() {
		return IssueTaskType.class;
	}

	/**
	 * Find by unique key
	 */
	public IssueTaskType findByName(String name) {
		return (IssueTaskType) this.em
				.createNamedQuery(IssueTaskType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
