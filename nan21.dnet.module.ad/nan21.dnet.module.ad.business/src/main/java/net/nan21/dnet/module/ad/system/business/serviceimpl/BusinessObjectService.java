/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.IBusinessObjectService;
import net.nan21.dnet.module.ad.system.domain.entity.BusinessObject;


public class BusinessObjectService extends AbstractEntityService<BusinessObject>
		implements IBusinessObjectService {
 
	public BusinessObjectService() {
		super();
	}

	public BusinessObjectService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<BusinessObject> getEntityClass() {
		return BusinessObject.class;
	}
	
	public BusinessObject findByName(String name) {		 
		return (BusinessObject) this.em
			.createNamedQuery(BusinessObject.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
