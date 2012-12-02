/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTaskCtx", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueTaskDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.pj_md_dc_IssueTaskCtx$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
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
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"hbox",
				defaults:{
					labelAlign:"right", labelWidth:80, width:210 
				}
			})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", [
				{layout:"anchor", border:false, items:[this._elems_.get("type")]},{layout:"anchor", border:false, items:[this._elems_.get("status")]},{layout:"anchor", border:false, items:[this._elems_.get("assignee")]}
			 ])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.pj_md_dc_IssueTaskCtx$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"type", dataIndex:"type", width:120})
			.addTextColumn({ name:"assignee", dataIndex:"assignee", width:120})
			.addTextColumn({ name:"status", dataIndex:"status", width:120})
			.addTextColumn({ name:"description", dataIndex:"description", hidden:true, width:200})
			.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"statusId", dataIndex:"statusId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"assigneeId", dataIndex:"assigneeId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueTaskCtx$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.pj_md_dc_IssueTaskCtx$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addLov({xtype:"pj_base_lovs_IssueTaskTypes", name:"type", _sharedLabel_:true, dataIndex:"type", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
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
			.addPanel({ name:"col1", width:280, layout:"form"})
			.addPanel({ name:"col2", width:500, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["type", "assignee", "status", "code"])
			.addChildrenTo("col2", ["description"])
		;
	}
});
