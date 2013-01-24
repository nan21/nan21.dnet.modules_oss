/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.ILicenseTypeService;
import net.nan21.dnet.module.hr.employee.domain.entity.LicenseType;

/**
 * Repository functionality for {@link LicenseType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class LicenseTypeService extends AbstractEntityService<LicenseType>
		implements
			ILicenseTypeService {

	public LicenseTypeService() {
		super();
	}

	public LicenseTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<LicenseType> getEntityClass() {
		return LicenseType.class;
	}

	/**
	 * Find by unique key
	 */
	public LicenseType findByName(String name) {
		return (LicenseType) this.getEntityManager()
				.createNamedQuery(LicenseType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
