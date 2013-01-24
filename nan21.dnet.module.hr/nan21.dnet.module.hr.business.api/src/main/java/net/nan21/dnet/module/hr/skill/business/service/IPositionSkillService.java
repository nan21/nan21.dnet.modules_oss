/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.skill.domain.entity.PositionSkill;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

/**
 * Interface to expose business functions specific for {@link PositionSkill} domain
 * entity.
 */
public interface IPositionSkillService extends IEntityService<PositionSkill> {

	/**
	 * Find by reference: position
	 */
	public List<PositionSkill> findByPosition(Position position);

	/**
	 * Find by ID of reference: position.id
	 */
	public List<PositionSkill> findByPositionId(Long positionId);

	/**
	 * Find by reference: skill
	 */
	public List<PositionSkill> findBySkill(Skill skill);

	/**
	 * Find by ID of reference: skill.id
	 */
	public List<PositionSkill> findBySkillId(Long skillId);

	/**
	 * Find by reference: requiredLevel
	 */
	public List<PositionSkill> findByRequiredLevel(RatingLevel requiredLevel);

	/**
	 * Find by ID of reference: requiredLevel.id
	 */
	public List<PositionSkill> findByRequiredLevelId(Long requiredLevelId);
}
