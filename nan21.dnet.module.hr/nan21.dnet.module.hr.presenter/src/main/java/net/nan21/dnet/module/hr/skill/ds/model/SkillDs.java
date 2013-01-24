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
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

@Ds(entity = Skill.class, sort = {@SortField(field = SkillDs.f_name)})
@RefLookups({
		@RefLookup(refId = SkillDs.f_typeId, namedQuery = SkillType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = SkillDs.f_type)}),
		@RefLookup(refId = SkillDs.f_ratingScaleId, namedQuery = RatingScale.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = SkillDs.f_ratingScale)})})
public class SkillDs extends AbstractTypeDs<Skill> {

	public static final String f_typeId = "typeId";
	public static final String f_type = "type";
	public static final String f_ratingScaleId = "ratingScaleId";
	public static final String f_ratingScale = "ratingScale";

	@DsField(join = "left", path = "type.id")
	private Long typeId;

	@DsField(join = "left", path = "type.name")
	private String type;

	@DsField(join = "left", path = "ratingScale.id")
	private Long ratingScaleId;

	@DsField(join = "left", path = "ratingScale.name")
	private String ratingScale;

	public SkillDs() {
		super();
	}

	public SkillDs(Skill e) {
		super(e);
	}

	public Long getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getRatingScaleId() {
		return this.ratingScaleId;
	}

	public void setRatingScaleId(Long ratingScaleId) {
		this.ratingScaleId = ratingScaleId;
	}

	public String getRatingScale() {
		return this.ratingScale;
	}

	public void setRatingScale(String ratingScale) {
		this.ratingScale = ratingScale;
	}
}
