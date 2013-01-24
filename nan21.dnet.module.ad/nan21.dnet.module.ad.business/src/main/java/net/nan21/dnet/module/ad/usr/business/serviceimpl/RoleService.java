/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IRoleService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.module.ad.usr.domain.entity.MenuItem;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.module.ad.usr.domain.entity.User;

/**
 * Repository functionality for {@link Role} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class RoleService extends AbstractEntityService<Role>
		implements
			IRoleService {

	public RoleService() {
		super();
	}

	public RoleService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Role> getEntityClass() {
		return Role.class;
	}

	/**
	 * Find by unique key
	 */
	public Role findByName(String name) {
		return (Role) this.getEntityManager()
				.createNamedQuery(Role.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: users
	 */
	public List<Role> findByUsers(User users) {
		return this.findByUsersId(users.getId());
	}

	/**
	 * Find by ID of reference: users.id
	 */
	public List<Role> findByUsersId(Long usersId) {
		return (List<Role>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Role e, IN (e.users) c where e.clientId = :pClientId and c.id = :pUsersId",
						Role.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pUsersId", usersId).getResultList();
	}

	/**
	 * Find by reference: accessControls
	 */
	public List<Role> findByAccessControls(AccessControl accessControls) {
		return this.findByAccessControlsId(accessControls.getId());
	}

	/**
	 * Find by ID of reference: accessControls.id
	 */
	public List<Role> findByAccessControlsId(Long accessControlsId) {
		return (List<Role>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Role e, IN (e.accessControls) c where e.clientId = :pClientId and c.id = :pAccessControlsId",
						Role.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pAccessControlsId", accessControlsId)
				.getResultList();
	}

	/**
	 * Find by reference: menus
	 */
	public List<Role> findByMenus(Menu menus) {
		return this.findByMenusId(menus.getId());
	}

	/**
	 * Find by ID of reference: menus.id
	 */
	public List<Role> findByMenusId(Long menusId) {
		return (List<Role>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Role e, IN (e.menus) c where e.clientId = :pClientId and c.id = :pMenusId",
						Role.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pMenusId", menusId).getResultList();
	}

	/**
	 * Find by reference: menuItems
	 */
	public List<Role> findByMenuItems(MenuItem menuItems) {
		return this.findByMenuItemsId(menuItems.getId());
	}

	/**
	 * Find by ID of reference: menuItems.id
	 */
	public List<Role> findByMenuItemsId(Long menuItemsId) {
		return (List<Role>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Role e, IN (e.menuItems) c where e.clientId = :pClientId and c.id = :pMenuItemsId",
						Role.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pMenuItemsId", menuItemsId).getResultList();
	}
}
