/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.UserType;

/**
 * Interface to expose business functions specific for {@link UserType} domain
 * entity.
 */
public interface IUserTypeService extends IEntityService<UserType> {

	/**
	 * Find by unique key
	 */
	public UserType findByName(String name);
}
