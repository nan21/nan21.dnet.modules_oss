/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActDeploymentService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActDeployment;

/**
 * Repository functionality for {@link ActDeployment} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActDeploymentService extends AbstractEntityService<ActDeployment>
		implements
			IActDeploymentService {

	public ActDeploymentService() {
		super();
	}

	public ActDeploymentService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ActDeployment> getEntityClass() {
		return ActDeployment.class;
	}
}
