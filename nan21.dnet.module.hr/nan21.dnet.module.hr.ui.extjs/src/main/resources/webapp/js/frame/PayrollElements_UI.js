/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.payroll.frame.PayrollElements_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.payroll.frame.PayrollElements_UI",
	_name_: "net.nan21.dnet.module.hr.payroll.frame.PayrollElements_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("elem", new net.nan21.dnet.module.hr.payroll.dc.PayrollElement({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("elem", {name:"elemFilter", height:120, xtype:"hr_payroll_dc_PayrollElement$Filter"})
			.addDcEditGridView("elem", {name:"elemList", xtype:"hr_payroll_dc_PayrollElement$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["elemFilter", "elemList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbElemList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbElemList", {dc: "elem"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Elements"})
			.end()
			;
	}

});
