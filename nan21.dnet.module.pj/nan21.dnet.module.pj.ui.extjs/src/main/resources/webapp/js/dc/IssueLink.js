/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.md.dc.IssueLink", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueLinkDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueLink$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.pj_md_dc_IssueLink$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"pj_md_lovs_Issues", name:"sourceIssue", dataIndex:"sourceIssue", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "sourceIssueId"} 
				]})
			.addLov({xtype:"pj_md_lovs_Issues", name:"targetIssue", dataIndex:"targetIssue", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "targetIssueId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueLinkTypes", name:"linkType", dataIndex:"linkType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "linkTypeId"} 
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
				{layout:"anchor", border:false, items:[this._elems_.get("linkType")]},{layout:"anchor", border:false, items:[this._elems_.get("sourceIssue")]},{layout:"anchor", border:false, items:[this._elems_.get("targetIssue")]}
			 ])
		;
	}
});


/* ================= GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueLink$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.pj_md_dc_IssueLink$CtxList",

	_defineColumns_: function() {
		this._getBuilder_()
			.addNumberColumn({ name:"sourceIssueId", dataIndex:"sourceIssueId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"sourceIssue", dataIndex:"sourceIssue", width:60})
			.addTextColumn({ name:"sourceSummary", dataIndex:"sourceSummary", width:150})
			.addTextColumn({ name:"linkType", dataIndex:"linkType", width:100})
			.addNumberColumn({ name:"targetIssueId", dataIndex:"targetIssueId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"targetIssue", dataIndex:"targetIssue", width:60})
			.addTextColumn({ name:"targetSummary", dataIndex:"targetSummary", width:150})
			.addDefaults();
	}
});


/* ================= EDITOR: CtxCreate ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueLink$CtxCreate", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.pj_md_dc_IssueLink$CtxCreate",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"pj_md_lovs_Issues", name:"targetIssue", dataIndex:"targetIssue", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "targetIssueId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueLinkTypes", name:"linkType", dataIndex:"linkType", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "linkTypeId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["linkType", "targetIssue"])
		;
	}
});
