/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.attr.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.attr.domain.entity.AttributeSet;

/**
 * Interface to expose business functions specific for {@link AttributeSet} domain
 * entity.
 */
public interface IAttributeSetService extends IEntityService<AttributeSet> {

	/**
	 * Find by unique key
	 */
	public AttributeSet findByName(String name);
}
