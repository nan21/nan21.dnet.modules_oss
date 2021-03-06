/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;

@Ds(entity = ProjectRole.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = ProjectRoleLovDs.f_name)})
public class ProjectRoleLovDs extends AbstractTypeLov<ProjectRole> {

	public ProjectRoleLovDs() {
		super();
	}

	public ProjectRoleLovDs(ProjectRole e) {
		super(e);
	}
}
