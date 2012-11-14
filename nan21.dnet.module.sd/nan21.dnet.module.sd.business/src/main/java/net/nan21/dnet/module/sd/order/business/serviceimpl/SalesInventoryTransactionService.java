/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.order.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import net.nan21.dnet.module.sd.order.business.service.ISalesInventoryTransactionService;
import net.nan21.dnet.module.sd.order.domain.entity.SalesInventoryTransaction;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

/**
 * Repository functionality for {@link SalesInventoryTransaction} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SalesInventoryTransactionService
		extends
			AbstractEntityService<SalesInventoryTransaction>
		implements
			ISalesInventoryTransactionService {

	public SalesInventoryTransactionService() {
		super();
	}

	public SalesInventoryTransactionService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SalesInventoryTransaction> getEntityClass() {
		return SalesInventoryTransaction.class;
	}

	/**
	 * Find by reference: customer
	 */
	public List<SalesInventoryTransaction> findByCustomer(
			BusinessPartner customer) {
		return this.findByCustomerId(customer.getId());
	}

	/**
	 * Find by ID of reference: customer.id
	 */
	public List<SalesInventoryTransaction> findByCustomerId(Long customerId) {
		return (List<SalesInventoryTransaction>) this.em
				.createQuery(
						"select e from SalesInventoryTransaction e where e.clientId = :pClientId and e.customer.id = :pCustomerId",
						SalesInventoryTransaction.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustomerId", customerId).getResultList();
	}

	/**
	 * Find by reference: deliveryLocation
	 */
	public List<SalesInventoryTransaction> findByDeliveryLocation(
			Location deliveryLocation) {
		return this.findByDeliveryLocationId(deliveryLocation.getId());
	}

	/**
	 * Find by ID of reference: deliveryLocation.id
	 */
	public List<SalesInventoryTransaction> findByDeliveryLocationId(
			Long deliveryLocationId) {
		return (List<SalesInventoryTransaction>) this.em
				.createQuery(
						"select e from SalesInventoryTransaction e where e.clientId = :pClientId and e.deliveryLocation.id = :pDeliveryLocationId",
						SalesInventoryTransaction.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDeliveryLocationId", deliveryLocationId)
				.getResultList();
	}

	/**
	 * Find by reference: deliveryContact
	 */
	public List<SalesInventoryTransaction> findByDeliveryContact(
			Contact deliveryContact) {
		return this.findByDeliveryContactId(deliveryContact.getId());
	}

	/**
	 * Find by ID of reference: deliveryContact.id
	 */
	public List<SalesInventoryTransaction> findByDeliveryContactId(
			Long deliveryContactId) {
		return (List<SalesInventoryTransaction>) this.em
				.createQuery(
						"select e from SalesInventoryTransaction e where e.clientId = :pClientId and e.deliveryContact.id = :pDeliveryContactId",
						SalesInventoryTransaction.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDeliveryContactId", deliveryContactId)
				.getResultList();
	}

	/**
	 * Find by reference: salesOrder
	 */
	public List<SalesInventoryTransaction> findBySalesOrder(
			SalesOrder salesOrder) {
		return this.findBySalesOrderId(salesOrder.getId());
	}

	/**
	 * Find by ID of reference: salesOrder.id
	 */
	public List<SalesInventoryTransaction> findBySalesOrderId(Long salesOrderId) {
		return (List<SalesInventoryTransaction>) this.em
				.createQuery(
						"select e from SalesInventoryTransaction e where e.clientId = :pClientId and e.salesOrder.id = :pSalesOrderId",
						SalesInventoryTransaction.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSalesOrderId", salesOrderId).getResultList();
	}
}
