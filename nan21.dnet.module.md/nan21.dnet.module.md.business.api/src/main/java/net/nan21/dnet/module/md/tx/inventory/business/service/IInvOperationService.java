/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.inventory.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvOperation;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionLine;

/**
 * Interface to expose business functions specific for {@link InvOperation} domain
 * entity.
 */
public interface IInvOperationService extends IEntityService<InvOperation> {

	/**
	 * Find by reference: inventory
	 */
	public List<InvOperation> findByInventory(Organization inventory);

	/**
	 * Find by ID of reference: inventory.id
	 */
	public List<InvOperation> findByInventoryId(Long inventoryId);

	/**
	 * Find by reference: subInventory
	 */
	public List<InvOperation> findBySubInventory(SubInventory subInventory);

	/**
	 * Find by ID of reference: subInventory.id
	 */
	public List<InvOperation> findBySubInventoryId(Long subInventoryId);

	/**
	 * Find by reference: locator
	 */
	public List<InvOperation> findByLocator(StockLocator locator);

	/**
	 * Find by ID of reference: locator.id
	 */
	public List<InvOperation> findByLocatorId(Long locatorId);

	/**
	 * Find by reference: item
	 */
	public List<InvOperation> findByItem(Product item);

	/**
	 * Find by ID of reference: item.id
	 */
	public List<InvOperation> findByItemId(Long itemId);

	/**
	 * Find by reference: transactionLine
	 */
	public List<InvOperation> findByTransactionLine(
			InvTransactionLine transactionLine);

	/**
	 * Find by ID of reference: transactionLine.id
	 */
	public List<InvOperation> findByTransactionLineId(Long transactionLineId);

	/**
	 * Find by reference: uom
	 */
	public List<InvOperation> findByUom(Uom uom);

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<InvOperation> findByUomId(Long uomId);
}
