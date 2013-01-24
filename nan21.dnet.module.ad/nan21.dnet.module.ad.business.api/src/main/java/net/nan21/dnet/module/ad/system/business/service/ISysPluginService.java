/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysPlugin;

/**
 * Interface to expose business functions specific for {@link SysPlugin} domain
 * entity.
 */
public interface ISysPluginService extends IEntityService<SysPlugin> {

	/**
	 * Find by unique key
	 */
	public SysPlugin findByName(String name);
}
