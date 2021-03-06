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
import net.nan21.dnet.module.pj.base.domain.entity.IssueCategory;
import net.nan21.dnet.module.pj.base.domain.entity.IssueType;

@Ds(entity = IssueType.class, sort = {@SortField(field = IssueTypeDs.f_name)})
@RefLookups({@RefLookup(refId = IssueTypeDs.f_categoryId, namedQuery = IssueCategory.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = IssueTypeDs.f_category)})})
public class IssueTypeDs extends AbstractTypeDs<IssueType> {

	public static final String f_categoryId = "categoryId";
	public static final String f_category = "category";

	@DsField(join = "left", path = "category.id")
	private Long categoryId;

	@DsField(join = "left", path = "category.name")
	private String category;

	public IssueTypeDs() {
		super();
	}

	public IssueTypeDs(IssueType e) {
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
