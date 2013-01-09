/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;

/**
 * Interface to expose business functions specific for {@link SysParam} domain
 * entity.
 */
public interface ISysParamService extends IEntityService<SysParam> {

	public void doSynchronizeCatalog() throws BusinessException;

	/**
	 * Find by unique key
	 */
	public SysParam findByCode(String code);

	/**
	 * Find by unique key
	 */
	public SysParam findByName(String name);
}
