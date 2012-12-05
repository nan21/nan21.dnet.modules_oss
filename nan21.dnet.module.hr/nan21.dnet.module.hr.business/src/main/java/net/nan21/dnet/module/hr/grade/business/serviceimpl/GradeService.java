/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.grade.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.grade.business.service.IGradeService;
import net.nan21.dnet.module.hr.grade.domain.entity.Grade;

/**
 * Repository functionality for {@link Grade} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class GradeService extends AbstractEntityService<Grade>
		implements
			IGradeService {

	public GradeService() {
		super();
	}

	public GradeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Grade> getEntityClass() {
		return Grade.class;
	}

	/**
	 * Find by unique key
	 */
	public Grade findByCode(String code) {
		return (Grade) this.getEntityManager()
				.createNamedQuery(Grade.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public Grade findByName(String name) {
		return (Grade) this.getEntityManager()
				.createNamedQuery(Grade.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
