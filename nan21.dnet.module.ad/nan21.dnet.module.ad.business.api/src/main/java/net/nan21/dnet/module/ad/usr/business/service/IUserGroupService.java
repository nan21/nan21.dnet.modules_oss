/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.module.ad.usr.domain.entity.UserGroup;

/**
 * Interface to expose business functions specific for {@link UserGroup} domain
 * entity.
 */
public interface IUserGroupService extends IEntityService<UserGroup> {

	/**
	 * Find by unique key
	 */
	public UserGroup findByName(String name);

	/**
	 * Find by reference: users
	 */
	public List<UserGroup> findByUsers(User users);

	/**
	 * Find by ID of reference: users.id
	 */
	public List<UserGroup> findByUsersId(Long usersId);
}
