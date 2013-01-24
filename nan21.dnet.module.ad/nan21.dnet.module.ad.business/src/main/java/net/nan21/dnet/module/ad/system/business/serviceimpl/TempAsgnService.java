/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ITempAsgnService;
import net.nan21.dnet.module.ad.system.domain.entity.TempAsgn;

/**
 * Repository functionality for {@link TempAsgn} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class TempAsgnService extends AbstractEntityService<TempAsgn>
		implements
			ITempAsgnService {

	public TempAsgnService() {
		super();
	}

	public TempAsgnService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<TempAsgn> getEntityClass() {
		return TempAsgn.class;
	}
}
