/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzCronTriggerService;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzCronTrigger;


public class QuartzCronTriggerService extends AbstractEntityService<QuartzCronTrigger>
		implements IQuartzCronTriggerService {
 
	public QuartzCronTriggerService() {
		super();
	}

	public QuartzCronTriggerService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<QuartzCronTrigger> getEntityClass() {
		return QuartzCronTrigger.class;
	}
}
