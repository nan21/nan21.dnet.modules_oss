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

/**
 * Repository functionality for {@link OpportunityStatus} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OpportunityStatusService
		extends
			AbstractEntityService<OpportunityStatus>
		implements
			IOpportunityStatusService {

	public OpportunityStatusService() {
		super();
	}

	public OpportunityStatusService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<OpportunityStatus> getEntityClass() {
		return OpportunityStatus.class;
	}

	/**
	 * Find by unique key
	 */
	public OpportunityStatus findByName(String name) {
		return (OpportunityStatus) this.getEntityManager()
				.createNamedQuery(OpportunityStatus.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
