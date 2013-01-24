/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.business.service.IProjectMemberService;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

/**
 * Repository functionality for {@link ProjectMember} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ProjectMemberService extends AbstractEntityService<ProjectMember>
		implements
			IProjectMemberService {

	public ProjectMemberService() {
		super();
	}

	public ProjectMemberService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ProjectMember> getEntityClass() {
		return ProjectMember.class;
	}

	/**
	 * Find by unique key
	 */
	public ProjectMember findByName(Project project, Assignable member) {
		return (ProjectMember) this.getEntityManager()
				.createNamedQuery(ProjectMember.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProject", project)
				.setParameter("pMember", member).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ProjectMember findByName(Long projectId, Long memberId) {
		return (ProjectMember) this.getEntityManager()
				.createNamedQuery(ProjectMember.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProjectId", projectId)
				.setParameter("pMemberId", memberId).getSingleResult();
	}

	/**
	 * Find by reference: project
	 */
	public List<ProjectMember> findByProject(Project project) {
		return this.findByProjectId(project.getId());
	}

	/**
	 * Find by ID of reference: project.id
	 */
	public List<ProjectMember> findByProjectId(Long projectId) {
		return (List<ProjectMember>) this
				.getEntityManager()
				.createQuery(
						"select e from ProjectMember e where e.clientId = :pClientId and e.project.id = :pProjectId",
						ProjectMember.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProjectId", projectId).getResultList();
	}

	/**
	 * Find by reference: member
	 */
	public List<ProjectMember> findByMember(Assignable member) {
		return this.findByMemberId(member.getId());
	}

	/**
	 * Find by ID of reference: member.id
	 */
	public List<ProjectMember> findByMemberId(Long memberId) {
		return (List<ProjectMember>) this
				.getEntityManager()
				.createQuery(
						"select e from ProjectMember e where e.clientId = :pClientId and e.member.id = :pMemberId",
						ProjectMember.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pMemberId", memberId).getResultList();
	}

	/**
	 * Find by reference: projectRole
	 */
	public List<ProjectMember> findByProjectRole(ProjectRole projectRole) {
		return this.findByProjectRoleId(projectRole.getId());
	}

	/**
	 * Find by ID of reference: projectRole.id
	 */
	public List<ProjectMember> findByProjectRoleId(Long projectRoleId) {
		return (List<ProjectMember>) this
				.getEntityManager()
				.createQuery(
						"select e from ProjectMember e where e.clientId = :pClientId and e.projectRole.id = :pProjectRoleId",
						ProjectMember.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pProjectRoleId", projectRoleId).getResultList();
	}
}
