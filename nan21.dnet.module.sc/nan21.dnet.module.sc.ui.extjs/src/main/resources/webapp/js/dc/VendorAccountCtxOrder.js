/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxOrder", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDs",
	filterModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDsFilter",
	paramModel: "net.nan21.dnet.module.sc.order.ds.param.PurchaseOrderDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.account.dc.VendorAccountCtxOrder$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_account_dc_VendorAccountCtxOrder$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"customer", dataIndex:"customer", hidden:true, width:100})
			.addTextColumn({ name:"inventory", dataIndex:"inventory", hidden:true, width:100})
			.addTextColumn({ name:"code", dataIndex:"code", width:80})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:70})
			.addTextColumn({ name:"supplierCode", dataIndex:"supplier", hidden:true, width:200})
			.addTextColumn({ name:"supplier", dataIndex:"supplier", hidden:true, width:200})
			.addTextColumn({ name:"docType", dataIndex:"docType", width:120})
			.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount", decimals:2})
			.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount", decimals:2})
			.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount", decimals:2})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"deliveryMethodId", dataIndex:"deliveryMethodId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"deliveryMethod", dataIndex:"deliveryMethod", hidden:true, width:120})
			.addDefaults();
	}});
