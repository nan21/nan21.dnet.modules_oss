/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesTxAmount;

@Ds(entity = SalesTxAmount.class, jpqlWhere = " e.amount <> 0")
public class SalesTxAmountPaymentProposalDs
		extends
			AbstractAuditableDs<SalesTxAmount> {

	public static final String f_bpartnerId = "bpartnerId";
	public static final String f_orgId = "orgId";
	public static final String f_invoiceId = "invoiceId";
	public static final String f_invoiceCode = "invoiceCode";
	public static final String f_invoiceDocDate = "invoiceDocDate";
	public static final String f_invoiceDocNo = "invoiceDocNo";
	public static final String f_orderId = "orderId";
	public static final String f_orderCode = "orderCode";
	public static final String f_orderDocDate = "orderDocDate";
	public static final String f_orderDocNo = "orderDocNo";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";
	public static final String f_dueDate = "dueDate";
	public static final String f_dueAmount = "dueAmount";
	public static final String f_payedAmount = "payedAmount";
	public static final String f_outstandingAmount = "outstandingAmount";
	public static final String f_currentPayment = "currentPayment";
	public static final String f_remainingAmount = "remainingAmount";
	public static final String f_paymentMethodId = "paymentMethodId";
	public static final String f_paymentMethod = "paymentMethod";

	@DsField(join = "left", path = "bpartner.id")
	private Long bpartnerId;

	@DsField(join = "left", path = "org.id")
	private Long orgId;

	@DsField(join = "left", path = "invoice.id")
	private Long invoiceId;

	@DsField(join = "left", path = "invoice.code")
	private String invoiceCode;

	@DsField(join = "left", path = "invoice.docDate")
	private Date invoiceDocDate;

	@DsField(join = "left", path = "invoice.docNo")
	private String invoiceDocNo;

	@DsField(join = "left", path = "order.id")
	private Long orderId;

	@DsField(join = "left", path = "order.code")
	private String orderCode;

	@DsField(join = "left", path = "order.docDate")
	private Date orderDocDate;

	@DsField(join = "left", path = "order.docNo")
	private String orderDocNo;

	@DsField(join = "left", path = "currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currency;

	@DsField
	private Date dueDate;

	@DsField
	private Float dueAmount;

	@DsField
	private Float payedAmount;

	@DsField(path = "amount")
	private Float outstandingAmount;

	@DsField(path = "amount")
	private Float currentPayment;

	@DsField(path = "amount")
	private Float remainingAmount;

	@DsField(join = "left", path = "paymentMethod.id")
	private Long paymentMethodId;

	@DsField(join = "left", path = "paymentMethod.name")
	private String paymentMethod;

	public SalesTxAmountPaymentProposalDs() {
		super();
	}

	public SalesTxAmountPaymentProposalDs(SalesTxAmount e) {
		super(e);
	}

	public Long getBpartnerId() {
		return this.bpartnerId;
	}

	public void setBpartnerId(Long bpartnerId) {
		this.bpartnerId = bpartnerId;
	}

	public Long getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
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

	public Date getInvoiceDocDate() {
		return this.invoiceDocDate;
	}

	public void setInvoiceDocDate(Date invoiceDocDate) {
		this.invoiceDocDate = invoiceDocDate;
	}

	public String getInvoiceDocNo() {
		return this.invoiceDocNo;
	}

	public void setInvoiceDocNo(String invoiceDocNo) {
		this.invoiceDocNo = invoiceDocNo;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public Date getOrderDocDate() {
		return this.orderDocDate;
	}

	public void setOrderDocDate(Date orderDocDate) {
		this.orderDocDate = orderDocDate;
	}

	public String getOrderDocNo() {
		return this.orderDocNo;
	}

	public void setOrderDocNo(String orderDocNo) {
		this.orderDocNo = orderDocNo;
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

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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

	public Float getCurrentPayment() {
		return this.currentPayment;
	}

	public void setCurrentPayment(Float currentPayment) {
		this.currentPayment = currentPayment;
	}

	public Float getRemainingAmount() {
		return this.remainingAmount;
	}

	public void setRemainingAmount(Float remainingAmount) {
		this.remainingAmount = remainingAmount;
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
