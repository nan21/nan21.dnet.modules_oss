/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.time.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.time.business.service.IAbsenceCategoryService;
import net.nan21.dnet.module.hr.time.domain.entity.AbsenceCategory;

/**
 * Repository functionality for {@link AbsenceCategory} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AbsenceCategoryService
		extends
			AbstractEntityService<AbsenceCategory>
		implements
			IAbsenceCategoryService {

	public AbsenceCategoryService() {
		super();
	}

	public AbsenceCategoryService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<AbsenceCategory> getEntityClass() {
		return AbsenceCategory.class;
	}

	/**
	 * Find by unique key
	 */
	public AbsenceCategory findByName(String name) {
		return (AbsenceCategory) this.em
				.createNamedQuery(AbsenceCategory.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
