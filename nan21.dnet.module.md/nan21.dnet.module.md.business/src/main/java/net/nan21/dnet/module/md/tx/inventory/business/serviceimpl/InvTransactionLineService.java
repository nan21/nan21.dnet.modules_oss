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
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.org.domain.entity.StockLocator;
import net.nan21.dnet.module.md.org.domain.entity.SubInventory;
import net.nan21.dnet.module.md.tx.inventory.business.service.IInvTransactionLineService;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransaction;
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionLine;

/**
 * Repository functionality for {@link InvTransactionLine} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class InvTransactionLineService
		extends
			AbstractEntityService<InvTransactionLine>
		implements
			IInvTransactionLineService {

	public InvTransactionLineService() {
		super();
	}

	public InvTransactionLineService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<InvTransactionLine> getEntityClass() {
		return InvTransactionLine.class;
	}

	/**
	 * Find by reference: invTransaction
	 */
	public List<InvTransactionLine> findByInvTransaction(
			InvTransaction invTransaction) {
		return this.findByInvTransactionId(invTransaction.getId());
	}

	/**
	 * Find by ID of reference: invTransaction.id
	 */
	public List<InvTransactionLine> findByInvTransactionId(Long invTransactionId) {
		return (List<InvTransactionLine>) this
				.getEntityManager()
				.createQuery(
						"select e from InvTransactionLine e where e.clientId = :pClientId and e.invTransaction.id = :pInvTransactionId",
						InvTransactionLine.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pInvTransactionId", invTransactionId)
				.getResultList();
	}

	/**
	 * Find by reference: item
	 */
	public List<InvTransactionLine> findByItem(Product item) {
		return this.findByItemId(item.getId());
	}

	/**
	 * Find by ID of reference: item.id
	 */
	public List<InvTransactionLine> findByItemId(Long itemId) {
		return (List<InvTransactionLine>) this
				.getEntityManager()
				.createQuery(
						"select e from InvTransactionLine e where e.clientId = :pClientId and e.item.id = :pItemId",
						InvTransactionLine.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pItemId", itemId).getResultList();
	}

	/**
	 * Find by reference: fromSubInventory
	 */
	public List<InvTransactionLine> findByFromSubInventory(
			SubInventory fromSubInventory) {
		return this.findByFromSubInventoryId(fromSubInventory.getId());
	}

	/**
	 * Find by ID of reference: fromSubInventory.id
	 */
	public List<InvTransactionLine> findByFromSubInventoryId(
			Long fromSubInventoryId) {
		return (List<InvTransactionLine>) this
				.getEntityManager()
				.createQuery(
						"select e from InvTransactionLine e where e.clientId = :pClientId and e.fromSubInventory.id = :pFromSubInventoryId",
						InvTransactionLine.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFromSubInventoryId", fromSubInventoryId)
				.getResultList();
	}

	/**
	 * Find by reference: fromLocator
	 */
	public List<InvTransactionLine> findByFromLocator(StockLocator fromLocator) {
		return this.findByFromLocatorId(fromLocator.getId());
	}

	/**
	 * Find by ID of reference: fromLocator.id
	 */
	public List<InvTransactionLine> findByFromLocatorId(Long fromLocatorId) {
		return (List<InvTransactionLine>) this
				.getEntityManager()
				.createQuery(
						"select e from InvTransactionLine e where e.clientId = :pClientId and e.fromLocator.id = :pFromLocatorId",
						InvTransactionLine.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFromLocatorId", fromLocatorId).getResultList();
	}

	/**
	 * Find by reference: toSubInventory
	 */
	public List<InvTransactionLine> findByToSubInventory(
			SubInventory toSubInventory) {
		return this.findByToSubInventoryId(toSubInventory.getId());
	}

	/**
	 * Find by ID of reference: toSubInventory.id
	 */
	public List<InvTransactionLine> findByToSubInventoryId(Long toSubInventoryId) {
		return (List<InvTransactionLine>) this
				.getEntityManager()
				.createQuery(
						"select e from InvTransactionLine e where e.clientId = :pClientId and e.toSubInventory.id = :pToSubInventoryId",
						InvTransactionLine.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pToSubInventoryId", toSubInventoryId)
				.getResultList();
	}

	/**
	 * Find by reference: toLocator
	 */
	public List<InvTransactionLine> findByToLocator(StockLocator toLocator) {
		return this.findByToLocatorId(toLocator.getId());
	}

	/**
	 * Find by ID of reference: toLocator.id
	 */
	public List<InvTransactionLine> findByToLocatorId(Long toLocatorId) {
		return (List<InvTransactionLine>) this
				.getEntityManager()
				.createQuery(
						"select e from InvTransactionLine e where e.clientId = :pClientId and e.toLocator.id = :pToLocatorId",
						InvTransactionLine.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pToLocatorId", toLocatorId).getResultList();
	}

	/**
	 * Find by reference: uom
	 */
	public List<InvTransactionLine> findByUom(Uom uom) {
		return this.findByUomId(uom.getId());
	}

	/**
	 * Find by ID of reference: uom.id
	 */
	public List<InvTransactionLine> findByUomId(Long uomId) {
		return (List<InvTransactionLine>) this
				.getEntityManager()
				.createQuery(
						"select e from InvTransactionLine e where e.clientId = :pClientId and e.uom.id = :pUomId",
						InvTransactionLine.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pUomId", uomId).getResultList();
	}
}
