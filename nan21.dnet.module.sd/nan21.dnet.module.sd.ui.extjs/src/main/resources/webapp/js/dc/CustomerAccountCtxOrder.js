/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxOrder", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs",
	filterModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderDsFilter",
	paramModel: "net.nan21.dnet.module.sd.order.ds.param.SalesOrderDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxOrder$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_account_dc_CustomerAccountCtxOrder$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"supplierCode", dataIndex:"supplier", hidden:true, width:100})
			.addTextColumn({ name:"inventory", dataIndex:"inventory", hidden:true, width:100})
			.addTextColumn({ name:"code", dataIndex:"code", width:80})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:70})
			.addTextColumn({ name:"customerCode", dataIndex:"customerCode", hidden:true, width:100})
			.addTextColumn({ name:"customer", dataIndex:"customer", hidden:true, width:200})
			.addTextColumn({ name:"docType", dataIndex:"docType", width:120})
			.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount", decimals:2})
			.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", decimals:2})
			.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount", decimals:2})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed", width:70})
			.addBooleanColumn({ name:"invoiced", dataIndex:"invoiced", hidden:true, width:70})
			.addBooleanColumn({ name:"delivered", dataIndex:"delivered", hidden:true, width:70})
			.addTextColumn({ name:"priceList", dataIndex:"priceList", width:120})
			.addTextColumn({ name:"deliveryMethod", dataIndex:"deliveryMethod", hidden:true, width:120})
			.addTextColumn({ name:"billTo", dataIndex:"billTo", hidden:true, width:200})
			.addTextColumn({ name:"billToCode", dataIndex:"billToCode", hidden:true, width:100})
			.addTextColumn({ name:"shipTo", dataIndex:"shipTo", hidden:true, width:200})
			.addTextColumn({ name:"shipToCode", dataIndex:"shipToCode", hidden:true, width:100})
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"billToId", dataIndex:"billToId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"shipToId", dataIndex:"shipToId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"deliveryMethodId", dataIndex:"deliveryMethodId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"priceListId", dataIndex:"priceListId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});
