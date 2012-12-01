/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementInput", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementInputDs",
	filterModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementInputDsFilter",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementInput$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_elem_dc_ElementInput$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"alias", dataIndex:"alias", anchor:"-20", maxLength:32})
			.addLov({xtype:"bd_elem_lovs_ElementsCode", name:"reference", dataIndex:"reference", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "referenceId"} 
				]})
			.addLov({xtype:"bd_elem_lovs_Engines", name:"engine", dataIndex:"engine", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "engineId"} 
				]})
			.addLov({xtype:"bd_elem_lovs_ElementsCode", name:"element", dataIndex:"element", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "elementId"} 
				],
				filterFieldMapping: [
					{lovField:"engineId",dsField: "engineId"} 
				]})
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
			.addChildrenTo("col1", ["engine", "element"])
			.addChildrenTo("col2", ["reference", "alias"])
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementInput$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_elem_dc_ElementInput$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"engine", dataIndex:"engine", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_elem_lovs_Engines", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "engineId"} 
						]}})
			.addLov({name:"element", dataIndex:"element", xtype:"gridcolumn", width:150,
					editor:{xtype:"bd_elem_lovs_ElementsCode", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "elementId"} ,{lovField:"name", dsField: "elementName"} 
						],
						filterFieldMapping: [
							{lovField:"engineId",dsField: "engineId"} 
						]}})
			.addTextColumn({name:"elementName", dataIndex:"elementName", width:200})
			.addLov({name:"reference", dataIndex:"reference", xtype:"gridcolumn", width:150,
					editor:{xtype:"bd_elem_lovs_ElementsCode", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "referenceId"} ,{lovField:"code", dsField: "alias"} ,{lovField:"name", dsField: "referenceName"} 
						]}})
			.addTextColumn({name:"referenceName", dataIndex:"referenceName", width:200})
			.addTextColumn({name:"alias", dataIndex:"alias", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"elementId", dataIndex:"elementId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"referenceId", dataIndex:"referenceId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementInput$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_elem_dc_ElementInput$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"reference", dataIndex:"reference", xtype:"gridcolumn", width:150,
					editor:{xtype:"bd_elem_lovs_ElementsCode", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "referenceId"} ,{lovField:"code", dsField: "alias"} ,{lovField:"name", dsField: "referenceName"} 
						]}})
			.addTextColumn({name:"referenceName", dataIndex:"referenceName", width:200})
			.addTextColumn({name:"alias", dataIndex:"alias", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"elementId", dataIndex:"elementId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"referenceId", dataIndex:"referenceId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementInput$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.bd_elem_dc_ElementInput$CtxList",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"reference", dataIndex:"reference", width:150})
			.addTextColumn({ name:"referenceName", dataIndex:"referenceName", width:200})
			.addTextColumn({ name:"alias", dataIndex:"alias", width:100})
			.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"referenceId", dataIndex:"referenceId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});
