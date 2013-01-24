/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.ISkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingScale;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;
import net.nan21.dnet.module.hr.skill.domain.entity.SkillType;

/**
 * Repository functionality for {@link Skill} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SkillService extends AbstractEntityService<Skill>
		implements
			ISkillService {

	public SkillService() {
		super();
	}

	public SkillService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Skill> getEntityClass() {
		return Skill.class;
	}

	/**
	 * Find by unique key
	 */
	public Skill findByName(String name) {
		return (Skill) this.getEntityManager()
				.createNamedQuery(Skill.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: type
	 */
	public List<Skill> findByType(SkillType type) {
		return this.findByTypeId(type.getId());
	}

	/**
	 * Find by ID of reference: type.id
	 */
	public List<Skill> findByTypeId(Long typeId) {
		return (List<Skill>) this
				.getEntityManager()
				.createQuery(
						"select e from Skill e where e.clientId = :pClientId and e.type.id = :pTypeId",
						Skill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTypeId", typeId).getResultList();
	}

	/**
	 * Find by reference: ratingScale
	 */
	public List<Skill> findByRatingScale(RatingScale ratingScale) {
		return this.findByRatingScaleId(ratingScale.getId());
	}

	/**
	 * Find by ID of reference: ratingScale.id
	 */
	public List<Skill> findByRatingScaleId(Long ratingScaleId) {
		return (List<Skill>) this
				.getEntityManager()
				.createQuery(
						"select e from Skill e where e.clientId = :pClientId and e.ratingScale.id = :pRatingScaleId",
						Skill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRatingScaleId", ratingScaleId).getResultList();
	}
}
