/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.Job;
import net.nan21.dnet.module.hr.job.domain.entity.JobType;

/**
 * Interface to expose business functions specific for {@link Job} domain
 * entity.
 */
public interface IJobService extends IEntityService<Job> {

	/**
	 * Find by unique key
	 */
	public Job findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Job findByName(String name);

	/**
	 * Find by reference: jobType
	 */
	public List<Job> findByJobType(JobType jobType);

	/**
	 * Find by ID of reference: jobType.id
	 */
	public List<Job> findByJobTypeId(Long jobTypeId);
}
