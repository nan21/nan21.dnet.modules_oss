/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJob;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;

/**
 * Interface to expose business functions specific for {@link SysJobParam} domain
 * entity.
 */
public interface ISysJobParamService extends IEntityService<SysJobParam> {

	/**
	 * Find by unique key
	 */
	public SysJobParam findByName(SysJob job, String name);

	/**
	 * Find by unique key
	 */
	public SysJobParam findByName(Long jobId, String name);

	/**
	 * Find by reference: job
	 */
	public List<SysJobParam> findByJob(SysJob job);

	/**
	 * Find by ID of reference: job.id
	 */
	public List<SysJobParam> findByJobId(Long jobId);
}
