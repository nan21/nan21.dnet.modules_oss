/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.pj.md.dc.IssueRoadmap", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueRoadmapDs",
	filterModel: "net.nan21.dnet.module.pj.md.ds.model.IssueRoadmapDsFilter",
	paramModel: "net.nan21.dnet.module.pj.md.ds.param.IssueRoadmapDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueRoadmap$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.pj_md_dc_IssueRoadmap$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"pj_md_lovs_Projects", name:"project", dataIndex:"project", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "projectId"} 
				]})
			.addLov({xtype:"pj_md_lovs_ProjectVersions", name:"targetVersion", dataIndex:"targetVersion", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "targetVersionId"} 
				],
				filterFieldMapping: [
					{lovField:"projectId",dsField: "projectId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			.addLov({xtype:"pj_base_lovs_IssueStatus", name:"status", _sharedLabel_:true, dataIndex:"status", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"summary", dataIndex:"summary", anchor:"-20"})
			.addDateField({name:"targetVersionDate_From", dataIndex:"targetVersionDate_From", emptyText:"From" })
			.addDateField({name:"targetVersionDate_To", dataIndex:"targetVersionDate_To", emptyText:"To" })
			.addFieldContainer({name: "targetVersionDate", fieldLabel:"Target Version Date"})
				.addChildrenTo("targetVersionDate",["targetVersionDate_From", "targetVersionDate_To"])
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:220, layout:"form"})
			.addPanel({ name:"col2", width:220, layout:"form"})
			.addPanel({ name:"col3", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["project", "targetVersion"])
			.addChildrenTo("col2", ["type", "status"])
			.addChildrenTo("col3", ["targetVersionDate"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.pj.md.dc.IssueRoadmap$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.pj_md_dc_IssueRoadmap$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"project", dataIndex:"project", width:100})
			.addTextColumn({ name:"projectName", dataIndex:"projectName", hidden:true, width:200})
			.addTextColumn({ name:"targetVersion", dataIndex:"targetVersion", width:120})
			.addDateColumn({ name:"targetVersionDate", dataIndex:"targetVersionDate", hidden:true, format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"summary", dataIndex:"summary", width:200})
			.addTextColumn({ name:"fixedInVersion", dataIndex:"fixedInVersion", width:120})
			.addTextColumn({ name:"status", dataIndex:"status", width:120})
			.addTextColumn({ name:"type", dataIndex:"type", width:120})
			.addNumberColumn({ name:"projectId", dataIndex:"projectId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});
