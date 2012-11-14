/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;

/**
 * Interface to expose business functions specific for {@link RatingLevel} domain
 * entity.
 */
public interface IRatingLevelService extends IEntityService<RatingLevel> {

	/**
	 * Find by unique key
	 */
	public RatingLevel findByName(RatingScale ratingScale, String name);

	/**
	 * Find by unique key
	 */
	public RatingLevel findByName(Long ratingScaleId, String name);

	/**
	 * Find by reference: ratingScale
	 */
	public List<RatingLevel> findByRatingScale(RatingScale ratingScale);

	/**
	 * Find by ID of reference: ratingScale.id
	 */
	public List<RatingLevel> findByRatingScaleId(Long ratingScaleId);
}
