/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysFrameExtension;

/**
 * Interface to expose business functions specific for {@link SysFrameExtension} domain
 * entity.
 */
public interface ISysFrameExtensionService
		extends
			IEntityService<SysFrameExtension> {

	/**
	 * Find by unique key
	 */
	public SysFrameExtension findByName(String frameFQN, String fileLocation);
}
