/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceext;

import org.quartz.JobDetail;
import org.quartz.Scheduler;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.job.IScheduler;
import net.nan21.dnet.core.scheduler.JobDetailBase;
import net.nan21.dnet.module.ad.system.business.service.ISysJobCtxService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;

import static org.quartz.JobBuilder.*;

public class SysJobCtxService extends
		net.nan21.dnet.module.ad.system.business.serviceimpl.SysJobCtxService
		implements ISysJobCtxService {

	private IScheduler scheduler;

	@Override
	protected void postUpdate(SysJobCtx e) throws BusinessException {
		JobDetail jobDetail = newJob(JobDetailBase.class)
				.withIdentity(e.getId().toString(), e.getClientId().toString())
				.storeDurably().build();
		jobDetail.getJobDataMap().put("__JOB_NAME__", e.getJobAlias());
		try {
			getQuartzScheduler().addJob(jobDetail, true);
		} catch (Exception exc) {
			throw new BusinessException("Cannot add job to quartz scheduler.",
					exc);
		}
	}

	@Override
	protected void postInsert(SysJobCtx e) throws BusinessException {
		JobDetail jobDetail = newJob(JobDetailBase.class)
				.withIdentity(e.getId().toString(), e.getClientId().toString())
				.storeDurably().build();
		jobDetail.getJobDataMap().put("__JOB_NAME__", e.getJobAlias());
		try {
			getQuartzScheduler().addJob(jobDetail, false);
		} catch (Exception exc) {
			throw new BusinessException("Cannot add job to quartz scheduler.",
					exc);
		}
	}

	protected Scheduler getQuartzScheduler() throws Exception {
		if (this.scheduler == null) {
			this.scheduler = (IScheduler) this.getApplicationContext().getBean(
					"osgiJobScheduler");
		}
		return (Scheduler) this.scheduler.getDelegate();
	}
}
