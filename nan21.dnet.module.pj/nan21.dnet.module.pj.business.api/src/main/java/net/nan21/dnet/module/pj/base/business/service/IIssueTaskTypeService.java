/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTaskType;

/**
 * Interface to expose business functions specific for {@link IssueTaskType} domain
 * entity.
 */
public interface IIssueTaskTypeService extends IEntityService<IssueTaskType> {

	/**
	 * Find by unique key
	 */
	public IssueTaskType findByName(String name);
}
