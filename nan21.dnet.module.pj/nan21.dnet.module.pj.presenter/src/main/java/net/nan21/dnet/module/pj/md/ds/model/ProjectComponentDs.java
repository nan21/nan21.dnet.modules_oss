/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.md.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.pj.md.domain.entity.Project;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectComponent;

@Ds(entity = ProjectComponent.class, sort = {@SortField(field = ProjectComponentDs.f_name)})
@RefLookups({@RefLookup(refId = ProjectComponentDs.f_projectId, namedQuery = Project.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = ProjectComponentDs.f_project)})})
public class ProjectComponentDs extends AbstractTypeDs<ProjectComponent> {

	public static final String f_projectId = "projectId";
	public static final String f_project = "project";
	public static final String f_projectName = "projectName";

	@DsField(join = "left", path = "project.id")
	private Long projectId;

	@DsField(join = "left", path = "project.code")
	private String project;

	@DsField(join = "left", path = "project.name")
	private String projectName;

	public ProjectComponentDs() {
		super();
	}

	public ProjectComponentDs(ProjectComponent e) {
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
}
