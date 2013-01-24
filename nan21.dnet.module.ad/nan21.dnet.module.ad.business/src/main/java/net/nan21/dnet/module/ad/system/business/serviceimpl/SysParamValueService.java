/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysParamValueService;
import net.nan21.dnet.module.ad.system.domain.entity.SysParamValue;

/**
 * Repository functionality for {@link SysParamValue} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SysParamValueService extends AbstractEntityService<SysParamValue>
		implements
			ISysParamValueService {

	public SysParamValueService() {
		super();
	}

	public SysParamValueService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<SysParamValue> getEntityClass() {
		return SysParamValue.class;
	}
}
