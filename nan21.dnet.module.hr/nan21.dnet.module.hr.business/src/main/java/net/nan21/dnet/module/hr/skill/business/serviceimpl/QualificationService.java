/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.skill.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.skill.business.service.IQualificationService;
import net.nan21.dnet.module.hr.skill.domain.entity.Qualification;

/**
 * Repository functionality for {@link Qualification} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QualificationService extends AbstractEntityService<Qualification>
		implements
			IQualificationService {

	public QualificationService() {
		super();
	}

	public QualificationService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Qualification> getEntityClass() {
		return Qualification.class;
	}

	/**
	 * Find by unique key
	 */
	public Qualification findByName(String name) {
		return (Qualification) this.getEntityManager()
				.createNamedQuery(Qualification.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
