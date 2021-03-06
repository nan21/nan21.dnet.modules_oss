/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOutAmount;

@Ds(entity = PaymentOutAmount.class)
public class PurchaseTxAmountPaymentDs
		extends
			AbstractAuditableDs<PaymentOutAmount> {

	public static final String f_paymentId = "paymentId";
	public static final String f_paymentDocDate = "paymentDocDate";
	public static final String f_paymentDocNo = "paymentDocNo";
	public static final String f_paymentCode = "paymentCode";
	public static final String f_txAmountId = "txAmountId";
	public static final String f_invoiceCode = "invoiceCode";
	public static final String f_invoiceDocNo = "invoiceDocNo";
	public static final String f_invoiceDocDate = "invoiceDocDate";
	public static final String f_dueAmount = "dueAmount";
	public static final String f_payedAmount = "payedAmount";
	public static final String f_outstandingAmount = "outstandingAmount";
	public static final String f_amount = "amount";

	@DsField(join = "left", path = "payment.id")
	private Long paymentId;

	@DsField(join = "left", path = "payment.docDate")
	private Date paymentDocDate;

	@DsField(join = "left", path = "payment.docNo")
	private String paymentDocNo;

	@DsField(join = "left", path = "payment.code")
	private String paymentCode;

	@DsField(join = "left", path = "txAmount.id")
	private Long txAmountId;

	@DsField(join = "left", path = "txAmount.invoice.code")
	private String invoiceCode;

	@DsField(join = "left", path = "txAmount.invoice.docNo")
	private String invoiceDocNo;

	@DsField(join = "left", path = "txAmount.invoice.docDate")
	private Date invoiceDocDate;

	@DsField(join = "left", path = "txAmount.dueAmount")
	private Float dueAmount;

	@DsField(join = "left", path = "txAmount.payedAmount")
	private Float payedAmount;

	@DsField(join = "left", path = "txAmount.amount")
	private Float outstandingAmount;

	@DsField
	private Float amount;

	public PurchaseTxAmountPaymentDs() {
		super();
	}

	public PurchaseTxAmountPaymentDs(PaymentOutAmount e) {
		super(e);
	}

	public Long getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Date getPaymentDocDate() {
		return this.paymentDocDate;
	}

	public void setPaymentDocDate(Date paymentDocDate) {
		this.paymentDocDate = paymentDocDate;
	}

	public String getPaymentDocNo() {
		return this.paymentDocNo;
	}

	public void setPaymentDocNo(String paymentDocNo) {
		this.paymentDocNo = paymentDocNo;
	}

	public String getPaymentCode() {
		return this.paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public Long getTxAmountId() {
		return this.txAmountId;
	}

	public void setTxAmountId(Long txAmountId) {
		this.txAmountId = txAmountId;
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

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}
}
