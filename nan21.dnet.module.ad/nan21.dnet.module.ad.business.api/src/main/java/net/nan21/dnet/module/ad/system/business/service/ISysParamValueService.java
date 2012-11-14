/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;
import net.nan21.dnet.module.ad.system.domain.entity.SysParamValue;

/**
 * Interface to expose business functions specific for {@link SysParamValue} domain
 * entity.
 */
public interface ISysParamValueService extends IEntityService<SysParamValue> {

	/**
	 * Find by reference: sysParam
	 */
	public List<SysParamValue> findBySysParam(SysParam sysParam);

	/**
	 * Find by ID of reference: sysParam.id
	 */
	public List<SysParamValue> findBySysParamId(Long sysParamId);
}
