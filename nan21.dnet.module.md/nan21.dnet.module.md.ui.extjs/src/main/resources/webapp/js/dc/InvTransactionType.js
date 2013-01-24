/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionType", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionTypeDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionType$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_tx_inventory_dc_InvTransactionType$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"hasFromInventory", dataIndex:"hasFromInventory", anchor:"-20"})
			.addBooleanField({ name:"hasToInventory", dataIndex:"hasToInventory", anchor:"-20"})
			.addLov({xtype:"md_base_tx_lovs_TxDocTypes", name:"docType", dataIndex:"docType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "docTypeId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:200, layout:"form", defaults:{labelAlign:"right", labelWidth:120}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "docType"])
			.addChildrenTo("col2", ["active", "hasFromInventory", "hasToInventory"])
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionType$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_tx_inventory_dc_InvTransactionType$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"docType", dataIndex:"docType", xtype:"gridcolumn", width:120,
					editor:{xtype:"md_base_tx_lovs_TxDocTypes", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "docTypeId"} 
						]}})
			.addBooleanColumn({name:"hasFromInventory", dataIndex:"hasFromInventory"})
			.addBooleanColumn({name:"hasToInventory", dataIndex:"hasToInventory"})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"docTypeId", dataIndex:"docTypeId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
