/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.benefit.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.benefit.business.service.IBenefitTypeService;
import net.nan21.dnet.module.hr.benefit.domain.entity.BenefitType;

/**
 * Repository functionality for {@link BenefitType} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class BenefitTypeService extends AbstractEntityService<BenefitType>
		implements
			IBenefitTypeService {

	public BenefitTypeService() {
		super();
	}

	public BenefitTypeService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<BenefitType> getEntityClass() {
		return BenefitType.class;
	}

	/**
	 * Find by unique key
	 */
	public BenefitType findByName(String name) {
		return (BenefitType) this.getEntityManager()
				.createNamedQuery(BenefitType.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
