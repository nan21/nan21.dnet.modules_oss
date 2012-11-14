/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.ProjectStatus;

/**
 * Interface to expose business functions specific for {@link ProjectStatus} domain
 * entity.
 */
public interface IProjectStatusService extends IEntityService<ProjectStatus> {

	/**
	 * Find by unique key
	 */
	public ProjectStatus findByName(String name);
}
