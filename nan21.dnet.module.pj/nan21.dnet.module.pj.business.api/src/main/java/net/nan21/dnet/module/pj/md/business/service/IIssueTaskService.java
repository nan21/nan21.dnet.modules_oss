/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.IssueTask;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

/**
 * Interface to expose business functions specific for {@link IssueTask} domain
 * entity.
 */
public interface IIssueTaskService extends IEntityService<IssueTask> {

	/**
	 * Find by reference: issue
	 */
	public List<IssueTask> findByIssue(Issue issue);

	/**
	 * Find by ID of reference: issue.id
	 */
	public List<IssueTask> findByIssueId(Long issueId);

	/**
	 * Find by reference: type
	 */
	public List<IssueTask> findByType(IssueTaskType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<IssueTask> findByTypeId(Long typeId);

	/**
	 * Find by reference: status
	 */
	public List<IssueTask> findByStatus(IssueTaskStatus status);

	/**
	 * Find by ID of reference: status.id
	 */
	public List<IssueTask> findByStatusId(Long statusId);

	/**
	 * Find by reference: assignee
	 */
	public List<IssueTask> findByAssignee(ProjectMember assignee);

	/**
	 * Find by ID of reference: assignee.id
	 */
	public List<IssueTask> findByAssigneeId(Long assigneeId);
}
