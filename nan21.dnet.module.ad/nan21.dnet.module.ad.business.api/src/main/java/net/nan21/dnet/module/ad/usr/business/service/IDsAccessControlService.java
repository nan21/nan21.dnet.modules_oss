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

/**
 * Interface to expose business functions specific for {@link DsAccessControl} domain
 * entity.
 */
public interface IDsAccessControlService
		extends
			IEntityService<DsAccessControl> {

	/**
	 * Find by unique key
	 */
	public DsAccessControl findByUnique(AccessControl accessControl,
			String dsName);

	/**
	 * Find by unique key
	 */
	public DsAccessControl findByUnique(Long accessControlId, String dsName);

	/**
	 * Find by reference: accessControl
	 */
	public List<DsAccessControl> findByAccessControl(AccessControl accessControl);

	/**
	 * Find by ID of reference: accessControl.id
	 */
	public List<DsAccessControl> findByAccessControlId(Long accessControlId);
}
