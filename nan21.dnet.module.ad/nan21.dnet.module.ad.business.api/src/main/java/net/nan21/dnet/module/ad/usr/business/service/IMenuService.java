/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Menu;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

/**
 * Interface to expose business functions specific for {@link Menu} domain
 * entity.
 */
public interface IMenuService extends IEntityService<Menu> {

	/**
	 * Find by unique key
	 */
	public Menu findByName(String name);

	/**
	 * Find by reference: roles
	 */
	public List<Menu> findByRoles(Role roles);

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<Menu> findByRolesId(Long rolesId);
}
