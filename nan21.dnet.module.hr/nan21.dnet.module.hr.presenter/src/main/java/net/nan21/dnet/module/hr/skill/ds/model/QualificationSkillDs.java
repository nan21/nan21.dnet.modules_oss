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
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.hr.skill.domain.entity.QualificationSkill;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

@Ds(entity = QualificationSkill.class, sort = {@SortField(field = QualificationSkillDs.f_skill)})
@RefLookups({
		@RefLookup(refId = QualificationSkillDs.f_qualificationId),
		@RefLookup(refId = QualificationSkillDs.f_skillId, namedQuery = Skill.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = QualificationSkillDs.f_skill)}),
		@RefLookup(refId = QualificationSkillDs.f_requiredLevelId, namedQuery = RatingLevel.NQ_FIND_BY_NAME_PRIMITIVE, params = {
				@Param(name = "pRatingScaleId", field = QualificationSkillDs.f_ratingScaleId),
				@Param(name = "pName", field = QualificationSkillDs.f_requiredLevel)})})
public class QualificationSkillDs
		extends
			AbstractAuditableDs<QualificationSkill> {

	public static final String f_qualificationId = "qualificationId";
	public static final String f_skillId = "skillId";
	public static final String f_skill = "skill";
	public static final String f_ratingScaleId = "ratingScaleId";
	public static final String f_requiredLevelId = "requiredLevelId";
	public static final String f_requiredLevel = "requiredLevel";

	@DsField(join = "left", path = "qualification.id")
	private Long qualificationId;

	@DsField(join = "left", path = "skill.id")
	private Long skillId;

	@DsField(join = "left", path = "skill.name")
	private String skill;

	@DsField(join = "left", path = "skill.ratingScale.id")
	private Long ratingScaleId;

	@DsField(join = "left", path = "requiredLevel.id")
	private Long requiredLevelId;

	@DsField(join = "left", path = "requiredLevel.name")
	private String requiredLevel;

	public QualificationSkillDs() {
		super();
	}

	public QualificationSkillDs(QualificationSkill e) {
		super(e);
	}

	public Long getQualificationId() {
		return this.qualificationId;
	}

	public void setQualificationId(Long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public Long getSkillId() {
		return this.skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkill() {
		return this.skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Long getRatingScaleId() {
		return this.ratingScaleId;
	}

	public void setRatingScaleId(Long ratingScaleId) {
		this.ratingScaleId = ratingScaleId;
	}

	public Long getRequiredLevelId() {
		return this.requiredLevelId;
	}

	public void setRequiredLevelId(Long requiredLevelId) {
		this.requiredLevelId = requiredLevelId;
	}

	public String getRequiredLevel() {
		return this.requiredLevel;
	}

	public void setRequiredLevel(String requiredLevel) {
		this.requiredLevel = requiredLevel;
	}
}
