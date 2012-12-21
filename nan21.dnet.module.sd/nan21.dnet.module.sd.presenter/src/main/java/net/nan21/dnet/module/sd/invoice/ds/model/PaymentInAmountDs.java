/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.PaymentInAmount;

@Ds(entity = PaymentInAmount.class)
@RefLookups({@RefLookup(refId = PaymentInAmountDs.f_paymentId)})
public class PaymentInAmountDs extends AbstractAuditableDs<PaymentInAmount> {

	public static final String f_paymentId = "paymentId";
	public static final String f_orgId = "orgId";
	public static final String f_bpartnerId = "bpartnerId";
	public static final String f_txAmountId = "txAmountId";
	public static final String f_invoiceCode = "invoiceCode";
	public static final String f_invoiceDocNo = "invoiceDocNo";
	public static final String f_invoiceDocDate = "invoiceDocDate";
	public static final String f_dueAmount = "dueAmount";
	public static final String f_payedAmount = "payedAmount";
	public static final String f_outstandingAmount = "outstandingAmount";
	public static final String f_currentPayment = "currentPayment";

	@DsField(join = "left", path = "payment.id")
	private Long paymentId;

	@DsField(join = "left", path = "payment.toOrg.id")
	private Long orgId;

	@DsField(join = "left", path = "payment.bpartner.id")
	private Long bpartnerId;

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

	@DsField(path = "amount")
	private Float currentPayment;

	public PaymentInAmountDs() {
		super();
	}

	public PaymentInAmountDs(PaymentInAmount e) {
		super(e);
	}

	public Long getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getBpartnerId() {
		return this.bpartnerId;
	}

	public void setBpartnerId(Long bpartnerId) {
		this.bpartnerId = bpartnerId;
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

	public Float getCurrentPayment() {
		return this.currentPayment;
	}

	public void setCurrentPayment(Float currentPayment) {
		this.currentPayment = currentPayment;
	}
}
