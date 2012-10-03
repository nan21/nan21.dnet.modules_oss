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

public interface IMenuService extends IEntityService<Menu> {
	
	public Menu findByName(String name);
	
	public List<Menu> findByRoles(Role roles);
	
	public List<Menu> findByRolesId(Long rolesId);
	
}
