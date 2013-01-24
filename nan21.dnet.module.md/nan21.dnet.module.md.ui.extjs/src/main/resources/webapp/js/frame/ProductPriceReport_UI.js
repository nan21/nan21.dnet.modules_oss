/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.mm.price.frame.ProductPriceReport_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.mm.price.frame.ProductPriceReport_UI",
	_name_: "net.nan21.dnet.module.md.mm.price.frame.ProductPriceReport_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("prodprice", new net.nan21.dnet.module.md.mm.price.dc.ProductPriceReport({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("prodprice", {name:"prodpriceFilter", height:110, xtype:"md_mm_price_dc_ProductPriceReport$Filter"})
			.addDcGridView("prodprice", {name:"prodpriceList", xtype:"md_mm_price_dc_ProductPriceReport$List"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["prodpriceFilter", "prodpriceList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbProdpriceList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProdpriceList", {dc: "prodprice"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Price report"})
			.end()
			;
	}

});
