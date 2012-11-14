/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/ds/EngineLovDs", "nan21.dnet.module.bd.ui.extjs/dc/ElementSetElement", "nan21.dnet.module.bd.ui.extjs/ds/ElementLovDs", "nan21.dnet.module.bd.ui.extjs/ds/ElementSetElementDs", "nan21.dnet.module.bd.ui.extjs/lov/Engines", "nan21.dnet.module.bd.ui.extjs/lov/ElementsCode", "nan21.dnet.module.bd.ui.extjs/ds/ElementSetDs", "nan21.dnet.module.bd.ui.extjs/dc/ElementSet"]);

Ext.define("net.nan21.dnet.module.bd.elem.frame.ElementSet_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.elem.frame.ElementSet_UI",
	_name_: "net.nan21.dnet.module.bd.elem.frame.ElementSet_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("set", new net.nan21.dnet.module.bd.elem.dc.ElementSet({multiEdit:true}))
			.addDc("elem", new net.nan21.dnet.module.bd.elem.dc.ElementSetElement({multiEdit:true}))
	
			.linkDc("elem", "set",{fields:[
				{childField:"elementSetId", parentField:"id"}, {childField:"engineId", parentField:"engineId"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("set", {name:"setFilter", height:80, xtype:"bd_elem_dc_ElementSet$Filter"})
			.addDcEditGridView("set", {name:"setEditList", xtype:"bd_elem_dc_ElementSet$EditList", frame:true})
			.addDcEditGridView("elem", {name:"elemCtxEditList", height:220, xtype:"bd_elem_dc_ElementSetElement$CtxEditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["setFilter", "setEditList", "elemCtxEditList"], ["north", "center", "south"])
			.addToolbarTo("canvas1", "tlbSetEditList")
			.addToolbarTo("elemCtxEditList", "tlbElemCtxEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSetEditList", {dc: "set"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Sets"})
			.end()
			.beginToolbar("tlbElemCtxEditList", {dc: "elem"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Elements"})
			.end()
			;
	}

});
