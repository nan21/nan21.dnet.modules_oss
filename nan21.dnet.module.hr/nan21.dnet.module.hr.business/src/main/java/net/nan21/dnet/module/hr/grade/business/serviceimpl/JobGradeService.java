/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IJobGradeService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;
import net.nan21.dnet.module.hr.grade.domain.entity.JobGrade;
import net.nan21.dnet.module.hr.job.domain.entity.Job;

/**
 * Repository functionality for {@link JobGrade} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobGradeService extends AbstractEntityService<JobGrade>
		implements
			IJobGradeService {

	public JobGradeService() {
		super();
	}

	public JobGradeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<JobGrade> getEntityClass() {
		return JobGrade.class;
	}

	/**
	 * Find by reference: job
	 */
	public List<JobGrade> findByJob(Job job) {
		return this.findByJobId(job.getId());
	}

	/**
	 * Find by ID of reference: job.id
	 */
	public List<JobGrade> findByJobId(Long jobId) {
		return (List<JobGrade>) this.em
				.createQuery(
						"select e from JobGrade e where e.clientId = :pClientId and e.job.id = :pJobId",
						JobGrade.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobId", jobId).getResultList();
	}

	/**
	 * Find by reference: grade
	 */
	public List<JobGrade> findByGrade(Grade grade) {
		return this.findByGradeId(grade.getId());
	}

	/**
	 * Find by ID of reference: grade.id
	 */
	public List<JobGrade> findByGradeId(Long gradeId) {
		return (List<JobGrade>) this.em
				.createQuery(
						"select e from JobGrade e where e.clientId = :pClientId and e.grade.id = :pGradeId",
						JobGrade.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pGradeId", gradeId).getResultList();
	}
}
