/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.pj.md.domain.entity.Issue;

@Ds(entity = Issue.class, jpqlWhere = "e.targetVersion.releaseDate is null", sort = {
		@SortField(field = IssueRoadmapDs.f_targetVersionDate),
		@SortField(field = IssueRoadmapDs.f_targetVersion),
		@SortField(field = IssueRoadmapDs.f_modifiedAt, desc = true)})
public class IssueRoadmapDs extends AbstractAuditableDs<Issue> {

	public static final String f_projectId = "projectId";
	public static final String f_project = "project";
	public static final String f_projectName = "projectName";
	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_statusId = "statusId";
	public static final String f_status = "status";
	public static final String f_code = "code";
	public static final String f_summary = "summary";
	public static final String f_targetVersionId = "targetVersionId";
	public static final String f_targetVersion = "targetVersion";
	public static final String f_targetVersionDate = "targetVersionDate";
	public static final String f_fixedInVersionId = "fixedInVersionId";
	public static final String f_fixedInVersion = "fixedInVersion";

	@DsField(join = "left", path = "project.id")
	private Long projectId;

	@DsField(join = "left", path = "project.code")
	private String project;

	@DsField(join = "left", path = "project.name")
	private String projectName;

	@DsField(join = "left", path = "type.id")
	private Long typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	@DsField(join = "left", path = "status.id")
	private Long statusId;

	@DsField(join = "left", path = "status.name")
	private String status;

	@DsField
	private String code;

	@DsField
	private String summary;

	@DsField(join = "left", path = "targetVersion.id")
	private Long targetVersionId;

	@DsField(join = "left", path = "targetVersion.name")
	private String targetVersion;

	@DsField(join = "left", path = "targetVersion.planDate")
	private Date targetVersionDate;

	@DsField(join = "left", path = "fixedInVersion.id")
	private Long fixedInVersionId;

	@DsField(join = "left", path = "fixedInVersion.name")
	private String fixedInVersion;

	public IssueRoadmapDs() {
		super();
	}

	public IssueRoadmapDs(Issue e) {
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

	public Date getTargetVersionDate() {
		return this.targetVersionDate;
	}

	public void setTargetVersionDate(Date targetVersionDate) {
		this.targetVersionDate = targetVersionDate;
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
}
