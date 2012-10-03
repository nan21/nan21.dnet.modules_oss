/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityStageService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;


public class OpportunityStageService extends AbstractEntityService<OpportunityStage>
		implements IOpportunityStageService {
 
	public OpportunityStageService() {
		super();
	}

	public OpportunityStageService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	protected Class<OpportunityStage> getEntityClass() {
		return OpportunityStage.class;
	}
	
	public OpportunityStage findByName(String name) {		 
		return (OpportunityStage) this.em
			.createNamedQuery(OpportunityStage.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
