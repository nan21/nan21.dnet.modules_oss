/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/dc/ElementFormula", "nan21.dnet.module.bd.ui.extjs/ds/EngineLovDs", "nan21.dnet.module.bd.ui.extjs/ds/ElementLovDs", "nan21.dnet.module.bd.ui.extjs/lov/Engines", "nan21.dnet.module.bd.ui.extjs/ds/ElementFormulaDs", "nan21.dnet.module.bd.ui.extjs/lov/ElementsCode"]);

Ext.define("net.nan21.dnet.module.hr.payroll.frame.PayrollElementFormulas_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.payroll.frame.PayrollElementFormulas_UI",
	_name_: "net.nan21.dnet.module.hr.payroll.frame.PayrollElementFormulas_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("formula", new net.nan21.dnet.module.bd.elem.dc.ElementFormula({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("formula", {name:"formulaFilter", height:120, xtype:"bd_elem_dc_ElementFormula$Filter"})
			.addDcEditGridView("formula", {name:"formulaList", xtype:"bd_elem_dc_ElementFormula$EditList", frame:true})
			.addDcFormView("formula", {name:"formulaEdit", width:350, xtype:"bd_elem_dc_ElementFormula$EditExpression"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["formulaFilter", "formulaList", "formulaEdit"], ["north", "center", "east"])
			.addToolbarTo("canvas1", "tlbInputList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInputList", {dc: "formula"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Element formulas"})
			.end()
			;
	}

});
