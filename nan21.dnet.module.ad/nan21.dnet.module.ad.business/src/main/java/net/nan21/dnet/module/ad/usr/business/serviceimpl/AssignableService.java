/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IAssignableService;
import net.nan21.dnet.module.ad.usr.domain.entity.Assignable;
import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;


public class AssignableService extends AbstractEntityService<Assignable>
		implements IAssignableService {
 
	public AssignableService() {
		super();
	}

	public AssignableService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<Assignable> getEntityClass() {
		return Assignable.class;
	}
	
	public Assignable findByName(String name) {		 
		return (Assignable) this.em
			.createNamedQuery(Assignable.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
	
	public List<Assignable> findByAssignableType(AssignableType assignableType) {
		return this.findByAssignableTypeId(assignableType.getId()); 
	}
	
	public List<Assignable> findByAssignableTypeId(Long assignableTypeId) {
		return (List<Assignable>) this.em
			.createQuery("select e from Assignable e where e.clientId = :pClientId and e.assignableType.id = :pAssignableTypeId", Assignable.class)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pAssignableTypeId", assignableTypeId)			 	
			.getResultList(); 
	}
}
