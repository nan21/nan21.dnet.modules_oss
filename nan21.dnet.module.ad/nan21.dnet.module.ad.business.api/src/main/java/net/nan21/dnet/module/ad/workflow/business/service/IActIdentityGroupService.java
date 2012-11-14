/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityGroup;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActIdentityUser;

/**
 * Interface to expose business functions specific for {@link ActIdentityGroup} domain
 * entity.
 */
public interface IActIdentityGroupService
		extends
			IEntityService<ActIdentityGroup> {

	/**
	 * Find by reference: users
	 */
	public List<ActIdentityGroup> findByUsers(ActIdentityUser users);

	/**
	 * Find by ID of reference: users.id
	 */
	public List<ActIdentityGroup> findByUsersId(String usersId);
}
