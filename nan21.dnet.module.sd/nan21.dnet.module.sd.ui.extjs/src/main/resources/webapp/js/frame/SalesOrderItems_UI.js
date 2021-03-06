/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sd.order.frame.SalesOrderItems_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.sd.order.frame.SalesOrderItems_UI",
	_name_: "net.nan21.dnet.module.sd.order.frame.SalesOrderItems_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("items", new net.nan21.dnet.module.sd.order.dc.SalesOrderItemOverview({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("items", {name:"filter", xtype:"sd_order_dc_SalesOrderItemOverview$Filter"})
			.addDcGridView("items", {name:"list", xtype:"sd_order_dc_SalesOrderItemOverview$List"})
			.addDcFormView("items", {name:"docView", title:"Sales document info", height:100, xtype:"sd_order_dc_SalesOrderItemOverview$DocView", collapsible:true
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
			.addReports().addSeparator().addSeparator().addTitle({text: "Ordered items"})
			.end()
			;
	}

});
