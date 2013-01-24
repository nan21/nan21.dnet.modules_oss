/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance", {
	extend: "dnet.core.dc.AbstractDc",

	paramModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDsParam",
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_workflow_dc_ActProcessInstance$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"id", _sharedLabel_:true, dataIndex:"id", anchor:"-20"})
			.addLov({xtype:"ad_workflow_lovs_ActProcessDefinitions", name:"process", dataIndex:"process", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "processId"} 
				]})
			.addTextField({ name:"startedBy", dataIndex:"startedBy", anchor:"-20", maxLength:32})
			.addDateField({name:"from", paramIndex:"from", anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"to", paramIndex:"to", anchor:"-20", format:Ext.DATE_FORMAT})
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
			.addChildrenTo("col1", ["process"])
			.addChildrenTo("col2", ["from", "to"])
			.addChildrenTo("col3", ["startedBy", "id"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessInstance$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_workflow_dc_ActProcessInstance$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"process", dataIndex:"process", width:200})
			.addTextColumn({ name:"processInstanceId", dataIndex:"processInstanceId", hidden:true, width:150})
			.addDateColumn({ name:"startTime", dataIndex:"startTime", format: Dnet.DATETIME_FORMAT})
			.addTextColumn({ name:"startedBy", dataIndex:"startedBy", width:100})
			.addTextColumn({ name:"startAction", dataIndex:"startAction", width:100})
			.addDefaults();
	}
});
