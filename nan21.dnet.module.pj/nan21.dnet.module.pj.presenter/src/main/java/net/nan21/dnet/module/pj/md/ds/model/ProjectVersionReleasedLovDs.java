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
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;

@Ds(entity = ProjectVersion.class, jpqlWhere = " e.releaseDate is not null ", sort = {@SortField(field = ProjectVersionReleasedLovDs.f_planDate, desc = true)})
public class ProjectVersionReleasedLovDs
		extends
			AbstractTypeLov<ProjectVersion> {

	public static final String f_projectId = "projectId";
	public static final String f_planDate = "planDate";

	@DsField(join = "left", path = "project.id")
	private Long projectId;

	@DsField
	private Date planDate;

	public ProjectVersionReleasedLovDs() {
		super();
	}

	public ProjectVersionReleasedLovDs(ProjectVersion e) {
		super(e);
	}

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Date getPlanDate() {
		return this.planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
}
