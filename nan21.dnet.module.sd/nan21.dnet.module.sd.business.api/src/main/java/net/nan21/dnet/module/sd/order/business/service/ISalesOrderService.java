/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.order.business.service;

import java.util.Date;
import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
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
import net.nan21.dnet.module.md.tx.inventory.domain.entity.InvTransactionType;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItem;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderTax;

/**
 * Interface to expose business functions specific for {@link SalesOrder} domain
 * entity.
 */
public interface ISalesOrderService extends IEntityService<SalesOrder> {

	public void doGenerateInvoice(SalesOrder salesOrder, TxDocType invDocType)
			throws BusinessException;

	public void doGenerateDelivery(SalesOrder salesOrder,
			TxDocType deliveryDocType, InvTransactionType delivTxType,
			Date delivEventDate) throws BusinessException;

	/**
	 * Find by reference: docType
	 */
	public List<SalesOrder> findByDocType(TxDocType docType);

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<SalesOrder> findByDocTypeId(Long docTypeId);

	/**
	 * Find by reference: customer
	 */
	public List<SalesOrder> findByCustomer(BusinessPartner customer);

	/**
	 * Find by ID of reference: customer.id
	 */
	public List<SalesOrder> findByCustomerId(Long customerId);

	/**
	 * Find by reference: supplier
	 */
	public List<SalesOrder> findBySupplier(Organization supplier);

	/**
	 * Find by ID of reference: supplier.id
	 */
	public List<SalesOrder> findBySupplierId(Long supplierId);

	/**
	 * Find by reference: priceList
	 */
	public List<SalesOrder> findByPriceList(PriceList priceList);

	/**
	 * Find by ID of reference: priceList.id
	 */
	public List<SalesOrder> findByPriceListId(Long priceListId);

	/**
	 * Find by reference: currency
	 */
	public List<SalesOrder> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<SalesOrder> findByCurrencyId(Long currencyId);

	/**
	 * Find by reference: paymentMethod
	 */
	public List<SalesOrder> findByPaymentMethod(PaymentMethod paymentMethod);

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<SalesOrder> findByPaymentMethodId(Long paymentMethodId);

	/**
	 * Find by reference: paymentTerm
	 */
	public List<SalesOrder> findByPaymentTerm(PaymentTerm paymentTerm);

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<SalesOrder> findByPaymentTermId(Long paymentTermId);

	/**
	 * Find by reference: inventory
	 */
	public List<SalesOrder> findByInventory(Organization inventory);

	/**
	 * Find by ID of reference: inventory.id
	 */
	public List<SalesOrder> findByInventoryId(Long inventoryId);

	/**
	 * Find by reference: deliveryMethod
	 */
	public List<SalesOrder> findByDeliveryMethod(DeliveryMethod deliveryMethod);

	/**
	 * Find by ID of reference: deliveryMethod.id
	 */
	public List<SalesOrder> findByDeliveryMethodId(Long deliveryMethodId);

	/**
	 * Find by reference: carrier
	 */
	public List<SalesOrder> findByCarrier(Organization carrier);

	/**
	 * Find by ID of reference: carrier.id
	 */
	public List<SalesOrder> findByCarrierId(Long carrierId);

	/**
	 * Find by reference: billTo
	 */
	public List<SalesOrder> findByBillTo(BusinessPartner billTo);

	/**
	 * Find by ID of reference: billTo.id
	 */
	public List<SalesOrder> findByBillToId(Long billToId);

	/**
	 * Find by reference: billToLocation
	 */
	public List<SalesOrder> findByBillToLocation(Location billToLocation);

	/**
	 * Find by ID of reference: billToLocation.id
	 */
	public List<SalesOrder> findByBillToLocationId(Long billToLocationId);

	/**
	 * Find by reference: billToContact
	 */
	public List<SalesOrder> findByBillToContact(Contact billToContact);

	/**
	 * Find by ID of reference: billToContact.id
	 */
	public List<SalesOrder> findByBillToContactId(Long billToContactId);

	/**
	 * Find by reference: shipTo
	 */
	public List<SalesOrder> findByShipTo(BusinessPartner shipTo);

	/**
	 * Find by ID of reference: shipTo.id
	 */
	public List<SalesOrder> findByShipToId(Long shipToId);

	/**
	 * Find by reference: shipToLocation
	 */
	public List<SalesOrder> findByShipToLocation(Location shipToLocation);

	/**
	 * Find by ID of reference: shipToLocation.id
	 */
	public List<SalesOrder> findByShipToLocationId(Long shipToLocationId);

	/**
	 * Find by reference: shipToContact
	 */
	public List<SalesOrder> findByShipToContact(Contact shipToContact);

	/**
	 * Find by ID of reference: shipToContact.id
	 */
	public List<SalesOrder> findByShipToContactId(Long shipToContactId);

	/**
	 * Find by reference: lines
	 */
	public List<SalesOrder> findByLines(SalesOrderItem lines);

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<SalesOrder> findByLinesId(Long linesId);

	/**
	 * Find by reference: taxes
	 */
	public List<SalesOrder> findByTaxes(SalesOrderTax taxes);

	/**
	 * Find by ID of reference: taxes.id
	 */
	public List<SalesOrder> findByTaxesId(Long taxesId);
}
