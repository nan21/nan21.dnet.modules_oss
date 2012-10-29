/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/dc/StockLocatorType", "nan21.dnet.module.md.ui.extjs/ds/StockLocatorTypeDs"]);

Ext.define("net.nan21.dnet.module.md.org.frame.StockLocatorTypes_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.org.frame.StockLocatorTypes_UI",
	_name_: "net.nan21.dnet.module.md.org.frame.StockLocatorTypes_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("sloctype", new net.nan21.dnet.module.md.org.dc.StockLocatorType({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("sloctype", {name:"sloctypeFilter", height:80, xtype:"md_org_dc_StockLocatorType$Filter"})
			.addDcEditGridView("sloctype", {name:"sloctypeEditList", xtype:"md_org_dc_StockLocatorType$EditList", frame:true})
			.addPanel({name:"main", layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["sloctypeFilter", "sloctypeEditList"], ["north", "center"])
			.addToolbarTo("main", "tlbSloctypeEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSloctypeEditList", {dc: "sloctype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Locator types"})
			.end()
	}

});
