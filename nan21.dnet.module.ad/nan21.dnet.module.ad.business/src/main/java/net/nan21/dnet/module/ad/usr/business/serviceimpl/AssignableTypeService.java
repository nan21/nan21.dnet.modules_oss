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

/**
 * Repository functionality for {@link AssignableType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AssignableTypeService
		extends
			AbstractEntityService<AssignableType>
		implements
			IAssignableTypeService {

	public AssignableTypeService() {
		super();
	}

	public AssignableTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AssignableType> getEntityClass() {
		return AssignableType.class;
	}

	/**
	 * Find by unique key
	 */
	public AssignableType findByName(String name) {
		return (AssignableType) this.getEntityManager()
				.createNamedQuery(AssignableType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
