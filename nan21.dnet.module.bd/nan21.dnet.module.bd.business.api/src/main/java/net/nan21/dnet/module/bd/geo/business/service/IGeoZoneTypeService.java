/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.GeoZoneType;

/**
 * Interface to expose business functions specific for {@link GeoZoneType} domain
 * entity.
 */
public interface IGeoZoneTypeService extends IEntityService<GeoZoneType> {

	/**
	 * Find by unique key
	 */
	public GeoZoneType findByName(String name);
}
