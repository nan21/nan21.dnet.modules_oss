/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.org.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.OrganizationType;

/**
 * Interface to expose business functions specific for {@link OrganizationType} domain
 * entity.
 */
public interface IOrganizationTypeService
		extends
			IEntityService<OrganizationType> {

	/**
	 * Find by unique key
	 */
	public OrganizationType findByName(String name);
}
