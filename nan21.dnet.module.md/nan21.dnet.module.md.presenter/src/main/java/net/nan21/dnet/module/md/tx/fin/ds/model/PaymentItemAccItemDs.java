/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.md.tx.fin.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.acc.domain.entity.AccItem;
import net.nan21.dnet.module.md.tx.fin.domain.entity.PaymentItem;

@Ds(entity = PaymentItem.class, jpqlWhere = " e.accItem is not null ")
@RefLookups({
		@RefLookup(refId = PaymentItemAccItemDs.f_paymentId),
		@RefLookup(refId = PaymentItemAccItemDs.f_accItemId, namedQuery = AccItem.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PaymentItemAccItemDs.f_accItem)})})
public class PaymentItemAccItemDs extends AbstractAuditableDs<PaymentItem> {

	public static final String f_paymentId = "paymentId";
	public static final String f_accItemId = "accItemId";
	public static final String f_accItem = "accItem";
	public static final String f_amount = "amount";

	@DsField(join = "left", path = "payment.id")
	private Long paymentId;

	@DsField(join = "left", path = "accItem.id")
	private Long accItemId;

	@DsField(join = "left", path = "accItem.name")
	private String accItem;

	@DsField
	private Float amount;

	public PaymentItemAccItemDs() {
		super();
	}

	public PaymentItemAccItemDs(PaymentItem e) {
		super(e);
	}

	public Long getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getAccItemId() {
		return this.accItemId;
	}

	public void setAccItemId(Long accItemId) {
		this.accItemId = accItemId;
	}

	public String getAccItem() {
		return this.accItem;
	}

	public void setAccItem(String accItem) {
		this.accItem = accItem;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}
}
