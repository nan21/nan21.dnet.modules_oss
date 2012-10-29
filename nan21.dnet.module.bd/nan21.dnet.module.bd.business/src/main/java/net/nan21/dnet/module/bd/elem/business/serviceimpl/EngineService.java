/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.elem.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.elem.business.service.IEngineService;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;


public class EngineService extends AbstractEntityService<Engine>
		implements IEngineService {
 
	public EngineService() {
		super();
	}

	public EngineService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<Engine> getEntityClass() {
		return Engine.class;
	}
	
	public Engine findByName(String name) {		 
		return (Engine) this.em
			.createNamedQuery(Engine.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
