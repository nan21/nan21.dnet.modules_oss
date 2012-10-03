/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.workflow.business.service.IActIdentityInfoService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityInfo;


public class ActIdentityInfoService extends AbstractEntityService<ActIdentityInfo>
		implements IActIdentityInfoService {
 
	public ActIdentityInfoService() {
		super();
	}

	public ActIdentityInfoService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	protected Class<ActIdentityInfo> getEntityClass() {
		return ActIdentityInfo.class;
	}
}
