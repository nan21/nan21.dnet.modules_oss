/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PurchaseTxAmountOverviewDsFilter extends AbstractAuditableDsFilter {

	private Long customerId;

	private Long customerId_From;

	private Long customerId_To;

	private String customer;

	private Long supplierId;

	private Long supplierId_From;

	private Long supplierId_To;

	private String supplierCode;

	private String supplier;

	private Long invoiceId;

	private Long invoiceId_From;

	private Long invoiceId_To;

	private String invoiceCode;

	private String invoiceDocNo;

	private Date invoiceDocDate;

	private Date invoiceDocDate_From;

	private Date invoiceDocDate_To;

	private Long currencyId;

	private Long currencyId_From;

	private Long currencyId_To;

	private String currency;

	private Long orderId;

	private Long orderId_From;

	private Long orderId_To;

	private Date dueDate;

	private Date dueDate_From;

	private Date dueDate_To;

	private Integer dueInDays;

	private Integer dueInDays_From;

	private Integer dueInDays_To;

	private Float dueAmount;

	private Float dueAmount_From;

	private Float dueAmount_To;

	private Float payedAmount;

	private Float payedAmount_From;

	private Float payedAmount_To;

	private Float outstandingAmount;

	private Float outstandingAmount_From;

	private Float outstandingAmount_To;

	private Long paymentMethodId;

	private Long paymentMethodId_From;

	private Long paymentMethodId_To;

	private String paymentMethod;

	public Long getCustomerId() {
		return this.customerId;
	}

	public Long getCustomerId_From() {
		return this.customerId_From;
	}

	public Long getCustomerId_To() {
		return this.customerId_To;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public void setCustomerId_From(Long customerId_From) {
		this.customerId_From = customerId_From;
	}

	public void setCustomerId_To(Long customerId_To) {
		this.customerId_To = customerId_To;
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

	public Long getSupplierId_From() {
		return this.supplierId_From;
	}

	public Long getSupplierId_To() {
		return this.supplierId_To;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public void setSupplierId_From(Long supplierId_From) {
		this.supplierId_From = supplierId_From;
	}

	public void setSupplierId_To(Long supplierId_To) {
		this.supplierId_To = supplierId_To;
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

	public String getInvoiceDocNo() {
		return this.invoiceDocNo;
	}

	public void setInvoiceDocNo(String invoiceDocNo) {
		this.invoiceDocNo = invoiceDocNo;
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

	public Integer getDueInDays() {
		return this.dueInDays;
	}

	public Integer getDueInDays_From() {
		return this.dueInDays_From;
	}

	public Integer getDueInDays_To() {
		return this.dueInDays_To;
	}

	public void setDueInDays(Integer dueInDays) {
		this.dueInDays = dueInDays;
	}

	public void setDueInDays_From(Integer dueInDays_From) {
		this.dueInDays_From = dueInDays_From;
	}

	public void setDueInDays_To(Integer dueInDays_To) {
		this.dueInDays_To = dueInDays_To;
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
