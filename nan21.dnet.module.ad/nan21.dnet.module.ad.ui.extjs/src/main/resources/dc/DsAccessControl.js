/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.usr.dc.DsAccessControl", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.DsAccessControlDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.DsAccessControlDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.DsAccessControl$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_usr_dc_DsAccessControl$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"ad_system_lovs_SysDataSourceDs", name:"dsName", dataIndex:"dsName", anchor:"-20"})
			.addLov({xtype:"ad_usr_lovs_AccessControls", name:"accessControl", dataIndex:"accessControl", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "accessControlId"} 
				]})
			.addBooleanField({ name:"queryAllowed", dataIndex:"queryAllowed", anchor:"-20"})
			.addBooleanField({ name:"insertAllowed", dataIndex:"insertAllowed", anchor:"-20"})
			.addBooleanField({ name:"updateAllowed", dataIndex:"updateAllowed", anchor:"-20"})
			.addBooleanField({ name:"deleteAllowed", dataIndex:"deleteAllowed", anchor:"-20"})
			.addBooleanField({ name:"importAllowed", dataIndex:"importAllowed", anchor:"-20"})
			.addBooleanField({ name:"exportAllowed", dataIndex:"exportAllowed", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:180, layout:"form"})
			.addPanel({ name:"col3", width:180, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["accessControl", "dsName"])
			.addChildrenTo("col2", ["queryAllowed", "importAllowed", "exportAllowed"])
			.addChildrenTo("col3", ["insertAllowed", "updateAllowed", "deleteAllowed"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.DsAccessControl$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_usr_dc_DsAccessControl$EditList",
	_bulkEditFields_: ["queryAllowed","insertAllowed","updateAllowed","deleteAllowed","importAllowed","exportAllowed"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accessControl", dataIndex:"accessControl", xtype:"gridcolumn", width:120,
					editor:{xtype:"ad_usr_lovs_AccessControls", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accessControlId"} 
						]}})
			.addLov({name:"dsName", dataIndex:"dsName", xtype:"gridcolumn", width:200,
					editor:{xtype:"ad_system_lovs_SysDataSourceDs", selectOnFocus:true}})
			.addBooleanColumn({name:"queryAllowed", dataIndex:"queryAllowed"})
			.addBooleanColumn({name:"insertAllowed", dataIndex:"insertAllowed"})
			.addBooleanColumn({name:"updateAllowed", dataIndex:"updateAllowed"})
			.addBooleanColumn({name:"deleteAllowed", dataIndex:"deleteAllowed"})
			.addBooleanColumn({name:"importAllowed", dataIndex:"importAllowed"})
			.addBooleanColumn({name:"exportAllowed", dataIndex:"exportAllowed"})
			.addNumberColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.DsAccessControl$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_usr_dc_DsAccessControl$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	_bulkEditFields_: ["queryAllowed","insertAllowed","updateAllowed","deleteAllowed","importAllowed","exportAllowed"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"dsName", dataIndex:"dsName", xtype:"gridcolumn", width:200,
					editor:{xtype:"ad_system_lovs_SysDataSourceDs", selectOnFocus:true}})
			.addBooleanColumn({name:"queryAllowed", dataIndex:"queryAllowed"})
			.addBooleanColumn({name:"insertAllowed", dataIndex:"insertAllowed"})
			.addBooleanColumn({name:"updateAllowed", dataIndex:"updateAllowed"})
			.addBooleanColumn({name:"deleteAllowed", dataIndex:"deleteAllowed"})
			.addBooleanColumn({name:"importAllowed", dataIndex:"importAllowed"})
			.addBooleanColumn({name:"exportAllowed", dataIndex:"exportAllowed"})
			.addNumberColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
