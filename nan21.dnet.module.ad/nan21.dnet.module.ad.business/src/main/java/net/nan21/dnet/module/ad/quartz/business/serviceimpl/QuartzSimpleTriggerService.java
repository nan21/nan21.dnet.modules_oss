/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzSimpleTriggerService;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzSimpleTrigger;


public class QuartzSimpleTriggerService extends AbstractEntityService<QuartzSimpleTrigger>
		implements IQuartzSimpleTriggerService {
 
	public QuartzSimpleTriggerService() {
		super();
	}

	public QuartzSimpleTriggerService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<QuartzSimpleTrigger> getEntityClass() {
		return QuartzSimpleTrigger.class;
	}
}
