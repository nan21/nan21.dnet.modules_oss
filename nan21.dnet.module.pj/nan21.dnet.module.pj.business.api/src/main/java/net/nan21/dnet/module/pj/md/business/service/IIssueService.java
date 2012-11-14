/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssuePriority;
import net.nan21.dnet.module.pj.base.domain.entity.IssueResolution;
import net.nan21.dnet.module.pj.base.domain.entity.IssueSeverity;
import net.nan21.dnet.module.pj.base.domain.entity.IssueStatus;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectComponent;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

/**
 * Interface to expose business functions specific for {@link Issue} domain
 * entity.
 */
public interface IIssueService extends IEntityService<Issue> {

	/**
	 * Find by unique key
	 */
	public Issue findByCode(String code);

	/**
	 * Find by reference: project
	 */
	public List<Issue> findByProject(Project project);

	/**
	 * Find by ID of reference: project.id
	 */
	public List<Issue> findByProjectId(Long projectId);

	/**
	 * Find by reference: status
	 */
	public List<Issue> findByStatus(IssueStatus status);

	/**
	 * Find by ID of reference: status.id
	 */
	public List<Issue> findByStatusId(Long statusId);

	/**
	 * Find by reference: type
	 */
	public List<Issue> findByType(IssueType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Issue> findByTypeId(Long typeId);

	/**
	 * Find by reference: priority
	 */
	public List<Issue> findByPriority(IssuePriority priority);

	/**
	 * Find by ID of reference: priority.id
	 */
	public List<Issue> findByPriorityId(Long priorityId);

	/**
	 * Find by reference: resolution
	 */
	public List<Issue> findByResolution(IssueResolution resolution);

	/**
	 * Find by ID of reference: resolution.id
	 */
	public List<Issue> findByResolutionId(Long resolutionId);

	/**
	 * Find by reference: severity
	 */
	public List<Issue> findBySeverity(IssueSeverity severity);

	/**
	 * Find by ID of reference: severity.id
	 */
	public List<Issue> findBySeverityId(Long severityId);

	/**
	 * Find by reference: reportedVersion
	 */
	public List<Issue> findByReportedVersion(ProjectVersion reportedVersion);

	/**
	 * Find by ID of reference: reportedVersion.id
	 */
	public List<Issue> findByReportedVersionId(Long reportedVersionId);

	/**
	 * Find by reference: targetVersion
	 */
	public List<Issue> findByTargetVersion(ProjectVersion targetVersion);

	/**
	 * Find by ID of reference: targetVersion.id
	 */
	public List<Issue> findByTargetVersionId(Long targetVersionId);

	/**
	 * Find by reference: fixedInVersion
	 */
	public List<Issue> findByFixedInVersion(ProjectVersion fixedInVersion);

	/**
	 * Find by ID of reference: fixedInVersion.id
	 */
	public List<Issue> findByFixedInVersionId(Long fixedInVersionId);

	/**
	 * Find by reference: assignee
	 */
	public List<Issue> findByAssignee(ProjectMember assignee);

	/**
	 * Find by ID of reference: assignee.id
	 */
	public List<Issue> findByAssigneeId(Long assigneeId);

	/**
	 * Find by reference: assigneeRole
	 */
	public List<Issue> findByAssigneeRole(ProjectRole assigneeRole);

	/**
	 * Find by ID of reference: assigneeRole.id
	 */
	public List<Issue> findByAssigneeRoleId(Long assigneeRoleId);

	/**
	 * Find by reference: affectedVersions
	 */
	public List<Issue> findByAffectedVersions(ProjectVersion affectedVersions);

	/**
	 * Find by ID of reference: affectedVersions.id
	 */
	public List<Issue> findByAffectedVersionsId(Long affectedVersionsId);

	/**
	 * Find by reference: affectedComponents
	 */
	public List<Issue> findByAffectedComponents(
			ProjectComponent affectedComponents);

	/**
	 * Find by ID of reference: affectedComponents.id
	 */
	public List<Issue> findByAffectedComponentsId(Long affectedComponentsId);
}
