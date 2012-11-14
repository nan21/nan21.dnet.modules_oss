/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtx;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobCtxParam;
import net.nan21.dnet.module.ad.system.domain.entity.SysJobParam;

/**
 * Interface to expose business functions specific for {@link SysJobCtxParam} domain
 * entity.
 */
public interface ISysJobCtxParamService extends IEntityService<SysJobCtxParam> {

	/**
	 * Find by reference: jobCtx
	 */
	public List<SysJobCtxParam> findByJobCtx(SysJobCtx jobCtx);

	/**
	 * Find by ID of reference: jobCtx.id
	 */
	public List<SysJobCtxParam> findByJobCtxId(Long jobCtxId);

	/**
	 * Find by reference: jobParam
	 */
	public List<SysJobCtxParam> findByJobParam(SysJobParam jobParam);

	/**
	 * Find by ID of reference: jobParam.id
	 */
	public List<SysJobCtxParam> findByJobParamId(Long jobParamId);
}
