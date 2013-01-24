/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;

/**
 * Interface to expose business functions specific for {@link SysJobCtx} domain
 * entity.
 */
public interface ISysJobCtxService extends IEntityService<SysJobCtx> {

	/**
	 * Find by unique key
	 */
	public SysJobCtx findByName(String name);
}
