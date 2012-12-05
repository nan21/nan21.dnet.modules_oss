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
import net.nan21.dnet.module.pj.md.business.service.IProjectVersionService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

/**
 * Repository functionality for {@link ProjectVersion} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProjectVersionService
		extends
			AbstractEntityService<ProjectVersion>
		implements
			IProjectVersionService {

	public ProjectVersionService() {
		super();
	}

	public ProjectVersionService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProjectVersion> getEntityClass() {
		return ProjectVersion.class;
	}

	/**
	 * Find by unique key
	 */
	public ProjectVersion findByName(Project project, String name) {
		return (ProjectVersion) this.getEntityManager()
				.createNamedQuery(ProjectVersion.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProject", project).setParameter("pName", name)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ProjectVersion findByName(Long projectId, String name) {
		return (ProjectVersion) this.getEntityManager()
				.createNamedQuery(ProjectVersion.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProjectId", projectId)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: project
	 */
	public List<ProjectVersion> findByProject(Project project) {
		return this.findByProjectId(project.getId());
	}

	/**
	 * Find by ID of reference: project.id
	 */
	public List<ProjectVersion> findByProjectId(Long projectId) {
		return (List<ProjectVersion>) this
				.getEntityManager()
				.createQuery(
						"select e from ProjectVersion e where e.clientId = :pClientId and e.project.id = :pProjectId",
						ProjectVersion.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProjectId", projectId).getResultList();
	}

	/**
	 * Find by reference: affectingIssues
	 */
	public List<ProjectVersion> findByAffectingIssues(Issue affectingIssues) {
		return this.findByAffectingIssuesId(affectingIssues.getId());
	}

	/**
	 * Find by ID of reference: affectingIssues.id
	 */
	public List<ProjectVersion> findByAffectingIssuesId(Long affectingIssuesId) {
		return (List<ProjectVersion>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from ProjectVersion e, IN (e.affectingIssues) c where e.clientId = :pClientId and c.id = :pAffectingIssuesId",
						ProjectVersion.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAffectingIssuesId", affectingIssuesId)
				.getResultList();
	}
}
