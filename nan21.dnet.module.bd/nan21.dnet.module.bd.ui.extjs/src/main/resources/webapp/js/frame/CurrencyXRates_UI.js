/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.bd.currency.frame.CurrencyXRates_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.currency.frame.CurrencyXRates_UI",
	_name_: "net.nan21.dnet.module.bd.currency.frame.CurrencyXRates_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("xrate", new net.nan21.dnet.module.bd.currency.dc.CurrencyXRate({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("xrate", {name:"xrateFilter", height:80, xtype:"bd_currency_dc_CurrencyXRate$Filter"})
			.addDcEditGridView("xrate", {name:"xrateEditList", xtype:"bd_currency_dc_CurrencyXRate$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["xrateFilter", "xrateEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbXrateEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbXrateEditList", {dc: "xrate"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Exchange rates"})
			.end()
			;
	}

});
