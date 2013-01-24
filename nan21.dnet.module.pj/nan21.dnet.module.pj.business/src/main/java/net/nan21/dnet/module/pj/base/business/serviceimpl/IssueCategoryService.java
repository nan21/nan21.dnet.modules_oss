/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IIssueCategoryService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueCategory;

/**
 * Repository functionality for {@link IssueCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssueCategoryService extends AbstractEntityService<IssueCategory>
		implements
			IIssueCategoryService {

	public IssueCategoryService() {
		super();
	}

	public IssueCategoryService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<IssueCategory> getEntityClass() {
		return IssueCategory.class;
	}

	/**
	 * Find by unique key
	 */
	public IssueCategory findByName(String name) {
		return (IssueCategory) this.getEntityManager()
				.createNamedQuery(IssueCategory.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
