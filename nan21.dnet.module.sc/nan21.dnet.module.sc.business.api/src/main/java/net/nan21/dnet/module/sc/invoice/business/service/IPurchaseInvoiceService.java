/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.sc.invoice.business.service;

import java.util.List;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IEntityService;
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
 * Interface to expose business functions specific for {@link PurchaseInvoice} domain
 * entity.
 */
public interface IPurchaseInvoiceService
		extends
			IEntityService<PurchaseInvoice> {

	public void doConfirm(PurchaseInvoice invoice) throws BusinessException;

	public void doUnConfirm(PurchaseInvoice invoice) throws BusinessException;

	public void doPost(PurchaseInvoice invoice) throws BusinessException;

	public void doUnPost(PurchaseInvoice invoice) throws BusinessException;

	public void doCopyLines(PurchaseInvoice target, Long sourceId)
			throws BusinessException;

	public void calculateAmounts(Long invoiceId) throws BusinessException;

	/**
	 * Find by unique key
	 */
	public PurchaseInvoice findByCode(String code);

	/**
	 * Find by reference: docType
	 */
	public List<PurchaseInvoice> findByDocType(TxDocType docType);

	/**
	 * Find by ID of reference: docType.id
	 */
	public List<PurchaseInvoice> findByDocTypeId(Long docTypeId);

	/**
	 * Find by reference: supplier
	 */
	public List<PurchaseInvoice> findBySupplier(BusinessPartner supplier);

	/**
	 * Find by ID of reference: supplier.id
	 */
	public List<PurchaseInvoice> findBySupplierId(Long supplierId);

	/**
	 * Find by reference: customer
	 */
	public List<PurchaseInvoice> findByCustomer(Organization customer);

	/**
	 * Find by ID of reference: customer.id
	 */
	public List<PurchaseInvoice> findByCustomerId(Long customerId);

	/**
	 * Find by reference: currency
	 */
	public List<PurchaseInvoice> findByCurrency(Currency currency);

	/**
	 * Find by ID of reference: currency.id
	 */
	public List<PurchaseInvoice> findByCurrencyId(Long currencyId);

	/**
	 * Find by reference: paymentMethod
	 */
	public List<PurchaseInvoice> findByPaymentMethod(PaymentMethod paymentMethod);

	/**
	 * Find by ID of reference: paymentMethod.id
	 */
	public List<PurchaseInvoice> findByPaymentMethodId(Long paymentMethodId);

	/**
	 * Find by reference: paymentTerm
	 */
	public List<PurchaseInvoice> findByPaymentTerm(PaymentTerm paymentTerm);

	/**
	 * Find by ID of reference: paymentTerm.id
	 */
	public List<PurchaseInvoice> findByPaymentTermId(Long paymentTermId);

	/**
	 * Find by reference: fromAccount
	 */
	public List<PurchaseInvoice> findByFromAccount(FinancialAccount fromAccount);

	/**
	 * Find by ID of reference: fromAccount.id
	 */
	public List<PurchaseInvoice> findByFromAccountId(Long fromAccountId);

	/**
	 * Find by reference: purchaseOrder
	 */
	public List<PurchaseInvoice> findByPurchaseOrder(PurchaseOrder purchaseOrder);

	/**
	 * Find by ID of reference: purchaseOrder.id
	 */
	public List<PurchaseInvoice> findByPurchaseOrderId(Long purchaseOrderId);

	/**
	 * Find by reference: lines
	 */
	public List<PurchaseInvoice> findByLines(PurchaseInvoiceItem lines);

	/**
	 * Find by ID of reference: lines.id
	 */
	public List<PurchaseInvoice> findByLinesId(Long linesId);

	/**
	 * Find by reference: taxes
	 */
	public List<PurchaseInvoice> findByTaxes(PurchaseInvoiceTax taxes);

	/**
	 * Find by ID of reference: taxes.id
	 */
	public List<PurchaseInvoice> findByTaxesId(Long taxesId);
}
