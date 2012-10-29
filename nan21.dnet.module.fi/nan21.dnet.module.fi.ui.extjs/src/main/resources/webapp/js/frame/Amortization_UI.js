/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.fi.ui.extjs/lov/AssetCategories", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs", "nan21.dnet.module.fi.ui.extjs/dc/Amortization", "nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations", "nan21.dnet.module.fi.ui.extjs/ds/AssetCategoryLovDs", "nan21.dnet.module.fi.ui.extjs/ds/AmortizationDs", "nan21.dnet.module.bd.ui.extjs/lov/Currencies", "nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs"]);

Ext.define("net.nan21.dnet.module.fi.asset.frame.Amortization_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.fi.asset.frame.Amortization_UI",
	_name_: "net.nan21.dnet.module.fi.asset.frame.Amortization_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("amort", new net.nan21.dnet.module.fi.asset.dc.Amortization({}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("amort", {name:"amortFilter", height:120, xtype:"fi_asset_dc_Amortization$Filter"})
			.addDcGridView("amort", {name:"amortList", xtype:"fi_asset_dc_Amortization$List"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["amortFilter", "amortList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbAmortList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAmortList", {dc: "amort"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Amortization"})
			.end()
	}

});
