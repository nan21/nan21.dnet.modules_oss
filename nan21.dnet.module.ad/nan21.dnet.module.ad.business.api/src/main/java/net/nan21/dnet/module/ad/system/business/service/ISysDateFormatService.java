/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDateFormat;

/**
 * Interface to expose business functions specific for {@link SysDateFormat} domain
 * entity.
 */
public interface ISysDateFormatService extends IEntityService<SysDateFormat> {

	/**
	 * Find by unique key
	 */
	public SysDateFormat findByName(String name);
}
