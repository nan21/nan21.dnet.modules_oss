/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransaction", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionDs",
	filterModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransaction$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_inventory_dc_InvTransaction$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"docNo", dataIndex:"docNo", anchor:"-20"})
			.addLov({xtype:"md_tx_inventory_lovs_InvTransactionTypes", name:"transactionType", dataIndex:"transactionType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "transactionTypeId"} 
				]})
			.addLov({xtype:"bd_org_lovs_InventoryOrganizations", name:"fromInventory", dataIndex:"fromInventory", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "fromInventoryId"} 
				]})
			.addLov({xtype:"bd_org_lovs_InventoryOrganizations", name:"toInventory", dataIndex:"toInventory", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "toInventoryId"} 
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
			.addPanel({ name:"col1", width:220, layout:"form"})
			.addPanel({ name:"col2", width:200, layout:"form"})
			.addPanel({ name:"col3", width:300, layout:"form"})
			.addPanel({ name:"col4", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
			.addChildrenTo("col1", ["transactionType", "fromInventory", "toInventory"])
			.addChildrenTo("col2", ["code", "docNo"])
			.addChildrenTo("col3", ["eventDate", "docDate"])
			.addChildrenTo("col4", ["confirmed", "posted"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransaction$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_inventory_dc_InvTransaction$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"docNo", dataIndex:"docNo", width:70})
			.addDateColumn({ name:"docDate", dataIndex:"docDate", format: Dnet.DATE_FORMAT})
			.addDateColumn({ name:"eventDate", dataIndex:"eventDate", format: Dnet.DATETIME_FORMAT})
			.addTextColumn({ name:"transactionType", dataIndex:"transactionType", width:120})
			.addTextColumn({ name:"fromInventory", dataIndex:"fromInventory", width:150})
			.addTextColumn({ name:"toInventory", dataIndex:"toInventory", width:150})
			.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})
			.addBooleanColumn({ name:"posted", dataIndex:"posted"})
			.addNumberColumn({ name:"transactionTypeId", dataIndex:"transactionTypeId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"fromInventoryId", dataIndex:"fromInventoryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"toInventoryId", dataIndex:"toInventoryId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
