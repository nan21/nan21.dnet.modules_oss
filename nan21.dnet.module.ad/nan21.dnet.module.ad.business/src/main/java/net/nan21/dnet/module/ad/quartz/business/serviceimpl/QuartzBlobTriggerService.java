/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzBlobTriggerService;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzBlobTrigger;


public class QuartzBlobTriggerService extends AbstractEntityService<QuartzBlobTrigger>
		implements IQuartzBlobTriggerService {
 
	public QuartzBlobTriggerService() {
		super();
	}

	public QuartzBlobTriggerService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<QuartzBlobTrigger> getEntityClass() {
		return QuartzBlobTrigger.class;
	}
}
