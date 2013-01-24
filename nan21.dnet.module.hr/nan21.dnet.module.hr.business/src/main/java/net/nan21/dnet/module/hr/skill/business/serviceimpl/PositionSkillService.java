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
import net.nan21.dnet.module.hr.job.domain.entity.Position;
import net.nan21.dnet.module.hr.skill.business.service.IPositionSkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.PositionSkill;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

/**
 * Repository functionality for {@link PositionSkill} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PositionSkillService extends AbstractEntityService<PositionSkill>
		implements
			IPositionSkillService {

	public PositionSkillService() {
		super();
	}

	public PositionSkillService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PositionSkill> getEntityClass() {
		return PositionSkill.class;
	}

	/**
	 * Find by reference: position
	 */
	public List<PositionSkill> findByPosition(Position position) {
		return this.findByPositionId(position.getId());
	}

	/**
	 * Find by ID of reference: position.id
	 */
	public List<PositionSkill> findByPositionId(Long positionId) {
		return (List<PositionSkill>) this
				.getEntityManager()
				.createQuery(
						"select e from PositionSkill e where e.clientId = :pClientId and e.position.id = :pPositionId",
						PositionSkill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPositionId", positionId).getResultList();
	}

	/**
	 * Find by reference: skill
	 */
	public List<PositionSkill> findBySkill(Skill skill) {
		return this.findBySkillId(skill.getId());
	}

	/**
	 * Find by ID of reference: skill.id
	 */
	public List<PositionSkill> findBySkillId(Long skillId) {
		return (List<PositionSkill>) this
				.getEntityManager()
				.createQuery(
						"select e from PositionSkill e where e.clientId = :pClientId and e.skill.id = :pSkillId",
						PositionSkill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSkillId", skillId).getResultList();
	}

	/**
	 * Find by reference: requiredLevel
	 */
	public List<PositionSkill> findByRequiredLevel(RatingLevel requiredLevel) {
		return this.findByRequiredLevelId(requiredLevel.getId());
	}

	/**
	 * Find by ID of reference: requiredLevel.id
	 */
	public List<PositionSkill> findByRequiredLevelId(Long requiredLevelId) {
		return (List<PositionSkill>) this
				.getEntityManager()
				.createQuery(
						"select e from PositionSkill e where e.clientId = :pClientId and e.requiredLevel.id = :pRequiredLevelId",
						PositionSkill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRequiredLevelId", requiredLevelId)
				.getResultList();
	}
}
