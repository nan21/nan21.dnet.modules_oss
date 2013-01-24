/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.skill.domain.entity.JobSkill;
import net.nan21.dnet.module.hr.skill.domain.entity.RatingLevel;
import net.nan21.dnet.module.hr.skill.domain.entity.Skill;

/**
 * Interface to expose business functions specific for {@link JobSkill} domain
 * entity.
 */
public interface IJobSkillService extends IEntityService<JobSkill> {

	/**
	 * Find by reference: job
	 */
	public List<JobSkill> findByJob(Job job);

	/**
	 * Find by ID of reference: job.id
	 */
	public List<JobSkill> findByJobId(Long jobId);

	/**
	 * Find by reference: skill
	 */
	public List<JobSkill> findBySkill(Skill skill);

	/**
	 * Find by ID of reference: skill.id
	 */
	public List<JobSkill> findBySkillId(Long skillId);

	/**
	 * Find by reference: requiredLevel
	 */
	public List<JobSkill> findByRequiredLevel(RatingLevel requiredLevel);

	/**
	 * Find by ID of reference: requiredLevel.id
	 */
	public List<JobSkill> findByRequiredLevelId(Long requiredLevelId);
}
