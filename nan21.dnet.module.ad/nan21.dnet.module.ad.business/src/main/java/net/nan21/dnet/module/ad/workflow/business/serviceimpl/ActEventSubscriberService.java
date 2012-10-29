/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActEventSubscriberService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActEventSubscriber;


public class ActEventSubscriberService extends AbstractEntityService<ActEventSubscriber>
		implements IActEventSubscriberService {
 
	public ActEventSubscriberService() {
		super();
	}

	public ActEventSubscriberService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ActEventSubscriber> getEntityClass() {
		return ActEventSubscriber.class;
	}
}
