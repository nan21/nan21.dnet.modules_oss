/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.DsMethodAccessControlDs",
	filterModel: "net.nan21.dnet.module.ad.usr.ds.model.DsMethodAccessControlDsFilter",
	paramModel: "net.nan21.dnet.module.ad.usr.ds.param.DsMethodAccessControlDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_usr_dc_DsMethodAccessControl$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"ad_system_lovs_SysDataSourceDs", name:"dsName", dataIndex:"dsName", anchor:"-20"})
			.addLov({xtype:"ad_usr_lovs_AccessControls", name:"accessControl", dataIndex:"accessControl", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "accessControlId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["accessControl", "dsName"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_usr_dc_DsMethodAccessControl$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accessControl", dataIndex:"accessControl", xtype:"gridcolumn", width:120,
					editor:{xtype:"ad_usr_lovs_AccessControls", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accessControlId"} 
						]}})
			.addLov({name:"dsName", dataIndex:"dsName", xtype:"gridcolumn", width:200,
					editor:{xtype:"ad_system_lovs_SysDataSourceDs", selectOnFocus:true}})
			.addLov({name:"serviceMethod", dataIndex:"serviceMethod", xtype:"gridcolumn", width:200,
					editor:{xtype:"ad_system_lovs_SysDsServices", selectOnFocus:true,
						filterFieldMapping: [
							{lovField:"dataSourceName",dsField: "dsName"} 
						]}})
			.addNumberColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_usr_dc_DsMethodAccessControl$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"dsName", dataIndex:"dsName", xtype:"gridcolumn", width:200,
					editor:{xtype:"ad_system_lovs_SysDataSourceDs", selectOnFocus:true}})
			.addLov({name:"serviceMethod", dataIndex:"serviceMethod", xtype:"gridcolumn", width:200,
					editor:{xtype:"ad_system_lovs_SysDsServices", selectOnFocus:true,
						filterFieldMapping: [
							{lovField:"dataSourceName",dsField: "dsName"} 
						]}})
			.addNumberColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
