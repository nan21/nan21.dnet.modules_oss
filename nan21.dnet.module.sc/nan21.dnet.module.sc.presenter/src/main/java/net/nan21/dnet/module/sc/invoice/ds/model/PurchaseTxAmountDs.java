/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.base.tx.domain.entity.PaymentMethod;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseTxAmount;

@Ds(entity = PurchaseTxAmount.class)
@RefLookups({
		@RefLookup(refId = PurchaseTxAmountDs.f_orderId),
		@RefLookup(refId = PurchaseTxAmountDs.f_invoiceId),
		@RefLookup(refId = PurchaseTxAmountDs.f_paymentMethodId, namedQuery = PaymentMethod.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PurchaseTxAmountDs.f_paymentMethod)})})
public class PurchaseTxAmountDs extends AbstractAuditableDs<PurchaseTxAmount> {

	public static final String f_orgId = "orgId";
	public static final String f_bpartnerId = "bpartnerId";
	public static final String f_invoiceId = "invoiceId";
	public static final String f_invoiceCode = "invoiceCode";
	public static final String f_invoiceDocNo = "invoiceDocNo";
	public static final String f_invoiceDocDate = "invoiceDocDate";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";
	public static final String f_orderId = "orderId";
	public static final String f_dueDate = "dueDate";
	public static final String f_dueAmount = "dueAmount";
	public static final String f_payedAmount = "payedAmount";
	public static final String f_outstandingAmount = "outstandingAmount";
	public static final String f_paymentMethodId = "paymentMethodId";
	public static final String f_paymentMethod = "paymentMethod";

	@DsField(join = "left", path = "org.id")
	private Long orgId;

	@DsField(join = "left", path = "bpartner.id")
	private Long bpartnerId;

	@DsField(noUpdate = true, join = "left", path = "invoice.id")
	private Long invoiceId;

	@DsField(noUpdate = true, join = "left", path = "invoice.code")
	private String invoiceCode;

	@DsField(noUpdate = true, join = "left", path = "invoice.docNo")
	private String invoiceDocNo;

	@DsField(noUpdate = true, join = "left", path = "invoice.docDate")
	private Date invoiceDocDate;

	@DsField(noUpdate = true, join = "left", path = "currency.id")
	private Long currencyId;

	@DsField(noUpdate = true, join = "left", path = "currency.code")
	private String currency;

	@DsField(noUpdate = true, join = "left", path = "order.id")
	private Long orderId;

	@DsField
	private Date dueDate;

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

	public PurchaseTxAmountDs() {
		super();
	}

	public PurchaseTxAmountDs(PurchaseTxAmount e) {
		super(e);
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
