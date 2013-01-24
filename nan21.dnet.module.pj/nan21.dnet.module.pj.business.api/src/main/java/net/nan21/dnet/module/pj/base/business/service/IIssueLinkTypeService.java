/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.pj.base.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.pj.base.domain.entity.IssueLinkType;

/**
 * Interface to expose business functions specific for {@link IssueLinkType} domain
 * entity.
 */
public interface IIssueLinkTypeService extends IEntityService<IssueLinkType> {

	/**
	 * Find by unique key
	 */
	public IssueLinkType findByName(String name);
}
