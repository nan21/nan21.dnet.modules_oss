/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectRole;

@Ds(entity = ProjectRole.class, sort = {@SortField(field = ProjectRoleDs.f_name)})
public class ProjectRoleDs extends AbstractTypeDs<ProjectRole> {

	public ProjectRoleDs() {
		super();
	}

	public ProjectRoleDs(ProjectRole e) {
		super(e);
	}
}
