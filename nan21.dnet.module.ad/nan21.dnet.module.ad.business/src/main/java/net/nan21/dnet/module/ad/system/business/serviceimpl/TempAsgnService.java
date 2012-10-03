/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ITempAsgnService;
import net.nan21.dnet.module.ad.system.domain.entity.TempAsgn;


public class TempAsgnService extends AbstractEntityService<TempAsgn>
		implements ITempAsgnService {
 
	public TempAsgnService() {
		super();
	}

	public TempAsgnService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	protected Class<TempAsgn> getEntityClass() {
		return TempAsgn.class;
	}
}
