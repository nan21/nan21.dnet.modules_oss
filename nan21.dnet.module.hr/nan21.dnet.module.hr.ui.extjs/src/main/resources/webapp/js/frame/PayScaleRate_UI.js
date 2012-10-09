/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.hr.ui.extjs/lov/PayScales", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs", "nan21.dnet.module.hr.ui.extjs/ds/PayScalePointLovDs", "nan21.dnet.module.hr.ui.extjs/dc/PayScaleRate", "nan21.dnet.module.hr.ui.extjs/lov/PayScalePoints", "nan21.dnet.module.bd.ui.extjs/lov/Currencies", "nan21.dnet.module.hr.ui.extjs/ds/PayScaleLovDs", "nan21.dnet.module.hr.ui.extjs/ds/PayScaleRateDs", "nan21.dnet.module.hr.ui.extjs/ds/PayScaleRateValueDs", "nan21.dnet.module.hr.ui.extjs/dc/PayScaleRateValue"]);

Ext.define("net.nan21.dnet.module.hr.grade.frame.PayScaleRate_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.grade.frame.PayScaleRate_UI",
	_name_: "net.nan21.dnet.module.hr.grade.frame.PayScaleRate_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("srate", new net.nan21.dnet.module.hr.grade.dc.PayScaleRate({}))
			.addDc("value", new net.nan21.dnet.module.hr.grade.dc.PayScaleRateValue({multiEdit:true}))
	
			.linkDc("value", "srate",{fields:[
				{childField:"scaleRateId", parentField:"id"}]}
			)
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("srate", {name:"srateFilter", height:80, xtype:"hr_grade_dc_PayScaleRate$Filter"})	
			.addDcGridView("srate", {name:"srateList", xtype:"hr_grade_dc_PayScaleRate$List"})	
			.addDcFormView("srate", {name:"srateEdit", height:120, xtype:"hr_grade_dc_PayScaleRate$Edit"})	
			.addDcEditGridView("value", {name:"valueEditList", xtype:"hr_grade_dc_PayScaleRateValue$CtxEditList", frame:true})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["srateFilter", "srateList"], ["north", "center"])
			.addChildrenTo("canvas2", ["srateEdit", "valueEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbSrateList")
			.addToolbarTo("canvas2", "tlbSrateEdit")
			.addToolbarTo("valueEditList", "tlbSalueEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSrateList", {dc: "srate"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Pay scale rates"})
			.end()
			.beginToolbar("tlbSrateEdit", {dc: "srate"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Pay scale rate"})
			.end()
			.beginToolbar("tlbSalueEditList", {dc: "value"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Progression point rates"})
			.end()
	}

});
