/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.JobType;

/**
 * Interface to expose business functions specific for {@link JobType} domain
 * entity.
 */
public interface IJobTypeService extends IEntityService<JobType> {

	/**
	 * Find by unique key
	 */
	public JobType findByName(String name);
}
