/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/lov/StockLocatorTypes", "nan21.dnet.module.md.ui.extjs/dc/SubInventory", "nan21.dnet.module.md.ui.extjs/ds/SubInventoryDs", "nan21.dnet.module.md.ui.extjs/dc/StockLocator", "nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations", "nan21.dnet.module.md.ui.extjs/ds/StockLocatorDs", "nan21.dnet.module.md.ui.extjs/ds/StockLocatorTypeLovDs", "nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs"]);

Ext.define("net.nan21.dnet.module.md.org.frame.SubInventories_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.org.frame.SubInventories_UI",
	_name_: "net.nan21.dnet.module.md.org.frame.SubInventories_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("subinv", new net.nan21.dnet.module.md.org.dc.SubInventory({}))
			.addDc("sloc", new net.nan21.dnet.module.md.org.dc.StockLocator({multiEdit:true}))
	
			.linkDc("sloc", "subinv",{fields:[
				{childField:"subInventoryId", parentField:"id"}]}
			)
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("subinv", {name:"subinvFilter", height:80, xtype:"md_org_dc_SubInventory$Filter"})	
			.addDcGridView("subinv", {name:"subinvList", xtype:"md_org_dc_SubInventory$List"})	
			.addDcFormView("subinv", {name:"subinvEdit", height:150, xtype:"md_org_dc_SubInventory$Edit"})	
			.addDcFilterFormView("sloc", {name:"slocFilter", xtype:"md_org_dc_StockLocator$Filter"})	
			.addDcEditGridView("sloc", {name:"slocEditList", xtype:"md_org_dc_StockLocator$CtxEditList", frame:true})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["subinvFilter", "subinvList"], ["north", "center"])
			.addChildrenTo("canvas2", ["subinvEdit", "slocEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbSubinvList")
			.addToolbarTo("canvas2", "tlbSubinvEdit")
			.addToolbarTo("slocEditList", "tlbSlocEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSubinvList", {dc: "subinv"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Sub-inventories"})
			.end()
			.beginToolbar("tlbSubinvEdit", {dc: "subinv"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Sub-inventory"})
			.end()
			.beginToolbar("tlbSlocEditList", {dc: "sloc"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Stock locators"})
			.end()
	}

});
