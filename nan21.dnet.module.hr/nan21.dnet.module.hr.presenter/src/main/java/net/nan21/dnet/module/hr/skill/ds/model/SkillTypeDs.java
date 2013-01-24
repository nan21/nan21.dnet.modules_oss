/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

@Ds(entity = SkillType.class, sort = {@SortField(field = SkillTypeDs.f_name)})
@RefLookups({@RefLookup(refId = SkillTypeDs.f_categoryId, namedQuery = SkillCategory.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = SkillTypeDs.f_category)})})
public class SkillTypeDs extends AbstractTypeDs<SkillType> {

	public static final String f_categoryId = "categoryId";
	public static final String f_category = "category";

	@DsField(join = "left", path = "category.id")
	private Long categoryId;

	@DsField(join = "left", path = "category.name")
	private String category;

	public SkillTypeDs() {
		super();
	}

	public SkillTypeDs(SkillType e) {
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
