/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueTextTypeService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;

/**
 * Repository functionality for {@link IssueTextType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssueTextTypeService extends AbstractEntityService<IssueTextType>
		implements
			IIssueTextTypeService {

	public IssueTextTypeService() {
		super();
	}

	public IssueTextTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<IssueTextType> getEntityClass() {
		return IssueTextType.class;
	}

	/**
	 * Find by unique key
	 */
	public IssueTextType findByName(String name) {
		return (IssueTextType) this.em
				.createNamedQuery(IssueTextType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
