/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.mm.price.frame.PriceListVersions_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.mm.price.frame.PriceListVersions_UI",
	_name_: "net.nan21.dnet.module.md.mm.price.frame.PriceListVersions_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("version", new net.nan21.dnet.module.md.mm.price.dc.PriceListVersion({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("version", {name:"versionFilter", height:80, xtype:"md_mm_price_dc_PriceListVersion$Filter"})
			.addDcEditGridView("version", {name:"versionEditList", xtype:"md_mm_price_dc_PriceListVersion$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["versionFilter", "versionEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbVersionEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbVersionEditList", {dc: "version"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Price list versions"})
			.end()
			;
	}

});
