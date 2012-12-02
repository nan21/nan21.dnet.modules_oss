/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementSetElement", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementSetElementDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementSetElement$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_elem_dc_ElementSetElement$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_elem_lovs_ElementSets", name:"elementSet", dataIndex:"elementSet", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "elementSetId"} 
				]})
			.addLov({xtype:"bd_elem_lovs_ElementsCode", name:"element", dataIndex:"element", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "elementId"} 
				]})
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
			.addChildrenTo("col1", ["elementSet"])
			.addChildrenTo("col2", ["element"])
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementSetElement$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_elem_dc_ElementSetElement$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"elementSet", dataIndex:"elementSet", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_elem_lovs_ElementSets", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "elementSetId"} 
						]}})
			.addLov({name:"element", dataIndex:"element", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_elem_lovs_ElementsCode", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "elementId"} 
						]}})
			.addTextColumn({name:"elementName", dataIndex:"elementName", width:200})
			.addNumberColumn({name:"elementSetId", dataIndex:"elementSetId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"engineId", dataIndex:"engineId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"elementId", dataIndex:"elementId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementSetElement$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_elem_dc_ElementSetElement$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"element", dataIndex:"element", xtype:"gridcolumn", width:150,
					editor:{xtype:"bd_elem_lovs_ElementsCode", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "elementId"} ,{lovField:"name", dsField: "printLabel"} ,{lovField:"name", dsField: "elementName"} 
						]}})
			.addTextColumn({name:"elementName", dataIndex:"elementName", width:250})
			.addTextColumn({name:"printLabel", dataIndex:"printLabel", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"elementSetId", dataIndex:"elementSetId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"engineId", dataIndex:"engineId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"elementId", dataIndex:"elementId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
