/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderItemOverview", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderItemOverviewDs",
	filterModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderItemOverviewDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderItemOverview$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sd_order_dc_SalesOrderItemOverview$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"docCode", dataIndex:"docCode", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypesSI", name:"docType", dataIndex:"docType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "docTypeId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"customer", dataIndex:"customerName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "customerId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"supplier", dataIndex:"supplierName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "supplierId"} 
				]})
			.addBooleanField({ name:"confirmed", dataIndex:"confirmed", anchor:"-20"})
			.addDateField({name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
			.addDateField({name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
			.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"})
				.addChildrenTo("docDate",["docDate_From", "docDate_To"])
			.addLov({xtype:"md_mm_prod_lovs_Products", name:"productCode", dataIndex:"productCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "productId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:200, layout:"form"})
			.addPanel({ name:"col3", width:300, layout:"form"})
			.addPanel({ name:"col4", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["customer", "supplier", "docType"])
			.addChildrenTo("col2", ["docCode", "docNo", "currency"])
			.addChildrenTo("col3", ["docDate", "productCode"])
			.addChildrenTo("col4", ["confirmed"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderItemOverview$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_order_dc_SalesOrderItemOverview$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"docCode", dataIndex:"docCode", hidden:true, width:100})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", hidden:true, width:200})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", hidden:true, format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"docType", dataIndex:"docType", hidden:true, width:120})
			.addTextColumn({ name:"customerName", dataIndex:"customerName", hidden:true, width:200})
			.addTextColumn({ name:"supplierName", dataIndex:"supplierName", hidden:true, width:200})
			.addTextColumn({ name:"productCode", dataIndex:"productCode", width:100})
			.addTextColumn({ name:"productName", dataIndex:"productName", width:200})
			.addNumberColumn({ name:"quantity", dataIndex:"quantity", decimals:2})
			.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"uomCode", dataIndex:"uomCode", width:100})
			.addNumberColumn({ name:"netUnitPrice", dataIndex:"unitPrice", decimals:2})
			.addNumberColumn({ name:"netAmount", dataIndex:"netAmount", decimals:2})
			.addTextColumn({ name:"tax", dataIndex:"tax", hidden:true, width:120})
			.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount", decimals:2})
			.addNumberColumn({ name:"lineAmount", dataIndex:"lineAmount", decimals:2})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:100})
			.addNumberColumn({ name:"purchaseInvoiceId", dataIndex:"docId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"taxId", dataIndex:"taxId", hidden:true, width:70})
			.addDefaults();
	}
});


/* ================= EDITOR: DocView ================= */


Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderItemOverview$DocView", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sd_order_dc_SalesOrderItemOverview$DocView",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"docCode", dataIndex:"docCode", anchor:"-20", maxLength:32})
			.addDisplayFieldText({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addDisplayFieldDate({ name:"docDate", dataIndex:"docDate", allowBlank:false, anchor:"-20" })
			.addDisplayFieldText({ name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32})
			.addDisplayFieldText({ name:"docType", dataIndex:"docType", anchor:"-20"})
			.addDisplayFieldText({ name:"customerName", dataIndex:"customerName", anchor:"-20"})
			.addDisplayFieldText({ name:"supplierName", dataIndex:"supplierName", anchor:"-20"})
			.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed", anchor:"-20" })
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:200, layout:"form"})
			.addPanel({ name:"col3", width:200, layout:"form"})
			.addPanel({ name:"col4", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["customerName", "supplierName"])
			.addChildrenTo("col2", ["docDate", "docNo"])
			.addChildrenTo("col3", ["docType", "docCode"])
			.addChildrenTo("col4", ["confirmed"])
		;
	}
});
