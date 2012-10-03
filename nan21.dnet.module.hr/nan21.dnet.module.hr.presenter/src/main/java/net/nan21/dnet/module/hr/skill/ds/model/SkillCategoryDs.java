/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillCategory;

@Ds(entity=SkillCategory.class, sort={@SortField(field=SkillCategoryDs.fNAME)})
public class SkillCategoryDs extends AbstractTypeDs<SkillCategory> {


	public SkillCategoryDs() {
		super();
	}

 	public SkillCategoryDs(SkillCategory e) {
		super(e);
	}
}
