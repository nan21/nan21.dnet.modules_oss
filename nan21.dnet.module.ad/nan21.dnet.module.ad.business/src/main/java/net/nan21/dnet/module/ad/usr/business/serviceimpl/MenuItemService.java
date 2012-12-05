/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IMenuItemService;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

/**
 * Repository functionality for {@link MenuItem} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class MenuItemService extends AbstractEntityService<MenuItem>
		implements
			IMenuItemService {

	public MenuItemService() {
		super();
	}

	public MenuItemService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<MenuItem> getEntityClass() {
		return MenuItem.class;
	}

	/**
	 * Find by unique key
	 */
	public MenuItem findByName(String name) {
		return (MenuItem) this.getEntityManager()
				.createNamedQuery(MenuItem.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: menuItem
	 */
	public List<MenuItem> findByMenuItem(MenuItem menuItem) {
		return this.findByMenuItemId(menuItem.getId());
	}

	/**
	 * Find by ID of reference: menuItem.id
	 */
	public List<MenuItem> findByMenuItemId(Long menuItemId) {
		return (List<MenuItem>) this
				.getEntityManager()
				.createQuery(
						"select e from MenuItem e where e.clientId = :pClientId and e.menuItem.id = :pMenuItemId",
						MenuItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pMenuItemId", menuItemId).getResultList();
	}

	/**
	 * Find by reference: menu
	 */
	public List<MenuItem> findByMenu(Menu menu) {
		return this.findByMenuId(menu.getId());
	}

	/**
	 * Find by ID of reference: menu.id
	 */
	public List<MenuItem> findByMenuId(Long menuId) {
		return (List<MenuItem>) this
				.getEntityManager()
				.createQuery(
						"select e from MenuItem e where e.clientId = :pClientId and e.menu.id = :pMenuId",
						MenuItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pMenuId", menuId).getResultList();
	}

	/**
	 * Find by reference: roles
	 */
	public List<MenuItem> findByRoles(Role roles) {
		return this.findByRolesId(roles.getId());
	}

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<MenuItem> findByRolesId(Long rolesId) {
		return (List<MenuItem>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from MenuItem e, IN (e.roles) c where e.clientId = :pClientId and c.id = :pRolesId",
						MenuItem.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRolesId", rolesId).getResultList();
	}
}
