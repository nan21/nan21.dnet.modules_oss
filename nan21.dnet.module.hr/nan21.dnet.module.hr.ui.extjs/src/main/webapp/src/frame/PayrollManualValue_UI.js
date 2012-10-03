/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.hr.ui.extjs/ds/PayrollElementLovDs", "nan21.dnet.module.hr.ui.extjs/lov/PayrollPeriods", "nan21.dnet.module.bd.ui.extjs/lov/ElementTypes", "nan21.dnet.module.bd.ui.extjs/ds/ElementTypeLovDs", "nan21.dnet.module.hr.ui.extjs/lov/PayrollElementsCode", "nan21.dnet.module.hr.ui.extjs/dc/PayrollManualValue", "nan21.dnet.module.hr.ui.extjs/ds/PayrollPeriodLovDs", "nan21.dnet.module.hr.ui.extjs/lov/Employees", "nan21.dnet.module.hr.ui.extjs/ds/PayrollManualValueDs", "nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations", "nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs", "nan21.dnet.module.hr.ui.extjs/ds/EmployeeLovDs"]);

Ext.define("net.nan21.dnet.module.hr.payroll.frame.PayrollManualValue_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.payroll.frame.PayrollManualValue_UI",
	_name_: "net.nan21.dnet.module.hr.payroll.frame.PayrollManualValue_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("elemval", new net.nan21.dnet.module.hr.payroll.dc.PayrollManualValue({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("elemval", {name:"elemvalFilter", height:120, xtype:"hr_payroll_dc_PayrollManualValue$Filter"})	
			.addDcEditGridView("elemval", {name:"elemvalList", xtype:"hr_payroll_dc_PayrollManualValue$EditList", frame:true})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["elemvalFilter", "elemvalList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbElemvalList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbElemvalList", {dc: "elemval"}).addQuery().addSave().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Payroll manual entries"})
			.end()
	}

});
