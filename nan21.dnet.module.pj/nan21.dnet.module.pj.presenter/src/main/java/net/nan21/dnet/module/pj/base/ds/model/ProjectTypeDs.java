/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.pj.base.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectCategory;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectType;

@Ds(entity = ProjectType.class, sort = {@SortField(field = ProjectTypeDs.f_name)})
@RefLookups({@RefLookup(refId = ProjectTypeDs.f_categoryId, namedQuery = ProjectCategory.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = ProjectTypeDs.f_category)})})
public class ProjectTypeDs extends AbstractTypeDs<ProjectType> {

	public static final String f_categoryId = "categoryId";
	public static final String f_category = "category";

	@DsField(join = "left", path = "category.id")
	private Long categoryId;

	@DsField(join = "left", path = "category.name")
	private String category;

	public ProjectTypeDs() {
		super();
	}

	public ProjectTypeDs(ProjectType e) {
		super(e);
	}

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
