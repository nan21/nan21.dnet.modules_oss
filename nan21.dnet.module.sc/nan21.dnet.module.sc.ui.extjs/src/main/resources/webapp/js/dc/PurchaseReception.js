/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseReception", {
	extend: "dnet.core.dc.AbstractDc",

	filterModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseReceptionDsFilter",
	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseReceptionDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseReception$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sc_order_dc_PurchaseReception$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addLov({xtype:"md_tx_inventory_lovs_InvTransactionTypes", name:"transactionType", dataIndex:"transactionType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "transactionTypeId"} 
				]})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"supplier", dataIndex:"supplier", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "supplierId"} 
				]})
			.addLov({xtype:"bd_org_lovs_WarehouseOrganizations", name:"warehouse", dataIndex:"warehouse", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "warehouseId"} 
				]})
			.addLov({xtype:"bd_org_lovs_CarrierOrganizations", name:"carrier", dataIndex:"carrier", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "carrierId"} 
				]})
			.addDateField({name:"eventDate_From", dataIndex:"eventDate_From", emptyText:"From" })
			.addDateField({name:"eventDate_To", dataIndex:"eventDate_To", emptyText:"To" })
			.addFieldContainer({name: "eventDate", fieldLabel:"Event Date"})
				.addChildrenTo("eventDate",["eventDate_From", "eventDate_To"])
			.addDateField({name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
			.addDateField({name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
			.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"})
				.addChildrenTo("docDate",["docDate_From", "docDate_To"])
			.addBooleanField({ name:"confirmed", dataIndex:"confirmed", anchor:"-20"})
			.addBooleanField({ name:"posted", dataIndex:"posted", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:200, layout:"form"})
			.addPanel({ name:"col3", width:300, layout:"form"})
			.addPanel({ name:"col4", width:180, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["warehouse", "supplier", "transactionType", "carrier"])
			.addChildrenTo("col2", ["code", "docNo"])
			.addChildrenTo("col3", ["docDate", "eventDate"])
			.addChildrenTo("col4", ["confirmed", "posted"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseReception$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_order_dc_PurchaseReception$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:70})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addDateColumn({ name:"eventDate", dataIndex:"eventDate", format: Dnet.DATETIME_FORMAT})
			.addTextColumn({ name:"transactionType", dataIndex:"transactionType", width:120})
			.addTextColumn({ name:"warehouse", dataIndex:"warehouse", width:100})
			.addTextColumn({ name:"supplier", dataIndex:"supplier", width:200})
			.addTextColumn({ name:"carrier", dataIndex:"carrier", width:100})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})
			.addBooleanColumn({ name:"posted", dataIndex:"posted"})
			.addNumberColumn({ name:"warehouseId", dataIndex:"warehouseId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"transactionTypeId", dataIndex:"transactionTypeId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"carrierId", dataIndex:"carrierId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseReception$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sc_order_dc_PurchaseReception$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addDateField({name:"docDate", dataIndex:"docDate", allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			.addDisplayFieldDate({ name:"eventDate", dataIndex:"eventDate", anchor:"-20" })
			.addLov({xtype:"md_bp_lovs_VendorsName", name:"supplier", dataIndex:"supplier", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "supplierId"} 
				]})
			.addLov({xtype:"bd_org_lovs_WarehouseOrganizations", name:"warehouse", dataIndex:"warehouse", noUpdate:true, allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "warehouseId"} 
				]})
			.addLov({xtype:"bd_org_lovs_CarrierOrganizations", name:"carrier", dataIndex:"carrier", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "carrierId"} 
				]})
			.addLov({xtype:"md_tx_inventory_lovs_InvTransactionTypes", name:"transactionType", dataIndex:"transactionType", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "transactionTypeId"} 
				]})
			.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed", anchor:"-20" })
			.addDisplayFieldBoolean({ name:"posted", dataIndex:"posted", anchor:"-20" })
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["transactionType", "warehouse", "supplier", "carrier"])
			.addChildrenTo("col2", ["docDate", "docNo", "code", "eventDate"])
			.addChildrenTo("col3", ["confirmed", "posted"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	_beforeApplyStates_: function(record) {
		
		if (record.get("confirmed") || record.get("posted") ) {
			this._disableAllFields_();
			return false;
		}
	},
	
	_endDefine_: function() {
		
		this._controller_.on("afterDoServiceSuccess", function(dc, response, name, options) {
		 	this._applyStates_(dc.record);
		 } , this )
	}

});
