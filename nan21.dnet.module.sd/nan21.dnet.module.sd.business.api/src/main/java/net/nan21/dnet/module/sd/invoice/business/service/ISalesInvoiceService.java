/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.geo.domain.entity.Location;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.bp.domain.entity.Contact;
import net.nan21.dnet.module.md.mm.price.domain.entity.PriceList;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceTax;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrder;

/**
 * Interface to expose business functions specific for {@link SalesInvoice} domain
 * entity.
 */
public interface ISalesInvoiceService extends IEntityService<SalesInvoice> {

	public void doConfirm(SalesInvoice invoice) throws BusinessException;

	public void doUnConfirm(SalesInvoice invoice) throws BusinessException;

	public void doPost(SalesInvoice invoice) throws BusinessException;

	public void doUnPost(SalesInvoice invoice) throws BusinessException;

	/**
	 * Find by reference: priceList
	 */
	public List<SalesInvoice> findByPriceList(PriceList priceList);

	/**
	 * Find by ID of reference: priceList.id
	 */
	public List<SalesInvoice> findByPriceListId(Long priceListId);

	/**
	 * Find by reference: currency
	 */
	public List<SalesInvoice> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<SalesInvoice> findByCurrencyId(Long currencyId);

	/**
	 * Find by reference: paymentMethod
	 */
	public List<SalesInvoice> findByPaymentMethod(PaymentMethod paymentMethod);

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<SalesInvoice> findByPaymentMethodId(Long paymentMethodId);

	/**
	 * Find by reference: paymentTerm
	 */
	public List<SalesInvoice> findByPaymentTerm(PaymentTerm paymentTerm);

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<SalesInvoice> findByPaymentTermId(Long paymentTermId);

	/**
	 * Find by reference: docType
	 */
	public List<SalesInvoice> findByDocType(TxDocType docType);

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<SalesInvoice> findByDocTypeId(Long docTypeId);

	/**
	 * Find by reference: customer
	 */
	public List<SalesInvoice> findByCustomer(BusinessPartner customer);

	/**
	 * Find by ID of reference: customer.id
	 */
	public List<SalesInvoice> findByCustomerId(Long customerId);

	/**
	 * Find by reference: billToLocation
	 */
	public List<SalesInvoice> findByBillToLocation(Location billToLocation);

	/**
	 * Find by ID of reference: billToLocation.id
	 */
	public List<SalesInvoice> findByBillToLocationId(Long billToLocationId);

	/**
	 * Find by reference: billToContact
	 */
	public List<SalesInvoice> findByBillToContact(Contact billToContact);

	/**
	 * Find by ID of reference: billToContact.id
	 */
	public List<SalesInvoice> findByBillToContactId(Long billToContactId);

	/**
	 * Find by reference: supplier
	 */
	public List<SalesInvoice> findBySupplier(Organization supplier);

	/**
	 * Find by ID of reference: supplier.id
	 */
	public List<SalesInvoice> findBySupplierId(Long supplierId);

	/**
	 * Find by reference: salesOrder
	 */
	public List<SalesInvoice> findBySalesOrder(SalesOrder salesOrder);

	/**
	 * Find by ID of reference: salesOrder.id
	 */
	public List<SalesInvoice> findBySalesOrderId(Long salesOrderId);

	/**
	 * Find by reference: lines
	 */
	public List<SalesInvoice> findByLines(SalesInvoiceItem lines);

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<SalesInvoice> findByLinesId(Long linesId);

	/**
	 * Find by reference: taxes
	 */
	public List<SalesInvoice> findByTaxes(SalesInvoiceTax taxes);

	/**
	 * Find by ID of reference: taxes.id
	 */
	public List<SalesInvoice> findByTaxesId(Long taxesId);
}
