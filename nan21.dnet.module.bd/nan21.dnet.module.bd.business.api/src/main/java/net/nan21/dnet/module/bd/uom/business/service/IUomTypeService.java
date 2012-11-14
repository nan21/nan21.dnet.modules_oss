/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.bd.uom.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.UomType;

/**
 * Interface to expose business functions specific for {@link UomType} domain
 * entity.
 */
public interface IUomTypeService extends IEntityService<UomType> {

	/**
	 * Find by unique key
	 */
	public UomType findByName(String name);
}
