/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs", "nan21.dnet.module.md.ui.extjs/lov/TxDocTypesSI", "nan21.dnet.module.md.ui.extjs/ds/ProductLovDs", "nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs", "nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations", "nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName", "nan21.dnet.module.sd.ui.extjs/dc/SalesOrderItemOverview", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderItemOverviewDs", "nan21.dnet.module.bd.ui.extjs/lov/Currencies", "nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs", "nan21.dnet.module.md.ui.extjs/lov/Products", "nan21.dnet.module.md.ui.extjs/ds/TxDocTypeSILovDs"]);

Ext.define("net.nan21.dnet.module.sd.order.frame.SalesOrderItems_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.sd.order.frame.SalesOrderItems_UI",
	_name_: "net.nan21.dnet.module.sd.order.frame.SalesOrderItems_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("items", new net.nan21.dnet.module.sd.order.dc.SalesOrderItemOverview({}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("items", {name:"filter", xtype:"sd_order_dc_SalesOrderItemOverview$Filter"})
			.addDcGridView("items", {name:"list", xtype:"sd_order_dc_SalesOrderItemOverview$List"})
			.addDcFormView("items", {name:"docView", title:"Sales document info", height:100, xtype:"sd_order_dc_SalesOrderItemOverview$DocView", collapsible:true
			})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["filter", "list", "docView"], ["north", "center", "south"])
			.addToolbarTo("canvas1", "tlbInvList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvList", {dc: "items"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Ordered items"})
			.end()
	}

});
