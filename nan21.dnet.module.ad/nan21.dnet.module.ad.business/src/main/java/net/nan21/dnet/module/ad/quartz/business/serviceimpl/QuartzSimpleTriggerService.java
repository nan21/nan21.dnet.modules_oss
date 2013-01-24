/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzSimpleTriggerService;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzSimpleTrigger;

/**
 * Repository functionality for {@link QuartzSimpleTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzSimpleTriggerService
		extends
			AbstractEntityService<QuartzSimpleTrigger>
		implements
			IQuartzSimpleTriggerService {

	public QuartzSimpleTriggerService() {
		super();
	}

	public QuartzSimpleTriggerService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzSimpleTrigger> getEntityClass() {
		return QuartzSimpleTrigger.class;
	}
}
