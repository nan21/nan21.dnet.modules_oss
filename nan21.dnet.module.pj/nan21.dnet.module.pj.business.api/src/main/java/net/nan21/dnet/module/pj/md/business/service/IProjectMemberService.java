/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

/**
 * Interface to expose business functions specific for {@link ProjectMember} domain
 * entity.
 */
public interface IProjectMemberService extends IEntityService<ProjectMember> {

	/**
	 * Find by unique key
	 */
	public ProjectMember findByName(Project project, Assignable member);

	/**
	 * Find by unique key
	 */
	public ProjectMember findByName(Long projectId, Long memberId);

	/**
	 * Find by reference: project
	 */
	public List<ProjectMember> findByProject(Project project);

	/**
	 * Find by ID of reference: project.id
	 */
	public List<ProjectMember> findByProjectId(Long projectId);

	/**
	 * Find by reference: member
	 */
	public List<ProjectMember> findByMember(Assignable member);

	/**
	 * Find by ID of reference: member.id
	 */
	public List<ProjectMember> findByMemberId(Long memberId);

	/**
	 * Find by reference: projectRole
	 */
	public List<ProjectMember> findByProjectRole(ProjectRole projectRole);

	/**
	 * Find by ID of reference: projectRole.id
	 */
	public List<ProjectMember> findByProjectRoleId(Long projectRoleId);
}
