/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.sc.invoice.domain.entity.PaymentOut;

@Ds(entity = PaymentOut.class, sort = {@SortField(field = PaymentOutDs.fDOCDATE)})
public class PaymentOutDs extends AbstractAuditableDs<PaymentOut> {

	public static final String fCODE = "code";
	public static final String fDOCDATE = "docDate";
	public static final String fDOCNO = "docNo";
	public static final String fBPARTNERID = "bpartnerId";
	public static final String fBPARTNERCODE = "bpartnerCode";
	public static final String fBPARTNER = "bpartner";
	public static final String fORGID = "orgId";
	public static final String fORG = "org";
	public static final String fFROMACCOUNTID = "fromAccountId";
	public static final String fFROMACCOUNT = "fromAccount";
	public static final String fCURRENCYID = "currencyId";
	public static final String fCURRENCY = "currency";
	public static final String fPAYMENTMETHODID = "paymentMethodId";
	public static final String fPAYMENTMETHOD = "paymentMethod";
	public static final String fPAYMENTMETHODTYPE = "paymentMethodType";
	public static final String fAMOUNT = "amount";
	public static final String fCONFIRMED = "confirmed";
	public static final String fPOSTED = "posted";
	public static final String fGENERATED = "generated";

	@DsField()
	private String code;

	@DsField()
	private Date docDate;

	@DsField()
	private String docNo;

	@DsField(join = "left", path = "bpartner.id")
	private Long bpartnerId;

	@DsField(join = "left", path = "bpartner.code")
	private String bpartnerCode;

	@DsField(join = "left", path = "bpartner.name")
	private String bpartner;

	@DsField(join = "left", path = "fromOrg.id")
	private Long orgId;

	@DsField(join = "left", path = "fromOrg.code")
	private String org;

	@DsField(join = "left", path = "fromAccount.id")
	private Long fromAccountId;

	@DsField(join = "left", path = "fromAccount.name")
	private String fromAccount;

	@DsField(join = "left", path = "currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "currency.code")
	private String currency;

	@DsField(join = "left", path = "paymentMethod.id")
	private Long paymentMethodId;

	@DsField(join = "left", path = "paymentMethod.name")
	private String paymentMethod;

	@DsField(join = "left", path = "paymentMethod.type")
	private String paymentMethodType;

	@DsField()
	private Float amount;

	@DsField()
	private Boolean confirmed;

	@DsField()
	private Boolean posted;

	@DsField()
	private Boolean generated;

	public PaymentOutDs() {
		super();
	}

	public PaymentOutDs(PaymentOut e) {
		super(e);
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDocDate() {
		return this.docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public String getDocNo() {
		return this.docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public Long getBpartnerId() {
		return this.bpartnerId;
	}

	public void setBpartnerId(Long bpartnerId) {
		this.bpartnerId = bpartnerId;
	}

	public String getBpartnerCode() {
		return this.bpartnerCode;
	}

	public void setBpartnerCode(String bpartnerCode) {
		this.bpartnerCode = bpartnerCode;
	}

	public String getBpartner() {
		return this.bpartner;
	}

	public void setBpartner(String bpartner) {
		this.bpartner = bpartner;
	}

	public Long getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrg() {
		return this.org;
	}

	public void setOrg(String org) {
		this.org = org;
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

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
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

	public Boolean getGenerated() {
		return this.generated;
	}

	public void setGenerated(Boolean generated) {
		this.generated = generated;
	}
}
