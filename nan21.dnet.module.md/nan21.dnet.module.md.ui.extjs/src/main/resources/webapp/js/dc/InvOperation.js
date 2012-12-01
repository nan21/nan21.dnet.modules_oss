/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvOperation", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvOperationDs",
	filterModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvOperationDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvOperation$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_inventory_dc_InvOperation$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDateField({name:"eventDate_From", dataIndex:"eventDate_From", emptyText:"From" })
			.addDateField({name:"eventDate_To", dataIndex:"eventDate_To", emptyText:"To" })
			.addFieldContainer({name: "eventDate", fieldLabel:"Event Date"})
				.addChildrenTo("eventDate",["eventDate_From", "eventDate_To"])
			.addLov({xtype:"md_mm_prod_lovs_Products", name:"itemCode", dataIndex:"itemCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "itemId"} 
				]})
			.addTextField({ name:"item", dataIndex:"item", anchor:"-20"})
			.addLov({xtype:"bd_org_lovs_InventoryOrganizations", name:"inventory", dataIndex:"inventory", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "inventoryId"} 
				]})
			.addLov({xtype:"md_org_lovs_SubInventorys", name:"subInventory", dataIndex:"subInventory", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "subInventoryId"} 
				],
				filterFieldMapping: [
					{lovField:"inventoryId",dsField: "inventoryId"} 
				]})
			.addLov({xtype:"md_org_lovs_StockLocators", name:"locator", dataIndex:"locator", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "locatorId"} 
				],
				filterFieldMapping: [
					{lovField:"subInventoryId",dsField: "subInventoryId"} 
				]})
			.addCombo({ xtype:"combo", name:"direction", dataIndex:"direction", anchor:"-20",
				store:[ "in", "out"]
			})
			.addNumberField({name:"transactionId", dataIndex:"transactionId", anchor:"-20"})
			.addNumberField({name:"transactionLineId", dataIndex:"transactionLineId", anchor:"-20"})
			.addNumberField({name:"quantity", dataIndex:"quantity", anchor:"-20", decimals:2})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:220, layout:"form"})
			.addPanel({ name:"col3", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["itemCode", "eventDate"])
			.addChildrenTo("col2", ["inventory", "subInventory", "locator"])
			.addChildrenTo("col3", ["direction", "transactionId", "transactionLineId"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvOperation$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_inventory_dc_InvOperation$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addDateColumn({ name:"eventDate", dataIndex:"eventDate", format: Dnet.DATETIME_FORMAT})
			.addTextColumn({ name:"itemCode", dataIndex:"itemCode", width:100})
			.addTextColumn({ name:"item", dataIndex:"item", width:200})
			.addTextColumn({ name:"inventory", dataIndex:"inventory", width:100})
			.addTextColumn({ name:"inventoryName", dataIndex:"inventoryName", hidden:true, width:200})
			.addTextColumn({ name:"subInventory", dataIndex:"subInventory", width:120})
			.addTextColumn({ name:"locator", dataIndex:"locator", width:120})
			.addTextColumn({ name:"direction", dataIndex:"direction", width:60})
			.addNumberColumn({ name:"quantity", dataIndex:"quantity", decimals:2})
			.addTextColumn({ name:"uom", dataIndex:"uom", width:80})
			.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"inventoryId", dataIndex:"inventoryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"subInventoryId", dataIndex:"subInventoryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"locatorId", dataIndex:"locatorId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"transactionId", dataIndex:"transactionId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"transactionLineId", dataIndex:"transactionLineId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
