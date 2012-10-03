/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/dc/CurrencyXRateProvider", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyXRateProviderDs"]);

Ext.define("net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI",
	_name_: "net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("prvd", new net.nan21.dnet.module.bd.currency.dc.CurrencyXRateProvider({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("prvd", {name:"prvdFilter", height:80, xtype:"bd_currency_dc_CurrencyXRateProvider$Filter"})	
			.addDcEditGridView("prvd", {name:"prvdEditList", xtype:"bd_currency_dc_CurrencyXRateProvider$EditList", frame:true})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["prvdFilter", "prvdEditList"], ["north", "center"])
			.addToolbarTo("main", "tlbMain")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMain", {dc: "prvd"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Exchange rate providers"})
			.end()
	}

});
