/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.org.dc.Organization", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.org.dc.Organization$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_org_dc_Organization$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addLov({xtype:"bd_org_lovs_OrganizationTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			.addLov({xtype:"bd_org_lovs_Calendars", name:"calendar", dataIndex:"calendar", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "calendarId"} 
				]})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "code"])
			.addChildrenTo("col2", ["type", "calendar"])
			.addChildrenTo("col3", ["active"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.bd.org.dc.Organization$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.bd_org_dc_Organization$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"type", dataIndex:"type", width:120})
			.addTextColumn({ name:"calendar", dataIndex:"calendar", width:120})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addBooleanColumn({ name:"valid", dataIndex:"valid"})
			.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true, width:200})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.bd.org.dc.Organization$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.bd_org_dc_Organization$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", allowBlank:false, anchor:"-20", maxLength:32})
			.addLov({xtype:"bd_org_lovs_Calendars", name:"calendar", dataIndex:"calendar", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "calendarId"} 
				]})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"valid", _sharedLabel_:true, dataIndex:"valid", anchor:"-20"})
			.addLov({xtype:"bd_org_lovs_OrganizationTypes", name:"type", _sharedLabel_:true, dataIndex:"type", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
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
			.addChildrenTo("col1", ["name", "code", "notes"])
			.addChildrenTo("col2", ["type", "calendar", "active", "valid"])
		;
	}
});
