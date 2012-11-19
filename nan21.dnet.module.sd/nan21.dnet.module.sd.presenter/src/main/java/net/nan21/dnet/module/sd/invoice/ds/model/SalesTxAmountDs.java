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

@Ds(entity = SalesTxAmount.class)
public class SalesTxAmountDs extends AbstractAuditableDs<SalesTxAmount> {

	public static final String fORGID = "orgId";
	public static final String fBPARTNERID = "bpartnerId";
	public static final String fINVOICEID = "invoiceId";
	public static final String fINVOICECODE = "invoiceCode";
	public static final String fINVOICEDOCNO = "invoiceDocNo";
	public static final String fINVOICEDOCDATE = "invoiceDocDate";
	public static final String fORDERID = "orderId";
	public static final String fDUEDATE = "dueDate";
	public static final String fDUEAMOUNT = "dueAmount";
	public static final String fPAYEDAMOUNT = "payedAmount";
	public static final String fOUTSTANDINGAMOUNT = "outstandingAmount";
	public static final String fPAYMENTMETHODID = "paymentMethodId";
	public static final String fPAYMENTMETHOD = "paymentMethod";

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

	@DsField(noUpdate = true, join = "left", path = "order.id")
	private Long orderId;

	@DsField()
	private Date dueDate;

	@DsField()
	private Float dueAmount;

	@DsField()
	private Float payedAmount;

	@DsField(path = "amount")
	private Float outstandingAmount;

	@DsField(join = "left", path = "paymentMethod.id")
	private Long paymentMethodId;

	@DsField(join = "left", path = "paymentMethod.name")
	private String paymentMethod;

	public SalesTxAmountDs() {
		super();
	}

	public SalesTxAmountDs(SalesTxAmount e) {
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
