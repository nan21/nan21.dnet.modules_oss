/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

/**
 * Interface to expose business functions specific for {@link Role} domain
 * entity.
 */
public interface IRoleService extends IEntityService<Role> {

	/**
	 * Find by unique key
	 */
	public Role findByName(String name);

	/**
	 * Find by reference: users
	 */
	public List<Role> findByUsers(User users);

	/**
	 * Find by ID of reference: users.id
	 */
	public List<Role> findByUsersId(Long usersId);

	/**
	 * Find by reference: accessControls
	 */
	public List<Role> findByAccessControls(AccessControl accessControls);

	/**
	 * Find by ID of reference: accessControls.id
	 */
	public List<Role> findByAccessControlsId(Long accessControlsId);

	/**
	 * Find by reference: menus
	 */
	public List<Role> findByMenus(Menu menus);

	/**
	 * Find by ID of reference: menus.id
	 */
	public List<Role> findByMenusId(Long menusId);

	/**
	 * Find by reference: menuItems
	 */
	public List<Role> findByMenuItems(MenuItem menuItems);

	/**
	 * Find by ID of reference: menuItems.id
	 */
	public List<Role> findByMenuItemsId(Long menuItemsId);
}
