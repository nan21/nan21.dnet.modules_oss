/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/ds/ElementCategoryDs", "nan21.dnet.module.bd.ui.extjs/ds/EngineLovDs", "nan21.dnet.module.bd.ui.extjs/dc/ElementType", "nan21.dnet.module.bd.ui.extjs/ds/ElementTypeDs", "nan21.dnet.module.bd.ui.extjs/ds/EngineDs", "nan21.dnet.module.bd.ui.extjs/ds/ElementCategoryLovDs", "nan21.dnet.module.bd.ui.extjs/lov/Engines", "nan21.dnet.module.bd.ui.extjs/dc/ElementCategory", "nan21.dnet.module.bd.ui.extjs/lov/ElementCategories", "nan21.dnet.module.bd.ui.extjs/dc/Engine"]);

Ext.define("net.nan21.dnet.module.bd.elem.frame.ElementBaseData_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.elem.frame.ElementBaseData_UI",
	_name_: "net.nan21.dnet.module.bd.elem.frame.ElementBaseData_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("engine", new net.nan21.dnet.module.bd.elem.dc.Engine({multiEdit:true}))
			.addDc("ecateg", new net.nan21.dnet.module.bd.elem.dc.ElementCategory({multiEdit:true}))
			.addDc("etype", new net.nan21.dnet.module.bd.elem.dc.ElementType({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("engine", {name:"engineFilter", height:80, xtype:"bd_elem_dc_Engine$Filter"})	
			.addDcEditGridView("engine", {name:"engineEditList", xtype:"bd_elem_dc_Engine$EditList", frame:true})	
			.addDcFilterFormView("ecateg", {name:"ecategFilter", height:80, xtype:"bd_elem_dc_ElementCategory$Filter"})	
			.addDcEditGridView("ecateg", {name:"ecategEditList", xtype:"bd_elem_dc_ElementCategory$EditList", frame:true})	
			.addDcFilterFormView("etype", {name:"etypeFilter", height:80, xtype:"bd_elem_dc_ElementType$Filter"})	
			.addDcEditGridView("etype", {name:"etypeEditList", xtype:"bd_elem_dc_ElementType$EditList", frame:true})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasEngine", title:"Engines", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasCateg", title:"Categories", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasType", title:"Types", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasType","canvasCateg","canvasEngine"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasType", "canvasCateg", "canvasEngine"])
			.addChildrenTo("canvasEngine", ["engineFilter", "engineEditList"], ["north", "center"])
			.addChildrenTo("canvasCateg", ["ecategFilter", "ecategEditList"], ["north", "center"])
			.addChildrenTo("canvasType", ["etypeFilter", "etypeEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasEngine", "tlbEngineEditList")
			.addToolbarTo("canvasCateg", "tlbEcategEditList")
			.addToolbarTo("canvasType", "tlbEtypeEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbEngineEditList", {dc: "engine"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Engines"})
			.end()
			.beginToolbar("tlbEcategEditList", {dc: "ecateg"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Categories"})
			.end()
			.beginToolbar("tlbEtypeEditList", {dc: "etype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Types"})
			.end()
	}

});
