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
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskType;
import net.nan21.dnet.module.pj.md.business.service.IIssueTaskService;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.IssueTask;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;

/**
 * Repository functionality for {@link IssueTask} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class IssueTaskService extends AbstractEntityService<IssueTask>
		implements
			IIssueTaskService {

	public IssueTaskService() {
		super();
	}

	public IssueTaskService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<IssueTask> getEntityClass() {
		return IssueTask.class;
	}

	/**
	 * Find by reference: issue
	 */
	public List<IssueTask> findByIssue(Issue issue) {
		return this.findByIssueId(issue.getId());
	}

	/**
	 * Find by ID of reference: issue.id
	 */
	public List<IssueTask> findByIssueId(Long issueId) {
		return (List<IssueTask>) this.em
				.createQuery(
						"select e from IssueTask e where e.clientId = :pClientId and e.issue.id = :pIssueId",
						IssueTask.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pIssueId", issueId).getResultList();
	}

	/**
	 * Find by reference: type
	 */
	public List<IssueTask> findByType(IssueTaskType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<IssueTask> findByTypeId(Long typeId) {
		return (List<IssueTask>) this.em
				.createQuery(
						"select e from IssueTask e where e.clientId = :pClientId and e.type.id = :pTypeId",
						IssueTask.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}

	/**
	 * Find by reference: status
	 */
	public List<IssueTask> findByStatus(IssueTaskStatus status) {
		return this.findByStatusId(status.getId());
	}

	/**
	 * Find by ID of reference: status.id
	 */
	public List<IssueTask> findByStatusId(Long statusId) {
		return (List<IssueTask>) this.em
				.createQuery(
						"select e from IssueTask e where e.clientId = :pClientId and e.status.id = :pStatusId",
						IssueTask.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pStatusId", statusId).getResultList();
	}

	/**
	 * Find by reference: assignee
	 */
	public List<IssueTask> findByAssignee(ProjectMember assignee) {
		return this.findByAssigneeId(assignee.getId());
	}

	/**
	 * Find by ID of reference: assignee.id
	 */
	public List<IssueTask> findByAssigneeId(Long assigneeId) {
		return (List<IssueTask>) this.em
				.createQuery(
						"select e from IssueTask e where e.clientId = :pClientId and e.assignee.id = :pAssigneeId",
						IssueTask.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAssigneeId", assigneeId).getResultList();
	}
}
