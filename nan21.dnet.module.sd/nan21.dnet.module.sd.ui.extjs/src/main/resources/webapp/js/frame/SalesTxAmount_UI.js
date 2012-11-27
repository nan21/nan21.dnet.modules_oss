/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesTxAmountOverview", "nan21.dnet.module.md.ui.extjs/ds/PaymentMethodLovDs", "nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs", "nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName", "nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations", "nan21.dnet.module.md.ui.extjs/lov/PaymentMethod", "nan21.dnet.module.bd.ui.extjs/lov/Currencies", "nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs", "nan21.dnet.module.sd.ui.extjs/ds/SalesTxAmountOverviewDs"]);

Ext.define("net.nan21.dnet.module.sd.invoice.frame.SalesTxAmount_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.sd.invoice.frame.SalesTxAmount_UI",
	_name_: "net.nan21.dnet.module.sd.invoice.frame.SalesTxAmount_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("txamount", new net.nan21.dnet.module.sd.invoice.dc.SalesTxAmountOverview({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("txamount", {name:"filter", xtype:"sd_invoice_dc_SalesTxAmountOverview$Filter"})
			.addDcGridView("txamount", {name:"list", xtype:"sd_invoice_dc_SalesTxAmountOverview$List"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["filter", "list"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbInvList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvList", {dc: "txamount"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Receivables"})
			.end()
			;
	}

});
