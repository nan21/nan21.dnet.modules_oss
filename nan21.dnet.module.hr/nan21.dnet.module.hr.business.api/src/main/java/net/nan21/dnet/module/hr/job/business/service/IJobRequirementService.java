/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.JobRequirement;
import net.nan21.dnet.module.hr.job.domain.entity.WorkRequirement;

/**
 * Interface to expose business functions specific for {@link JobRequirement} domain
 * entity.
 */
public interface IJobRequirementService extends IEntityService<JobRequirement> {

	/**
	 * Find by reference: job
	 */
	public List<JobRequirement> findByJob(Job job);

	/**
	 * Find by ID of reference: job.id
	 */
	public List<JobRequirement> findByJobId(Long jobId);

	/**
	 * Find by reference: requirement
	 */
	public List<JobRequirement> findByRequirement(WorkRequirement requirement);

	/**
	 * Find by ID of reference: requirement.id
	 */
	public List<JobRequirement> findByRequirementId(Long requirementId);
}
