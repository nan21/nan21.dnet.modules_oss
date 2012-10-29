/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.ad.system.dc.UiViewState", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.ad.system.ds.model.UiViewStateDs",
	filterModel: "net.nan21.dnet.module.ad.system.ds.model.UiViewStateDsFilter",
	paramModel: "net.nan21.dnet.module.ad.system.ds.param.UiViewStateDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.UiViewState$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.ad_system_dc_UiViewState$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"cmp", dataIndex:"cmp", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"cmpType", dataIndex:"cmpType", anchor:"-20",
				store:[ "frame-dcgrid", "frame-dcegrid"]
			})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "cmpType"])
			.addChildrenTo("col2", ["cmp"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.UiViewState$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.ad_system_dc_UiViewState$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:150})
			.addTextColumn({ name:"cmpType", dataIndex:"cmpType", width:120})
			.addTextColumn({ name:"cmp", dataIndex:"cmp", width:400})
			.addTextColumn({ name:"stateValue", dataIndex:"stateValue", hidden:true, width:200})
			.addDefaults();
	}});


/* ================= EDITOR: ViewState ================= */


Ext.define("net.nan21.dnet.module.ad.system.dc.UiViewState$ViewState", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.ad_system_dc_UiViewState$ViewState",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"stateValue", dataIndex:"stateValue", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form", defaults:{labelAlign:"top"}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["stateValue"])
		;
	}});
