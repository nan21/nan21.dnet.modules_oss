/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeContactRelationshipService;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactRelationship;

/**
 * Repository functionality for {@link EmployeeContactRelationship} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class EmployeeContactRelationshipService
		extends
			AbstractEntityService<EmployeeContactRelationship>
		implements
			IEmployeeContactRelationshipService {

	public EmployeeContactRelationshipService() {
		super();
	}

	public EmployeeContactRelationshipService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<EmployeeContactRelationship> getEntityClass() {
		return EmployeeContactRelationship.class;
	}

	/**
	 * Find by unique key
	 */
	public EmployeeContactRelationship findByName(String name) {
		return (EmployeeContactRelationship) this.em
				.createNamedQuery(EmployeeContactRelationship.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
