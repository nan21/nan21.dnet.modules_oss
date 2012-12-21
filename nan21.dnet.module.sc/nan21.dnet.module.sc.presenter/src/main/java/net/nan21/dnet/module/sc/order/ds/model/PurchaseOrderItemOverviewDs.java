/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.sc.order.domain.entity.PurchaseOrderItem;

@Ds(entity = PurchaseOrderItem.class)
public class PurchaseOrderItemOverviewDs
		extends
			AbstractAuditableDs<PurchaseOrderItem> {

	public static final String f_docId = "docId";
	public static final String f_docCode = "docCode";
	public static final String f_docNo = "docNo";
	public static final String f_docDate = "docDate";
	public static final String f_customerId = "customerId";
	public static final String f_customerCode = "customerCode";
	public static final String f_customerName = "customerName";
	public static final String f_supplierId = "supplierId";
	public static final String f_supplierCode = "supplierCode";
	public static final String f_supplierName = "supplierName";
	public static final String f_docTypeId = "docTypeId";
	public static final String f_docType = "docType";
	public static final String f_currencyId = "currencyId";
	public static final String f_currency = "currency";
	public static final String f_confirmed = "confirmed";
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

	@DsField(join = "left", path = "purchaseOrder.id")
	private Long docId;

	@DsField(join = "left", path = "purchaseOrder.code")
	private String docCode;

	@DsField(join = "left", path = "purchaseOrder.docNo")
	private String docNo;

	@DsField(join = "left", path = "purchaseOrder.docDate")
	private Date docDate;

	@DsField(join = "left", path = "purchaseOrder.customer.id")
	private Long customerId;

	@DsField(join = "left", path = "purchaseOrder.customer.code")
	private String customerCode;

	@DsField(join = "left", path = "purchaseOrder.customer.name")
	private String customerName;

	@DsField(join = "left", path = "purchaseOrder.supplier.id")
	private Long supplierId;

	@DsField(join = "left", path = "purchaseOrder.supplier.code")
	private String supplierCode;

	@DsField(join = "left", path = "purchaseOrder.supplier.name")
	private String supplierName;

	@DsField(join = "left", path = "purchaseOrder.docType.id")
	private Long docTypeId;

	@DsField(join = "left", path = "purchaseOrder.docType.name")
	private String docType;

	@DsField(join = "left", path = "purchaseOrder.currency.id")
	private Long currencyId;

	@DsField(join = "left", path = "purchaseOrder.currency.code")
	private String currency;

	@DsField(join = "left", path = "purchaseOrder.confirmed")
	private Boolean confirmed;

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

	@DsField
	private Float netAmount;

	@DsField
	private Float taxAmount;

	@DsField(fetch = false)
	private Float lineAmount;

	@DsField(join = "left", path = "tax.id")
	private Long taxId;

	@DsField(join = "left", path = "tax.name")
	private String tax;

	public PurchaseOrderItemOverviewDs() {
		super();
	}

	public PurchaseOrderItemOverviewDs(PurchaseOrderItem e) {
		super(e);
	}

	public Long getDocId() {
		return this.docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getDocCode() {
		return this.docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public String getDocNo() {
		return this.docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public Date getDocDate() {
		return this.docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierCode() {
		return this.supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Long getDocTypeId() {
		return this.docTypeId;
	}

	public void setDocTypeId(Long docTypeId) {
		this.docTypeId = docTypeId;
	}

	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
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

	public Boolean getConfirmed() {
		return this.confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
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
