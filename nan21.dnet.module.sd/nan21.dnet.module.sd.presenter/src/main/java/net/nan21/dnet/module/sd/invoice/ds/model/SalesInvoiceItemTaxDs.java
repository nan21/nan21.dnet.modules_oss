/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItemTax;

@Ds(entity = SalesInvoiceItemTax.class)
public class SalesInvoiceItemTaxDs
		extends
			AbstractAuditableDs<SalesInvoiceItemTax> {

	public static final String f_salesInvoiceItemId = "salesInvoiceItemId";
	public static final String f_taxId = "taxId";
	public static final String f_tax = "tax";
	public static final String f_baseAmount = "baseAmount";
	public static final String f_taxAmount = "taxAmount";

	@DsField(join = "left", path = "salesInvoiceItem.id")
	private Long salesInvoiceItemId;

	@DsField(join = "left", path = "tax.id")
	private Long taxId;

	@DsField(join = "left", path = "tax.name")
	private String tax;

	@DsField
	private Float baseAmount;

	@DsField
	private Float taxAmount;

	public SalesInvoiceItemTaxDs() {
		super();
	}

	public SalesInvoiceItemTaxDs(SalesInvoiceItemTax e) {
		super(e);
	}

	public Long getSalesInvoiceItemId() {
		return this.salesInvoiceItemId;
	}

	public void setSalesInvoiceItemId(Long salesInvoiceItemId) {
		this.salesInvoiceItemId = salesInvoiceItemId;
	}

	public Long getTaxId() {
		return this.taxId;
	}

	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}

	public String getTax() {
		return this.tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public Float getBaseAmount() {
		return this.baseAmount;
	}

	public void setBaseAmount(Float baseAmount) {
		this.baseAmount = baseAmount;
	}

	public Float getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(Float taxAmount) {
		this.taxAmount = taxAmount;
	}
}
