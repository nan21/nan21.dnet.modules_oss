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
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.skill.business.service.IJobSkillService;
import net.nan21.dnet.module.hr.skill.domain.entity.JobSkill;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

/**
 * Repository functionality for {@link JobSkill} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobSkillService extends AbstractEntityService<JobSkill>
		implements
			IJobSkillService {

	public JobSkillService() {
		super();
	}

	public JobSkillService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<JobSkill> getEntityClass() {
		return JobSkill.class;
	}

	/**
	 * Find by reference: job
	 */
	public List<JobSkill> findByJob(Job job) {
		return this.findByJobId(job.getId());
	}

	/**
	 * Find by ID of reference: job.id
	 */
	public List<JobSkill> findByJobId(Long jobId) {
		return (List<JobSkill>) this.em
				.createQuery(
						"select e from JobSkill e where e.clientId = :pClientId and e.job.id = :pJobId",
						JobSkill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobId", jobId).getResultList();
	}

	/**
	 * Find by reference: skill
	 */
	public List<JobSkill> findBySkill(Skill skill) {
		return this.findBySkillId(skill.getId());
	}

	/**
	 * Find by ID of reference: skill.id
	 */
	public List<JobSkill> findBySkillId(Long skillId) {
		return (List<JobSkill>) this.em
				.createQuery(
						"select e from JobSkill e where e.clientId = :pClientId and e.skill.id = :pSkillId",
						JobSkill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSkillId", skillId).getResultList();
	}

	/**
	 * Find by reference: requiredLevel
	 */
	public List<JobSkill> findByRequiredLevel(RatingLevel requiredLevel) {
		return this.findByRequiredLevelId(requiredLevel.getId());
	}

	/**
	 * Find by ID of reference: requiredLevel.id
	 */
	public List<JobSkill> findByRequiredLevelId(Long requiredLevelId) {
		return (List<JobSkill>) this.em
				.createQuery(
						"select e from JobSkill e where e.clientId = :pClientId and e.requiredLevel.id = :pRequiredLevelId",
						JobSkill.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRequiredLevelId", requiredLevelId)
				.getResultList();
	}
}
