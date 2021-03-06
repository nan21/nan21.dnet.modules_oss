/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.md.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskType;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectMember;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({})
@Entity
@Table(name = IssueTask.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
public class IssueTask extends AbstractAuditable {

	public static final String TABLE_NAME = "PJ_TASK";
	public static final String SEQUENCE_NAME = "PJ_TASK_SEQ";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * System generated unique identifier.
	 */
	@Column(name = "ID", nullable = false)
	@NotNull
	@Id
	@GeneratedValue(generator = SEQUENCE_NAME)
	private Long id;

	@Column(name = "CODE", nullable = false, length = 32)
	@NotBlank
	private String code;

	@Column(name = "DESCRIPTION", length = 4000)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Issue.class)
	@JoinColumn(name = "ISSUE_ID", referencedColumnName = "ID")
	private Issue issue;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = IssueTaskType.class)
	@JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
	private IssueTaskType type;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = IssueTaskStatus.class)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
	private IssueTaskStatus status;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ProjectMember.class)
	@JoinColumn(name = "ASSIGNEE_ID", referencedColumnName = "ID")
	private ProjectMember assignee;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Issue getIssue() {
		return this.issue;
	}

	public void setIssue(Issue issue) {
		if (issue != null) {
			this.__validate_client_context__(issue.getClientId());
		}
		this.issue = issue;
	}

	public IssueTaskType getType() {
		return this.type;
	}

	public void setType(IssueTaskType type) {
		if (type != null) {
			this.__validate_client_context__(type.getClientId());
		}
		this.type = type;
	}

	public IssueTaskStatus getStatus() {
		return this.status;
	}

	public void setStatus(IssueTaskStatus status) {
		if (status != null) {
			this.__validate_client_context__(status.getClientId());
		}
		this.status = status;
	}

	public ProjectMember getAssignee() {
		return this.assignee;
	}

	public void setAssignee(ProjectMember assignee) {
		if (assignee != null) {
			this.__validate_client_context__(assignee.getClientId());
		}
		this.assignee = assignee;
	}

	public void aboutToInsert(DescriptorEvent event) {
		super.aboutToInsert(event);

		if (this.getCode() == null || this.getCode().equals("")) {
			event.updateAttributeWithObject("code", "T-" + this.getId());
		}
	}
}
