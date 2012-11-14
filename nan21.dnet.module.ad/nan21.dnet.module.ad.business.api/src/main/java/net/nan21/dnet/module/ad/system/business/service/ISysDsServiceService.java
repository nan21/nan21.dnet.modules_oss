/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

/**
 * Interface to expose business functions specific for {@link SysDsService} domain
 * entity.
 */
public interface ISysDsServiceService extends IEntityService<SysDsService> {

	/**
	 * Find by unique key
	 */
	public SysDsService findByName(SysDataSource dataSource, String name);

	/**
	 * Find by unique key
	 */
	public SysDsService findByName(Long dataSourceId, String name);

	/**
	 * Find by reference: dataSource
	 */
	public List<SysDsService> findByDataSource(SysDataSource dataSource);

	/**
	 * Find by ID of reference: dataSource.id
	 */
	public List<SysDsService> findByDataSourceId(Long dataSourceId);
}
