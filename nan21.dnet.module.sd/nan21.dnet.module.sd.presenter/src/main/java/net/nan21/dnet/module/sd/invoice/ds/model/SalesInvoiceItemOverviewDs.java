/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.sd.invoice.ds.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;
import net.nan21.dnet.module.sd.invoice.domain.entity.SalesInvoiceItem;

@Ds(entity=SalesInvoiceItem.class)
public class SalesInvoiceItemOverviewDs extends AbstractAuditableDs<SalesInvoiceItem> {

 	public static final String fDOCID = "docId";
 	public static final String fDOCCODE = "docCode";
 	public static final String fDOCNO = "docNo";
 	public static final String fDOCDATE = "docDate";
 	public static final String fCUSTOMERID = "customerId";
 	public static final String fCUSTOMERCODE = "customerCode";
 	public static final String fCUSTOMERNAME = "customerName";
 	public static final String fSUPPLIERID = "supplierId";
 	public static final String fSUPPLIERCODE = "supplierCode";
 	public static final String fSUPPLIERNAME = "supplierName";
 	public static final String fDOCTYPEID = "docTypeId";
 	public static final String fDOCTYPE = "docType";
 	public static final String fCURRENCYID = "currencyId";
 	public static final String fCURRENCY = "currency";
 	public static final String fCONFIRMED = "confirmed";
 	public static final String fPOSTED = "posted";
 	public static final String fPRODUCTID = "productId";
 	public static final String fPRODUCTCODE = "productCode";
 	public static final String fPRODUCTNAME = "productName";
 	public static final String fDESCRIPTION = "description";
 	public static final String fQUANTITY = "quantity";
 	public static final String fUOMID = "uomId";
 	public static final String fUOMCODE = "uomCode";
 	public static final String fUNITPRICE = "unitPrice";
 	public static final String fNETAMOUNT = "netAmount";
 	public static final String fTAXAMOUNT = "taxAmount";
 	public static final String fLINEAMOUNT = "lineAmount";
 	public static final String fTAXID = "taxId";
 	public static final String fTAX = "tax";
 	
 	@DsField(join="left", path="salesInvoice.id")
 	private Long docId;
 	
 	@DsField(join="left", path="salesInvoice.code")
 	private String docCode;
 	
 	@DsField(join="left", path="salesInvoice.docNo")
 	private String docNo;
 	
 	@DsField(join="left", path="salesInvoice.docDate")
 	private Date docDate;
 	
 	@DsField(join="left", path="salesInvoice.customer.id")
 	private Long customerId;
 	
 	@DsField(join="left", path="salesInvoice.customer.code")
 	private String customerCode;
 	
 	@DsField(join="left", path="salesInvoice.customer.name")
 	private String customerName;
 	
 	@DsField(join="left", path="salesInvoice.supplier.id")
 	private Long supplierId;
 	
 	@DsField(join="left", path="salesInvoice.supplier.code")
 	private String supplierCode;
 	
 	@DsField(join="left", path="salesInvoice.supplier.name")
 	private String supplierName;
 	
 	@DsField(join="left", path="salesInvoice.docType.id")
 	private Long docTypeId;
 	
 	@DsField(join="left", path="salesInvoice.docType.name")
 	private String docType;
 	
 	@DsField(join="left", path="salesInvoice.currency.id")
 	private Long currencyId;
 	
 	@DsField(join="left", path="salesInvoice.currency.code")
 	private String currency;
 	
 	@DsField(join="left", path="salesInvoice.confirmed")
 	private Boolean confirmed;
 	
 	@DsField(join="left", path="salesInvoice.posted")
 	private Boolean posted;
 	
 	@DsField(join="left", path="product.id")
 	private Long productId;
 	
 	@DsField(join="left", path="product.code")
 	private String productCode;
 	
 	@DsField(join="left", path="product.name")
 	private String productName;
 	
 	@DsField()
 	private String description;
 	
 	@DsField()
 	private Float quantity;
 	
 	@DsField(join="left", path="uom.id")
 	private Long uomId;
 	
 	@DsField(join="left", path="uom.code")
 	private String uomCode;
 	
 	@DsField()
 	private Float unitPrice;
 	
 	@DsField()
 	private Float netAmount;
 	
 	@DsField()
 	private Float taxAmount;
 	
 	@DsField(fetch=false)
 	private Float lineAmount;
 	
 	@DsField(join="left", path="tax.id")
 	private Long taxId;
 	
 	@DsField(join="left", path="tax.name")
 	private String tax;

	public SalesInvoiceItemOverviewDs() {
		super();
	}

 	public SalesInvoiceItemOverviewDs(SalesInvoiceItem e) {
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
	
	public Boolean getPosted() {
		return this.posted;
	}
	
	public void setPosted(Boolean posted) {
		this.posted = posted;
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
