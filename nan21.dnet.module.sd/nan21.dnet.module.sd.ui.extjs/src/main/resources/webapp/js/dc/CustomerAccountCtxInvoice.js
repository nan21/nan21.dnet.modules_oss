/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxInvoice", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs",
	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxInvoice$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_account_dc_CustomerAccountCtxInvoice$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:80})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"supplierCode", dataIndex:"supplier", hidden:true, width:100})
			.addTextColumn({ name:"customerCode", dataIndex:"customerCode", hidden:true, width:100})
			.addTextColumn({ name:"customer", dataIndex:"customer", hidden:true, width:200})
			.addTextColumn({ name:"docType", dataIndex:"docType", width:120})
			.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount", decimals:2})
			.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", decimals:2})
			.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount", decimals:2})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:60})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})
			.addBooleanColumn({ name:"posted", dataIndex:"posted"})
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"salesOrderId", dataIndex:"salesOrderId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});
