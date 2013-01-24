/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.job.business.service.IJobService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.JobType;

/**
 * Repository functionality for {@link Job} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobService extends AbstractEntityService<Job>
		implements
			IJobService {

	public JobService() {
		super();
	}

	public JobService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Job> getEntityClass() {
		return Job.class;
	}

	/**
	 * Find by unique key
	 */
	public Job findByCode(String code) {
		return (Job) this.getEntityManager()
				.createNamedQuery(Job.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Job findByName(String name) {
		return (Job) this.getEntityManager()
				.createNamedQuery(Job.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: jobType
	 */
	public List<Job> findByJobType(JobType jobType) {
		return this.findByJobTypeId(jobType.getId());
	}

	/**
	 * Find by ID of reference: jobType.id
	 */
	public List<Job> findByJobTypeId(Long jobTypeId) {
		return (List<Job>) this
				.getEntityManager()
				.createQuery(
						"select e from Job e where e.clientId = :pClientId and e.jobType.id = :pJobTypeId",
						Job.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobTypeId", jobTypeId).getResultList();
	}
}
