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
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderTax;

/**
 * Repository functionality for {@link SalesOrder} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SalesOrderService extends AbstractEntityService<SalesOrder> {

	public SalesOrderService() {
		super();
	}

	public SalesOrderService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SalesOrder> getEntityClass() {
		return SalesOrder.class;
	}

	/**
	 * Find by reference: docType
	 */
	public List<SalesOrder> findByDocType(TxDocType docType) {
		return this.findByDocTypeId(docType.getId());
	}

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<SalesOrder> findByDocTypeId(Long docTypeId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.docType.id = :pDocTypeId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDocTypeId", docTypeId).getResultList();
	}

	/**
	 * Find by reference: customer
	 */
	public List<SalesOrder> findByCustomer(BusinessPartner customer) {
		return this.findByCustomerId(customer.getId());
	}

	/**
	 * Find by ID of reference: customer.id
	 */
	public List<SalesOrder> findByCustomerId(Long customerId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.customer.id = :pCustomerId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustomerId", customerId).getResultList();
	}

	/**
	 * Find by reference: supplier
	 */
	public List<SalesOrder> findBySupplier(Organization supplier) {
		return this.findBySupplierId(supplier.getId());
	}

	/**
	 * Find by ID of reference: supplier.id
	 */
	public List<SalesOrder> findBySupplierId(Long supplierId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.supplier.id = :pSupplierId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSupplierId", supplierId).getResultList();
	}

	/**
	 * Find by reference: priceList
	 */
	public List<SalesOrder> findByPriceList(PriceList priceList) {
		return this.findByPriceListId(priceList.getId());
	}

	/**
	 * Find by ID of reference: priceList.id
	 */
	public List<SalesOrder> findByPriceListId(Long priceListId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.priceList.id = :pPriceListId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPriceListId", priceListId).getResultList();
	}

	/**
	 * Find by reference: currency
	 */
	public List<SalesOrder> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<SalesOrder> findByCurrencyId(Long currencyId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCurrencyId", currencyId).getResultList();
	}

	/**
	 * Find by reference: paymentMethod
	 */
	public List<SalesOrder> findByPaymentMethod(PaymentMethod paymentMethod) {
		return this.findByPaymentMethodId(paymentMethod.getId());
	}

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<SalesOrder> findByPaymentMethodId(Long paymentMethodId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentMethodId", paymentMethodId)
				.getResultList();
	}

	/**
	 * Find by reference: paymentTerm
	 */
	public List<SalesOrder> findByPaymentTerm(PaymentTerm paymentTerm) {
		return this.findByPaymentTermId(paymentTerm.getId());
	}

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<SalesOrder> findByPaymentTermId(Long paymentTermId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.paymentTerm.id = :pPaymentTermId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentTermId", paymentTermId).getResultList();
	}

	/**
	 * Find by reference: inventory
	 */
	public List<SalesOrder> findByInventory(Organization inventory) {
		return this.findByInventoryId(inventory.getId());
	}

	/**
	 * Find by ID of reference: inventory.id
	 */
	public List<SalesOrder> findByInventoryId(Long inventoryId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.inventory.id = :pInventoryId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pInventoryId", inventoryId).getResultList();
	}

	/**
	 * Find by reference: deliveryMethod
	 */
	public List<SalesOrder> findByDeliveryMethod(DeliveryMethod deliveryMethod) {
		return this.findByDeliveryMethodId(deliveryMethod.getId());
	}

	/**
	 * Find by ID of reference: deliveryMethod.id
	 */
	public List<SalesOrder> findByDeliveryMethodId(Long deliveryMethodId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.deliveryMethod.id = :pDeliveryMethodId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDeliveryMethodId", deliveryMethodId)
				.getResultList();
	}

	/**
	 * Find by reference: carrier
	 */
	public List<SalesOrder> findByCarrier(Organization carrier) {
		return this.findByCarrierId(carrier.getId());
	}

	/**
	 * Find by ID of reference: carrier.id
	 */
	public List<SalesOrder> findByCarrierId(Long carrierId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.carrier.id = :pCarrierId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCarrierId", carrierId).getResultList();
	}

	/**
	 * Find by reference: billTo
	 */
	public List<SalesOrder> findByBillTo(BusinessPartner billTo) {
		return this.findByBillToId(billTo.getId());
	}

	/**
	 * Find by ID of reference: billTo.id
	 */
	public List<SalesOrder> findByBillToId(Long billToId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.billTo.id = :pBillToId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBillToId", billToId).getResultList();
	}

	/**
	 * Find by reference: billToLocation
	 */
	public List<SalesOrder> findByBillToLocation(Location billToLocation) {
		return this.findByBillToLocationId(billToLocation.getId());
	}

	/**
	 * Find by ID of reference: billToLocation.id
	 */
	public List<SalesOrder> findByBillToLocationId(Long billToLocationId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.billToLocation.id = :pBillToLocationId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBillToLocationId", billToLocationId)
				.getResultList();
	}

	/**
	 * Find by reference: billToContact
	 */
	public List<SalesOrder> findByBillToContact(Contact billToContact) {
		return this.findByBillToContactId(billToContact.getId());
	}

	/**
	 * Find by ID of reference: billToContact.id
	 */
	public List<SalesOrder> findByBillToContactId(Long billToContactId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.billToContact.id = :pBillToContactId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBillToContactId", billToContactId)
				.getResultList();
	}

	/**
	 * Find by reference: shipTo
	 */
	public List<SalesOrder> findByShipTo(BusinessPartner shipTo) {
		return this.findByShipToId(shipTo.getId());
	}

	/**
	 * Find by ID of reference: shipTo.id
	 */
	public List<SalesOrder> findByShipToId(Long shipToId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.shipTo.id = :pShipToId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pShipToId", shipToId).getResultList();
	}

	/**
	 * Find by reference: shipToLocation
	 */
	public List<SalesOrder> findByShipToLocation(Location shipToLocation) {
		return this.findByShipToLocationId(shipToLocation.getId());
	}

	/**
	 * Find by ID of reference: shipToLocation.id
	 */
	public List<SalesOrder> findByShipToLocationId(Long shipToLocationId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.shipToLocation.id = :pShipToLocationId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pShipToLocationId", shipToLocationId)
				.getResultList();
	}

	/**
	 * Find by reference: shipToContact
	 */
	public List<SalesOrder> findByShipToContact(Contact shipToContact) {
		return this.findByShipToContactId(shipToContact.getId());
	}

	/**
	 * Find by ID of reference: shipToContact.id
	 */
	public List<SalesOrder> findByShipToContactId(Long shipToContactId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select e from SalesOrder e where e.clientId = :pClientId and e.shipToContact.id = :pShipToContactId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pShipToContactId", shipToContactId)
				.getResultList();
	}

	/**
	 * Find by reference: lines
	 */
	public List<SalesOrder> findByLines(SalesOrderItem lines) {
		return this.findByLinesId(lines.getId());
	}

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<SalesOrder> findByLinesId(Long linesId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select distinct e from SalesOrder e, IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLinesId", linesId).getResultList();
	}

	/**
	 * Find by reference: taxes
	 */
	public List<SalesOrder> findByTaxes(SalesOrderTax taxes) {
		return this.findByTaxesId(taxes.getId());
	}

	/**
	 * Find by ID of reference: taxes.id
	 */
	public List<SalesOrder> findByTaxesId(Long taxesId) {
		return (List<SalesOrder>) this.em
				.createQuery(
						"select distinct e from SalesOrder e, IN (e.taxes) c where e.clientId = :pClientId and c.id = :pTaxesId",
						SalesOrder.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxesId", taxesId).getResultList();
	}
}
