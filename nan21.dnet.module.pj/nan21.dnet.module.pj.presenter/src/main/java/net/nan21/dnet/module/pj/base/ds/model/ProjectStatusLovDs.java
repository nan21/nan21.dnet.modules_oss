/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectStatus;

@Ds(entity = ProjectStatus.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = ProjectStatusLovDs.f_name)})
public class ProjectStatusLovDs extends AbstractTypeLov<ProjectStatus> {

	public ProjectStatusLovDs() {
		super();
	}

	public ProjectStatusLovDs(ProjectStatus e) {
		super(e);
	}
}
