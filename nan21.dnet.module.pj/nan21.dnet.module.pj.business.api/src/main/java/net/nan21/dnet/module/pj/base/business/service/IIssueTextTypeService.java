/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueTextType;

/**
 * Interface to expose business functions specific for {@link IssueTextType} domain
 * entity.
 */
public interface IIssueTextTypeService extends IEntityService<IssueTextType> {

	/**
	 * Find by unique key
	 */
	public IssueTextType findByName(String name);
}
