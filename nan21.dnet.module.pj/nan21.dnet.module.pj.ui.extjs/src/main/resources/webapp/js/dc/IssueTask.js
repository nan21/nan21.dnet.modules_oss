/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTask", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueTaskDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.IssueTaskDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.IssueTaskDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTask$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.pj_md_dc_IssueTask$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addLov({xtype:"pj_md_lovs_Issues", name:"issue", dataIndex:"issue", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "issueId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueSeverities", name:"issueSeverity", dataIndex:"issueSeverity", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "issueSeverityId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueStatus", name:"issueStatus", dataIndex:"issueStatus", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "issueStatusId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueTypes", name:"issueType", dataIndex:"issueType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "issueTypeId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssuePriorities", name:"issuePriority", dataIndex:"issuePriority", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "issuePriorityId"} 
				]})
			.addLov({xtype:"pj_md_lovs_Projects", name:"project", dataIndex:"project", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "projectId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueTaskTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueTaskStatuses", name:"status", _sharedLabel_:true, dataIndex:"status", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addLov({xtype:"pj_md_lovs_ProjectMembers", name:"assignee", dataIndex:"assignee", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "assigneeId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			.addNumberField({name:"issueId", dataIndex:"issueId", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", title:"Task", width:220, layout:"form", xtype:"fieldset", border:true, collapsible:true, defaults:{labelAlign:"right", labelWidth:70}})
			.addPanel({ name:"col2", width:220, layout:"form", defaults:{labelAlign:"right", labelWidth:70}})
			.addPanel({ name:"col3", title:"Issue", width:250, layout:"form", xtype:"fieldset", border:true, collapsible:true})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col2", "col1", "col3"])
			.addChildrenTo("col1", ["type", "status", "assignee", "code"])
			.addChildrenTo("col2", ["project", "issue"])
			.addChildrenTo("col3", ["issueType", "issuePriority", "issueSeverity", "issueStatus"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTask$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.pj_md_dc_IssueTask$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:70})
			.addTextColumn({ name:"status", dataIndex:"status", width:80})
			.addTextColumn({ name:"type", dataIndex:"type", width:80})
			.addTextColumn({ name:"issue", dataIndex:"issue", width:70})
			.addTextColumn({ name:"issueSummary", dataIndex:"issueSummary", width:200})
			.addTextColumn({ name:"assignee", dataIndex:"assignee", width:120})
			.addNumberColumn({ name:"prioritySequenceNo", dataIndex:"issuePrioritySequenceNo", hidden:true})
			.addTextColumn({ name:"issuePriority", dataIndex:"issuePriority", width:80})
			.addTextColumn({ name:"issueSeverity", dataIndex:"issueSeverity", width:80})
			.addTextColumn({ name:"issueType", dataIndex:"issueType", width:80})
			.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
			.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"assigneeId", dataIndex:"assigneeId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"issueId", dataIndex:"issueId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTask$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.pj_md_dc_IssueTask$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addDisplayFieldText({ name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20"})
			.addLov({xtype:"pj_base_lovs_IssueTaskStatuses", name:"status", _sharedLabel_:true, dataIndex:"status", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addLov({xtype:"pj_md_lovs_ProjectMembers", name:"assignee", dataIndex:"assignee", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "assigneeId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:500, layout:"form", defaults:{labelAlign:"top"}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["type", "assignee", "status", "code"])
			.addChildrenTo("col2", ["description"])
		;
	}});


/* ================= EDITOR: ViewDescription ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTask$ViewDescription", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.pj_md_dc_IssueTask$ViewDescription",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20", asText:true, fieldStyle:"height:auto;"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true})
			.addPanel({ name:"r1", width:"90%", layout:"form", defaults:{labelAlign:"top"}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["r1"])
			.addChildrenTo("r1", ["description"])
		;
	}});


/* ================= EDITOR: View ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTask$View", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.pj_md_dc_IssueTask$View",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addTextField({ name:"issue", dataIndex:"issue", anchor:"-20", maxLength:32})
			.addTextField({ name:"issueSeverity", dataIndex:"issueSeverity", anchor:"-20"})
			.addTextField({ name:"issueStatus", dataIndex:"issueStatus", anchor:"-20"})
			.addTextField({ name:"issueType", dataIndex:"issueType", anchor:"-20"})
			.addTextField({ name:"issuePriority", dataIndex:"issuePriority", anchor:"-20"})
			.addTextField({ name:"project", dataIndex:"project", anchor:"-20", maxLength:32})
			.addTextField({ name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20"})
			.addTextField({ name:"status", _sharedLabel_:true, dataIndex:"status", anchor:"-20"})
			.addTextField({ name:"assignee", dataIndex:"assignee", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true})
			.addPanel({ name:"col1", title:"Task info", width:250, layout:"form", xtype:"fieldset", border:true, collapsible:true})
			.addPanel({ name:"col2", title:"Task description", width:250, layout:"form", xtype:"fieldset", border:true, collapsible:true})
			.addPanel({ name:"col3", title:"Issue info", width:250, layout:"form", xtype:"fieldset", border:true, collapsible:true})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["type", "status", "assignee", "code"])
			.addChildrenTo("col2", ["description"])
			.addChildrenTo("col3", ["project", "issue", "issueType", "issuePriority", "issueSeverity", "issueStatus"])
		;
	}});
