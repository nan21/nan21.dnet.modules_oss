/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;
import net.nan21.dnet.module.pj.md.business.service.IProjectService;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

/**
 * Repository functionality for {@link Project} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProjectService extends AbstractEntityService<Project>
		implements
			IProjectService {

	public ProjectService() {
		super();
	}

	public ProjectService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<Project> getEntityClass() {
		return Project.class;
	}

	/**
	 * Find by unique key
	 */
	public Project findByCode(String code) {
		return (Project) this.em.createNamedQuery(Project.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Project findByName(String name) {
		return (Project) this.em.createNamedQuery(Project.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: type
	 */
	public List<Project> findByType(ProjectType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Project> findByTypeId(Long typeId) {
		return (List<Project>) this.em
				.createQuery(
						"select e from Project e where e.clientId = :pClientId and e.type.id = :pTypeId",
						Project.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}

	/**
	 * Find by reference: projectLead
	 */
	public List<Project> findByProjectLead(ProjectMember projectLead) {
		return this.findByProjectLeadId(projectLead.getId());
	}

	/**
	 * Find by ID of reference: projectLead.id
	 */
	public List<Project> findByProjectLeadId(Long projectLeadId) {
		return (List<Project>) this.em
				.createQuery(
						"select e from Project e where e.clientId = :pClientId and e.projectLead.id = :pProjectLeadId",
						Project.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProjectLeadId", projectLeadId).getResultList();
	}
}
