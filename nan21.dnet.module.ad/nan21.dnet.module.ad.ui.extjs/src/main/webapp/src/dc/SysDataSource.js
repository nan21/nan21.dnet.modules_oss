/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.system.dc.SysDataSource", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysDataSourceDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.SysDataSourceDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.SysDataSourceDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.SysDataSource$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_system_dc_SysDataSource$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"model", dataIndex:"model", anchor:"-20"})
			.addBooleanField({ name:"isAsgn", dataIndex:"isAsgn", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "model"])
			.addChildrenTo("col2", ["isAsgn"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.SysDataSource$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_system_dc_SysDataSource$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"model", dataIndex:"model", width:350})
			.addBooleanColumn({ name:"isAsgn", dataIndex:"isAsgn"})
			.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
			.addDefaults();
	}});
