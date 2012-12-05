/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.benefit.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.benefit.business.service.IBenefitService;
import net.nan21.dnet.module.hr.benefit.domain.entity.Benefit;

/**
 * Repository functionality for {@link Benefit} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BenefitService extends AbstractEntityService<Benefit>
		implements
			IBenefitService {

	public BenefitService() {
		super();
	}

	public BenefitService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Benefit> getEntityClass() {
		return Benefit.class;
	}

	/**
	 * Find by unique key
	 */
	public Benefit findByName(String name) {
		return (Benefit) this.getEntityManager()
				.createNamedQuery(Benefit.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
