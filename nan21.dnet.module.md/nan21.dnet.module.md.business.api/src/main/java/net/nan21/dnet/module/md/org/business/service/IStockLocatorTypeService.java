/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.org.business.service;

import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.org.domain.entity.StockLocatorType;

/**
 * Interface to expose business functions specific for {@link StockLocatorType} domain
 * entity.
 */
public interface IStockLocatorTypeService
		extends
			IEntityService<StockLocatorType> {

	/**
	 * Find by unique key
	 */
	public StockLocatorType findByName(String name);
}
