/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.AsgnAccessControlDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_usr_dc_AsgnAccessControl$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"ad_system_lovs_SysDataSourceAsgn", name:"dsName", dataIndex:"dsName", anchor:"-20"})
			.addLov({xtype:"ad_usr_lovs_AccessControls", name:"accessControl", dataIndex:"accessControl", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "accessControlId"} 
				]})
			.addBooleanField({ name:"queryAllowed", dataIndex:"queryAllowed", anchor:"-20"})
			.addBooleanField({ name:"updateAllowed", dataIndex:"updateAllowed", anchor:"-20"})
			.addBooleanField({ name:"importAllowed", dataIndex:"importAllowed", anchor:"-20"})
			.addBooleanField({ name:"exportAllowed", dataIndex:"exportAllowed", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:180, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["accessControl", "dsName"])
			.addChildrenTo("col2", ["queryAllowed", "updateAllowed"])
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_usr_dc_AsgnAccessControl$EditList",
	_bulkEditFields_: ["queryAllowed","updateAllowed"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accessControl", dataIndex:"accessControl", xtype:"gridcolumn", width:120,
					editor:{xtype:"ad_usr_lovs_AccessControls", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accessControlId"} 
						]}})
			.addLov({name:"dsName", dataIndex:"dsName", xtype:"gridcolumn", width:200,
					editor:{xtype:"ad_system_lovs_SysDataSourceAsgn", selectOnFocus:true}})
			.addBooleanColumn({name:"queryAllowed", dataIndex:"queryAllowed"})
			.addBooleanColumn({name:"updateAllowed", dataIndex:"updateAllowed"})
			.addNumberColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_usr_dc_AsgnAccessControl$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	_bulkEditFields_: ["queryAllowed","updateAllowed"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"dsName", dataIndex:"dsName", xtype:"gridcolumn", width:200,
					editor:{xtype:"ad_system_lovs_SysDataSourceAsgn", selectOnFocus:true}})
			.addBooleanColumn({name:"queryAllowed", dataIndex:"queryAllowed"})
			.addBooleanColumn({name:"updateAllowed", dataIndex:"updateAllowed"})
			.addNumberColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
