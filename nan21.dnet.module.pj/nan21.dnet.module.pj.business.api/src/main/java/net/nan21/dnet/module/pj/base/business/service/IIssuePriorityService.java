/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssuePriority;

/**
 * Interface to expose business functions specific for {@link IssuePriority} domain
 * entity.
 */
public interface IIssuePriorityService extends IEntityService<IssuePriority> {

	/**
	 * Find by unique key
	 */
	public IssuePriority findByName(String name);
}
