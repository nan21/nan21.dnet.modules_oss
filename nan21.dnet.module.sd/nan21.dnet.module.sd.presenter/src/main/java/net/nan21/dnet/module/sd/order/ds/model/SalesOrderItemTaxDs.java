/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.order.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.sd.order.domain.entity.SalesOrderItemTax;

@Ds(entity = SalesOrderItemTax.class)
public class SalesOrderItemTaxDs extends AbstractAuditableDs<SalesOrderItemTax> {

	public static final String f_salesOrderItemId = "salesOrderItemId";
	public static final String f_taxId = "taxId";
	public static final String f_tax = "tax";
	public static final String f_baseAmount = "baseAmount";
	public static final String f_taxAmount = "taxAmount";

	@DsField(join = "left", path = "salesOrderItem.id")
	private Long salesOrderItemId;

	@DsField(join = "left", path = "tax.id")
	private Long taxId;

	@DsField(join = "left", path = "tax.name")
	private String tax;

	@DsField
	private Float baseAmount;

	@DsField
	private Float taxAmount;

	public SalesOrderItemTaxDs() {
		super();
	}

	public SalesOrderItemTaxDs(SalesOrderItemTax e) {
		super(e);
	}

	public Long getSalesOrderItemId() {
		return this.salesOrderItemId;
	}

	public void setSalesOrderItemId(Long salesOrderItemId) {
		this.salesOrderItemId = salesOrderItemId;
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
