/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.elem.dc.Element", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementDs",
	filterModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementDsFilter",
	paramModel: "net.nan21.dnet.module.bd.elem.ds.param.ElementDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.Element$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_elem_dc_Element$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"dataType", dataIndex:"dataType", anchor:"-20",
				store:[ "string", "number", "boolean", "date"]
			})
			.addCombo({ xtype:"combo", name:"calculation", dataIndex:"calculation", anchor:"-20",
				store:[ "manual", "formula"]
			})
			.addLov({xtype:"bd_elem_lovs_Engines", name:"engine", dataIndex:"engine", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "engineId"} 
				]})
			.addLov({xtype:"bd_elem_lovs_ElementTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				],
				filterFieldMapping: [
					{lovField:"engineId",dsField: "engineId"} 
				]})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:200, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "code"])
			.addChildrenTo("col2", ["engine", "type"])
			.addChildrenTo("col3", ["dataType", "active"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.Element$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.bd_elem_dc_Element$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"type", dataIndex:"type", width:120})
			.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo"})
			.addTextColumn({ name:"dataType", dataIndex:"dataType", width:100})
			.addTextColumn({ name:"calculation", dataIndex:"calculation", width:100})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
			.addDefaults();
	}});
