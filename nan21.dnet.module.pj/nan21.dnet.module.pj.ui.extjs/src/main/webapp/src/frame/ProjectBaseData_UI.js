/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.pj.ui.extjs/lov/ProjectCategories", "nan21.dnet.module.pj.ui.extjs/dc/ProjectRole", "nan21.dnet.module.pj.ui.extjs/ds/ProjectCategoryLovDs", "nan21.dnet.module.pj.ui.extjs/ds/ProjectCategoryDs", "nan21.dnet.module.pj.ui.extjs/ds/ProjectTypeDs", "nan21.dnet.module.pj.ui.extjs/ds/ProjectRoleDs", "nan21.dnet.module.pj.ui.extjs/dc/ProjectType", "nan21.dnet.module.pj.ui.extjs/dc/ProjectCategory"]);

Ext.define("net.nan21.dnet.module.pj.base.frame.ProjectBaseData_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.pj.base.frame.ProjectBaseData_UI",
	_name_: "net.nan21.dnet.module.pj.base.frame.ProjectBaseData_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("categ", new net.nan21.dnet.module.pj.base.dc.ProjectCategory({multiEdit:true}))
			.addDc("type", new net.nan21.dnet.module.pj.base.dc.ProjectType({multiEdit:true}))
			.addDc("role", new net.nan21.dnet.module.pj.base.dc.ProjectRole({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("categ", {name:"categFilter", height:80, xtype:"pj_base_dc_ProjectCategory$Filter"})	
			.addDcEditGridView("categ", {name:"categEditList", xtype:"pj_base_dc_ProjectCategory$EditList", frame:true})	
			.addDcFilterFormView("type", {name:"typeFilter", height:80, xtype:"pj_base_dc_ProjectType$Filter"})	
			.addDcEditGridView("type", {name:"typeEditList", xtype:"pj_base_dc_ProjectType$EditList", frame:true})	
			.addDcFilterFormView("role", {name:"roleFilter", height:80, xtype:"pj_base_dc_ProjectRole$Filter"})	
			.addDcEditGridView("role", {name:"roleEditList", xtype:"pj_base_dc_ProjectRole$EditList", frame:true})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasCategory", title:"Categories", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasType", title:"Types", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasRole", title:"Roles", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasCategory","canvasType","canvasRole"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasCategory", "canvasType", "canvasRole"])
			.addChildrenTo("canvasCategory", ["categFilter", "categEditList"], ["north", "center"])
			.addChildrenTo("canvasType", ["typeFilter", "typeEditList"], ["north", "center"])
			.addChildrenTo("canvasRole", ["roleFilter", "roleEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasCategory", "tlbCategEditList")
			.addToolbarTo("canvasType", "tlbTypeEditList")
			.addToolbarTo("canvasRole", "tlbRoleEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCategEditList", {dc: "categ"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Categories"})
			.end()
			.beginToolbar("tlbTypeEditList", {dc: "type"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Types"})
			.end()
			.beginToolbar("tlbRoleEditList", {dc: "role"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Roles"})
			.end()
	}

});
