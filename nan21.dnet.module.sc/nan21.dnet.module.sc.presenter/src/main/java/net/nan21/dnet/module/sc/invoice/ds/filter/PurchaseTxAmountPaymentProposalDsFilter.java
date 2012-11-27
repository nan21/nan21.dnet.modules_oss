/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PurchaseTxAmountPaymentProposalDsFilter
		extends
			AbstractAuditableDsFilter {

	private Long bpartnerId;

	private Long bpartnerId_From;

	private Long bpartnerId_To;

	private Long orgId;

	private Long orgId_From;

	private Long orgId_To;

	private Long invoiceId;

	private Long invoiceId_From;

	private Long invoiceId_To;

	private String invoiceCode;

	private Date invoiceDocDate;

	private Date invoiceDocDate_From;

	private Date invoiceDocDate_To;

	private String invoiceDocNo;

	private Long orderId;

	private Long orderId_From;

	private Long orderId_To;

	private String orderCode;

	private Date orderDocDate;

	private Date orderDocDate_From;

	private Date orderDocDate_To;

	private String orderDocNo;

	private Long currencyId;

	private Long currencyId_From;

	private Long currencyId_To;

	private String currency;

	private Date dueDate;

	private Date dueDate_From;

	private Date dueDate_To;

	private Float dueAmount;

	private Float dueAmount_From;

	private Float dueAmount_To;

	private Float payedAmount;

	private Float payedAmount_From;

	private Float payedAmount_To;

	private Float outstandingAmount;

	private Float outstandingAmount_From;

	private Float outstandingAmount_To;

	private Float currentPayment;

	private Float currentPayment_From;

	private Float currentPayment_To;

	private Float remainingAmount;

	private Float remainingAmount_From;

	private Float remainingAmount_To;

	private Long paymentMethodId;

	private Long paymentMethodId_From;

	private Long paymentMethodId_To;

	private String paymentMethod;

	public Long getBpartnerId() {
		return this.bpartnerId;
	}

	public Long getBpartnerId_From() {
		return this.bpartnerId_From;
	}

	public Long getBpartnerId_To() {
		return this.bpartnerId_To;
	}

	public void setBpartnerId(Long bpartnerId) {
		this.bpartnerId = bpartnerId;
	}

	public void setBpartnerId_From(Long bpartnerId_From) {
		this.bpartnerId_From = bpartnerId_From;
	}

	public void setBpartnerId_To(Long bpartnerId_To) {
		this.bpartnerId_To = bpartnerId_To;
	}

	public Long getOrgId() {
		return this.orgId;
	}

	public Long getOrgId_From() {
		return this.orgId_From;
	}

	public Long getOrgId_To() {
		return this.orgId_To;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public void setOrgId_From(Long orgId_From) {
		this.orgId_From = orgId_From;
	}

	public void setOrgId_To(Long orgId_To) {
		this.orgId_To = orgId_To;
	}

	public Long getInvoiceId() {
		return this.invoiceId;
	}

	public Long getInvoiceId_From() {
		return this.invoiceId_From;
	}

	public Long getInvoiceId_To() {
		return this.invoiceId_To;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public void setInvoiceId_From(Long invoiceId_From) {
		this.invoiceId_From = invoiceId_From;
	}

	public void setInvoiceId_To(Long invoiceId_To) {
		this.invoiceId_To = invoiceId_To;
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

	public Date getInvoiceDocDate_From() {
		return this.invoiceDocDate_From;
	}

	public Date getInvoiceDocDate_To() {
		return this.invoiceDocDate_To;
	}

	public void setInvoiceDocDate(Date invoiceDocDate) {
		this.invoiceDocDate = invoiceDocDate;
	}

	public void setInvoiceDocDate_From(Date invoiceDocDate_From) {
		this.invoiceDocDate_From = invoiceDocDate_From;
	}

	public void setInvoiceDocDate_To(Date invoiceDocDate_To) {
		this.invoiceDocDate_To = invoiceDocDate_To;
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

	public Long getOrderId_From() {
		return this.orderId_From;
	}

	public Long getOrderId_To() {
		return this.orderId_To;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setOrderId_From(Long orderId_From) {
		this.orderId_From = orderId_From;
	}

	public void setOrderId_To(Long orderId_To) {
		this.orderId_To = orderId_To;
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

	public Date getOrderDocDate_From() {
		return this.orderDocDate_From;
	}

	public Date getOrderDocDate_To() {
		return this.orderDocDate_To;
	}

	public void setOrderDocDate(Date orderDocDate) {
		this.orderDocDate = orderDocDate;
	}

	public void setOrderDocDate_From(Date orderDocDate_From) {
		this.orderDocDate_From = orderDocDate_From;
	}

	public void setOrderDocDate_To(Date orderDocDate_To) {
		this.orderDocDate_To = orderDocDate_To;
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

	public Long getCurrencyId_From() {
		return this.currencyId_From;
	}

	public Long getCurrencyId_To() {
		return this.currencyId_To;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public void setCurrencyId_From(Long currencyId_From) {
		this.currencyId_From = currencyId_From;
	}

	public void setCurrencyId_To(Long currencyId_To) {
		this.currencyId_To = currencyId_To;
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

	public Date getDueDate_From() {
		return this.dueDate_From;
	}

	public Date getDueDate_To() {
		return this.dueDate_To;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setDueDate_From(Date dueDate_From) {
		this.dueDate_From = dueDate_From;
	}

	public void setDueDate_To(Date dueDate_To) {
		this.dueDate_To = dueDate_To;
	}

	public Float getDueAmount() {
		return this.dueAmount;
	}

	public Float getDueAmount_From() {
		return this.dueAmount_From;
	}

	public Float getDueAmount_To() {
		return this.dueAmount_To;
	}

	public void setDueAmount(Float dueAmount) {
		this.dueAmount = dueAmount;
	}

	public void setDueAmount_From(Float dueAmount_From) {
		this.dueAmount_From = dueAmount_From;
	}

	public void setDueAmount_To(Float dueAmount_To) {
		this.dueAmount_To = dueAmount_To;
	}

	public Float getPayedAmount() {
		return this.payedAmount;
	}

	public Float getPayedAmount_From() {
		return this.payedAmount_From;
	}

	public Float getPayedAmount_To() {
		return this.payedAmount_To;
	}

	public void setPayedAmount(Float payedAmount) {
		this.payedAmount = payedAmount;
	}

	public void setPayedAmount_From(Float payedAmount_From) {
		this.payedAmount_From = payedAmount_From;
	}

	public void setPayedAmount_To(Float payedAmount_To) {
		this.payedAmount_To = payedAmount_To;
	}

	public Float getOutstandingAmount() {
		return this.outstandingAmount;
	}

	public Float getOutstandingAmount_From() {
		return this.outstandingAmount_From;
	}

	public Float getOutstandingAmount_To() {
		return this.outstandingAmount_To;
	}

	public void setOutstandingAmount(Float outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public void setOutstandingAmount_From(Float outstandingAmount_From) {
		this.outstandingAmount_From = outstandingAmount_From;
	}

	public void setOutstandingAmount_To(Float outstandingAmount_To) {
		this.outstandingAmount_To = outstandingAmount_To;
	}

	public Float getCurrentPayment() {
		return this.currentPayment;
	}

	public Float getCurrentPayment_From() {
		return this.currentPayment_From;
	}

	public Float getCurrentPayment_To() {
		return this.currentPayment_To;
	}

	public void setCurrentPayment(Float currentPayment) {
		this.currentPayment = currentPayment;
	}

	public void setCurrentPayment_From(Float currentPayment_From) {
		this.currentPayment_From = currentPayment_From;
	}

	public void setCurrentPayment_To(Float currentPayment_To) {
		this.currentPayment_To = currentPayment_To;
	}

	public Float getRemainingAmount() {
		return this.remainingAmount;
	}

	public Float getRemainingAmount_From() {
		return this.remainingAmount_From;
	}

	public Float getRemainingAmount_To() {
		return this.remainingAmount_To;
	}

	public void setRemainingAmount(Float remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public void setRemainingAmount_From(Float remainingAmount_From) {
		this.remainingAmount_From = remainingAmount_From;
	}

	public void setRemainingAmount_To(Float remainingAmount_To) {
		this.remainingAmount_To = remainingAmount_To;
	}

	public Long getPaymentMethodId() {
		return this.paymentMethodId;
	}

	public Long getPaymentMethodId_From() {
		return this.paymentMethodId_From;
	}

	public Long getPaymentMethodId_To() {
		return this.paymentMethodId_To;
	}

	public void setPaymentMethodId(Long paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public void setPaymentMethodId_From(Long paymentMethodId_From) {
		this.paymentMethodId_From = paymentMethodId_From;
	}

	public void setPaymentMethodId_To(Long paymentMethodId_To) {
		this.paymentMethodId_To = paymentMethodId_To;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}
