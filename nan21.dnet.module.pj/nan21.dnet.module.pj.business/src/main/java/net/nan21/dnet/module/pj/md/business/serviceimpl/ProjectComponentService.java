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
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.md.business.service.IProjectComponentService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectComponent;

/**
 * Repository functionality for {@link ProjectComponent} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProjectComponentService
		extends
			AbstractEntityService<ProjectComponent>
		implements
			IProjectComponentService {

	public ProjectComponentService() {
		super();
	}

	public ProjectComponentService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProjectComponent> getEntityClass() {
		return ProjectComponent.class;
	}

	/**
	 * Find by unique key
	 */
	public ProjectComponent findByName(Project project, String name) {
		return (ProjectComponent) this.getEntityManager()
				.createNamedQuery(ProjectComponent.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProject", project).setParameter("pName", name)
				.getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ProjectComponent findByName(Long projectId, String name) {
		return (ProjectComponent) this.getEntityManager()
				.createNamedQuery(ProjectComponent.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProjectId", projectId)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: componentLead
	 */
	public List<ProjectComponent> findByComponentLead(Assignable componentLead) {
		return this.findByComponentLeadId(componentLead.getId());
	}

	/**
	 * Find by ID of reference: componentLead.id
	 */
	public List<ProjectComponent> findByComponentLeadId(Long componentLeadId) {
		return (List<ProjectComponent>) this
				.getEntityManager()
				.createQuery(
						"select e from ProjectComponent e where e.clientId = :pClientId and e.componentLead.id = :pComponentLeadId",
						ProjectComponent.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pComponentLeadId", componentLeadId)
				.getResultList();
	}

	/**
	 * Find by reference: project
	 */
	public List<ProjectComponent> findByProject(Project project) {
		return this.findByProjectId(project.getId());
	}

	/**
	 * Find by ID of reference: project.id
	 */
	public List<ProjectComponent> findByProjectId(Long projectId) {
		return (List<ProjectComponent>) this
				.getEntityManager()
				.createQuery(
						"select e from ProjectComponent e where e.clientId = :pClientId and e.project.id = :pProjectId",
						ProjectComponent.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProjectId", projectId).getResultList();
	}

	/**
	 * Find by reference: affectingIssues
	 */
	public List<ProjectComponent> findByAffectingIssues(Issue affectingIssues) {
		return this.findByAffectingIssuesId(affectingIssues.getId());
	}

	/**
	 * Find by ID of reference: affectingIssues.id
	 */
	public List<ProjectComponent> findByAffectingIssuesId(Long affectingIssuesId) {
		return (List<ProjectComponent>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from ProjectComponent e, IN (e.affectingIssues) c where e.clientId = :pClientId and c.id = :pAffectingIssuesId",
						ProjectComponent.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAffectingIssuesId", affectingIssuesId)
				.getResultList();
	}
}
