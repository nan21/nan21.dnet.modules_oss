/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.benefit.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.hr.benefit.business.service.IBenefitTypeService;
import net.nan21.dnet.module.hr.benefit.domain.entity.BenefitType;


public class BenefitTypeService extends AbstractEntityService<BenefitType>
		implements IBenefitTypeService {
 
	public BenefitTypeService() {
		super();
	}

	public BenefitTypeService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<BenefitType> getEntityClass() {
		return BenefitType.class;
	}
	
	public BenefitType findByName(String name) {		 
		return (BenefitType) this.em
			.createNamedQuery(BenefitType.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
