/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzBlobTriggerService;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzBlobTrigger;

/**
 * Repository functionality for {@link QuartzBlobTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzBlobTriggerService
		extends
			AbstractEntityService<QuartzBlobTrigger>
		implements
			IQuartzBlobTriggerService {

	public QuartzBlobTriggerService() {
		super();
	}

	public QuartzBlobTriggerService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzBlobTrigger> getEntityClass() {
		return QuartzBlobTrigger.class;
	}
}
