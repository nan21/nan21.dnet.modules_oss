/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.geo.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.GeoZone;

/**
 * Interface to expose business functions specific for {@link GeoZone} domain
 * entity.
 */
public interface IGeoZoneService extends IEntityService<GeoZone> {

	/**
	 * Find by unique key
	 */
	public GeoZone findByName(String name);
}
