/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.acc.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;

/**
 * Interface to expose business functions specific for {@link AccItem} domain
 * entity.
 */
public interface IAccItemService extends IEntityService<AccItem> {

	/**
	 * Find by unique key
	 */
	public AccItem findByName(String name);
}
