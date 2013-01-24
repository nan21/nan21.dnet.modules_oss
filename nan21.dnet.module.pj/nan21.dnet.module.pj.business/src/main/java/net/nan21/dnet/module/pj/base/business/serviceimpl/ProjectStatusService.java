/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IProjectStatusService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectStatus;

/**
 * Repository functionality for {@link ProjectStatus} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProjectStatusService extends AbstractEntityService<ProjectStatus>
		implements
			IProjectStatusService {

	public ProjectStatusService() {
		super();
	}

	public ProjectStatusService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProjectStatus> getEntityClass() {
		return ProjectStatus.class;
	}

	/**
	 * Find by unique key
	 */
	public ProjectStatus findByName(String name) {
		return (ProjectStatus) this.getEntityManager()
				.createNamedQuery(ProjectStatus.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
