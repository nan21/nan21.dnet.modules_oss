/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.param;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class SalesTxAmountPaymentProposalDsParam extends EmptyParam {

	public static final String fBUSINESSPARTNER = "businessPartner";
	public static final String fRECEIVEDAMOUNT = "receivedAmount";
	public static final String fUNALLOCATEDAMOUNT = "unAllocatedAmount";
	public static final String fCURRENCY = "currency";
	public static final String fPAYMENTID = "paymentId";

	private String businessPartner;

	private Float receivedAmount;

	private Float unAllocatedAmount;

	private String currency;

	private Long paymentId;

	public String getBusinessPartner() {
		return this.businessPartner;
	}

	public void setBusinessPartner(String businessPartner) {
		this.businessPartner = businessPartner;
	}

	public Float getReceivedAmount() {
		return this.receivedAmount;
	}

	public void setReceivedAmount(Float receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public Float getUnAllocatedAmount() {
		return this.unAllocatedAmount;
	}

	public void setUnAllocatedAmount(Float unAllocatedAmount) {
		this.unAllocatedAmount = unAllocatedAmount;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Long getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
}
