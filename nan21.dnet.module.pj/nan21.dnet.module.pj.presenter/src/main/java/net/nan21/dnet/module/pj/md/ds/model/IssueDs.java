/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.pj.base.domain.entity.IssuePriority;
import net.nan21.dnet.module.pj.base.domain.entity.IssueResolution;
import net.nan21.dnet.module.pj.base.domain.entity.IssueSeverity;
import net.nan21.dnet.module.pj.base.domain.entity.IssueStatus;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

@Ds(entity = Issue.class, sort = {@SortField(field = IssueDs.f_modifiedAt, desc = true)})
@RefLookups({
		@RefLookup(refId = IssueDs.f_projectId, namedQuery = Project.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = IssueDs.f_project)}),
		@RefLookup(refId = IssueDs.f_typeId, namedQuery = IssueType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = IssueDs.f_type)}),
		@RefLookup(refId = IssueDs.f_statusId, namedQuery = IssueStatus.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = IssueDs.f_status)}),
		@RefLookup(refId = IssueDs.f_priorityId, namedQuery = IssuePriority.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = IssueDs.f_priority)}),
		@RefLookup(refId = IssueDs.f_resolutionId, namedQuery = IssueResolution.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = IssueDs.f_resolution)}),
		@RefLookup(refId = IssueDs.f_severityId, namedQuery = IssueSeverity.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = IssueDs.f_severity)}),
		@RefLookup(refId = IssueDs.f_assigneeId),
		@RefLookup(refId = IssueDs.f_assigneeRoleId, namedQuery = ProjectRole.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = IssueDs.f_assigneeRole)}),
		@RefLookup(refId = IssueDs.f_reportedVersionId, namedQuery = ProjectVersion.NQ_FIND_BY_NAME_PRIMITIVE, params = {
				@Param(name = "pProjectId", field = IssueDs.f_projectId),
				@Param(name = "pName", field = IssueDs.f_reportedVersion)}),
		@RefLookup(refId = IssueDs.f_targetVersionId, namedQuery = ProjectVersion.NQ_FIND_BY_NAME_PRIMITIVE, params = {
				@Param(name = "pName", field = IssueDs.f_targetVersion),
				@Param(name = "pProjectId", field = IssueDs.f_projectId)}),
		@RefLookup(refId = IssueDs.f_fixedInVersionId, namedQuery = ProjectVersion.NQ_FIND_BY_NAME_PRIMITIVE, params = {
				@Param(name = "pName", field = IssueDs.f_fixedInVersion),
				@Param(name = "pProjectId", field = IssueDs.f_projectId)})})
public class IssueDs extends AbstractAuditableDs<Issue> {

	public static final String f_projectId = "projectId";
	public static final String f_project = "project";
	public static final String f_projectName = "projectName";
	public static final String f_code = "code";
	public static final String f_summary = "summary";
	public static final String f_description = "description";
	public static final String f_businessValue = "businessValue";
	public static final String f_estimatedEffort = "estimatedEffort";
	public static final String f_clarity = "clarity";
	public static final String f_dueDate = "dueDate";
	public static final String f_resolutionDate = "resolutionDate";
	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_statusId = "statusId";
	public static final String f_status = "status";
	public static final String f_priorityId = "priorityId";
	public static final String f_priority = "priority";
	public static final String f_resolutionId = "resolutionId";
	public static final String f_resolution = "resolution";
	public static final String f_severityId = "severityId";
	public static final String f_severity = "severity";
	public static final String f_assigneeId = "assigneeId";
	public static final String f_assignee = "assignee";
	public static final String f_assigneeRoleId = "assigneeRoleId";
	public static final String f_assigneeRole = "assigneeRole";
	public static final String f_reportedVersionId = "reportedVersionId";
	public static final String f_reportedVersion = "reportedVersion";
	public static final String f_targetVersionId = "targetVersionId";
	public static final String f_targetVersion = "targetVersion";
	public static final String f_fixedInVersionId = "fixedInVersionId";
	public static final String f_fixedInVersion = "fixedInVersion";
	public static final String f_businessObject = "businessObject";

	@DsField(noUpdate = true, join = "left", path = "project.id")
	private Long projectId;

	@DsField(noUpdate = true, join = "left", path = "project.code")
	private String project;

	@DsField(noUpdate = true, join = "left", path = "project.name")
	private String projectName;

	@DsField(noUpdate = true)
	private String code;

	@DsField
	private String summary;

	@DsField
	private String description;

	@DsField
	private Integer businessValue;

	@DsField
	private Integer estimatedEffort;

	@DsField
	private Integer clarity;

	@DsField
	private Date dueDate;

	@DsField
	private Date resolutionDate;

	@DsField(join = "left", path = "type.id")
	private Long typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	@DsField(join = "left", path = "status.id")
	private Long statusId;

	@DsField(join = "left", path = "status.name")
	private String status;

	@DsField(join = "left", path = "priority.id")
	private Long priorityId;

	@DsField(join = "left", path = "priority.name")
	private String priority;

	@DsField(join = "left", path = "resolution.id")
	private Long resolutionId;

	@DsField(join = "left", path = "resolution.name")
	private String resolution;

	@DsField(join = "left", path = "severity.id")
	private Long severityId;

	@DsField(join = "left", path = "severity.name")
	private String severity;

	@DsField(join = "left", path = "assignee.id")
	private Long assigneeId;

	@DsField(join = "left", path = "assignee.member.name")
	private String assignee;

	@DsField(join = "left", path = "assigneeRole.id")
	private Long assigneeRoleId;

	@DsField(join = "left", path = "assigneeRole.name")
	private String assigneeRole;

	@DsField(join = "left", path = "reportedVersion.id")
	private Long reportedVersionId;

	@DsField(join = "left", path = "reportedVersion.name")
	private String reportedVersion;

	@DsField(join = "left", path = "targetVersion.id")
	private Long targetVersionId;

	@DsField(join = "left", path = "targetVersion.name")
	private String targetVersion;

	@DsField(join = "left", path = "fixedInVersion.id")
	private Long fixedInVersionId;

	@DsField(join = "left", path = "fixedInVersion.name")
	private String fixedInVersion;

	@DsField(fetch = false)
	private String businessObject;

	public IssueDs() {
		super();
	}

	public IssueDs(Issue e) {
		super(e);
	}

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getBusinessValue() {
		return this.businessValue;
	}

	public void setBusinessValue(Integer businessValue) {
		this.businessValue = businessValue;
	}

	public Integer getEstimatedEffort() {
		return this.estimatedEffort;
	}

	public void setEstimatedEffort(Integer estimatedEffort) {
		this.estimatedEffort = estimatedEffort;
	}

	public Integer getClarity() {
		return this.clarity;
	}

	public void setClarity(Integer clarity) {
		this.clarity = clarity;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getResolutionDate() {
		return this.resolutionDate;
	}

	public void setResolutionDate(Date resolutionDate) {
		this.resolutionDate = resolutionDate;
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getPriorityId() {
		return this.priorityId;
	}

	public void setPriorityId(Long priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Long getResolutionId() {
		return this.resolutionId;
	}

	public void setResolutionId(Long resolutionId) {
		this.resolutionId = resolutionId;
	}

	public String getResolution() {
		return this.resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public Long getSeverityId() {
		return this.severityId;
	}

	public void setSeverityId(Long severityId) {
		this.severityId = severityId;
	}

	public String getSeverity() {
		return this.severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Long getAssigneeId() {
		return this.assigneeId;
	}

	public void setAssigneeId(Long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public String getAssignee() {
		return this.assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public Long getAssigneeRoleId() {
		return this.assigneeRoleId;
	}

	public void setAssigneeRoleId(Long assigneeRoleId) {
		this.assigneeRoleId = assigneeRoleId;
	}

	public String getAssigneeRole() {
		return this.assigneeRole;
	}

	public void setAssigneeRole(String assigneeRole) {
		this.assigneeRole = assigneeRole;
	}

	public Long getReportedVersionId() {
		return this.reportedVersionId;
	}

	public void setReportedVersionId(Long reportedVersionId) {
		this.reportedVersionId = reportedVersionId;
	}

	public String getReportedVersion() {
		return this.reportedVersion;
	}

	public void setReportedVersion(String reportedVersion) {
		this.reportedVersion = reportedVersion;
	}

	public Long getTargetVersionId() {
		return this.targetVersionId;
	}

	public void setTargetVersionId(Long targetVersionId) {
		this.targetVersionId = targetVersionId;
	}

	public String getTargetVersion() {
		return this.targetVersion;
	}

	public void setTargetVersion(String targetVersion) {
		this.targetVersion = targetVersion;
	}

	public Long getFixedInVersionId() {
		return this.fixedInVersionId;
	}

	public void setFixedInVersionId(Long fixedInVersionId) {
		this.fixedInVersionId = fixedInVersionId;
	}

	public String getFixedInVersion() {
		return this.fixedInVersion;
	}

	public void setFixedInVersion(String fixedInVersion) {
		this.fixedInVersion = fixedInVersion;
	}

	public String getBusinessObject() {
		return this.businessObject;
	}

	public void setBusinessObject(String businessObject) {
		this.businessObject = businessObject;
	}
}
