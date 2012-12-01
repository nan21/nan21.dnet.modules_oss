/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceHistoryDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceHistoryDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActProcessInstanceHistoryDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_workflow_dc_ActProcessInstanceHistory$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"id", _sharedLabel_:true, dataIndex:"id", anchor:"-20"})
			.addLov({xtype:"ad_workflow_lovs_ActProcessDefinitions", name:"processFullName", paramIndex:"processFullName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "processId"} 
				]})
			.addTextField({ name:"startedBy", dataIndex:"startedBy", anchor:"-20", maxLength:32})
			.addDateField({name:"startTime", dataIndex:"startTime", anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"endTime", dataIndex:"endTime", anchor:"-20", format:Ext.DATE_FORMAT})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["processFullName"])
			.addChildrenTo("col2", ["startTime", "endTime"])
			.addChildrenTo("col3", ["startedBy", "id"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstanceHistory$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_workflow_dc_ActProcessInstanceHistory$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"process", dataIndex:"process", width:200})
			.addNumberColumn({ name:"processVersion", dataIndex:"processVersion"})
			.addTextColumn({ name:"processInstanceId", dataIndex:"processInstanceId", hidden:true, width:150})
			.addDateColumn({ name:"startTime", dataIndex:"startTime", format: Dnet.DATETIME_FORMAT})
			.addDateColumn({ name:"endTime", dataIndex:"endTime", format: Dnet.DATETIME_FORMAT})
			.addTextColumn({ name:"duration", dataIndex:"durationText", width:200})
			.addNumberColumn({ name:"durationMili", dataIndex:"duration", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"startedBy", dataIndex:"startedBy", width:100})
			.addTextColumn({ name:"startAction", dataIndex:"startAction", width:100})
			.addTextColumn({ name:"endAction", dataIndex:"endAction", width:100})
			.addTextColumn({ name:"deleteReason", dataIndex:"deleteReason", width:100})
			.addDefaults();
	}
});
