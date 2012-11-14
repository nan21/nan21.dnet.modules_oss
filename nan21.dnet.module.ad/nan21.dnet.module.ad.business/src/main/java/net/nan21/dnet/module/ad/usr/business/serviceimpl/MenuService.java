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
import net.nan21.dnet.module.ad.usr.business.service.IMenuService;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

/**
 * Repository functionality for {@link Menu} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class MenuService extends AbstractEntityService<Menu>
		implements
			IMenuService {

	public MenuService() {
		super();
	}

	public MenuService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<Menu> getEntityClass() {
		return Menu.class;
	}

	/**
	 * Find by unique key
	 */
	public Menu findByName(String name) {
		return (Menu) this.em.createNamedQuery(Menu.NQ_FIND_BY_NAME)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pName", name).getSingleResult();
	}

	/**
	 * Find by reference: roles
	 */
	public List<Menu> findByRoles(Role roles) {
		return this.findByRolesId(roles.getId());
	}

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<Menu> findByRolesId(Long rolesId) {
		return (List<Menu>) this.em
				.createQuery(
						"select distinct e from Menu e, IN (e.roles) c where e.clientId = :pClientId and c.id = :pRolesId",
						Menu.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pRolesId", rolesId).getResultList();
	}
}
