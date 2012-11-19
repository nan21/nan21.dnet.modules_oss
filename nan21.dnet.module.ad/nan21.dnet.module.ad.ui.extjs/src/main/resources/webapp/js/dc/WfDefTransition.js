/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.workflow.dc.WfDefTransition", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.WfDefTransitionDs",
	filterModel: "net.nan21.dnet.module.ad.workflow.ds.model.WfDefTransitionDsFilter",
	paramModel: "net.nan21.dnet.module.ad.workflow.ds.param.WfDefTransitionDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.WfDefTransition$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_workflow_dc_WfDefTransition$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"source", dataIndex:"source", anchor:"-20"})
			.addTextField({ name:"target", dataIndex:"target", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["source", "target"])
		;
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.ad.workflow.dc.WfDefTransition$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.ad_workflow_dc_WfDefTransition$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"processId", dataIndex:"processId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"sourceId", dataIndex:"sourceId", hidden:true, align:"right", width:70, format:"0"})
			.addTextColumn({name:"source", dataIndex:"source", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"targetId", dataIndex:"targetId", hidden:true, align:"right", width:70, format:"0"})
			.addTextColumn({name:"target", dataIndex:"target", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}});
