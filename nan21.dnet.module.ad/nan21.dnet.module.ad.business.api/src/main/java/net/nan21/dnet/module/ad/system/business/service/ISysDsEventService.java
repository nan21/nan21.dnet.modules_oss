/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsEvent;

/**
 * Interface to expose business functions specific for {@link SysDsEvent} domain
 * entity.
 */
public interface ISysDsEventService extends IEntityService<SysDsEvent> {

	/**
	 * Find by unique key
	 */
	public SysDsEvent findByName(SysDataSource dataSource, String eventType);

	/**
	 * Find by unique key
	 */
	public SysDsEvent findByName(Long dataSourceId, String eventType);

	/**
	 * Find by reference: dataSource
	 */
	public List<SysDsEvent> findByDataSource(SysDataSource dataSource);

	/**
	 * Find by ID of reference: dataSource.id
	 */
	public List<SysDsEvent> findByDataSourceId(Long dataSourceId);
}
