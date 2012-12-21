/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;

/** Data-provider for a standalone receivables overview */
@Ds(entity = SalesTxAmount.class)
public class SalesTxAmountOverviewDs extends AbstractAuditableDs<SalesTxAmount> {

	public static final String f_supplierId = "supplierId";
	public static final String f_supplier = "supplier";
	public static final String f_customerId = "customerId";
	public static final String f_customerCode = "customerCode";
	public static final String f_customer = "customer";
	public static final String f_invoiceId = "invoiceId";
	public static final String f_invoiceCode = "invoiceCode";
	public static final String f_invoiceDocNo = "invoiceDocNo";
	public static final String f_invoiceDocDate = "invoiceDocDate";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";
	public static final String f_orderId = "orderId";
	public static final String f_dueDate = "dueDate";
	public static final String f_dueInDays = "dueInDays";
	public static final String f_dueAmount = "dueAmount";
	public static final String f_payedAmount = "payedAmount";
	public static final String f_outstandingAmount = "outstandingAmount";
	public static final String f_paymentMethodId = "paymentMethodId";
	public static final String f_paymentMethod = "paymentMethod";

	@DsField(join = "left", path = "org.id")
	private Long supplierId;

	@DsField(join = "left", path = "org.code")
	private String supplier;

	@DsField(join = "left", path = "bpartner.id")
	private Long customerId;

	@DsField(join = "left", path = "bpartner.code")
	private String customerCode;

	@DsField(join = "left", path = "bpartner.name")
	private String customer;

	@DsField(join = "left", path = "invoice.id")
	private Long invoiceId;

	@DsField(join = "left", path = "invoice.code")
	private String invoiceCode;

	@DsField(join = "left", path = "invoice.docNo")
	private String invoiceDocNo;

	@DsField(join = "left", path = "invoice.docDate")
	private Date invoiceDocDate;

	@DsField(join = "left", path = "currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currency;

	@DsField(join = "left", path = "order.id")
	private Long orderId;

	@DsField
	private Date dueDate;

	@DsField(fetch = false)
	private Integer dueInDays;

	@DsField
	private Float dueAmount;

	@DsField
	private Float payedAmount;

	@DsField(path = "amount")
	private Float outstandingAmount;

	@DsField(join = "left", path = "paymentMethod.id")
	private Long paymentMethodId;

	@DsField(join = "left", path = "paymentMethod.name")
	private String paymentMethod;

	public SalesTxAmountOverviewDs() {
		super();
	}

	public SalesTxAmountOverviewDs(SalesTxAmount e) {
		super(e);
	}

	public Long getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Long getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceCode() {
		return this.invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public String getInvoiceDocNo() {
		return this.invoiceDocNo;
	}

	public void setInvoiceDocNo(String invoiceDocNo) {
		this.invoiceDocNo = invoiceDocNo;
	}

	public Date getInvoiceDocDate() {
		return this.invoiceDocDate;
	}

	public void setInvoiceDocDate(Date invoiceDocDate) {
		this.invoiceDocDate = invoiceDocDate;
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

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Integer getDueInDays() {
		return this.dueInDays;
	}

	public void setDueInDays(Integer dueInDays) {
		this.dueInDays = dueInDays;
	}

	public Float getDueAmount() {
		return this.dueAmount;
	}

	public void setDueAmount(Float dueAmount) {
		this.dueAmount = dueAmount;
	}

	public Float getPayedAmount() {
		return this.payedAmount;
	}

	public void setPayedAmount(Float payedAmount) {
		this.payedAmount = payedAmount;
	}

	public Float getOutstandingAmount() {
		return this.outstandingAmount;
	}

	public void setOutstandingAmount(Float outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
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
}
