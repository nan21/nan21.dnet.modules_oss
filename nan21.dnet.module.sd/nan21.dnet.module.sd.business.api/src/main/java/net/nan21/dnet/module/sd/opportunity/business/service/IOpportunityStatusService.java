/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStatus;

/**
 * Interface to expose business functions specific for {@link OpportunityStatus} domain
 * entity.
 */
public interface IOpportunityStatusService
		extends
			IEntityService<OpportunityStatus> {

	/**
	 * Find by unique key
	 */
	public OpportunityStatus findByName(String name);
}
