/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition", {
	extend: "dnet.core.dc.AbstractDc",

	paramModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDsParam",
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_workflow_dc_ActProcessDefinition$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"id", _sharedLabel_:true, dataIndex:"id", anchor:"-20"})
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"category", dataIndex:"category", anchor:"-20"})
			.addTextField({ name:"resourceName", dataIndex:"resourceName", anchor:"-20"})
			.addLov({xtype:"ad_workflow_lovs_ActDeployments", name:"deployment", paramIndex:"deployment", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "deploymentId"} ,{lovField:"fullName", dsParam: "deployment"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:280, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name"])
			.addChildrenTo("col2", ["category", "resourceName"])
			.addChildrenTo("col3", ["deployment"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActProcessDefinition$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_workflow_dc_ActProcessDefinition$List",
	_noImport_: true,

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"category", dataIndex:"category", width:200})
			.addTextColumn({ name:"resourceName", dataIndex:"resourceName", width:200})
			.addTextColumn({ name:"diagramResourceName", dataIndex:"diagramResourceName", hidden:true, width:200})
			.addDefaults();
	}
});
