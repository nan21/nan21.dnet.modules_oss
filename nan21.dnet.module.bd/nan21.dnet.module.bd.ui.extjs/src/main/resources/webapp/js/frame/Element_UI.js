/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/dc/ElementFormula", "nan21.dnet.module.bd.ui.extjs/lov/ElementTypes", "nan21.dnet.module.bd.ui.extjs/ds/ElementTypeLovDs", "nan21.dnet.module.bd.ui.extjs/ds/EngineLovDs", "nan21.dnet.module.bd.ui.extjs/dc/ElementInput", "nan21.dnet.module.bd.ui.extjs/dc/Element", "nan21.dnet.module.bd.ui.extjs/lov/Engines", "nan21.dnet.module.bd.ui.extjs/ds/ElementFormulaDs", "nan21.dnet.module.bd.ui.extjs/ds/ElementInputDs", "nan21.dnet.module.bd.ui.extjs/ds/ElementDs"]);

Ext.define("net.nan21.dnet.module.bd.elem.frame.Element_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.elem.frame.Element_UI",
	_name_: "net.nan21.dnet.module.bd.elem.frame.Element_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("elem", new net.nan21.dnet.module.bd.elem.dc.Element({}))
			.addDc("input", new net.nan21.dnet.module.bd.elem.dc.ElementInput({}))
			.addDc("formula", new net.nan21.dnet.module.bd.elem.dc.ElementFormula({}))
	
			.linkDc("input", "elem",{fields:[
				{childField:"elementId", parentField:"id"}]}
			)
			.linkDc("formula", "elem",{fields:[
				{childField:"elementId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("elem", {name:"elemFilter", height:80, xtype:"bd_elem_dc_Element$Filter"})
			.addDcGridView("elem", {name:"elemList", xtype:"bd_elem_dc_Element$List"})
			.addDcGridView("input", {name:"inputList", title:"Input values", xtype:"bd_elem_dc_ElementInput$CtxList"})
			.addDcGridView("formula", {name:"formulaList", width:300, xtype:"bd_elem_dc_ElementFormula$CtxList"})
			.addDcFormView("formula", {name:"formulaEdit", xtype:"bd_elem_dc_ElementFormula$ViewExpression"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"detailsTab", height:220, xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"formulaPanel", title:"Formula", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["elemFilter", "elemList", "detailsTab"], ["north", "center", "south"])
			.addChildrenTo("detailsTab", ["inputList", "formulaPanel"])
			.addChildrenTo("formulaPanel", ["formulaList", "formulaEdit"], ["west", "center"])
			.addToolbarTo("canvas1", "tlbElemList")
			.addToolbarTo("inputList", "tlbInputList")
			.addToolbarTo("formulaPanel", "tlbFormulaList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbElemList", {dc: "elem"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Elements"})
			.end()
			.beginToolbar("tlbInputList", {dc: "input"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Input values"})
			.end()
			.beginToolbar("tlbFormulaList", {dc: "formula"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Formula"})
			.end()
			;
	}

});
