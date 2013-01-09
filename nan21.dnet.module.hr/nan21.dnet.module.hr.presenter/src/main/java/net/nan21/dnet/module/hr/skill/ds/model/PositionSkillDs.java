/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.skill.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.hr.skill.domain.entity.PositionSkill;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

@Ds(entity = PositionSkill.class)
@RefLookups({
		@RefLookup(refId = PositionSkillDs.f_positionId),
		@RefLookup(refId = PositionSkillDs.f_requiredLevelId, namedQuery = RatingLevel.NQ_FIND_BY_NAME_PRIMITIVE, params = {
				@Param(name = "pRatingScaleId", field = PositionSkillDs.f_ratingScaleId),
				@Param(name = "pName", field = PositionSkillDs.f_requiredLevel)}),
		@RefLookup(refId = PositionSkillDs.f_competenceId, namedQuery = Skill.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PositionSkillDs.f_competence)})})
public class PositionSkillDs extends AbstractAuditableDs<PositionSkill> {

	public static final String f_positionId = "positionId";
	public static final String f_competenceId = "competenceId";
	public static final String f_competence = "competence";
	public static final String f_ratingScaleId = "ratingScaleId";
	public static final String f_requiredLevelId = "requiredLevelId";
	public static final String f_requiredLevel = "requiredLevel";

	@DsField(join = "left", path = "position.id")
	private Long positionId;

	@DsField(join = "left", path = "skill.id")
	private Long competenceId;

	@DsField(join = "left", path = "skill.name")
	private String competence;

	@DsField(join = "left", path = "skill.ratingScale.id")
	private Long ratingScaleId;

	@DsField(join = "left", path = "requiredLevel.id")
	private Long requiredLevelId;

	@DsField(join = "left", path = "requiredLevel.name")
	private String requiredLevel;

	public PositionSkillDs() {
		super();
	}

	public PositionSkillDs(PositionSkill e) {
		super(e);
	}

	public Long getPositionId() {
		return this.positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public Long getCompetenceId() {
		return this.competenceId;
	}

	public void setCompetenceId(Long competenceId) {
		this.competenceId = competenceId;
	}

	public String getCompetence() {
		return this.competence;
	}

	public void setCompetence(String competence) {
		this.competence = competence;
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
