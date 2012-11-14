/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.order.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.DeliveryMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

/**
 * Interface to expose business functions specific for {@link PurchaseOrder} domain
 * entity.
 */
public interface IPurchaseOrderService extends IEntityService<PurchaseOrder> {

	/**
	 * Find by reference: docType
	 */
	public List<PurchaseOrder> findByDocType(TxDocType docType);

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<PurchaseOrder> findByDocTypeId(Long docTypeId);

	/**
	 * Find by reference: supplier
	 */
	public List<PurchaseOrder> findBySupplier(BusinessPartner supplier);

	/**
	 * Find by ID of reference: supplier.id
	 */
	public List<PurchaseOrder> findBySupplierId(Long supplierId);

	/**
	 * Find by reference: customer
	 */
	public List<PurchaseOrder> findByCustomer(Organization customer);

	/**
	 * Find by ID of reference: customer.id
	 */
	public List<PurchaseOrder> findByCustomerId(Long customerId);

	/**
	 * Find by reference: priceList
	 */
	public List<PurchaseOrder> findByPriceList(PriceList priceList);

	/**
	 * Find by ID of reference: priceList.id
	 */
	public List<PurchaseOrder> findByPriceListId(Long priceListId);

	/**
	 * Find by reference: currency
	 */
	public List<PurchaseOrder> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<PurchaseOrder> findByCurrencyId(Long currencyId);

	/**
	 * Find by reference: paymentMethod
	 */
	public List<PurchaseOrder> findByPaymentMethod(PaymentMethod paymentMethod);

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<PurchaseOrder> findByPaymentMethodId(Long paymentMethodId);

	/**
	 * Find by reference: paymentTerm
	 */
	public List<PurchaseOrder> findByPaymentTerm(PaymentTerm paymentTerm);

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<PurchaseOrder> findByPaymentTermId(Long paymentTermId);

	/**
	 * Find by reference: inventory
	 */
	public List<PurchaseOrder> findByInventory(Organization inventory);

	/**
	 * Find by ID of reference: inventory.id
	 */
	public List<PurchaseOrder> findByInventoryId(Long inventoryId);

	/**
	 * Find by reference: deliveryMethod
	 */
	public List<PurchaseOrder> findByDeliveryMethod(
			DeliveryMethod deliveryMethod);

	/**
	 * Find by ID of reference: deliveryMethod.id
	 */
	public List<PurchaseOrder> findByDeliveryMethodId(Long deliveryMethodId);

	/**
	 * Find by reference: lines
	 */
	public List<PurchaseOrder> findByLines(PurchaseOrderItem lines);

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<PurchaseOrder> findByLinesId(Long linesId);
}
