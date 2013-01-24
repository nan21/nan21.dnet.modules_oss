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
import net.nan21.dnet.module.hr.job.business.service.IJobRequirementService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.JobRequirement;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

/**
 * Repository functionality for {@link JobRequirement} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class JobRequirementService
		extends
			AbstractEntityService<JobRequirement>
		implements
			IJobRequirementService {

	public JobRequirementService() {
		super();
	}

	public JobRequirementService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<JobRequirement> getEntityClass() {
		return JobRequirement.class;
	}

	/**
	 * Find by reference: job
	 */
	public List<JobRequirement> findByJob(Job job) {
		return this.findByJobId(job.getId());
	}

	/**
	 * Find by ID of reference: job.id
	 */
	public List<JobRequirement> findByJobId(Long jobId) {
		return (List<JobRequirement>) this
				.getEntityManager()
				.createQuery(
						"select e from JobRequirement e where e.clientId = :pClientId and e.job.id = :pJobId",
						JobRequirement.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pJobId", jobId).getResultList();
	}

	/**
	 * Find by reference: requirement
	 */
	public List<JobRequirement> findByRequirement(WorkRequirement requirement) {
		return this.findByRequirementId(requirement.getId());
	}

	/**
	 * Find by ID of reference: requirement.id
	 */
	public List<JobRequirement> findByRequirementId(Long requirementId) {
		return (List<JobRequirement>) this
				.getEntityManager()
				.createQuery(
						"select e from JobRequirement e where e.clientId = :pClientId and e.requirement.id = :pRequirementId",
						JobRequirement.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRequirementId", requirementId).getResultList();
	}
}
