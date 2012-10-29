/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/dc/ElementInput", "nan21.dnet.module.bd.ui.extjs/ds/EngineLovDs", "nan21.dnet.module.bd.ui.extjs/ds/ElementTypeLovDs", "nan21.dnet.module.bd.ui.extjs/lov/ElementTypes", "nan21.dnet.module.bd.ui.extjs/ds/ElementLovDs", "nan21.dnet.module.md.ui.extjs/lov/AccItems", "nan21.dnet.module.bd.ui.extjs/ds/ElementInputDs", "nan21.dnet.module.md.ui.extjs/ds/AccItemLovDs", "nan21.dnet.module.bd.ui.extjs/dc/ElementFormula", "nan21.dnet.module.hr.ui.extjs/ds/PayrollElementSourceLovDs", "nan21.dnet.module.hr.ui.extjs/ds/PayrollElementDs", "nan21.dnet.module.bd.ui.extjs/lov/Engines", "nan21.dnet.module.hr.ui.extjs/lov/PayrollElementsSource", "nan21.dnet.module.bd.ui.extjs/ds/ElementFormulaDs", "nan21.dnet.module.bd.ui.extjs/lov/ElementsCode", "nan21.dnet.module.hr.ui.extjs/dc/PayrollElement"]);

Ext.define("net.nan21.dnet.module.hr.payroll.frame.PayrollElement_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.payroll.frame.PayrollElement_UI",
	_name_: "net.nan21.dnet.module.hr.payroll.frame.PayrollElement_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("elem", new net.nan21.dnet.module.hr.payroll.dc.PayrollElement({}))
			.addDc("input", new net.nan21.dnet.module.bd.elem.dc.ElementInput({multiEdit:true}))
			.addDc("formula", new net.nan21.dnet.module.bd.elem.dc.ElementFormula({multiEdit:true}))
	
			.linkDc("input", "elem",{fields:[
				{childField:"elementId", parentField:"id"}, {childField:"engineId", parentField:"engineId"}]}
			)
			.linkDc("formula", "elem",{fetchMode:"auto",fields:[
				{childField:"elementId", parentField:"id"}, {childField:"engineId", parentField:"engineId"}]}
			)
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("elem", {name:"elemFilter", height:120, xtype:"hr_payroll_dc_PayrollElement$Filter"})
			.addDcGridView("elem", {name:"elemList", xtype:"hr_payroll_dc_PayrollElement$List"})
			.addDcFormView("elem", {name:"elemEdit", height:170, xtype:"hr_payroll_dc_PayrollElement$Edit"})
			.addDcEditGridView("input", {name:"inputEditList", title:"Input values", xtype:"bd_elem_dc_ElementInput$CtxEditList", frame:true})
			.addDcEditGridView("formula", {name:"formulaList", width:300, xtype:"bd_elem_dc_ElementFormula$CtxEditList", frame:true})
			.addDcFormView("formula", {name:"formulaEdit", xtype:"bd_elem_dc_ElementFormula$EditExpression"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"detailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"formulaPanel", title:"Formula", layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["elemFilter", "elemList"], ["north", "center"])
			.addChildrenTo("canvas2", ["elemEdit", "detailsTab"], ["north", "center"])
			.addChildrenTo("detailsTab", ["inputEditList", "formulaPanel"])
			.addChildrenTo("formulaPanel", ["formulaList", "formulaEdit"], ["west", "center"])
			.addToolbarTo("canvas1", "tlbElemList")
			.addToolbarTo("canvas2", "tlbElemmEdit")
			.addToolbarTo("inputEditList", "tlbInputEditList")
			.addToolbarTo("formulaPanel", "tlbFormulaList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbElemList", {dc: "elem"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Elements"})
			.end()
			.beginToolbar("tlbElemmEdit", {dc: "elem"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Element"})
			.end()
			.beginToolbar("tlbInputEditList", {dc: "input"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Input values"})
			.end()
			.beginToolbar("tlbFormulaList", {dc: "formula"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Formula"})
			.end()
	}

});
