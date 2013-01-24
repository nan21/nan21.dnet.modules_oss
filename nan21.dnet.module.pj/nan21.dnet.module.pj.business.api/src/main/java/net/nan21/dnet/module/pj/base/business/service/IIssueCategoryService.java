/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueCategory;

/**
 * Interface to expose business functions specific for {@link IssueCategory} domain
 * entity.
 */
public interface IIssueCategoryService extends IEntityService<IssueCategory> {

	/**
	 * Find by unique key
	 */
	public IssueCategory findByName(String name);
}
