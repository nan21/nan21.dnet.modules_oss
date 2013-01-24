/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.AssignableType;

/**
 * Interface to expose business functions specific for {@link AssignableType} domain
 * entity.
 */
public interface IAssignableTypeService extends IEntityService<AssignableType> {

	/**
	 * Find by unique key
	 */
	public AssignableType findByName(String name);
}
