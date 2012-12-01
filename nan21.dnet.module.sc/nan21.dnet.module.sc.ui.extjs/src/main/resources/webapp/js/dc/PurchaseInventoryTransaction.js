/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseInventoryTransactionDs",
	filterModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseInventoryTransactionDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sc_order_dc_PurchaseInventoryTransaction$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"supplier", dataIndex:"supplier", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "supplierId"} 
				]})
			.addTextField({ name:"transactionType", dataIndex:"transactionType", anchor:"-20"})
			.addLov({xtype:"bd_org_lovs_InventoryOrganizations", name:"toInventory", dataIndex:"toInventory", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "toInventoryId"} 
				]})
			.addLov({xtype:"bd_org_lovs_InventoryOrganizations", name:"fromInventory", dataIndex:"fromInventory", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "fromInventoryId"} 
				]})
			.addDateField({name:"eventDate", dataIndex:"eventDate", anchor:"-20", format:Ext.DATE_FORMAT})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["supplier"])
			.addChildrenTo("col2", ["transactionType", "fromInventory", "toInventory"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sc_order_dc_PurchaseInventoryTransaction$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"supplier", dataIndex:"supplier", width:100})
			.addNumberColumn({ name:"transactionTypeId", dataIndex:"transactionTypeId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"transactionType", dataIndex:"transactionType", width:120})
			.addBooleanColumn({ name:"hasFromInventory", dataIndex:"hasFromInventory"})
			.addBooleanColumn({ name:"hasToInventory", dataIndex:"hasToInventory"})
			.addNumberColumn({ name:"fromInventoryId", dataIndex:"fromInventoryId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"fromInventory", dataIndex:"fromInventory", width:100})
			.addNumberColumn({ name:"toInventoryId", dataIndex:"toInventoryId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"toInventory", dataIndex:"toInventory", width:100})
			.addDateColumn({ name:"eventDate", dataIndex:"eventDate", format: Dnet.DATETIME_FORMAT})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sc_order_dc_PurchaseInventoryTransaction$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_bp_lovs_VendorsName", name:"supplier", dataIndex:"supplier", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "supplierId"} 
				]})
			.addLov({xtype:"bd_org_lovs_InventoryOrganizations", name:"fromInventory", dataIndex:"fromInventory", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "fromInventoryId"} 
				]})
			.addLov({xtype:"bd_org_lovs_InventoryOrganizations", name:"toInventory", dataIndex:"toInventory", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "toInventoryId"} 
				]})
			.addDateField({name:"eventDate", dataIndex:"eventDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"md_tx_inventory_lovs_InvTransactionTypes", name:"transactionType", dataIndex:"transactionType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "transactionTypeId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["supplier", "transactionType"])
			.addChildrenTo("col2", ["fromInventory", "toInventory", "eventDate"])
		;
	}
});
