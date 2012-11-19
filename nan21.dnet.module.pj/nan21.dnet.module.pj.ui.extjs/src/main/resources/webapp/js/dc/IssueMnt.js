/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.md.dc.IssueMnt", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.IssueDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.IssueDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueMnt$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.pj_md_dc_IssueMnt$Filter",
	
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
			.addLov({xtype:"ad_usr_lovs_Assignables", name:"assignee", dataIndex:"assignee", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "assigneeId"} 
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
			.addLov({xtype:"pj_md_lovs_ProjectComponents", name:"affectedComponent", paramIndex:"affectedComponent", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "affectedComponentId"} 
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
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueMnt$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.pj_md_dc_IssueMnt$EditList",
	_bulkEditFields_: ["dueDate","type","status","priority","severity","assignee","reportedVersion","targetVersion","fixedInVersion","resolution","businessValue","estimatedEffort","clarity"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"code", dataIndex:"code", width:80})
			.addTextColumn({name:"project", dataIndex:"project", width:90})
			.addTextColumn({name:"projectName", dataIndex:"projectName", hidden:true, width:200})
			.addTextColumn({name:"summary", dataIndex:"summary", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"dueDate", dataIndex:"dueDate", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addLov({name:"type", dataIndex:"type", xtype:"gridcolumn", width:80,
					editor:{xtype:"pj_base_lovs_IssueTypes", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "typeId"} 
						]}})
			.addLov({name:"status", dataIndex:"status", xtype:"gridcolumn", width:80,
					editor:{xtype:"pj_base_lovs_IssueStatus", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "statusId"} 
						]}})
			.addLov({name:"priority", dataIndex:"priority", xtype:"gridcolumn", width:80,
					editor:{xtype:"pj_base_lovs_IssuePriorities", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "priorityId"} 
						]}})
			.addLov({name:"severity", dataIndex:"severity", xtype:"gridcolumn", width:80,
					editor:{xtype:"pj_base_lovs_IssueSeverities", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "severityId"} 
						]}})
			.addLov({name:"assignee", dataIndex:"assignee", xtype:"gridcolumn", width:80,
					editor:{xtype:"ad_usr_lovs_Assignables", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "assigneeId"} 
						]}})
			.addLov({name:"reportedVersion", dataIndex:"reportedVersion", xtype:"gridcolumn", width:80,
					editor:{xtype:"pj_md_lovs_ProjectVersions", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "reportedVersionId"} 
						],
						filterFieldMapping: [
							{lovField:"projectId",dsField: "projectId"} 
						]}})
			.addLov({name:"targetVersion", dataIndex:"targetVersion", xtype:"gridcolumn", width:80,
					editor:{xtype:"pj_md_lovs_ProjectVersions", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "targetVersionId"} 
						],
						filterFieldMapping: [
							{lovField:"projectId",dsField: "projectId"} 
						]}})
			.addLov({name:"fixedInVersion", dataIndex:"fixedInVersion", xtype:"gridcolumn", width:80,
					editor:{xtype:"pj_md_lovs_ProjectVersions", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "fixedInVersionId"} 
						],
						filterFieldMapping: [
							{lovField:"projectId",dsField: "projectId"} 
						]}})
			.addLov({name:"resolution", dataIndex:"resolution", hidden:true, xtype:"gridcolumn", width:80,
					editor:{xtype:"pj_base_lovs_IssueResolutions", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "resolutionId"} 
						]}})
			.addNumberColumn({name:"businessValue", dataIndex:"businessValue", align:"right", width:80,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"estimatedEffort", dataIndex:"estimatedEffort", hidden:true, align:"right", width:80,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"clarity", dataIndex:"clarity", hidden:true, align:"right", width:80,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addDefaults();
	}});


/* ================= EDITOR: ViewText ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueMnt$ViewText", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.pj_md_dc_IssueMnt$ViewText",

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
	}});


/* ================= EDITOR: EditText ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueMnt$EditText", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.pj_md_dc_IssueMnt$EditText",

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
	}});
