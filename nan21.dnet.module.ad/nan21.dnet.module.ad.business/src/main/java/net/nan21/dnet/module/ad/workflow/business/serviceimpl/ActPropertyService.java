/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActPropertyService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActProperty;

/**
 * Repository functionality for {@link ActProperty} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActPropertyService extends AbstractEntityService<ActProperty>
		implements
			IActPropertyService {

	public ActPropertyService() {
		super();
	}

	public ActPropertyService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ActProperty> getEntityClass() {
		return ActProperty.class;
	}
}
