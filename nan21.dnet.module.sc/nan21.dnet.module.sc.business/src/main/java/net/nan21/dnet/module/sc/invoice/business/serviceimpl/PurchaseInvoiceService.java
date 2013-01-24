/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.serviceimpl;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceTax;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrder;

/**
 * Repository functionality for {@link PurchaseInvoice} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class PurchaseInvoiceService
		extends
			AbstractEntityService<PurchaseInvoice> {

	public PurchaseInvoiceService() {
		super();
	}

	public PurchaseInvoiceService(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<PurchaseInvoice> getEntityClass() {
		return PurchaseInvoice.class;
	}

	/**
	 * Find by unique key
	 */
	public PurchaseInvoice findByCode(String code) {
		return (PurchaseInvoice) this.getEntityManager()
				.createNamedQuery(PurchaseInvoice.NQ_FIND_BY_CODE)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCode", code).getSingleResult();
	}

	/**
	 * Find by reference: docType
	 */
	public List<PurchaseInvoice> findByDocType(TxDocType docType) {
		return this.findByDocTypeId(docType.getId());
	}

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<PurchaseInvoice> findByDocTypeId(Long docTypeId) {
		return (List<PurchaseInvoice>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoice e where e.clientId = :pClientId and e.docType.id = :pDocTypeId",
						PurchaseInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pDocTypeId", docTypeId).getResultList();
	}

	/**
	 * Find by reference: supplier
	 */
	public List<PurchaseInvoice> findBySupplier(BusinessPartner supplier) {
		return this.findBySupplierId(supplier.getId());
	}

	/**
	 * Find by ID of reference: supplier.id
	 */
	public List<PurchaseInvoice> findBySupplierId(Long supplierId) {
		return (List<PurchaseInvoice>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoice e where e.clientId = :pClientId and e.supplier.id = :pSupplierId",
						PurchaseInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pSupplierId", supplierId).getResultList();
	}

	/**
	 * Find by reference: customer
	 */
	public List<PurchaseInvoice> findByCustomer(Organization customer) {
		return this.findByCustomerId(customer.getId());
	}

	/**
	 * Find by ID of reference: customer.id
	 */
	public List<PurchaseInvoice> findByCustomerId(Long customerId) {
		return (List<PurchaseInvoice>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoice e where e.clientId = :pClientId and e.customer.id = :pCustomerId",
						PurchaseInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCustomerId", customerId).getResultList();
	}

	/**
	 * Find by reference: currency
	 */
	public List<PurchaseInvoice> findByCurrency(Currency currency) {
		return this.findByCurrencyId(currency.getId());
	}

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<PurchaseInvoice> findByCurrencyId(Long currencyId) {
		return (List<PurchaseInvoice>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoice e where e.clientId = :pClientId and e.currency.id = :pCurrencyId",
						PurchaseInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pCurrencyId", currencyId).getResultList();
	}

	/**
	 * Find by reference: paymentMethod
	 */
	public List<PurchaseInvoice> findByPaymentMethod(PaymentMethod paymentMethod) {
		return this.findByPaymentMethodId(paymentMethod.getId());
	}

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<PurchaseInvoice> findByPaymentMethodId(Long paymentMethodId) {
		return (List<PurchaseInvoice>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoice e where e.clientId = :pClientId and e.paymentMethod.id = :pPaymentMethodId",
						PurchaseInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentMethodId", paymentMethodId)
				.getResultList();
	}

	/**
	 * Find by reference: paymentTerm
	 */
	public List<PurchaseInvoice> findByPaymentTerm(PaymentTerm paymentTerm) {
		return this.findByPaymentTermId(paymentTerm.getId());
	}

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<PurchaseInvoice> findByPaymentTermId(Long paymentTermId) {
		return (List<PurchaseInvoice>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoice e where e.clientId = :pClientId and e.paymentTerm.id = :pPaymentTermId",
						PurchaseInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPaymentTermId", paymentTermId).getResultList();
	}

	/**
	 * Find by reference: fromAccount
	 */
	public List<PurchaseInvoice> findByFromAccount(FinancialAccount fromAccount) {
		return this.findByFromAccountId(fromAccount.getId());
	}

	/**
	 * Find by ID of reference: fromAccount.id
	 */
	public List<PurchaseInvoice> findByFromAccountId(Long fromAccountId) {
		return (List<PurchaseInvoice>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoice e where e.clientId = :pClientId and e.fromAccount.id = :pFromAccountId",
						PurchaseInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pFromAccountId", fromAccountId).getResultList();
	}

	/**
	 * Find by reference: purchaseOrder
	 */
	public List<PurchaseInvoice> findByPurchaseOrder(PurchaseOrder purchaseOrder) {
		return this.findByPurchaseOrderId(purchaseOrder.getId());
	}

	/**
	 * Find by ID of reference: purchaseOrder.id
	 */
	public List<PurchaseInvoice> findByPurchaseOrderId(Long purchaseOrderId) {
		return (List<PurchaseInvoice>) this
				.getEntityManager()
				.createQuery(
						"select e from PurchaseInvoice e where e.clientId = :pClientId and e.purchaseOrder.id = :pPurchaseOrderId",
						PurchaseInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pPurchaseOrderId", purchaseOrderId)
				.getResultList();
	}

	/**
	 * Find by reference: lines
	 */
	public List<PurchaseInvoice> findByLines(PurchaseInvoiceItem lines) {
		return this.findByLinesId(lines.getId());
	}

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<PurchaseInvoice> findByLinesId(Long linesId) {
		return (List<PurchaseInvoice>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from PurchaseInvoice e, IN (e.lines) c where e.clientId = :pClientId and c.id = :pLinesId",
						PurchaseInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pLinesId", linesId).getResultList();
	}

	/**
	 * Find by reference: taxes
	 */
	public List<PurchaseInvoice> findByTaxes(PurchaseInvoiceTax taxes) {
		return this.findByTaxesId(taxes.getId());
	}

	/**
	 * Find by ID of reference: taxes.id
	 */
	public List<PurchaseInvoice> findByTaxesId(Long taxesId) {
		return (List<PurchaseInvoice>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from PurchaseInvoice e, IN (e.taxes) c where e.clientId = :pClientId and c.id = :pTaxesId",
						PurchaseInvoice.class)
				.setParameter("pClientId", Session.user.get().getClientId())
				.setParameter("pTaxesId", taxesId).getResultList();
	}
}
