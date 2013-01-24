/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.system.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

/**
 * Interface to expose business functions specific for {@link SysDataSource} domain
 * entity.
 */
public interface ISysDataSourceService extends IEntityService<SysDataSource> {

	/**
	 * Find by unique key
	 */
	public SysDataSource findByName(String name);

	/**
	 * Find by unique key
	 */
	public SysDataSource findByModel(String model);

	/**
	 * Find by reference: fields
	 */
	public List<SysDataSource> findByFields(SysDsField fields);

	/**
	 * Find by ID of reference: fields.id
	 */
	public List<SysDataSource> findByFieldsId(Long fieldsId);

	/**
	 * Find by reference: serviceMethods
	 */
	public List<SysDataSource> findByServiceMethods(SysDsService serviceMethods);

	/**
	 * Find by ID of reference: serviceMethods.id
	 */
	public List<SysDataSource> findByServiceMethodsId(Long serviceMethodsId);
}
