/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActDeployment", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.ActDeploymentDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActDeployment$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_workflow_dc_ActDeployment$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addDateField({name:"from", paramIndex:"from", anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"to", paramIndex:"to", anchor:"-20", format:Ext.DATE_FORMAT})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name"])
			.addChildrenTo("col2", ["from", "to"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.ActDeployment$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_workflow_dc_ActDeployment$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:300})
			.addDateColumn({ name:"deployTime", dataIndex:"deployTime", width:150, format: Dnet.DATETIME_FORMAT})
			.addDefaults();
	}});
