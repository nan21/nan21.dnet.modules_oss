/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.standards.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.standards.business.service.IClassificationSystemService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

/**
 * Repository functionality for {@link ClassificationSystem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ClassificationSystemService
		extends
			AbstractEntityService<ClassificationSystem>
		implements
			IClassificationSystemService {

	public ClassificationSystemService() {
		super();
	}

	public ClassificationSystemService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<ClassificationSystem> getEntityClass() {
		return ClassificationSystem.class;
	}

	/**
	 * Find by unique key
	 */
	public ClassificationSystem findByCode(String code) {
		return (ClassificationSystem) this.em
				.createNamedQuery(ClassificationSystem.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by unique key
	 */
	public ClassificationSystem findByName(String name) {
		return (ClassificationSystem) this.em
				.createNamedQuery(ClassificationSystem.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
