/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IAssignableTypeService;
import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;


public class AssignableTypeService extends AbstractEntityService<AssignableType>
		implements IAssignableTypeService {
 
	public AssignableTypeService() {
		super();
	}

	public AssignableTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<AssignableType> getEntityClass() {
		return AssignableType.class;
	}
	
	public AssignableType findByName(String name) {		 
		return (AssignableType) this.em
			.createNamedQuery(AssignableType.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
