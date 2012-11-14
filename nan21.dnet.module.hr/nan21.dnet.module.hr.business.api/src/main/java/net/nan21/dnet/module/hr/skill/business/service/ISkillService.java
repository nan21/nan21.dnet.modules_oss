/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

/**
 * Interface to expose business functions specific for {@link Skill} domain
 * entity.
 */
public interface ISkillService extends IEntityService<Skill> {

	/**
	 * Find by unique key
	 */
	public Skill findByName(String name);

	/**
	 * Find by reference: type
	 */
	public List<Skill> findByType(SkillType type);

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Skill> findByTypeId(Long typeId);

	/**
	 * Find by reference: ratingScale
	 */
	public List<Skill> findByRatingScale(RatingScale ratingScale);

	/**
	 * Find by ID of reference: ratingScale.id
	 */
	public List<Skill> findByRatingScaleId(Long ratingScaleId);
}
