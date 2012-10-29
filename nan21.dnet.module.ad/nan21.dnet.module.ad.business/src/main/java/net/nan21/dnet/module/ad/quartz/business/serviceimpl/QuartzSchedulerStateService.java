/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzSchedulerStateService;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzSchedulerState;


public class QuartzSchedulerStateService extends AbstractEntityService<QuartzSchedulerState>
		implements IQuartzSchedulerStateService {
 
	public QuartzSchedulerStateService() {
		super();
	}

	public QuartzSchedulerStateService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<QuartzSchedulerState> getEntityClass() {
		return QuartzSchedulerState.class;
	}
}
