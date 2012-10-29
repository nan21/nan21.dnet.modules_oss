/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEducationTypeService;
import net.nan21.dnet.module.hr.employee.domain.entity.EducationType;


public class EducationTypeService extends AbstractEntityService<EducationType>
		implements IEducationTypeService {
 
	public EducationTypeService() {
		super();
	}

	public EducationTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<EducationType> getEntityClass() {
		return EducationType.class;
	}
	
	public EducationType findByName(String name) {		 
		return (EducationType) this.em
			.createNamedQuery(EducationType.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
