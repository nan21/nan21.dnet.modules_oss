/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActEventSubscriberService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActEventSubscriber;

/**
 * Repository functionality for {@link ActEventSubscriber} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActEventSubscriberService
		extends
			AbstractEntityService<ActEventSubscriber>
		implements
			IActEventSubscriberService {

	public ActEventSubscriberService() {
		super();
	}

	public ActEventSubscriberService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ActEventSubscriber> getEntityClass() {
		return ActEventSubscriber.class;
	}
}
