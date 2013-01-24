/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.usr.dc.MenuItem", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.MenuItemDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.MenuItem$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_usr_dc_MenuItem$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"title", dataIndex:"title", anchor:"-20"})
			.addTextField({ name:"frame", dataIndex:"frame", anchor:"-20"})
			.addTextField({ name:"bundle", dataIndex:"bundle", anchor:"-20"})
			.addTextField({ name:"iconUrl", dataIndex:"iconUrl", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"separatorBefore", dataIndex:"separatorBefore", anchor:"-20"})
			.addBooleanField({ name:"separatorAfter", dataIndex:"separatorAfter", anchor:"-20"})
			.addLov({xtype:"ad_usr_lovs_MenuItems", name:"menuItem", dataIndex:"menuItem", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "menuItemId"} 
				]})
			.addLov({xtype:"ad_usr_lovs_Menus", name:"menu", dataIndex:"menu", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "menuId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:180, layout:"form"})
			.addPanel({ name:"col3", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "title", "frame", "bundle"])
			.addChildrenTo("col2", ["active", "separatorBefore", "separatorAfter"])
			.addChildrenTo("col3", ["menu", "menuItem", "iconUrl"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.MenuItem$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_usr_dc_MenuItem$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", width:70})
			.addTextColumn({ name:"name", dataIndex:"name", width:120})
			.addTextColumn({ name:"title", dataIndex:"title", width:200})
			.addTextColumn({ name:"menuItem", dataIndex:"menuItem", width:120})
			.addTextColumn({ name:"menu", dataIndex:"menu", width:120})
			.addTextColumn({ name:"frame", dataIndex:"frame", width:200})
			.addTextColumn({ name:"bundle", dataIndex:"bundle", width:200})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addTextColumn({ name:"description", dataIndex:"description", width:200})
			.addDefaults();
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.MenuItem$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_usr_dc_MenuItem$EditList",
	_bulkEditFields_: ["menu","menuItem","active","bundle","frame","sequenceNo"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"title", dataIndex:"title", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"menu", dataIndex:"menu", xtype:"gridcolumn", width:120,
					editor:{xtype:"ad_usr_lovs_Menus", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "menuId"} 
						]}})
			.addLov({name:"menuItem", dataIndex:"menuItem", xtype:"gridcolumn", width:120,
					editor:{xtype:"ad_usr_lovs_MenuItems", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "menuItemId"} 
						]}})
			.addTextColumn({name:"frame", dataIndex:"frame", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"bundle", dataIndex:"bundle", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active", width:70})
			.addTextColumn({name:"description", dataIndex:"description", hidden:true, width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"separatorBefore", dataIndex:"separatorBefore", hidden:true})
			.addBooleanColumn({name:"separatorAfter", dataIndex:"separatorAfter", hidden:true})
			.addTextColumn({name:"iconUrl", dataIndex:"iconUrl", hidden:true, width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.MenuItem$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_usr_dc_MenuItem$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"title", dataIndex:"title", anchor:"-20"})
			.addTextField({ name:"frame", dataIndex:"frame", anchor:"-20"})
			.addTextField({ name:"bundle", dataIndex:"bundle", anchor:"-20"})
			.addTextField({ name:"iconUrl", dataIndex:"iconUrl", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"separatorBefore", dataIndex:"separatorBefore", anchor:"-20"})
			.addBooleanField({ name:"separatorAfter", dataIndex:"separatorAfter", anchor:"-20"})
			.addLov({xtype:"ad_usr_lovs_MenuItems", name:"menuItem", dataIndex:"menuItem", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "menuItemId"} 
				]})
			.addLov({xtype:"ad_usr_lovs_Menus", name:"menu", dataIndex:"menu", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "menuId"} 
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
			.addChildrenTo("col1", ["name", "title", "separatorBefore", "separatorAfter", "iconUrl", "active"])
			.addChildrenTo("col2", ["menu", "menuItem", "frame", "bundle"])
		;
	}
});
