/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.DsAccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;

/**
 * Interface to expose business functions specific for {@link AccessControl} domain
 * entity.
 */
public interface IAccessControlService extends IEntityService<AccessControl> {

	/**
	 * Find by unique key
	 */
	public AccessControl findByName(String name);

	/**
	 * Find by reference: dsRules
	 */
	public List<AccessControl> findByDsRules(DsAccessControl dsRules);

	/**
	 * Find by ID of reference: dsRules.id
	 */
	public List<AccessControl> findByDsRulesId(Long dsRulesId);

	/**
	 * Find by reference: roles
	 */
	public List<AccessControl> findByRoles(Role roles);

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<AccessControl> findByRolesId(Long rolesId);
}
