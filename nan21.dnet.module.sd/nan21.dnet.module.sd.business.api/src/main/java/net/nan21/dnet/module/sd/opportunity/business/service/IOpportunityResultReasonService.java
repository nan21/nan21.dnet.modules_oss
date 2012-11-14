/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityResultReason;

/**
 * Interface to expose business functions specific for {@link OpportunityResultReason} domain
 * entity.
 */
public interface IOpportunityResultReasonService
		extends
			IEntityService<OpportunityResultReason> {

	/**
	 * Find by unique key
	 */
	public OpportunityResultReason findByName(String name);
}
