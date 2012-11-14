/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.hr.ui.extjs/ds/CourseCategoryLovDs", "nan21.dnet.module.hr.ui.extjs/dc/CourseCategory", "nan21.dnet.module.hr.ui.extjs/lov/CourseCategories", "nan21.dnet.module.hr.ui.extjs/dc/CourseType", "nan21.dnet.module.hr.ui.extjs/ds/CourseTypeDs", "nan21.dnet.module.hr.ui.extjs/ds/CourseCategoryDs"]);

Ext.define("net.nan21.dnet.module.hr.training.frame.CourseType_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.training.frame.CourseType_UI",
	_name_: "net.nan21.dnet.module.hr.training.frame.CourseType_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("ccateg", new net.nan21.dnet.module.hr.training.dc.CourseCategory({multiEdit:true}))
			.addDc("ctype", new net.nan21.dnet.module.hr.training.dc.CourseType({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("ccateg", {name:"ccategFilter", height:80, xtype:"hr_training_dc_CourseCategory$Filter"})
			.addDcEditGridView("ccateg", {name:"ccategEditList", xtype:"hr_training_dc_CourseCategory$EditList", frame:true})
			.addDcFilterFormView("ctype", {name:"ctypeFilter", height:80, xtype:"hr_training_dc_CourseType$Filter"})
			.addDcEditGridView("ctype", {name:"ctypeEditList", xtype:"hr_training_dc_CourseType$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasCategory", title:"Course categories", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasType", title:"Course types", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasCategory","canvasType"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasCategory", "canvasType"])
			.addChildrenTo("canvasCategory", ["ccategFilter", "ccategEditList"], ["north", "center"])
			.addChildrenTo("canvasType", ["ctypeFilter", "ctypeEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasCategory", "tlbCcategEditList")
			.addToolbarTo("canvasType", "tlbCtypeEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCcategEditList", {dc: "ccateg"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Course categories"})
			.end()
			.beginToolbar("tlbCtypeEditList", {dc: "ctype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Course types"})
			.end()
			;
	}

});
