/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

@Ds(entity = PurchaseOrderItem.class)
@RefLookups({
		@RefLookup(refId = PurchaseOrderItemDs.f_purchaseOrderId),
		@RefLookup(refId = PurchaseOrderItemDs.f_uomId),
		@RefLookup(refId = PurchaseOrderItemDs.f_productId, namedQuery = Product.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PurchaseOrderItemDs.f_productCode)}),
		@RefLookup(refId = PurchaseOrderItemDs.f_taxId, namedQuery = Tax.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PurchaseOrderItemDs.f_tax)})})
public class PurchaseOrderItemDs extends AbstractAuditableDs<PurchaseOrderItem> {

	public static final String f_purchaseOrderId = "purchaseOrderId";
	public static final String f_productId = "productId";
	public static final String f_productCode = "productCode";
	public static final String f_productName = "productName";
	public static final String f_description = "description";
	public static final String f_uomId = "uomId";
	public static final String f_uomCode = "uomCode";
	public static final String f_quantity = "quantity";
	public static final String f_unitPrice = "unitPrice";
	public static final String f_netAmount = "netAmount";
	public static final String f_taxAmount = "taxAmount";
	public static final String f_lineAmount = "lineAmount";
	public static final String f_taxId = "taxId";
	public static final String f_tax = "tax";

	@DsField(noUpdate = true, join = "left", path = "purchaseOrder.id")
	private Long purchaseOrderId;

	@DsField(join = "left", path = "product.id")
	private Long productId;

	@DsField(join = "left", path = "product.code")
	private String productCode;

	@DsField(join = "left", path = "product.name")
	private String productName;

	@DsField
	private String description;

	@DsField(join = "left", path = "uom.id")
	private Long uomId;

	@DsField(join = "left", path = "uom.code")
	private String uomCode;

	@DsField
	private Float quantity;

	@DsField
	private Float unitPrice;

	@DsField(noInsert = true, noUpdate = true)
	private Float netAmount;

	@DsField(noInsert = true, noUpdate = true)
	private Float taxAmount;

	@DsField(noInsert = true, noUpdate = true, fetch = false)
	private Float lineAmount;

	@DsField(join = "left", path = "tax.id")
	private Long taxId;

	@DsField(join = "left", path = "tax.name")
	private String tax;

	public PurchaseOrderItemDs() {
		super();
	}

	public PurchaseOrderItemDs(PurchaseOrderItem e) {
		super(e);
	}

	public Long getPurchaseOrderId() {
		return this.purchaseOrderId;
	}

	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUomId() {
		return this.uomId;
	}

	public void setUomId(Long uomId) {
		this.uomId = uomId;
	}

	public String getUomCode() {
		return this.uomCode;
	}

	public void setUomCode(String uomCode) {
		this.uomCode = uomCode;
	}

	public Float getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public Float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Float getNetAmount() {
		return this.netAmount;
	}

	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
	}

	public Float getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(Float taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Float getLineAmount() {
		return this.lineAmount;
	}

	public void setLineAmount(Float lineAmount) {
		this.lineAmount = lineAmount;
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
}
