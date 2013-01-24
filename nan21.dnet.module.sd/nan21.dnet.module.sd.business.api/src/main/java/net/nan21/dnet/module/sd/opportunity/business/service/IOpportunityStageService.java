/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunityStage;

/**
 * Interface to expose business functions specific for {@link OpportunityStage} domain
 * entity.
 */
public interface IOpportunityStageService
		extends
			IEntityService<OpportunityStage> {

	/**
	 * Find by unique key
	 */
	public OpportunityStage findByName(String name);
}
