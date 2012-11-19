/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.report.dc.Report", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.report.ds.model.ReportDs",
	filterModel: "net.nan21.dnet.module.ad.report.ds.model.ReportDsFilter",
	paramModel: "net.nan21.dnet.module.ad.report.ds.param.ReportDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.report.dc.Report$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_report_dc_Report$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addLov({xtype:"ad_report_lovs_ReportServers", name:"reportServer", dataIndex:"reportServer", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "reportServerId"} 
				]})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextField({ name:"contextPath", dataIndex:"contextPath", anchor:"-20"})
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
			.addChildrenTo("col2", ["reportServer", "contextPath"])
			.addChildrenTo("col3", ["active"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.report.dc.Report$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_report_dc_Report$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
			.addTextColumn({ name:"reportServer", dataIndex:"reportServer", width:120})
			.addTextColumn({ name:"contextPath", dataIndex:"contextPath", width:200})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addNumberColumn({ name:"reportServerId", dataIndex:"reportServerId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.ad.report.dc.Report$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_report_dc_Report$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", allowBlank:false, anchor:"-20", maxLength:32})
			.addTextField({ name:"contextPath", dataIndex:"contextPath", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addLov({xtype:"ad_report_lovs_ReportServers", name:"reportServer", dataIndex:"reportServer", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "reportServerId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:400, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "code", "reportServer", "contextPath", "active"])
			.addChildrenTo("col2", ["notes"])
		;
	}});
