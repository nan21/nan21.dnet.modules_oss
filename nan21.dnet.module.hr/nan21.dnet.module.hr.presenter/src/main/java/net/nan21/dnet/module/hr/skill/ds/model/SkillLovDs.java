/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeLov;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

@Ds(entity = Skill.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = SkillLovDs.f_name)})
public class SkillLovDs extends AbstractTypeLov<Skill> {

	public static final String f_ratingScaleId = "ratingScaleId";

	@DsField(join = "left", path = "ratingScale.id")
	private Long ratingScaleId;

	public SkillLovDs() {
		super();
	}

	public SkillLovDs(Skill e) {
		super(e);
	}

	public Long getRatingScaleId() {
		return this.ratingScaleId;
	}

	public void setRatingScaleId(Long ratingScaleId) {
		this.ratingScaleId = ratingScaleId;
	}
}
