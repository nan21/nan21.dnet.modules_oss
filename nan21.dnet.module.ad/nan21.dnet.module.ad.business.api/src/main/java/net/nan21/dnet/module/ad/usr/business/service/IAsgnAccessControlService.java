/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import net.nan21.dnet.module.ad.usr.domain.entity.AsgnAccessControl;

/**
 * Interface to expose business functions specific for {@link AsgnAccessControl} domain
 * entity.
 */
public interface IAsgnAccessControlService
		extends
			IEntityService<AsgnAccessControl> {

	/**
	 * Find by unique key
	 */
	public AsgnAccessControl findByUnique(AccessControl accessControl,
			String dsName);

	/**
	 * Find by unique key
	 */
	public AsgnAccessControl findByUnique(Long accessControlId, String dsName);

	/**
	 * Find by reference: accessControl
	 */
	public List<AsgnAccessControl> findByAccessControl(
			AccessControl accessControl);

	/**
	 * Find by ID of reference: accessControl.id
	 */
	public List<AsgnAccessControl> findByAccessControlId(Long accessControlId);
}
