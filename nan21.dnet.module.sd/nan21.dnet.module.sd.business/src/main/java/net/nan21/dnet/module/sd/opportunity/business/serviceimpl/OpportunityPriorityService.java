/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityPriorityService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityPriority;

/**
 * Repository functionality for {@link OpportunityPriority} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OpportunityPriorityService
		extends
			AbstractEntityService<OpportunityPriority>
		implements
			IOpportunityPriorityService {

	public OpportunityPriorityService() {
		super();
	}

	public OpportunityPriorityService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<OpportunityPriority> getEntityClass() {
		return OpportunityPriority.class;
	}

	/**
	 * Find by unique key
	 */
	public OpportunityPriority findByName(String name) {
		return (OpportunityPriority) this.getEntityManager()
				.createNamedQuery(OpportunityPriority.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
