/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvBalance", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvBalanceDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvBalance$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_inventory_dc_InvBalance$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_org_lovs_SubInventorys", name:"subInventory", dataIndex:"subInventory", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "subInventoryId"} 
				]})
			.addLov({xtype:"md_org_lovs_StockLocators", name:"locator", dataIndex:"locator", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "locatorId"} 
				]})
			.addLov({xtype:"md_mm_prod_lovs_Products", name:"item", dataIndex:"item", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "itemId"} 
				]})
			.addLov({xtype:"bd_uom_lovs_UnitsOfMeasure", name:"uom", dataIndex:"uom", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "uomId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["subInventory", "locator"])
			.addChildrenTo("col2", ["item", "uom"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvBalance$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_inventory_dc_InvBalance$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"subInventory", dataIndex:"subInventory", width:120})
			.addTextColumn({ name:"locator", dataIndex:"locator", width:120})
			.addTextColumn({ name:"item", dataIndex:"item", width:100})
			.addTextColumn({ name:"itemName", dataIndex:"itemName", width:200})
			.addNumberColumn({ name:"quantity", dataIndex:"quantity", decimals:2})
			.addTextColumn({ name:"uom", dataIndex:"uom", width:100})
			.addNumberColumn({ name:"subInventoryId", dataIndex:"subInventoryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"locatorId", dataIndex:"locatorId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= GRID: CtxListProduct ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvBalance$CtxListProduct", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_inventory_dc_InvBalance$CtxListProduct",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"inventory", dataIndex:"inventory", width:200})
			.addTextColumn({ name:"subInventory", dataIndex:"subInventory", width:120})
			.addTextColumn({ name:"locator", dataIndex:"locator", width:120})
			.addTextColumn({ name:"item", dataIndex:"item", hidden:true, width:100})
			.addNumberColumn({ name:"quantity", dataIndex:"quantity", decimals:2})
			.addTextColumn({ name:"uom", dataIndex:"uom", width:100})
			.addNumberColumn({ name:"inventoryId", dataIndex:"inventoryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"subInventoryId", dataIndex:"subInventoryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"locatorId", dataIndex:"locatorId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= FILTER: CtxFilterProduct ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvBalance$CtxFilterProduct", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.md_tx_inventory_dc_InvBalance$CtxFilterProduct",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_org_lovs_SubInventorys", name:"subInventory", dataIndex:"subInventory", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.org.lovs.SubInventorys", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "subInventoryId"} 
					]}})
			.addLov({xtype:"md_org_lovs_StockLocators", name:"locator", dataIndex:"locator", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.org.lovs.StockLocators", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "locatorId"} 
					],
					filterFieldMapping: [
						{lovField:"subInventoryId",dsField: "subInventoryId"} 
					]}})
		;
	}
});
