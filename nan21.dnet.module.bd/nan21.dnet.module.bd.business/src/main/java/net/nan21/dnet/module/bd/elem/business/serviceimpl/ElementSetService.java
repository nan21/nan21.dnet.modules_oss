/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.elem.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.elem.business.service.IElementSetService;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementSet;
import net.nan21.dnet.module.bd.elem.domain.entity.Engine;


public class ElementSetService extends AbstractEntityService<ElementSet>
		implements IElementSetService {
 
	public ElementSetService() {
		super();
	}

	public ElementSetService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ElementSet> getEntityClass() {
		return ElementSet.class;
	}
	
	public ElementSet findByEngine_name(Engine engine,String name) {		 
		return (ElementSet) this.em
			.createNamedQuery(ElementSet.NQ_FIND_BY_ENGINE_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pEngine", engine)
			.setParameter("pName", name)
			.getSingleResult(); 
	}
	
	public ElementSet findByEngine_name( Long engineId,String name) {
		return (ElementSet) this.em
			.createNamedQuery(ElementSet.NQ_FIND_BY_ENGINE_NAME_PRIMITIVE)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pEngineId", engineId)
			.setParameter("pName", name)
			.getSingleResult(); 
	}
	
	public List<ElementSet> findByEngine(Engine engine) {
		return this.findByEngineId(engine.getId()); 
	}
	
	public List<ElementSet> findByEngineId(Long engineId) {
		return (List<ElementSet>) this.em
			.createQuery("select e from ElementSet e where e.clientId = :pClientId and e.engine.id = :pEngineId", ElementSet.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pEngineId", engineId)			 	
			.getResultList(); 
	}
}
