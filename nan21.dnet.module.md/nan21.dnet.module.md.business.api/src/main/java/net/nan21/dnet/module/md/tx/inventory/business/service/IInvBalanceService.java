/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.inventory.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvBalance;

/**
 * Interface to expose business functions specific for {@link InvBalance} domain
 * entity.
 */
public interface IInvBalanceService extends IEntityService<InvBalance> {

	/**
	 * Find by reference: subInventory
	 */
	public List<InvBalance> findBySubInventory(SubInventory subInventory);

	/**
	 * Find by ID of reference: subInventory.id
	 */
	public List<InvBalance> findBySubInventoryId(Long subInventoryId);

	/**
	 * Find by reference: locator
	 */
	public List<InvBalance> findByLocator(StockLocator locator);

	/**
	 * Find by ID of reference: locator.id
	 */
	public List<InvBalance> findByLocatorId(Long locatorId);

	/**
	 * Find by reference: item
	 */
	public List<InvBalance> findByItem(Product item);

	/**
	 * Find by ID of reference: item.id
	 */
	public List<InvBalance> findByItemId(Long itemId);

	/**
	 * Find by reference: uom
	 */
	public List<InvBalance> findByUom(Uom uom);

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<InvBalance> findByUomId(Long uomId);
}
