/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.IRatingLevelService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;

/**
 * Repository functionality for {@link RatingLevel} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class RatingLevelService extends AbstractEntityService<RatingLevel>
		implements
			IRatingLevelService {

	public RatingLevelService() {
		super();
	}

	public RatingLevelService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<RatingLevel> getEntityClass() {
		return RatingLevel.class;
	}

	/**
	 * Find by unique key
	 */
	public RatingLevel findByName(RatingScale ratingScale, String name) {
		return (RatingLevel) this.em
				.createNamedQuery(RatingLevel.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRatingScale", ratingScale)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public RatingLevel findByName(Long ratingScaleId, String name) {
		return (RatingLevel) this.em
				.createNamedQuery(RatingLevel.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRatingScaleId", ratingScaleId)
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: ratingScale
	 */
	public List<RatingLevel> findByRatingScale(RatingScale ratingScale) {
		return this.findByRatingScaleId(ratingScale.getId());
	}

	/**
	 * Find by ID of reference: ratingScale.id
	 */
	public List<RatingLevel> findByRatingScaleId(Long ratingScaleId) {
		return (List<RatingLevel>) this.em
				.createQuery(
						"select e from RatingLevel e where e.clientId = :pClientId and e.ratingScale.id = :pRatingScaleId",
						RatingLevel.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRatingScaleId", ratingScaleId).getResultList();
	}
}
