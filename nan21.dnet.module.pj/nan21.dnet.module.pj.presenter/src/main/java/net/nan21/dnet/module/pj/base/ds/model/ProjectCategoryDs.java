/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectCategory;

@Ds(entity = ProjectCategory.class, sort = {@SortField(field = ProjectCategoryDs.f_name)})
public class ProjectCategoryDs extends AbstractTypeDs<ProjectCategory> {

	public ProjectCategoryDs() {
		super();
	}

	public ProjectCategoryDs(ProjectCategory e) {
		super(e);
	}
}
