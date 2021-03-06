/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.base.period.frame.FiscalPeriod_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.base.period.frame.FiscalPeriod_UI",
	_name_: "net.nan21.dnet.module.md.base.period.frame.FiscalPeriod_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("period", new net.nan21.dnet.module.md.base.period.dc.FiscalPeriod({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("period", {name:"periodFilter", xtype:"md_base_period_dc_FiscalPeriod$Filter"})
			.addDcEditGridView("period", {name:"periodEditList", xtype:"md_base_period_dc_FiscalPeriod$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["periodFilter", "periodEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbPeriodList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPeriodList", {dc: "period"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Fiscal periods"})
			.end()
			;
	}

});
