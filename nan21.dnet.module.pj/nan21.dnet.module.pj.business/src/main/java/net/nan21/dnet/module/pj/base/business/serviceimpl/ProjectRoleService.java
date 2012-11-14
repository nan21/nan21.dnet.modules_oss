/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.business.service.IProjectRoleService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

/**
 * Repository functionality for {@link ProjectRole} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProjectRoleService extends AbstractEntityService<ProjectRole>
		implements
			IProjectRoleService {

	public ProjectRoleService() {
		super();
	}

	public ProjectRoleService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ProjectRole> getEntityClass() {
		return ProjectRole.class;
	}

	/**
	 * Find by unique key
	 */
	public ProjectRole findByName(String name) {
		return (ProjectRole) this.em
				.createNamedQuery(ProjectRole.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: projectTypes
	 */
	public List<ProjectRole> findByProjectTypes(ProjectType projectTypes) {
		return this.findByProjectTypesId(projectTypes.getId());
	}

	/**
	 * Find by ID of reference: projectTypes.id
	 */
	public List<ProjectRole> findByProjectTypesId(Long projectTypesId) {
		return (List<ProjectRole>) this.em
				.createQuery(
						"select distinct e from ProjectRole e, IN (e.projectTypes) c where e.clientId = :pClientId and c.id = :pProjectTypesId",
						ProjectRole.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProjectTypesId", projectTypesId)
				.getResultList();
	}
}
