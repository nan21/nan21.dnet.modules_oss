/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.business.serviceimpl;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.sd.opportunity.business.service.IOpportunitySourceService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;

/**
 * Repository functionality for {@link OpportunitySource} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class OpportunitySourceService
		extends
			AbstractEntityService<OpportunitySource>
		implements
			IOpportunitySourceService {

	public OpportunitySourceService() {
		super();
	}

	public OpportunitySourceService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<OpportunitySource> getEntityClass() {
		return OpportunitySource.class;
	}

	/**
	 * Find by unique key
	 */
	public OpportunitySource findByName(String name) {
		return (OpportunitySource) this.em
				.createNamedQuery(OpportunitySource.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}
}
