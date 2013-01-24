/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.inventory.frame.InvBalance_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.tx.inventory.frame.InvBalance_UI",
	_name_: "net.nan21.dnet.module.md.tx.inventory.frame.InvBalance_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("invbalance", new net.nan21.dnet.module.md.tx.inventory.dc.InvBalance({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("invbalance", {name:"invbalanceFilter", height:80, xtype:"md_tx_inventory_dc_InvBalance$Filter"})
			.addDcGridView("invbalance", {name:"invbalanceList", xtype:"md_tx_inventory_dc_InvBalance$List"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["invbalanceFilter", "invbalanceList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbInvbalanceList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvbalanceList", {dc: "invbalance"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Stocks"})
			.end()
			;
	}

});
