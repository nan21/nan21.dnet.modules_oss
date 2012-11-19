/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PaymentOutAmountDsFilter extends AbstractAuditableDsFilter {

	private Long paymentId;

	private Long paymentId_From;

	private Long paymentId_To;

	private Long orgId;

	private Long orgId_From;

	private Long orgId_To;

	private Long bpartnerId;

	private Long bpartnerId_From;

	private Long bpartnerId_To;

	private Long txAmountId;

	private Long txAmountId_From;

	private Long txAmountId_To;

	private String invoiceCode;

	private String invoiceDocNo;

	private Date invoiceDocDate;

	private Date invoiceDocDate_From;

	private Date invoiceDocDate_To;

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

	public Long getPaymentId() {
		return this.paymentId;
	}

	public Long getPaymentId_From() {
		return this.paymentId_From;
	}

	public Long getPaymentId_To() {
		return this.paymentId_To;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public void setPaymentId_From(Long paymentId_From) {
		this.paymentId_From = paymentId_From;
	}

	public void setPaymentId_To(Long paymentId_To) {
		this.paymentId_To = paymentId_To;
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

	public Long getTxAmountId() {
		return this.txAmountId;
	}

	public Long getTxAmountId_From() {
		return this.txAmountId_From;
	}

	public Long getTxAmountId_To() {
		return this.txAmountId_To;
	}

	public void setTxAmountId(Long txAmountId) {
		this.txAmountId = txAmountId;
	}

	public void setTxAmountId_From(Long txAmountId_From) {
		this.txAmountId_From = txAmountId_From;
	}

	public void setTxAmountId_To(Long txAmountId_To) {
		this.txAmountId_To = txAmountId_To;
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
}
