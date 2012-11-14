/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.training.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.training.domain.entity.Course;
import net.nan21.dnet.module.hr.training.domain.entity.JobCourse;

/**
 * Interface to expose business functions specific for {@link JobCourse} domain
 * entity.
 */
public interface IJobCourseService extends IEntityService<JobCourse> {

	/**
	 * Find by reference: job
	 */
	public List<JobCourse> findByJob(Job job);

	/**
	 * Find by ID of reference: job.id
	 */
	public List<JobCourse> findByJobId(Long jobId);

	/**
	 * Find by reference: course
	 */
	public List<JobCourse> findByCourse(Course course);

	/**
	 * Find by ID of reference: course.id
	 */
	public List<JobCourse> findByCourseId(Long courseId);
}
