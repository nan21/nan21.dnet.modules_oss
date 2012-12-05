/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IProjectCategoryService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectCategory;

/**
 * Repository functionality for {@link ProjectCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProjectCategoryService
		extends
			AbstractEntityService<ProjectCategory>
		implements
			IProjectCategoryService {

	public ProjectCategoryService() {
		super();
	}

	public ProjectCategoryService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProjectCategory> getEntityClass() {
		return ProjectCategory.class;
	}

	/**
	 * Find by unique key
	 */
	public ProjectCategory findByName(String name) {
		return (ProjectCategory) this.getEntityManager()
				.createNamedQuery(ProjectCategory.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
