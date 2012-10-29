/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzTriggerService;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzTrigger;


public class QuartzTriggerService extends AbstractEntityService<QuartzTrigger>
		implements IQuartzTriggerService {
 
	public QuartzTriggerService() {
		super();
	}

	public QuartzTriggerService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<QuartzTrigger> getEntityClass() {
		return QuartzTrigger.class;
	}
}
