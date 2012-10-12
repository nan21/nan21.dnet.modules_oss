/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementFormula", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementFormulaDs",
	filterModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementFormulaDsFilter",
	paramModel: "net.nan21.dnet.module.bd.elem.ds.param.ElementFormulaDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementFormula$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_elem_dc_ElementFormula$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
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
			.addDateField({name:"validFrom_From", dataIndex:"validFrom_From", emptyText:"From" })
			.addDateField({name:"validFrom_To", dataIndex:"validFrom_To", emptyText:"To" })
			.addFieldContainer({name: "validFrom", fieldLabel:"Valid From"})
				.addChildrenTo("validFrom",["validFrom_From", "validFrom_To"])
			.addDateField({name:"validTo_From", dataIndex:"validTo_From", emptyText:"From" })
			.addDateField({name:"validTo_To", dataIndex:"validTo_To", emptyText:"To" })
			.addFieldContainer({name: "validTo", fieldLabel:"Valid To"})
				.addChildrenTo("validTo",["validTo_From", "validTo_To"])
			.addNumberField({name:"sequenceNo_From", dataIndex:"sequenceNo_From", emptyText:"From" })
			.addNumberField({name:"sequenceNo_To", dataIndex:"sequenceNo_To", emptyText:"To" })
			.addFieldContainer({name: "sequenceNo", fieldLabel:"Sequence No"})
				.addChildrenTo("sequenceNo",["sequenceNo_From", "sequenceNo_To"])
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["engine", "element"])
			.addChildrenTo("col2", ["validFrom", "validTo", "sequenceNo"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementFormula$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_elem_dc_ElementFormula$EditList",
	_bulkEditFields_: ["validFrom","validTo"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"engine", dataIndex:"engine", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_elem_lovs_Engines", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "engineId"} 
						]}})
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70})
			.addLov({name:"element", dataIndex:"element", xtype:"gridcolumn", width:150,
					editor:{xtype:"bd_elem_lovs_ElementsCode", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "elementId"} ,{lovField:"name", dsField: "elementName"} 
						],
						filterFieldMapping: [
							{lovField:"engineId",dsField: "engineId"} 
						]}})
			.addTextColumn({name:"elementName", dataIndex:"elementName", width:200})
			.addDateColumn({name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"validTo", dataIndex:"validTo", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addTextColumn({name:"expression", dataIndex:"expression", hidden:true, width:200})
			.addNumberColumn({name:"elementId", dataIndex:"elementId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementFormula$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_elem_dc_ElementFormula$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addDateColumn({name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDateColumn({name:"validTo", dataIndex:"validTo", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addDefaults();
	}});


/* ================= GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementFormula$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.bd_elem_dc_ElementFormula$CtxList",

	_defineColumns_: function() {
		this._getBuilder_()
			.addDateColumn({ name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT})
			.addDateColumn({ name:"validTo", dataIndex:"validTo", format: Dnet.DATE_FORMAT})
			.addDefaults();
	}});


/* ================= EDITOR: EditExpression ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementFormula$EditExpression", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.bd_elem_dc_ElementFormula$EditExpression",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextArea({ name:"expression", dataIndex:"expression", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form", defaults:{labelAlign:"top"}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["expression"])
		;
	}});


/* ================= EDITOR: ViewExpression ================= */


Ext.define("net.nan21.dnet.module.bd.elem.dc.ElementFormula$ViewExpression", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.bd_elem_dc_ElementFormula$ViewExpression",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDisplayFieldText({ name:"expression", dataIndex:"expression", anchor:"-20", asText:true})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form", defaults:{labelAlign:"top"}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["expression"])
		;
	}});
