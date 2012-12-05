/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmploymentTypeService;
import net.nan21.dnet.module.hr.employee.domain.entity.EmploymentType;

/**
 * Repository functionality for {@link EmploymentType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class EmploymentTypeService
		extends
			AbstractEntityService<EmploymentType>
		implements
			IEmploymentTypeService {

	public EmploymentTypeService() {
		super();
	}

	public EmploymentTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<EmploymentType> getEntityClass() {
		return EmploymentType.class;
	}

	/**
	 * Find by unique key
	 */
	public EmploymentType findByName(String name) {
		return (EmploymentType) this.getEntityManager()
				.createNamedQuery(EmploymentType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
