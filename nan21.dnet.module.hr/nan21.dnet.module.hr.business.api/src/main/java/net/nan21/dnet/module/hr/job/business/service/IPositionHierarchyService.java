/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.hr.job.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.hr.job.domain.entity.PositionHierarchy;

/**
 * Interface to expose business functions specific for {@link PositionHierarchy} domain
 * entity.
 */
public interface IPositionHierarchyService
		extends
			IEntityService<PositionHierarchy> {

	/**
	 * Find by unique key
	 */
	public PositionHierarchy findByName(String name);
}
