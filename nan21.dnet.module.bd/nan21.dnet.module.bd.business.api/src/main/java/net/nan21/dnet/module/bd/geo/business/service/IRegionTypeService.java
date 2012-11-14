/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.RegionType;

/**
 * Interface to expose business functions specific for {@link RegionType} domain
 * entity.
 */
public interface IRegionTypeService extends IEntityService<RegionType> {

	/**
	 * Find by unique key
	 */
	public RegionType findByName(String name);
}
