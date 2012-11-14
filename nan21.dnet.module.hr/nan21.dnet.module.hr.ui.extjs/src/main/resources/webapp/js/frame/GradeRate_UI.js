/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.hr.ui.extjs/ds/GradeRateDs", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs", "nan21.dnet.module.hr.ui.extjs/ds/GradeLovDs", "nan21.dnet.module.hr.ui.extjs/dc/GradeRateValue", "nan21.dnet.module.hr.ui.extjs/ds/GradeRateValueDs", "nan21.dnet.module.hr.ui.extjs/lov/Grades", "nan21.dnet.module.hr.ui.extjs/dc/GradeRate", "nan21.dnet.module.bd.ui.extjs/lov/Currencies"]);

Ext.define("net.nan21.dnet.module.hr.grade.frame.GradeRate_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.grade.frame.GradeRate_UI",
	_name_: "net.nan21.dnet.module.hr.grade.frame.GradeRate_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("rate", new net.nan21.dnet.module.hr.grade.dc.GradeRate({}))
			.addDc("value", new net.nan21.dnet.module.hr.grade.dc.GradeRateValue({multiEdit:true}))
	
			.linkDc("value", "rate",{fields:[
				{childField:"gradeRateId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("rate", {name:"rateFilter", height:80, xtype:"hr_grade_dc_GradeRate$Filter"})
			.addDcGridView("rate", {name:"rateList", xtype:"hr_grade_dc_GradeRate$List"})
			.addDcFormView("rate", {name:"rateEdit", height:120, xtype:"hr_grade_dc_GradeRate$Edit"})
			.addDcEditGridView("value", {name:"valueEditList", xtype:"hr_grade_dc_GradeRateValue$CtxEditList4GradeRate", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["rateFilter", "rateList"], ["north", "center"])
			.addChildrenTo("canvas2", ["rateEdit", "valueEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbRateList")
			.addToolbarTo("canvas2", "tlbRateEdit")
			.addToolbarTo("valueEditList", "tlbValueEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbRateList", {dc: "rate"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Grade rates"})
			.end()
			.beginToolbar("tlbRateEdit", {dc: "rate"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Grade rate"})
			.end()
			.beginToolbar("tlbValueEditList", {dc: "value"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Values"})
			.end()
			;
	}

});
