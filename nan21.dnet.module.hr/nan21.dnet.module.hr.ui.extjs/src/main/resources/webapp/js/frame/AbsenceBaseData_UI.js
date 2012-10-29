/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.hr.ui.extjs/lov/AbsenceTypes", "nan21.dnet.module.hr.ui.extjs/dc/AbsenceReason", "nan21.dnet.module.hr.ui.extjs/dc/AbsenceType", "nan21.dnet.module.hr.ui.extjs/ds/AbsenceTypeLovDs", "nan21.dnet.module.hr.ui.extjs/dc/AbsenceCategory", "nan21.dnet.module.hr.ui.extjs/ds/AbsenceTypeDs", "nan21.dnet.module.hr.ui.extjs/lov/AbsenceCategories", "nan21.dnet.module.hr.ui.extjs/ds/AbsenceCategoryLovDs", "nan21.dnet.module.hr.ui.extjs/ds/AbsenceReasonDs", "nan21.dnet.module.hr.ui.extjs/ds/AbsenceCategoryDs"]);

Ext.define("net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI",
	_name_: "net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("abscateg", new net.nan21.dnet.module.hr.time.dc.AbsenceCategory({multiEdit:true}))
			.addDc("abstype", new net.nan21.dnet.module.hr.time.dc.AbsenceType({multiEdit:true}))
			.addDc("absreason", new net.nan21.dnet.module.hr.time.dc.AbsenceReason({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("abscateg", {name:"abscategFilter", height:80, xtype:"hr_time_dc_AbsenceCategory$Filter"})
			.addDcEditGridView("abscateg", {name:"abscategEditList", xtype:"hr_time_dc_AbsenceCategory$EditList", frame:true})
			.addDcFilterFormView("abstype", {name:"abstypeFilter", height:80, xtype:"hr_time_dc_AbsenceType$Filter"})
			.addDcEditGridView("abstype", {name:"abstypeEditList", xtype:"hr_time_dc_AbsenceType$EditList", frame:true})
			.addDcFilterFormView("absreason", {name:"absreasonFilter", height:80, xtype:"hr_time_dc_AbsenceReason$Filter"})
			.addDcEditGridView("absreason", {name:"absreasonEditList", xtype:"hr_time_dc_AbsenceReason$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasCateg", title:"Absence categories", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasType", title:"Absence types", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasReason", title:"Absence reasons", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasReason","canvasType","canvasCateg"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasCateg", "canvasType", "canvasReason"])
			.addChildrenTo("canvasCateg", ["abscategFilter", "abscategEditList"], ["north", "center"])
			.addChildrenTo("canvasType", ["abstypeFilter", "abstypeEditList"], ["north", "center"])
			.addChildrenTo("canvasReason", ["absreasonFilter", "absreasonEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasCateg", "tlbabcategFilter")
			.addToolbarTo("canvasType", "tlbabstypeFilter")
			.addToolbarTo("canvasReason", "tlbabsreasonFilter")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbabcategFilter", {dc: "abscateg"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Absence categories"})
			.end()
			.beginToolbar("tlbabstypeFilter", {dc: "abstype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Absence types"})
			.end()
			.beginToolbar("tlbabsreasonFilter", {dc: "absreason"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Absence reasons"})
			.end()
	}

});
