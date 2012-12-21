/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.invoice.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.base.tax.domain.entity.Tax;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.sc.invoice.domain.entity.PurchaseInvoiceItem;

@Ds(entity = PurchaseInvoiceItem.class)
@RefLookups({
		@RefLookup(refId = PurchaseInvoiceItemDs.f_purchaseInvoiceId),
		@RefLookup(refId = PurchaseInvoiceItemDs.f_uomId, namedQuery = Uom.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PurchaseInvoiceItemDs.f_uomCode)}),
		@RefLookup(refId = PurchaseInvoiceItemDs.f_productId, namedQuery = Product.NQ_FIND_BY_CODE, params = {@Param(name = "pCode", field = PurchaseInvoiceItemDs.f_productCode)}),
		@RefLookup(refId = PurchaseInvoiceItemDs.f_taxId, namedQuery = Tax.NQ_FIND_BY_NAME, params = {@Param(name = "pName", field = PurchaseInvoiceItemDs.f_tax)})})
public class PurchaseInvoiceItemDs
		extends
			AbstractAuditableDs<PurchaseInvoiceItem> {

	public static final String f_purchaseInvoiceId = "purchaseInvoiceId";
	public static final String f_productId = "productId";
	public static final String f_productCode = "productCode";
	public static final String f_productName = "productName";
	public static final String f_description = "description";
	public static final String f_quantity = "quantity";
	public static final String f_uomId = "uomId";
	public static final String f_uomCode = "uomCode";
	public static final String f_unitPrice = "unitPrice";
	public static final String f_netAmount = "netAmount";
	public static final String f_taxAmount = "taxAmount";
	public static final String f_lineAmount = "lineAmount";
	public static final String f_entryMode = "entryMode";
	public static final String f_taxId = "taxId";
	public static final String f_tax = "tax";

	@DsField(noUpdate = true, join = "left", path = "purchaseInvoice.id")
	private Long purchaseInvoiceId;

	@DsField(join = "left", path = "product.id")
	private Long productId;

	@DsField(join = "left", path = "product.code")
	private String productCode;

	@DsField(join = "left", path = "product.name")
	private String productName;

	@DsField
	private String description;

	@DsField
	private Float quantity;

	@DsField(join = "left", path = "uom.id")
	private Long uomId;

	@DsField(join = "left", path = "uom.code")
	private String uomCode;

	@DsField
	private Float unitPrice;

	@DsField
	private Float netAmount;

	@DsField
	private Float taxAmount;

	@DsField
	private Float lineAmount;

	@DsField
	private String entryMode;

	@DsField(join = "left", path = "tax.id")
	private Long taxId;

	@DsField(join = "left", path = "tax.name")
	private String tax;

	public PurchaseInvoiceItemDs() {
		super();
	}

	public PurchaseInvoiceItemDs(PurchaseInvoiceItem e) {
		super(e);
	}

	public Long getPurchaseInvoiceId() {
		return this.purchaseInvoiceId;
	}

	public void setPurchaseInvoiceId(Long purchaseInvoiceId) {
		this.purchaseInvoiceId = purchaseInvoiceId;
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

	public Float getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
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

	public String getEntryMode() {
		return this.entryMode;
	}

	public void setEntryMode(String entryMode) {
		this.entryMode = entryMode;
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
