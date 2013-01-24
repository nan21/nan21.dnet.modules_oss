/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.inventory.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionLine;

/**
 * Interface to expose business functions specific for {@link InvTransactionLine} domain
 * entity.
 */
public interface IInvTransactionLineService
		extends
			IEntityService<InvTransactionLine> {

	/**
	 * Find by reference: invTransaction
	 */
	public List<InvTransactionLine> findByInvTransaction(
			InvTransaction invTransaction);

	/**
	 * Find by ID of reference: invTransaction.id
	 */
	public List<InvTransactionLine> findByInvTransactionId(Long invTransactionId);

	/**
	 * Find by reference: item
	 */
	public List<InvTransactionLine> findByItem(Product item);

	/**
	 * Find by ID of reference: item.id
	 */
	public List<InvTransactionLine> findByItemId(Long itemId);

	/**
	 * Find by reference: fromSubInventory
	 */
	public List<InvTransactionLine> findByFromSubInventory(
			SubInventory fromSubInventory);

	/**
	 * Find by ID of reference: fromSubInventory.id
	 */
	public List<InvTransactionLine> findByFromSubInventoryId(
			Long fromSubInventoryId);

	/**
	 * Find by reference: fromLocator
	 */
	public List<InvTransactionLine> findByFromLocator(StockLocator fromLocator);

	/**
	 * Find by ID of reference: fromLocator.id
	 */
	public List<InvTransactionLine> findByFromLocatorId(Long fromLocatorId);

	/**
	 * Find by reference: toSubInventory
	 */
	public List<InvTransactionLine> findByToSubInventory(
			SubInventory toSubInventory);

	/**
	 * Find by ID of reference: toSubInventory.id
	 */
	public List<InvTransactionLine> findByToSubInventoryId(Long toSubInventoryId);

	/**
	 * Find by reference: toLocator
	 */
	public List<InvTransactionLine> findByToLocator(StockLocator toLocator);

	/**
	 * Find by ID of reference: toLocator.id
	 */
	public List<InvTransactionLine> findByToLocatorId(Long toLocatorId);

	/**
	 * Find by reference: uom
	 */
	public List<InvTransactionLine> findByUom(Uom uom);

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<InvTransactionLine> findByUomId(Long uomId);
}
