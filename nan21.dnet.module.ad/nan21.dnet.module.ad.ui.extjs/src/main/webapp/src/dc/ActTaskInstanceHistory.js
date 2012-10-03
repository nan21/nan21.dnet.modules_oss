/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceHistoryDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceHistoryDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActTaskInstanceHistoryDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_workflow_dc_ActTaskInstanceHistory$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"id", _sharedLabel_:true, dataIndex:"id", anchor:"-20"})
			.addTextField({ name:"processDefinitionId", dataIndex:"processDefinitionId", anchor:"-20"})
			.addTextField({ name:"taskDefinitionKey", dataIndex:"taskDefinitionKey", anchor:"-20"})
			.addTextField({ name:"processInstanceId", dataIndex:"processInstanceId", anchor:"-20"})
			.addTextField({ name:"executionId", dataIndex:"executionId", anchor:"-20"})
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addTextField({ name:"assignee", dataIndex:"assignee", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["id", "processDefinitionId", "taskDefinitionKey", "processInstanceId", "executionId", "name", "description", "assignee"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_workflow_dc_ActTaskInstanceHistory$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"processDefinitionId", dataIndex:"processDefinitionId", hidden:true, width:150})
			.addTextColumn({ name:"taskDefinitionKey", dataIndex:"taskDefinitionKey", width:200})
			.addTextColumn({ name:"processInstanceId", dataIndex:"processInstanceId", hidden:true, width:150})
			.addTextColumn({ name:"executionId", dataIndex:"executionId", hidden:true, width:200})
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"description", dataIndex:"description", width:200})
			.addTextColumn({ name:"assignee", dataIndex:"assignee", width:100})
			.addDateColumn({ name:"startTime", dataIndex:"startTime", format: Dnet.DATETIME_FORMAT})
			.addTextColumn({ name:"duration", dataIndex:"durationText", width:200})
			.addNumberColumn({ name:"durationMili", dataIndex:"duration", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"priority", dataIndex:"priority", hidden:true, width:70, format:"0"})
			.addDateColumn({ name:"dueDate", dataIndex:"dueDate", hidden:true, format: Dnet.DATETIME_FORMAT})
			.addDefaults();
	}});


/* ================= EDITOR: AssignForm ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActTaskInstanceHistory$AssignForm", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_workflow_dc_ActTaskInstanceHistory$AssignForm",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"assignee", dataIndex:"assignee", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["assignee"])
		;
	}});
