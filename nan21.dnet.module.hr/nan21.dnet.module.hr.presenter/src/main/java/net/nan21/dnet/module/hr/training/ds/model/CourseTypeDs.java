/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.training.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.hr.training.domain.entity.CourseCategory;
import net.nan21.dnet.module.hr.training.domain.entity.CourseType;

@Ds(entity = CourseType.class, sort = {@SortField(field = CourseTypeDs.f_name)})
@RefLookups({@RefLookup(refId = CourseTypeDs.f_categoryId, namedQuery = CourseCategory.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = CourseTypeDs.f_category)})})
public class CourseTypeDs extends AbstractTypeDs<CourseType> {

	public static final String f_categoryId = "categoryId";
	public static final String f_category = "category";

	@DsField(join = "left", path = "category.id")
	private Long categoryId;

	@DsField(join = "left", path = "category.name")
	private String category;

	public CourseTypeDs() {
		super();
	}

	public CourseTypeDs(CourseType e) {
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
