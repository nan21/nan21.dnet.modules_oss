/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sd.invoice.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
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
 * Repository functionality for {@link SalesInvoice} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class SalesInvoiceService extends AbstractEntityService<SalesInvoice> {

	public SalesInvoiceService() {
		super();
	}

	public SalesInvoiceService(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Class<SalesInvoice> getEntityClass() {
		return SalesInvoice.class;
	}

	/**
	 * Find by unique key
	 */
	public SalesInvoice findByCode(String code) {
		return (SalesInvoice) this.em
				.createNamedQuery(SalesInvoice.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by reference: priceList
	 */
	public List<SalesInvoice> findByPriceList(PriceList priceList) {
		return this.findByPriceListId(priceList.getId());
	}

	/**
	 * Find by ID of reference: priceList.id
	 */
	public List<SalesInvoice> findByPriceListId(Long priceListId) {
		return (List<SalesInvoice>) this.em
				.createQuery(
						"select e from SalesInvoice e where e.clientId = :pClientId and e.priceList.id = :pPriceListId",
						SalesInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPriceListId", priceListId).getResultList();
	}

	/**
	 * Find by reference: currency
	 */
	public List<SalesInvoice> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<SalesInvoice> findByCurrencyId(Long currencyId) {
		return (List<SalesInvoice>) this.em
				.createQuery(
						"select e from SalesInvoice e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
						SalesInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCurrencyId", currencyId).getResultList();
	}

	/**
	 * Find by reference: paymentMethod
	 */
	public List<SalesInvoice> findByPaymentMethod(PaymentMethod paymentMethod) {
		return this.findByPaymentMethodId(paymentMethod.getId());
	}

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<SalesInvoice> findByPaymentMethodId(Long paymentMethodId) {
		return (List<SalesInvoice>) this.em
				.createQuery(
						"select e from SalesInvoice e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
						SalesInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentMethodId", paymentMethodId)
				.getResultList();
	}

	/**
	 * Find by reference: paymentTerm
	 */
	public List<SalesInvoice> findByPaymentTerm(PaymentTerm paymentTerm) {
		return this.findByPaymentTermId(paymentTerm.getId());
	}

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<SalesInvoice> findByPaymentTermId(Long paymentTermId) {
		return (List<SalesInvoice>) this.em
				.createQuery(
						"select e from SalesInvoice e where e.clientId = :pClientId and e.paymentTerm.id = :pPaymentTermId",
						SalesInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentTermId", paymentTermId).getResultList();
	}

	/**
	 * Find by reference: docType
	 */
	public List<SalesInvoice> findByDocType(TxDocType docType) {
		return this.findByDocTypeId(docType.getId());
	}

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<SalesInvoice> findByDocTypeId(Long docTypeId) {
		return (List<SalesInvoice>) this.em
				.createQuery(
						"select e from SalesInvoice e where e.clientId = :pClientId and e.docType.id = :pDocTypeId",
						SalesInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDocTypeId", docTypeId).getResultList();
	}

	/**
	 * Find by reference: customer
	 */
	public List<SalesInvoice> findByCustomer(BusinessPartner customer) {
		return this.findByCustomerId(customer.getId());
	}

	/**
	 * Find by ID of reference: customer.id
	 */
	public List<SalesInvoice> findByCustomerId(Long customerId) {
		return (List<SalesInvoice>) this.em
				.createQuery(
						"select e from SalesInvoice e where e.clientId = :pClientId and e.customer.id = :pCustomerId",
						SalesInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustomerId", customerId).getResultList();
	}

	/**
	 * Find by reference: billToLocation
	 */
	public List<SalesInvoice> findByBillToLocation(Location billToLocation) {
		return this.findByBillToLocationId(billToLocation.getId());
	}

	/**
	 * Find by ID of reference: billToLocation.id
	 */
	public List<SalesInvoice> findByBillToLocationId(Long billToLocationId) {
		return (List<SalesInvoice>) this.em
				.createQuery(
						"select e from SalesInvoice e where e.clientId = :pClientId and e.billToLocation.id = :pBillToLocationId",
						SalesInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBillToLocationId", billToLocationId)
				.getResultList();
	}

	/**
	 * Find by reference: billToContact
	 */
	public List<SalesInvoice> findByBillToContact(Contact billToContact) {
		return this.findByBillToContactId(billToContact.getId());
	}

	/**
	 * Find by ID of reference: billToContact.id
	 */
	public List<SalesInvoice> findByBillToContactId(Long billToContactId) {
		return (List<SalesInvoice>) this.em
				.createQuery(
						"select e from SalesInvoice e where e.clientId = :pClientId and e.billToContact.id = :pBillToContactId",
						SalesInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pBillToContactId", billToContactId)
				.getResultList();
	}

	/**
	 * Find by reference: supplier
	 */
	public List<SalesInvoice> findBySupplier(Organization supplier) {
		return this.findBySupplierId(supplier.getId());
	}

	/**
	 * Find by ID of reference: supplier.id
	 */
	public List<SalesInvoice> findBySupplierId(Long supplierId) {
		return (List<SalesInvoice>) this.em
				.createQuery(
						"select e from SalesInvoice e where e.clientId = :pClientId and e.supplier.id = :pSupplierId",
						SalesInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSupplierId", supplierId).getResultList();
	}

	/**
	 * Find by reference: salesOrder
	 */
	public List<SalesInvoice> findBySalesOrder(SalesOrder salesOrder) {
		return this.findBySalesOrderId(salesOrder.getId());
	}

	/**
	 * Find by ID of reference: salesOrder.id
	 */
	public List<SalesInvoice> findBySalesOrderId(Long salesOrderId) {
		return (List<SalesInvoice>) this.em
				.createQuery(
						"select e from SalesInvoice e where e.clientId = :pClientId and e.salesOrder.id = :pSalesOrderId",
						SalesInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSalesOrderId", salesOrderId).getResultList();
	}

	/**
	 * Find by reference: lines
	 */
	public List<SalesInvoice> findByLines(SalesInvoiceItem lines) {
		return this.findByLinesId(lines.getId());
	}

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<SalesInvoice> findByLinesId(Long linesId) {
		return (List<SalesInvoice>) this.em
				.createQuery(
						"select distinct e from SalesInvoice e, IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
						SalesInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLinesId", linesId).getResultList();
	}

	/**
	 * Find by reference: taxes
	 */
	public List<SalesInvoice> findByTaxes(SalesInvoiceTax taxes) {
		return this.findByTaxesId(taxes.getId());
	}

	/**
	 * Find by ID of reference: taxes.id
	 */
	public List<SalesInvoice> findByTaxesId(Long taxesId) {
		return (List<SalesInvoice>) this.em
				.createQuery(
						"select distinct e from SalesInvoice e, IN (e.taxes) c where e.clientId = :pClientId and c.id = :pTaxesId",
						SalesInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxesId", taxesId).getResultList();
	}
}
