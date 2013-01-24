/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.training.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.training.business.service.IJobCourseService;
import net.nan21.dnet.module.hr.training.domain.entity.Course;
import net.nan21.dnet.module.hr.training.domain.entity.JobCourse;

/**
 * Repository functionality for {@link JobCourse} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobCourseService extends AbstractEntityService<JobCourse>
		implements
			IJobCourseService {

	public JobCourseService() {
		super();
	}

	public JobCourseService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<JobCourse> getEntityClass() {
		return JobCourse.class;
	}

	/**
	 * Find by reference: job
	 */
	public List<JobCourse> findByJob(Job job) {
		return this.findByJobId(job.getId());
	}

	/**
	 * Find by ID of reference: job.id
	 */
	public List<JobCourse> findByJobId(Long jobId) {
		return (List<JobCourse>) this
				.getEntityManager()
				.createQuery(
						"select e from JobCourse e where e.clientId = :pClientId and e.job.id = :pJobId",
						JobCourse.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobId", jobId).getResultList();
	}

	/**
	 * Find by reference: course
	 */
	public List<JobCourse> findByCourse(Course course) {
		return this.findByCourseId(course.getId());
	}

	/**
	 * Find by ID of reference: course.id
	 */
	public List<JobCourse> findByCourseId(Long courseId) {
		return (List<JobCourse>) this
				.getEntityManager()
				.createQuery(
						"select e from JobCourse e where e.clientId = :pClientId and e.course.id = :pCourseId",
						JobCourse.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCourseId", courseId).getResultList();
	}
}
