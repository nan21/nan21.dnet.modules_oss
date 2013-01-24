/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ITempAsgnLineService;
import net.nan21.dnet.module.ad.system.domain.entity.TempAsgnLine;

/**
 * Repository functionality for {@link TempAsgnLine} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class TempAsgnLineService extends AbstractEntityService<TempAsgnLine>
		implements
			ITempAsgnLineService {

	public TempAsgnLineService() {
		super();
	}

	public TempAsgnLineService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<TempAsgnLine> getEntityClass() {
		return TempAsgnLine.class;
	}
}
