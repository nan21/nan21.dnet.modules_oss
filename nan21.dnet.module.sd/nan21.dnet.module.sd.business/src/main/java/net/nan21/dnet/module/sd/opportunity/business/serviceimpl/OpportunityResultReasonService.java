/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunityResultReasonService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;

/**
 * Repository functionality for {@link OpportunityResultReason} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OpportunityResultReasonService
		extends
			AbstractEntityService<OpportunityResultReason>
		implements
			IOpportunityResultReasonService {

	public OpportunityResultReasonService() {
		super();
	}

	public OpportunityResultReasonService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<OpportunityResultReason> getEntityClass() {
		return OpportunityResultReason.class;
	}

	/**
	 * Find by unique key
	 */
	public OpportunityResultReason findByName(String name) {
		return (OpportunityResultReason) this.getEntityManager()
				.createNamedQuery(OpportunityResultReason.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
