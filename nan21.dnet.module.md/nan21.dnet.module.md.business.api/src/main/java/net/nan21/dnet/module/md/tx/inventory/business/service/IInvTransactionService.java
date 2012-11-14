/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.inventory.business.service;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionLine;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;

/**
 * Interface to expose business functions specific for {@link InvTransaction} domain
 * entity.
 */
public interface IInvTransactionService extends IEntityService<InvTransaction> {

	public void doConfirm(Long transactionId) throws BusinessException;

	public void doUnConfirm(Long transactionId) throws BusinessException;

	/**
	 * Find by reference: transactionType
	 */
	public List<InvTransaction> findByTransactionType(
			InvTransactionType transactionType);

	/**
	 * Find by ID of reference: transactionType.id
	 */
	public List<InvTransaction> findByTransactionTypeId(Long transactionTypeId);

	/**
	 * Find by reference: fromInventory
	 */
	public List<InvTransaction> findByFromInventory(Organization fromInventory);

	/**
	 * Find by ID of reference: fromInventory.id
	 */
	public List<InvTransaction> findByFromInventoryId(Long fromInventoryId);

	/**
	 * Find by reference: toInventory
	 */
	public List<InvTransaction> findByToInventory(Organization toInventory);

	/**
	 * Find by ID of reference: toInventory.id
	 */
	public List<InvTransaction> findByToInventoryId(Long toInventoryId);

	/**
	 * Find by reference: lines
	 */
	public List<InvTransaction> findByLines(InvTransactionLine lines);

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<InvTransaction> findByLinesId(Long linesId);
}
