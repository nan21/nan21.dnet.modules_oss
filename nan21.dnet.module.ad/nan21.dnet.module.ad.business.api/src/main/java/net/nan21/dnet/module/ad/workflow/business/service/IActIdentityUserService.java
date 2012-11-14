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
 * Interface to expose business functions specific for {@link ActIdentityUser} domain
 * entity.
 */
public interface IActIdentityUserService
		extends
			IEntityService<ActIdentityUser> {

	/**
	 * Find by reference: groups
	 */
	public List<ActIdentityUser> findByGroups(ActIdentityGroup groups);

	/**
	 * Find by ID of reference: groups.id
	 */
	public List<ActIdentityUser> findByGroupsId(String groupsId);
}
