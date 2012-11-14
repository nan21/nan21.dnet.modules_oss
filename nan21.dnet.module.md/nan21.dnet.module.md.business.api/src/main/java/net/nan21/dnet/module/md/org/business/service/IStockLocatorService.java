/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.org.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.StockLocatorType;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;

/**
 * Interface to expose business functions specific for {@link StockLocator} domain
 * entity.
 */
public interface IStockLocatorService extends IEntityService<StockLocator> {

	/**
	 * Find by unique key
	 */
	public StockLocator findByName(String name);

	/**
	 * Find by reference: subInventory
	 */
	public List<StockLocator> findBySubInventory(SubInventory subInventory);

	/**
	 * Find by ID of reference: subInventory.id
	 */
	public List<StockLocator> findBySubInventoryId(Long subInventoryId);

	/**
	 * Find by reference: locatorType
	 */
	public List<StockLocator> findByLocatorType(StockLocatorType locatorType);

	/**
	 * Find by ID of reference: locatorType.id
	 */
	public List<StockLocator> findByLocatorTypeId(Long locatorTypeId);
}
