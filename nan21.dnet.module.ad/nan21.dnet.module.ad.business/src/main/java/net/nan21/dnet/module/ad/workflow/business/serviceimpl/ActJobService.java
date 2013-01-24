/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActJobService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActJob;

/**
 * Repository functionality for {@link ActJob} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActJobService extends AbstractEntityService<ActJob>
		implements
			IActJobService {

	public ActJobService() {
		super();
	}

	public ActJobService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ActJob> getEntityClass() {
		return ActJob.class;
	}
}
