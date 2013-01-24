/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.skill.domain.entity.Qualification;
import net.nan21.dnet.module.hr.skill.domain.entity.QualificationSkill;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

/**
 * Interface to expose business functions specific for {@link QualificationSkill} domain
 * entity.
 */
public interface IQualificationSkillService
		extends
			IEntityService<QualificationSkill> {

	/**
	 * Find by reference: qualification
	 */
	public List<QualificationSkill> findByQualification(
			Qualification qualification);

	/**
	 * Find by ID of reference: qualification.id
	 */
	public List<QualificationSkill> findByQualificationId(Long qualificationId);

	/**
	 * Find by reference: skill
	 */
	public List<QualificationSkill> findBySkill(Skill skill);

	/**
	 * Find by ID of reference: skill.id
	 */
	public List<QualificationSkill> findBySkillId(Long skillId);

	/**
	 * Find by reference: requiredLevel
	 */
	public List<QualificationSkill> findByRequiredLevel(
			RatingLevel requiredLevel);

	/**
	 * Find by ID of reference: requiredLevel.id
	 */
	public List<QualificationSkill> findByRequiredLevelId(Long requiredLevelId);
}
