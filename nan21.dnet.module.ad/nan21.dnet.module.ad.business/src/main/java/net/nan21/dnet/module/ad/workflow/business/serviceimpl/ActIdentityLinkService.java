/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActIdentityLinkService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityLink;

/**
 * Repository functionality for {@link ActIdentityLink} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ActIdentityLinkService
		extends
			AbstractEntityService<ActIdentityLink>
		implements
			IActIdentityLinkService {

	public ActIdentityLinkService() {
		super();
	}

	public ActIdentityLinkService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ActIdentityLink> getEntityClass() {
		return ActIdentityLink.class;
	}
}
