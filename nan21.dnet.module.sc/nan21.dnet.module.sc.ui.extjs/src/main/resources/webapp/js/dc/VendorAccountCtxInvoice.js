/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxInvoice", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.param.PurchaseInvoiceDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxInvoice$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_account_dc_VendorAccountCtxInvoice$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:70})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"customer", dataIndex:"customer", hidden:true, width:100})
			.addTextColumn({ name:"supplierCode", dataIndex:"supplierCode", hidden:true, width:100})
			.addTextColumn({ name:"supplier", dataIndex:"supplier", hidden:true, width:200})
			.addTextColumn({ name:"docType", dataIndex:"docType", width:120})
			.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount", decimals:2})
			.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", decimals:2})
			.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount", decimals:2})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:60})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})
			.addBooleanColumn({ name:"posted", dataIndex:"posted"})
			.addNumberColumn({ name:"purchaseOrderId", dataIndex:"purchaseOrderId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});
