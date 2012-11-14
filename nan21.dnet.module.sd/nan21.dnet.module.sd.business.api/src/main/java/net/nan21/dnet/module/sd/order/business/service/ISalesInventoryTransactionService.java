/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import net.nan21.dnet.module.sd.order.domain.entity.SalesInventoryTransaction;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

/**
 * Interface to expose business functions specific for {@link SalesInventoryTransaction} domain
 * entity.
 */
public interface ISalesInventoryTransactionService
		extends
			IEntityService<SalesInventoryTransaction> {

	/**
	 * Find by reference: customer
	 */
	public List<SalesInventoryTransaction> findByCustomer(
			BusinessPartner customer);

	/**
	 * Find by ID of reference: customer.id
	 */
	public List<SalesInventoryTransaction> findByCustomerId(Long customerId);

	/**
	 * Find by reference: deliveryLocation
	 */
	public List<SalesInventoryTransaction> findByDeliveryLocation(
			Location deliveryLocation);

	/**
	 * Find by ID of reference: deliveryLocation.id
	 */
	public List<SalesInventoryTransaction> findByDeliveryLocationId(
			Long deliveryLocationId);

	/**
	 * Find by reference: deliveryContact
	 */
	public List<SalesInventoryTransaction> findByDeliveryContact(
			Contact deliveryContact);

	/**
	 * Find by ID of reference: deliveryContact.id
	 */
	public List<SalesInventoryTransaction> findByDeliveryContactId(
			Long deliveryContactId);

	/**
	 * Find by reference: salesOrder
	 */
	public List<SalesInventoryTransaction> findBySalesOrder(
			SalesOrder salesOrder);

	/**
	 * Find by ID of reference: salesOrder.id
	 */
	public List<SalesInventoryTransaction> findBySalesOrderId(Long salesOrderId);
}
