/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueResolution;

/**
 * Interface to expose business functions specific for {@link IssueResolution} domain
 * entity.
 */
public interface IIssueResolutionService
		extends
			IEntityService<IssueResolution> {

	/**
	 * Find by unique key
	 */
	public IssueResolution findByName(String name);
}
