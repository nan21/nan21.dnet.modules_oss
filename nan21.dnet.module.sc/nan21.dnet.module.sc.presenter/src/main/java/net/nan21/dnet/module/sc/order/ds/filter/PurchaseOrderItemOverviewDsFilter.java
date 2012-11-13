/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sc.order.ds.filter;

import java.util.Date;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class PurchaseOrderItemOverviewDsFilter extends AbstractAuditableDsFilter {
	
	private Long  docId;
	
	private Long  docId_From;
	
	private Long  docId_To;
	
	private String  docCode;
	
	private String  docNo;
	
	private Date  docDate;
	
	private Date  docDate_From;
	
	private Date  docDate_To;
	
	private Long  customerId;
	
	private Long  customerId_From;
	
	private Long  customerId_To;
	
	private String  customerCode;
	
	private String  customerName;
	
	private Long  supplierId;
	
	private Long  supplierId_From;
	
	private Long  supplierId_To;
	
	private String  supplierCode;
	
	private String  supplierName;
	
	private Long  docTypeId;
	
	private Long  docTypeId_From;
	
	private Long  docTypeId_To;
	
	private String  docType;
	
	private Long  currencyId;
	
	private Long  currencyId_From;
	
	private Long  currencyId_To;
	
	private String  currency;
	
	private Boolean  confirmed;
	
	private Long  productId;
	
	private Long  productId_From;
	
	private Long  productId_To;
	
	private String  productCode;
	
	private String  productName;
	
	private String  description;
	
	private Long  uomId;
	
	private Long  uomId_From;
	
	private Long  uomId_To;
	
	private String  uomCode;
	
	private Float  quantity;
	
	private Float  quantity_From;
	
	private Float  quantity_To;
	
	private Float  unitPrice;
	
	private Float  unitPrice_From;
	
	private Float  unitPrice_To;
	
	private Float  netAmount;
	
	private Float  netAmount_From;
	
	private Float  netAmount_To;
	
	private Float  taxAmount;
	
	private Float  taxAmount_From;
	
	private Float  taxAmount_To;
	
	private Float  lineAmount;
	
	private Float  lineAmount_From;
	
	private Float  lineAmount_To;
	
	private Long  taxId;
	
	private Long  taxId_From;
	
	private Long  taxId_To;
	
	private String  tax;
	
	public Long getDocId() {
		return this.docId;
	}
	
	public Long getDocId_From() {
		return this.docId_From;
	}
	
	public Long getDocId_To() {
		return this.docId_To;
	}
	
	public void setDocId(Long docId) {
		this.docId = docId;
	}
	
	public void setDocId_From(Long docId_From) {
		this.docId_From = docId_From;
	}
	
	public void setDocId_To(Long docId_To) {
		this.docId_To = docId_To;
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
	
	public Date getDocDate_From() {
		return this.docDate_From;
	}
	
	public Date getDocDate_To() {
		return this.docDate_To;
	}
	
	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}
	
	public void setDocDate_From(Date docDate_From) {
		this.docDate_From = docDate_From;
	}
	
	public void setDocDate_To(Date docDate_To) {
		this.docDate_To = docDate_To;
	}
	
	public Long getCustomerId() {
		return this.customerId;
	}
	
	public Long getCustomerId_From() {
		return this.customerId_From;
	}
	
	public Long getCustomerId_To() {
		return this.customerId_To;
	}
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public void setCustomerId_From(Long customerId_From) {
		this.customerId_From = customerId_From;
	}
	
	public void setCustomerId_To(Long customerId_To) {
		this.customerId_To = customerId_To;
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
	
	public Long getSupplierId_From() {
		return this.supplierId_From;
	}
	
	public Long getSupplierId_To() {
		return this.supplierId_To;
	}
	
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	
	public void setSupplierId_From(Long supplierId_From) {
		this.supplierId_From = supplierId_From;
	}
	
	public void setSupplierId_To(Long supplierId_To) {
		this.supplierId_To = supplierId_To;
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
	
	public Long getDocTypeId_From() {
		return this.docTypeId_From;
	}
	
	public Long getDocTypeId_To() {
		return this.docTypeId_To;
	}
	
	public void setDocTypeId(Long docTypeId) {
		this.docTypeId = docTypeId;
	}
	
	public void setDocTypeId_From(Long docTypeId_From) {
		this.docTypeId_From = docTypeId_From;
	}
	
	public void setDocTypeId_To(Long docTypeId_To) {
		this.docTypeId_To = docTypeId_To;
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
	
	public Long getCurrencyId_From() {
		return this.currencyId_From;
	}
	
	public Long getCurrencyId_To() {
		return this.currencyId_To;
	}
	
	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}
	
	public void setCurrencyId_From(Long currencyId_From) {
		this.currencyId_From = currencyId_From;
	}
	
	public void setCurrencyId_To(Long currencyId_To) {
		this.currencyId_To = currencyId_To;
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
	
	public Long getProductId_From() {
		return this.productId_From;
	}
	
	public Long getProductId_To() {
		return this.productId_To;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public void setProductId_From(Long productId_From) {
		this.productId_From = productId_From;
	}
	
	public void setProductId_To(Long productId_To) {
		this.productId_To = productId_To;
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
	
	public Long getUomId_From() {
		return this.uomId_From;
	}
	
	public Long getUomId_To() {
		return this.uomId_To;
	}
	
	public void setUomId(Long uomId) {
		this.uomId = uomId;
	}
	
	public void setUomId_From(Long uomId_From) {
		this.uomId_From = uomId_From;
	}
	
	public void setUomId_To(Long uomId_To) {
		this.uomId_To = uomId_To;
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
	
	public Float getQuantity_From() {
		return this.quantity_From;
	}
	
	public Float getQuantity_To() {
		return this.quantity_To;
	}
	
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	
	public void setQuantity_From(Float quantity_From) {
		this.quantity_From = quantity_From;
	}
	
	public void setQuantity_To(Float quantity_To) {
		this.quantity_To = quantity_To;
	}
	
	public Float getUnitPrice() {
		return this.unitPrice;
	}
	
	public Float getUnitPrice_From() {
		return this.unitPrice_From;
	}
	
	public Float getUnitPrice_To() {
		return this.unitPrice_To;
	}
	
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public void setUnitPrice_From(Float unitPrice_From) {
		this.unitPrice_From = unitPrice_From;
	}
	
	public void setUnitPrice_To(Float unitPrice_To) {
		this.unitPrice_To = unitPrice_To;
	}
	
	public Float getNetAmount() {
		return this.netAmount;
	}
	
	public Float getNetAmount_From() {
		return this.netAmount_From;
	}
	
	public Float getNetAmount_To() {
		return this.netAmount_To;
	}
	
	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
	}
	
	public void setNetAmount_From(Float netAmount_From) {
		this.netAmount_From = netAmount_From;
	}
	
	public void setNetAmount_To(Float netAmount_To) {
		this.netAmount_To = netAmount_To;
	}
	
	public Float getTaxAmount() {
		return this.taxAmount;
	}
	
	public Float getTaxAmount_From() {
		return this.taxAmount_From;
	}
	
	public Float getTaxAmount_To() {
		return this.taxAmount_To;
	}
	
	public void setTaxAmount(Float taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	public void setTaxAmount_From(Float taxAmount_From) {
		this.taxAmount_From = taxAmount_From;
	}
	
	public void setTaxAmount_To(Float taxAmount_To) {
		this.taxAmount_To = taxAmount_To;
	}
	
	public Float getLineAmount() {
		return this.lineAmount;
	}
	
	public Float getLineAmount_From() {
		return this.lineAmount_From;
	}
	
	public Float getLineAmount_To() {
		return this.lineAmount_To;
	}
	
	public void setLineAmount(Float lineAmount) {
		this.lineAmount = lineAmount;
	}
	
	public void setLineAmount_From(Float lineAmount_From) {
		this.lineAmount_From = lineAmount_From;
	}
	
	public void setLineAmount_To(Float lineAmount_To) {
		this.lineAmount_To = lineAmount_To;
	}
	
	public Long getTaxId() {
		return this.taxId;
	}
	
	public Long getTaxId_From() {
		return this.taxId_From;
	}
	
	public Long getTaxId_To() {
		return this.taxId_To;
	}
	
	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}
	
	public void setTaxId_From(Long taxId_From) {
		this.taxId_From = taxId_From;
	}
	
	public void setTaxId_To(Long taxId_To) {
		this.taxId_To = taxId_To;
	}
	
	public String getTax() {
		return this.tax;
	}
	
	public void setTax(String tax) {
		this.tax = tax;
	}
}
