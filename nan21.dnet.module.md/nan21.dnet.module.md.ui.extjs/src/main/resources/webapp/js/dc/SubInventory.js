/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.org.dc.SubInventory", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.org.ds.model.SubInventoryDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.SubInventory$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_org_dc_SubInventory$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"bd_org_lovs_InventoryOrganizations", name:"inventory", dataIndex:"inventory", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "inventoryId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "inventory"])
			.addChildrenTo("col2", ["active"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.SubInventory$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_org_dc_SubInventory$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"inventory", dataIndex:"inventory", width:100})
			.addTextColumn({ name:"name", dataIndex:"name", width:120})
			.addTextColumn({ name:"description", dataIndex:"description", width:200})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addNumberColumn({ name:"inventoryId", dataIndex:"inventoryId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.org.dc.SubInventory$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_org_dc_SubInventory$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addLov({xtype:"bd_org_lovs_InventoryOrganizations", name:"inventory", dataIndex:"inventory", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "inventoryId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:400, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "description", "inventory"])
			.addChildrenTo("col2", ["active"])
		;
	}
});
