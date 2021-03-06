/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActIdentityInfoService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityInfo;

/**
 * Repository functionality for {@link ActIdentityInfo} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActIdentityInfoService
		extends
			AbstractEntityService<ActIdentityInfo>
		implements
			IActIdentityInfoService {

	public ActIdentityInfoService() {
		super();
	}

	public ActIdentityInfoService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ActIdentityInfo> getEntityClass() {
		return ActIdentityInfo.class;
	}
}
