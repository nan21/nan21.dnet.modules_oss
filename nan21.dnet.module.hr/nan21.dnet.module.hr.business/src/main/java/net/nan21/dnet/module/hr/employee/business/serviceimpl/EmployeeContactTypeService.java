/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeContactTypeService;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeContactType;

/**
 * Repository functionality for {@link EmployeeContactType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class EmployeeContactTypeService
		extends
			AbstractEntityService<EmployeeContactType>
		implements
			IEmployeeContactTypeService {

	public EmployeeContactTypeService() {
		super();
	}

	public EmployeeContactTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<EmployeeContactType> getEntityClass() {
		return EmployeeContactType.class;
	}

	/**
	 * Find by unique key
	 */
	public EmployeeContactType findByName(String name) {
		return (EmployeeContactType) this.getEntityManager()
				.createNamedQuery(EmployeeContactType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
