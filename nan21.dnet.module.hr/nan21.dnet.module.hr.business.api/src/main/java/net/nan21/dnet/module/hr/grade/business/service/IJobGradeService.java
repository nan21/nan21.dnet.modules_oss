/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.JobGrade;
import net.nan21.dnet.module.hr.job.domain.entity.Job;

/**
 * Interface to expose business functions specific for {@link JobGrade} domain
 * entity.
 */
public interface IJobGradeService extends IEntityService<JobGrade> {

	/**
	 * Find by reference: job
	 */
	public List<JobGrade> findByJob(Job job);

	/**
	 * Find by ID of reference: job.id
	 */
	public List<JobGrade> findByJobId(Long jobId);

	/**
	 * Find by reference: grade
	 */
	public List<JobGrade> findByGrade(Grade grade);

	/**
	 * Find by ID of reference: grade.id
	 */
	public List<JobGrade> findByGradeId(Long gradeId);
}
