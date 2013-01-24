/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskStatus;

/**
 * Interface to expose business functions specific for {@link IssueTaskStatus} domain
 * entity.
 */
public interface IIssueTaskStatusService
		extends
			IEntityService<IssueTaskStatus> {

	/**
	 * Find by unique key
	 */
	public IssueTaskStatus findByName(String name);
}
