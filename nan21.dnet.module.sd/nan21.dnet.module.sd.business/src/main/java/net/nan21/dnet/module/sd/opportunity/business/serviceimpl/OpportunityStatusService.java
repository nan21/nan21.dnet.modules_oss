/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityStatusService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;


public class OpportunityStatusService extends AbstractEntityService<OpportunityStatus>
		implements IOpportunityStatusService {
 
	public OpportunityStatusService() {
		super();
	}

	public OpportunityStatusService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<OpportunityStatus> getEntityClass() {
		return OpportunityStatus.class;
	}
	
	public OpportunityStatus findByName(String name) {		 
		return (OpportunityStatus) this.em
			.createNamedQuery(OpportunityStatus.NQ_FIND_BY_NAME)
			.setParameter("pClientId", Session.user.get().getClientId())
			.setParameter("pName", name)
			.getSingleResult(); 
	}
}
