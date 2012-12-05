/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.md.tx.inventory.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionLine;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;

/**
 * Repository functionality for {@link InvTransaction} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class InvTransactionService
		extends
			AbstractEntityService<InvTransaction> {

	public InvTransactionService() {
		super();
	}

	public InvTransactionService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<InvTransaction> getEntityClass() {
		return InvTransaction.class;
	}

	/**
	 * Find by reference: transactionType
	 */
	public List<InvTransaction> findByTransactionType(
			InvTransactionType transactionType) {
		return this.findByTransactionTypeId(transactionType.getId());
	}

	/**
	 * Find by ID of reference: transactionType.id
	 */
	public List<InvTransaction> findByTransactionTypeId(Long transactionTypeId) {
		return (List<InvTransaction>) this
				.getEntityManager()
				.createQuery(
						"select e from InvTransaction e where e.clientId = :pClientId and e.transactionType.id = :pTransactionTypeId",
						InvTransaction.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTransactionTypeId", transactionTypeId)
				.getResultList();
	}

	/**
	 * Find by reference: fromInventory
	 */
	public List<InvTransaction> findByFromInventory(Organization fromInventory) {
		return this.findByFromInventoryId(fromInventory.getId());
	}

	/**
	 * Find by ID of reference: fromInventory.id
	 */
	public List<InvTransaction> findByFromInventoryId(Long fromInventoryId) {
		return (List<InvTransaction>) this
				.getEntityManager()
				.createQuery(
						"select e from InvTransaction e where e.clientId = :pClientId and e.fromInventory.id = :pFromInventoryId",
						InvTransaction.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFromInventoryId", fromInventoryId)
				.getResultList();
	}

	/**
	 * Find by reference: toInventory
	 */
	public List<InvTransaction> findByToInventory(Organization toInventory) {
		return this.findByToInventoryId(toInventory.getId());
	}

	/**
	 * Find by ID of reference: toInventory.id
	 */
	public List<InvTransaction> findByToInventoryId(Long toInventoryId) {
		return (List<InvTransaction>) this
				.getEntityManager()
				.createQuery(
						"select e from InvTransaction e where e.clientId = :pClientId and e.toInventory.id = :pToInventoryId",
						InvTransaction.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pToInventoryId", toInventoryId).getResultList();
	}

	/**
	 * Find by reference: lines
	 */
	public List<InvTransaction> findByLines(InvTransactionLine lines) {
		return this.findByLinesId(lines.getId());
	}

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<InvTransaction> findByLinesId(Long linesId) {
		return (List<InvTransaction>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from InvTransaction e, IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
						InvTransaction.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLinesId", linesId).getResultList();
	}
}
