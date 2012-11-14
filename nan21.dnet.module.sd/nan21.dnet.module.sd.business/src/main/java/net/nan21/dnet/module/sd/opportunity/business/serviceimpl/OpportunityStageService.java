/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityStageService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;

/**
 * Repository functionality for {@link OpportunityStage} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OpportunityStageService
		extends
			AbstractEntityService<OpportunityStage>
		implements
			IOpportunityStageService {

	public OpportunityStageService() {
		super();
	}

	public OpportunityStageService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<OpportunityStage> getEntityClass() {
		return OpportunityStage.class;
	}

	/**
	 * Find by unique key
	 */
	public OpportunityStage findByName(String name) {
		return (OpportunityStage) this.em
				.createNamedQuery(OpportunityStage.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
