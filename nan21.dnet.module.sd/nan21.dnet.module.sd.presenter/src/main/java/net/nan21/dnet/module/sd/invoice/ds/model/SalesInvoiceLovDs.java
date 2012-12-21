/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableLov;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoice;

@Ds(entity = SalesInvoice.class)
public class SalesInvoiceLovDs extends AbstractAuditableLov<SalesInvoice> {

	public static final String f_code = "code";
	public static final String f_docNo = "docNo";
	public static final String f_supplier = "supplier";
	public static final String f_totalAmount = "totalAmount";
	public static final String f_currency = "currency";

	@DsField
	private String code;

	@DsField
	private String docNo;

	@DsField(join = "left", path = "supplier.name")
	private String supplier;

	@DsField
	private Float totalAmount;

	@DsField(join = "left", path = "currency.code")
	private String currency;

	public SalesInvoiceLovDs() {
		super();
	}

	public SalesInvoiceLovDs(SalesInvoice e) {
		super(e);
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDocNo() {
		return this.docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Float getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
