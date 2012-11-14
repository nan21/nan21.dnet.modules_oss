/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

/**
 * Interface to expose business functions specific for {@link MenuItem} domain
 * entity.
 */
public interface IMenuItemService extends IEntityService<MenuItem> {

	/**
	 * Find by unique key
	 */
	public MenuItem findByName(String name);

	/**
	 * Find by reference: menuItem
	 */
	public List<MenuItem> findByMenuItem(MenuItem menuItem);

	/**
	 * Find by ID of reference: menuItem.id
	 */
	public List<MenuItem> findByMenuItemId(Long menuItemId);

	/**
	 * Find by reference: menu
	 */
	public List<MenuItem> findByMenu(Menu menu);

	/**
	 * Find by ID of reference: menu.id
	 */
	public List<MenuItem> findByMenuId(Long menuId);

	/**
	 * Find by reference: roles
	 */
	public List<MenuItem> findByRoles(Role roles);

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<MenuItem> findByRolesId(Long rolesId);
}
