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
import net.nan21.dnet.module.hr.skill.domain.entity.EmployeeSkill;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

@Ds(entity = EmployeeSkill.class)
@RefLookups({
		@RefLookup(refId = EmployeeSkillDs.f_employeeId),
		@RefLookup(refId = EmployeeSkillDs.f_skillId, namedQuery = Skill.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = EmployeeSkillDs.f_skill)}),
		@RefLookup(refId = EmployeeSkillDs.f_skillLevelId, namedQuery = RatingLevel.NQ_FIND_BY_NAME_PRIMITIVE, params = {
				@Param(name = "pRatingScaleId", field = EmployeeSkillDs.f_ratingScaleId),
				@Param(name = "pName", field = EmployeeSkillDs.f_skillLevel)})})
public class EmployeeSkillDs extends AbstractAuditableDs<EmployeeSkill> {

	public static final String f_employeeId = "employeeId";
	public static final String f_skillId = "skillId";
	public static final String f_skill = "skill";
	public static final String f_ratingScaleId = "ratingScaleId";
	public static final String f_skillLevelId = "skillLevelId";
	public static final String f_skillLevel = "skillLevel";

	@DsField(join = "left", path = "employee.id")
	private Long employeeId;

	@DsField(join = "left", path = "skill.id")
	private Long skillId;

	@DsField(join = "left", path = "skill.name")
	private String skill;

	@DsField(join = "left", path = "skill.ratingScale.id")
	private Long ratingScaleId;

	@DsField(join = "left", path = "skillLevel.id")
	private Long skillLevelId;

	@DsField(join = "left", path = "skillLevel.name")
	private String skillLevel;

	public EmployeeSkillDs() {
		super();
	}

	public EmployeeSkillDs(EmployeeSkill e) {
		super(e);
	}

	public Long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public Long getSkillLevelId() {
		return this.skillLevelId;
	}

	public void setSkillLevelId(Long skillLevelId) {
		this.skillLevelId = skillLevelId;
	}

	public String getSkillLevel() {
		return this.skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
}
