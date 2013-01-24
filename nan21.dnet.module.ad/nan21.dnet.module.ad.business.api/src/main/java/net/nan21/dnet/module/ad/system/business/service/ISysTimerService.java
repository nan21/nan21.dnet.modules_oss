/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;
import net.nan21.dnet.module.ad.system.domain.entity.SysTimer;

/**
 * Interface to expose business functions specific for {@link SysTimer} domain
 * entity.
 */
public interface ISysTimerService extends IEntityService<SysTimer> {

	/**
	 * Find by unique key
	 */
	public SysTimer findByName(SysJobCtx jobCtx, String name);

	/**
	 * Find by unique key
	 */
	public SysTimer findByName(Long jobCtxId, String name);

	/**
	 * Find by reference: jobCtx
	 */
	public List<SysTimer> findByJobCtx(SysJobCtx jobCtx);

	/**
	 * Find by ID of reference: jobCtx.id
	 */
	public List<SysTimer> findByJobCtxId(Long jobCtxId);
}
