/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionLineDs",
	filterModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionLineDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.inventory.ds.param.InvTransactionLineDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_inventory_dc_InvTransactionLine$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"itemCode", dataIndex:"itemCode", anchor:"-20", maxLength:32})
			.addTextField({ name:"item", dataIndex:"item", anchor:"-20"})
			.addTextField({ name:"fromSubInventory", dataIndex:"fromSubInventory", anchor:"-20"})
			.addTextField({ name:"fromLocator", dataIndex:"fromLocator", anchor:"-20"})
			.addTextField({ name:"toSubInventory", dataIndex:"toSubInventory", anchor:"-20"})
			.addTextField({ name:"toLocator", dataIndex:"toLocator", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["itemCode"])
			.addChildrenTo("col2", ["fromSubInventory", "fromLocator"])
			.addChildrenTo("col3", ["toSubInventory", "toLocator"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_tx_inventory_dc_InvTransactionLine$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"itemCode", dataIndex:"itemCode", width:150})
			.addTextColumn({ name:"item", dataIndex:"item", hidden:true, width:200})
			.addTextColumn({ name:"fromSubInventory", dataIndex:"fromSubInventory", width:150})
			.addTextColumn({ name:"fromLocator", dataIndex:"fromLocator", width:150})
			.addTextColumn({ name:"toSubInventory", dataIndex:"toSubInventory", width:150})
			.addTextColumn({ name:"toLocator", dataIndex:"toLocator", width:150})
			.addNumberColumn({ name:"quantity", dataIndex:"quantity", decimals:2})
			.addTextColumn({ name:"uom", dataIndex:"uom", width:100})
			.addNumberColumn({ name:"transactionId", dataIndex:"transactionId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"fromInventoryId", dataIndex:"fromInventoryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"fromSubInventoryId", dataIndex:"fromSubInventoryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"fromLocatorId", dataIndex:"fromLocatorId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"toInventoryId", dataIndex:"toInventoryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"toSubInventoryId", dataIndex:"toSubInventoryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"toLocatorId", dataIndex:"toLocatorId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_tx_inventory_dc_InvTransactionLine$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"itemCode", dataIndex:"itemCode", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_mm_prod_lovs_ProductsWithUom", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "itemId"} ,{lovField:"name", dsField: "item"} ,{lovField:"uomId", dsField: "uomId"} ,{lovField:"uom", dsField: "uom"} 
						]}})
			.addTextColumn({name:"item", dataIndex:"item", hidden:true, width:200})
			.addLov({name:"fromSubInventory", dataIndex:"fromSubInventory", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_org_lovs_SubInventorys", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "fromSubInventoryId"} 
						],
						filterFieldMapping: [
							{lovField:"inventoryId",dsField: "fromInventoryId"} 
						]}})
			.addLov({name:"fromLocator", dataIndex:"fromLocator", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_org_lovs_StockLocators", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "fromLocatorId"} 
						],
						filterFieldMapping: [
							{lovField:"subInventoryId",dsField: "fromSubInventoryId"} 
						]}})
			.addLov({name:"toSubInventory", dataIndex:"toSubInventory", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_org_lovs_SubInventorys", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "toSubInventoryId"} 
						],
						filterFieldMapping: [
							{lovField:"inventoryId",dsField: "toInventoryId"} 
						]}})
			.addLov({name:"toLocator", dataIndex:"toLocator", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_org_lovs_StockLocators", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "toLocatorId"} 
						],
						filterFieldMapping: [
							{lovField:"subInventoryId",dsField: "toSubInventoryId"} 
						]}})
			.addNumberColumn({name:"quantity", dataIndex:"quantity", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"uom", dataIndex:"uom", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_uom_lovs_UnitsOfMeasureCode", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "uomId"} 
						]}})
			.addNumberColumn({name:"transactionId", dataIndex:"transactionId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"itemId", dataIndex:"itemId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"fromSubInventoryId", dataIndex:"fromSubInventoryId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"fromLocatorId", dataIndex:"fromLocatorId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"toSubInventoryId", dataIndex:"toSubInventoryId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"toLocatorId", dataIndex:"toLocatorId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: EditListFrom ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$EditListFrom", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_tx_inventory_dc_InvTransactionLine$EditListFrom",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"itemCode", dataIndex:"itemCode", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_mm_prod_lovs_ProductsWithUom", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "itemId"} ,{lovField:"name", dsField: "item"} ,{lovField:"uomId", dsField: "uomId"} ,{lovField:"uom", dsField: "uom"} 
						]}})
			.addTextColumn({name:"item", dataIndex:"item", hidden:true, width:200})
			.addLov({name:"fromSubInventory", dataIndex:"fromSubInventory", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_org_lovs_SubInventorys", selectOnFocus:true, allowBlank:false,
						retFieldMapping: [
							{lovField:"id", dsField: "fromSubInventoryId"} 
						],
						filterFieldMapping: [
							{lovField:"inventoryId",dsField: "fromInventoryId"} 
						]}})
			.addLov({name:"fromLocator", dataIndex:"fromLocator", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_org_lovs_StockLocators", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "fromLocatorId"} 
						],
						filterFieldMapping: [
							{lovField:"subInventoryId",dsField: "fromSubInventoryId"} 
						]}})
			.addNumberColumn({name:"quantity", dataIndex:"quantity", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"uom", dataIndex:"uom", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_uom_lovs_UnitsOfMeasureCode", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "uomId"} 
						]}})
			.addNumberColumn({name:"transactionId", dataIndex:"transactionId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"itemId", dataIndex:"itemId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"fromSubInventoryId", dataIndex:"fromSubInventoryId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"fromLocatorId", dataIndex:"fromLocatorId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: EditListTo ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$EditListTo", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_tx_inventory_dc_InvTransactionLine$EditListTo",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"itemCode", dataIndex:"itemCode", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_mm_prod_lovs_ProductsWithUom", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "itemId"} ,{lovField:"name", dsField: "item"} ,{lovField:"uomId", dsField: "uomId"} ,{lovField:"uom", dsField: "uom"} 
						]}})
			.addTextColumn({name:"item", dataIndex:"item", hidden:true, width:200})
			.addLov({name:"toSubInventory", dataIndex:"toSubInventory", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_org_lovs_SubInventorys", selectOnFocus:true, allowBlank:false,
						retFieldMapping: [
							{lovField:"id", dsField: "toSubInventoryId"} 
						],
						filterFieldMapping: [
							{lovField:"inventoryId",dsField: "toInventoryId"} 
						]}})
			.addLov({name:"toLocator", dataIndex:"toLocator", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_org_lovs_StockLocators", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "toLocatorId"} 
						],
						filterFieldMapping: [
							{lovField:"subInventoryId",dsField: "toSubInventoryId"} 
						]}})
			.addNumberColumn({name:"quantity", dataIndex:"quantity", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"uom", dataIndex:"uom", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_uom_lovs_UnitsOfMeasureCode", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "uomId"} 
						]}})
			.addNumberColumn({name:"transactionId", dataIndex:"transactionId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"itemId", dataIndex:"itemId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"toSubInventoryId", dataIndex:"toSubInventoryId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"toLocatorId", dataIndex:"toLocatorId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: CtxFormView ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine$CtxFormView", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_tx_inventory_dc_InvTransactionLine$CtxFormView",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"item", dataIndex:"item", anchor:"-20", fieldCls:"displayfield important-field"})
			.addDisplayFieldNumber({ name:"quantity", dataIndex:"quantity", anchor:"-20", fieldCls:"displayfield important-field", decimals:2 })
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:500, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["item"])
			.addChildrenTo("col2", ["quantity"])
		;
	}});
