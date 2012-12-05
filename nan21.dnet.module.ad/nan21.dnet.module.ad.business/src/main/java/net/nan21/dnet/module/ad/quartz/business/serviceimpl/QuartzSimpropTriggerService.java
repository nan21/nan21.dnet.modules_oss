/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzSimpropTriggerService;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzSimpropTrigger;

/**
 * Repository functionality for {@link QuartzSimpropTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzSimpropTriggerService
		extends
			AbstractEntityService<QuartzSimpropTrigger>
		implements
			IQuartzSimpropTriggerService {

	public QuartzSimpropTriggerService() {
		super();
	}

	public QuartzSimpropTriggerService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzSimpropTrigger> getEntityClass() {
		return QuartzSimpropTrigger.class;
	}
}
