/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.currency.domain.entity.Currency;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentTerm;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md.org.domain.entity.FinancialAccount;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoice;

@Ds(entity = PurchaseInvoice.class, sort = {@SortField(field = PurchaseInvoiceDs.f_docDate, desc = true)})
@RefLookups({
		@RefLookup(refId = PurchaseInvoiceDs.f_currencyId, namedQuery = Currency.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PurchaseInvoiceDs.f_currency)}),
		@RefLookup(refId = PurchaseInvoiceDs.f_paymentMethodId, namedQuery = PaymentMethod.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PurchaseInvoiceDs.f_paymentMethod)}),
		@RefLookup(refId = PurchaseInvoiceDs.f_paymentTermId, namedQuery = PaymentTerm.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PurchaseInvoiceDs.f_paymentTerm)}),
		@RefLookup(refId = PurchaseInvoiceDs.f_docTypeId, namedQuery = TxDocType.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PurchaseInvoiceDs.f_docType)}),
		@RefLookup(refId = PurchaseInvoiceDs.f_supplierId, namedQuery = BusinessPartner.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PurchaseInvoiceDs.f_supplier)}),
		@RefLookup(refId = PurchaseInvoiceDs.f_customerId, namedQuery = Organization.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PurchaseInvoiceDs.f_customer)}),
		@RefLookup(refId = PurchaseInvoiceDs.f_fromAccountId, namedQuery = FinancialAccount.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PurchaseInvoiceDs.f_fromAccount)})})
public class PurchaseInvoiceDs extends AbstractAuditableDs<PurchaseInvoice> {

	public static final String f_code = "code";
	public static final String f_docNo = "docNo";
	public static final String f_docDate = "docDate";
	public static final String f_customerId = "customerId";
	public static final String f_customer = "customer";
	public static final String f_supplierId = "supplierId";
	public static final String f_supplierUuid = "supplierUuid";
	public static final String f_supplierCode = "supplierCode";
	public static final String f_supplier = "supplier";
	public static final String f_docTypeId = "docTypeId";
	public static final String f_docType = "docType";
	public static final String f_description = "description";
	public static final String f_paymentMethodId = "paymentMethodId";
	public static final String f_paymentMethod = "paymentMethod";
	public static final String f_paymentMethodType = "paymentMethodType";
	public static final String f_paymentTermId = "paymentTermId";
	public static final String f_paymentTerm = "paymentTerm";
	public static final String f_selfPayed = "selfPayed";
	public static final String f_fromAccountId = "fromAccountId";
	public static final String f_fromAccount = "fromAccount";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";
	public static final String f_totalNetAmount = "totalNetAmount";
	public static final String f_totalTaxAmount = "totalTaxAmount";
	public static final String f_totalAmount = "totalAmount";
	public static final String f_confirmed = "confirmed";
	public static final String f_posted = "posted";
	public static final String f_purchaseOrderId = "purchaseOrderId";
	public static final String f_className = "className";
	public static final String f_businessObject = "businessObject";

	@DsField(noUpdate = true)
	private String code;

	@DsField
	private String docNo;

	@DsField
	private Date docDate;

	@DsField(noUpdate = true, join = "left", path = "customer.id")
	private Long customerId;

	@DsField(noUpdate = true, join = "left", path = "customer.code")
	private String customer;

	@DsField(noUpdate = true, join = "left", path = "supplier.id")
	private Long supplierId;

	@DsField(noUpdate = true, join = "left", path = "supplier.uuid")
	private String supplierUuid;

	@DsField(noUpdate = true, join = "left", path = "supplier.code")
	private String supplierCode;

	@DsField(noUpdate = true, join = "left", path = "supplier.name")
	private String supplier;

	@DsField(join = "left", path = "docType.id")
	private Long docTypeId;

	@DsField(join = "left", path = "docType.name")
	private String docType;

	@DsField
	private String description;

	@DsField(join = "left", path = "paymentMethod.id")
	private Long paymentMethodId;

	@DsField(join = "left", path = "paymentMethod.name")
	private String paymentMethod;

	@DsField(join = "left", path = "paymentMethod.type")
	private String paymentMethodType;

	@DsField(join = "left", path = "paymentTerm.id")
	private Long paymentTermId;

	@DsField(join = "left", path = "paymentTerm.name")
	private String paymentTerm;

	@DsField
	private Boolean selfPayed;

	@DsField(join = "left", path = "fromAccount.id")
	private Long fromAccountId;

	@DsField(join = "left", path = "fromAccount.name")
	private String fromAccount;

	@DsField(join = "left", path = "currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currency;

	@DsField
	private Float totalNetAmount;

	@DsField
	private Float totalTaxAmount;

	@DsField
	private Float totalAmount;

	@DsField
	private Boolean confirmed;

	@DsField
	private Boolean posted;

	@DsField(join = "left", path = "purchaseOrder.id")
	private Long purchaseOrderId;

	@DsField(fetch = false)
	private String className;

	@DsField(fetch = false)
	private String businessObject;

	public PurchaseInvoiceDs() {
		super();
	}

	public PurchaseInvoiceDs(PurchaseInvoice e) {
		super(e);
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDocNo() {
		return this.docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public Date getDocDate() {
		return this.docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Long getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierUuid() {
		return this.supplierUuid;
	}

	public void setSupplierUuid(String supplierUuid) {
		this.supplierUuid = supplierUuid;
	}

	public String getSupplierCode() {
		return this.supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Long getDocTypeId() {
		return this.docTypeId;
	}

	public void setDocTypeId(Long docTypeId) {
		this.docTypeId = docTypeId;
	}

	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPaymentMethodId() {
		return this.paymentMethodId;
	}

	public void setPaymentMethodId(Long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentMethodType() {
		return this.paymentMethodType;
	}

	public void setPaymentMethodType(String paymentMethodType) {
		this.paymentMethodType = paymentMethodType;
	}

	public Long getPaymentTermId() {
		return this.paymentTermId;
	}

	public void setPaymentTermId(Long paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getPaymentTerm() {
		return this.paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public Boolean getSelfPayed() {
		return this.selfPayed;
	}

	public void setSelfPayed(Boolean selfPayed) {
		this.selfPayed = selfPayed;
	}

	public Long getFromAccountId() {
		return this.fromAccountId;
	}

	public void setFromAccountId(Long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getFromAccount() {
		return this.fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Long getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Float getTotalNetAmount() {
		return this.totalNetAmount;
	}

	public void setTotalNetAmount(Float totalNetAmount) {
		this.totalNetAmount = totalNetAmount;
	}

	public Float getTotalTaxAmount() {
		return this.totalTaxAmount;
	}

	public void setTotalTaxAmount(Float totalTaxAmount) {
		this.totalTaxAmount = totalTaxAmount;
	}

	public Float getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Boolean getConfirmed() {
		return this.confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Boolean getPosted() {
		return this.posted;
	}

	public void setPosted(Boolean posted) {
		this.posted = posted;
	}

	public Long getPurchaseOrderId() {
		return this.purchaseOrderId;
	}

	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getBusinessObject() {
		return this.businessObject;
	}

	public void setBusinessObject(String businessObject) {
		this.businessObject = businessObject;
	}
}
