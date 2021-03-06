/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
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
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

@Ds(entity = ProjectVersion.class, sort = {@SortField(field = ProjectVersionDs.f_planDate, desc = true)})
@RefLookups({@RefLookup(refId = ProjectVersionDs.f_projectId, namedQuery = Project.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProjectVersionDs.f_project)})})
public class ProjectVersionDs extends AbstractTypeDs<ProjectVersion> {

	public static final String f_projectId = "projectId";
	public static final String f_project = "project";
	public static final String f_projectName = "projectName";
	public static final String f_planDate = "planDate";
	public static final String f_releaseDate = "releaseDate";

	@DsField(join = "left", path = "project.id")
	private Long projectId;

	@DsField(join = "left", path = "project.code")
	private String project;

	@DsField(join = "left", path = "project.name")
	private String projectName;

	@DsField
	private Date planDate;

	@DsField
	private Date releaseDate;

	public ProjectVersionDs() {
		super();
	}

	public ProjectVersionDs(ProjectVersion e) {
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

	public Date getPlanDate() {
		return this.planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}
