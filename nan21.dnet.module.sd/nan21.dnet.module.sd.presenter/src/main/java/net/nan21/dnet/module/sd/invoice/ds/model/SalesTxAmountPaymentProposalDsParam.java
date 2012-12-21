/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class SalesTxAmountPaymentProposalDsParam extends EmptyParam {

	public static final String f_businessPartner = "businessPartner";
	public static final String f_receivedAmount = "receivedAmount";
	public static final String f_unAllocatedAmount = "unAllocatedAmount";
	public static final String f_paymentCurrency = "paymentCurrency";
	public static final String f_paymentId = "paymentId";

	private String businessPartner;

	private Float receivedAmount;

	private Float unAllocatedAmount;

	private String paymentCurrency;

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

	public String getPaymentCurrency() {
		return this.paymentCurrency;
	}

	public void setPaymentCurrency(String paymentCurrency) {
		this.paymentCurrency = paymentCurrency;
	}

	public Long getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
}
