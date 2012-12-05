/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.quartz.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.quartz.business.service.IQuartzLockService;
import net.nan21.dnet.module.ad.quartz.domain.entity.QuartzLock;

/**
 * Repository functionality for {@link QuartzLock} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzLockService extends AbstractEntityService<QuartzLock>
		implements
			IQuartzLockService {

	public QuartzLockService() {
		super();
	}

	public QuartzLockService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzLock> getEntityClass() {
		return QuartzLock.class;
	}
}
