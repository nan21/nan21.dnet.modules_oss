/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.md.dc.Issue", {
	extend: "dnet.core.dc.AbstractDc",

	paramModel: "net.nan21.dnet.module.pj.md.ds.model.IssueDsParam",
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.Issue$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.pj_md_dc_Issue$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"summary", dataIndex:"summary", anchor:"-20"})
			.addTextField({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addLov({xtype:"pj_md_lovs_Projects", name:"project", dataIndex:"project", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "projectId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueStatus", name:"status", _sharedLabel_:true, dataIndex:"status", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssuePriorities", name:"priority", dataIndex:"priority", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priorityId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueResolutions", name:"resolution", dataIndex:"resolution", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "resolutionId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueSeverities", name:"severity", dataIndex:"severity", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "severityId"} 
				]})
			.addLov({xtype:"pj_md_lovs_ProjectMembers", name:"assignee", dataIndex:"assignee", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "assigneeId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			.addLov({xtype:"pj_md_lovs_ProjectVersions", name:"reportedVersion", dataIndex:"reportedVersion", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "reportedVersionId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			.addLov({xtype:"pj_md_lovs_ProjectVersions", name:"targetVersion", dataIndex:"targetVersion", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "targetVersionId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			.addLov({xtype:"pj_md_lovs_ProjectVersions", name:"fixedInVersion", dataIndex:"fixedInVersion", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "fixedInVersionId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			.addLov({xtype:"pj_md_lovs_ProjectVersions", name:"affectedVersion", paramIndex:"affectedVersion", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "affectedVersionId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			.addLov({xtype:"pj_md_lovs_ProjectComponents", name:"affectedComponent", paramIndex:"affectedComponent", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "affectedComponentId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:200, layout:"form", defaults:{labelAlign:"right", labelWidth:70}})
			.addPanel({ name:"col2", width:200, layout:"form", defaults:{labelAlign:"right", labelWidth:70}})
			.addPanel({ name:"col3", width:200, layout:"form", defaults:{labelAlign:"right", labelWidth:70}})
			.addPanel({ name:"col4", width:200, layout:"form"})
			.addPanel({ name:"col5", width:200, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3", "col4", "col5"])
			.addChildrenTo("col1", ["project", "type", "code"])
			.addChildrenTo("col2", ["summary", "description", "assignee"])
			.addChildrenTo("col3", ["status", "severity", "priority"])
			.addChildrenTo("col4", ["affectedComponent", "affectedVersion", "resolution"])
			.addChildrenTo("col5", ["reportedVersion", "targetVersion", "fixedInVersion"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.Issue$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.pj_md_dc_Issue$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:80})
			.addTextColumn({ name:"project", dataIndex:"project", width:80})
			.addTextColumn({ name:"projectName", dataIndex:"projectName", hidden:true, width:200})
			.addTextColumn({ name:"summary", dataIndex:"summary", width:200})
			.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
			.addDateColumn({ name:"dueDate", dataIndex:"dueDate", width:80, format: Dnet.DATE_FORMAT})
			.addDateColumn({ name:"resolutionDate", dataIndex:"resolutionDate", hidden:true, width:80, format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"type", dataIndex:"type", width:80})
			.addTextColumn({ name:"status", dataIndex:"status", width:80})
			.addTextColumn({ name:"priority", dataIndex:"priority", width:80})
			.addTextColumn({ name:"resolution", dataIndex:"resolution", width:80})
			.addTextColumn({ name:"severity", dataIndex:"severity", width:80})
			.addTextColumn({ name:"assignee", dataIndex:"assignee", width:120})
			.addTextColumn({ name:"assigneeRole", dataIndex:"assigneeRole", hidden:true, width:120})
			.addTextColumn({ name:"reportedVersion", dataIndex:"reportedVersion", hidden:true, width:120})
			.addTextColumn({ name:"targetVersion", dataIndex:"targetVersion", hidden:true, width:120})
			.addTextColumn({ name:"fixedInVersion", dataIndex:"fixedInVersion", hidden:true, width:120})
			.addNumberColumn({ name:"businessValue", dataIndex:"businessValue", width:80})
			.addNumberColumn({ name:"estimatedEffort", dataIndex:"estimatedEffort", hidden:true, width:80})
			.addNumberColumn({ name:"clarity", dataIndex:"clarity", hidden:true, width:80})
			.addNumberColumn({ name:"projectId", dataIndex:"projectId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"assigneeId", dataIndex:"assigneeId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.Issue$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.pj_md_dc_Issue$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addLov({xtype:"pj_md_lovs_Projects", name:"project", dataIndex:"project", noUpdate:true, allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "projectId"} ,{lovField:"name", dsField: "projectName"} 
				]})
			.addDisplayFieldText({ name:"projectName", dataIndex:"projectName", anchor:"-20"})
			.addTextField({ name:"summary", dataIndex:"summary", allowBlank:false, anchor:"-20"})
			.addDateField({name:"dueDate", dataIndex:"dueDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addDisplayFieldDate({ name:"resolutionDate", dataIndex:"resolutionDate", anchor:"-20" })
			.addLov({xtype:"pj_base_lovs_IssueTypes", name:"type", _sharedLabel_:true, dataIndex:"type", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueStatus", name:"status", _sharedLabel_:true, dataIndex:"status", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssuePriorities", name:"priority", dataIndex:"priority", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priorityId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueResolutions", name:"resolution", dataIndex:"resolution", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "resolutionId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueSeverities", name:"severity", dataIndex:"severity", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "severityId"} 
				]})
			.addLov({xtype:"pj_md_lovs_ProjectMembers", name:"assignee", dataIndex:"assignee", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "assigneeId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			.addTextField({ name:"assigneeRole", dataIndex:"assigneeRole", anchor:"-20"})
			.addLov({xtype:"pj_md_lovs_ProjectVersionsReleased", name:"reportedVersion", dataIndex:"reportedVersion", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "reportedVersionId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			.addLov({xtype:"pj_md_lovs_ProjectVersionsPlanned", name:"targetVersion", dataIndex:"targetVersion", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "targetVersionId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			.addLov({xtype:"pj_md_lovs_ProjectVersions", name:"fixedInVersion", dataIndex:"fixedInVersion", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "fixedInVersionId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			.addNumberField({name:"businessValue", dataIndex:"businessValue", anchor:"-20"})
			.addNumberField({name:"estimatedEffort", dataIndex:"estimatedEffort", anchor:"-20"})
			.addNumberField({name:"clarity", dataIndex:"clarity", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true})
			.addPanel({ name:"row1", width:900, layout:"form"})
			.addPanel({ name:"row2", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
			.addPanel({ name:"col1", width:260, layout:"form"})
			.addPanel({ name:"col3", width:250, layout:"form"})
			.addPanel({ name:"col4", title:"Versions", width:220, layout:"form", xtype:"fieldset", border:true, collapsible:true})
			.addPanel({ name:"col5", width:200, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["row1", "row2"])
			.addChildrenTo("row1", ["summary"])
			.addChildrenTo("row2", ["col1", "col3", "col4", "col5"])
			.addChildrenTo("col1", ["project", "projectName", "type", "status", "code"])
			.addChildrenTo("col3", ["assignee", "priority", "severity", "resolution"])
			.addChildrenTo("col4", ["reportedVersion", "targetVersion", "fixedInVersion"])
			.addChildrenTo("col5", ["dueDate", "resolutionDate", "businessValue", "clarity", "estimatedEffort"])
		;
	}
});


/* ================= EDITOR: EditText ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.Issue$EditText", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.pj_md_dc_Issue$EditText",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"fit", defaults:{labelAlign:"right"}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["description"])
		;
	}
});


/* ================= EDITOR: ViewDescription ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.Issue$ViewDescription", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.pj_md_dc_Issue$ViewDescription",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20", asText:true})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"fit", defaults:{labelAlign:"right"}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["description"])
		;
	}
});


/* ================= EDITOR: View ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.Issue$View", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.pj_md_dc_Issue$View",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addDisplayFieldNumber({ name:"projectId", dataIndex:"projectId", anchor:"-20" })
			.addDisplayFieldText({ name:"project", dataIndex:"project", anchor:"-20", maxLength:32})
			.addDisplayFieldText({ name:"projectName", dataIndex:"projectName", anchor:"-20"})
			.addDisplayFieldText({ name:"summary", dataIndex:"summary", allowBlank:false, anchor:"-20"})
			.addDisplayFieldDate({ name:"dueDate", dataIndex:"dueDate", anchor:"-20" })
			.addDisplayFieldDate({ name:"resolutionDate", dataIndex:"resolutionDate", anchor:"-20" })
			.addDisplayFieldText({ name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20"})
			.addDisplayFieldText({ name:"status", _sharedLabel_:true, dataIndex:"status", anchor:"-20"})
			.addDisplayFieldText({ name:"priority", dataIndex:"priority", anchor:"-20"})
			.addDisplayFieldText({ name:"resolution", dataIndex:"resolution", anchor:"-20"})
			.addDisplayFieldText({ name:"severity", dataIndex:"severity", anchor:"-20"})
			.addDisplayFieldText({ name:"assignee", dataIndex:"assignee", anchor:"-20"})
			.addDisplayFieldText({ name:"assigneeRole", dataIndex:"assigneeRole", anchor:"-20"})
			.addDisplayFieldText({ name:"reportedVersion", dataIndex:"reportedVersion", anchor:"-20"})
			.addDisplayFieldText({ name:"targetVersion", dataIndex:"targetVersion", anchor:"-20"})
			.addDisplayFieldText({ name:"fixedInVersion", dataIndex:"fixedInVersion", anchor:"-20"})
			.addDisplayFieldNumber({ name:"businessValue", dataIndex:"businessValue", anchor:"-20" })
			.addDisplayFieldNumber({ name:"estimatedEffort", dataIndex:"estimatedEffort", anchor:"-20" })
			.addDisplayFieldNumber({ name:"clarity", dataIndex:"clarity", anchor:"-20" })
			.addDisplayFieldText({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20", asText:true})
			/* containers */
			.addPanel({ name:"main", autoScroll:true})
			.addPanel({ name:"r1", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
			.addPanel({ name:"col1", width:260, layout:"form"})
			.addPanel({ name:"col2"})
			.addPanel({ name:"row1", width:600, layout:"form"})
			.addPanel({ name:"row2", layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}}})
			.addPanel({ name:"col3", width:250, layout:"form"})
			.addPanel({ name:"col4", title:"Versions", width:250, layout:"form", xtype:"fieldset", border:true, collapsible:true})
			.addPanel({ name:"col5", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["r1"])
			.addChildrenTo("r1", ["col1", "col2"])
			.addChildrenTo("col1", ["project", "projectName", "type", "severity", "priority", "code"])
			.addChildrenTo("col2", ["row1", "row2"])
			.addChildrenTo("row1", ["summary"])
			.addChildrenTo("row2", ["col3", "col4", "col5"])
			.addChildrenTo("col3", ["assignee", "status", "resolution"])
			.addChildrenTo("col4", ["reportedVersion", "targetVersion", "fixedInVersion"])
			.addChildrenTo("col5", ["dueDate", "resolutionDate", "businessValue", "clarity", "estimatedEffort"])
		;
	}
});
