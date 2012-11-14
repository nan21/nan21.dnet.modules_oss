/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueSeverity;

/**
 * Interface to expose business functions specific for {@link IssueSeverity} domain
 * entity.
 */
public interface IIssueSeverityService extends IEntityService<IssueSeverity> {

	/**
	 * Find by unique key
	 */
	public IssueSeverity findByName(String name);
}
