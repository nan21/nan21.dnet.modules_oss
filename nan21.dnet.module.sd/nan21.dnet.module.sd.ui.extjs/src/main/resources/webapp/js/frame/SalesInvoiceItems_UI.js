/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceItems_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceItems_UI",
	_name_: "net.nan21.dnet.module.sd.invoice.frame.SalesInvoiceItems_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("items", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItemOverview({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("items", {name:"filter", xtype:"sd_invoice_dc_SalesInvoiceItemOverview$Filter"})
			.addDcGridView("items", {name:"list", xtype:"sd_invoice_dc_SalesInvoiceItemOverview$List"})
			.addDcFormView("items", {name:"docView", title:"Sales document info", height:100, xtype:"sd_invoice_dc_SalesInvoiceItemOverview$DocView", collapsible:true
			})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["filter", "list", "docView"], ["north", "center", "south"])
			.addToolbarTo("canvas1", "tlbInvList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvList", {dc: "items"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Sold items"})
			.end()
			;
	}

});
