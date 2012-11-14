/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;

/**
 * Interface to expose business functions specific for {@link SysDsField} domain
 * entity.
 */
public interface ISysDsFieldService extends IEntityService<SysDsField> {

	/**
	 * Find by unique key
	 */
	public SysDsField findByName(SysDataSource dataSource, String name);

	/**
	 * Find by unique key
	 */
	public SysDsField findByName(Long dataSourceId, String name);

	/**
	 * Find by reference: dataSource
	 */
	public List<SysDsField> findByDataSource(SysDataSource dataSource);

	/**
	 * Find by ID of reference: dataSource.id
	 */
	public List<SysDsField> findByDataSourceId(Long dataSourceId);
}
