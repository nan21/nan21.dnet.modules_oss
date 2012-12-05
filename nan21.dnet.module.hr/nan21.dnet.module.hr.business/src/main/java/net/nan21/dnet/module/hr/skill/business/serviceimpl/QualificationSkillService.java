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
import net.nan21.dnet.module.hr.skill.business.service.IQualificationSkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.Qualification;
import net.nan21.dnet.module.hr.skill.domain.entity.QualificationSkill;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

/**
 * Repository functionality for {@link QualificationSkill} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QualificationSkillService
		extends
			AbstractEntityService<QualificationSkill>
		implements
			IQualificationSkillService {

	public QualificationSkillService() {
		super();
	}

	public QualificationSkillService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QualificationSkill> getEntityClass() {
		return QualificationSkill.class;
	}

	/**
	 * Find by reference: qualification
	 */
	public List<QualificationSkill> findByQualification(
			Qualification qualification) {
		return this.findByQualificationId(qualification.getId());
	}

	/**
	 * Find by ID of reference: qualification.id
	 */
	public List<QualificationSkill> findByQualificationId(Long qualificationId) {
		return (List<QualificationSkill>) this
				.getEntityManager()
				.createQuery(
						"select e from QualificationSkill e where e.clientId = :pClientId and e.qualification.id = :pQualificationId",
						QualificationSkill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pQualificationId", qualificationId)
				.getResultList();
	}

	/**
	 * Find by reference: skill
	 */
	public List<QualificationSkill> findBySkill(Skill skill) {
		return this.findBySkillId(skill.getId());
	}

	/**
	 * Find by ID of reference: skill.id
	 */
	public List<QualificationSkill> findBySkillId(Long skillId) {
		return (List<QualificationSkill>) this
				.getEntityManager()
				.createQuery(
						"select e from QualificationSkill e where e.clientId = :pClientId and e.skill.id = :pSkillId",
						QualificationSkill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSkillId", skillId).getResultList();
	}

	/**
	 * Find by reference: requiredLevel
	 */
	public List<QualificationSkill> findByRequiredLevel(
			RatingLevel requiredLevel) {
		return this.findByRequiredLevelId(requiredLevel.getId());
	}

	/**
	 * Find by ID of reference: requiredLevel.id
	 */
	public List<QualificationSkill> findByRequiredLevelId(Long requiredLevelId) {
		return (List<QualificationSkill>) this
				.getEntityManager()
				.createQuery(
						"select e from QualificationSkill e where e.clientId = :pClientId and e.requiredLevel.id = :pRequiredLevelId",
						QualificationSkill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRequiredLevelId", requiredLevelId)
				.getResultList();
	}
}
