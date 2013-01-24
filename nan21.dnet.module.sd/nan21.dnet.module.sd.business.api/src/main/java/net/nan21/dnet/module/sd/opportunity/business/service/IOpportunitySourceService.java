/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.opportunity.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.sd.opportunity.domain.entity.OpportunitySource;

/**
 * Interface to expose business functions specific for {@link OpportunitySource} domain
 * entity.
 */
public interface IOpportunitySourceService
		extends
			IEntityService<OpportunitySource> {

	/**
	 * Find by unique key
	 */
	public OpportunitySource findByName(String name);
}
