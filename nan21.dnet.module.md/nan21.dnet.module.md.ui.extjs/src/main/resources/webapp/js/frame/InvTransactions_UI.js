/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.inventory.frame.InvTransactions_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.tx.inventory.frame.InvTransactions_UI",
	_name_: "net.nan21.dnet.module.md.tx.inventory.frame.InvTransactions_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("tx", new net.nan21.dnet.module.md.tx.inventory.dc.InvTransaction({}))
			.addDc("txline", new net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine({}))
	
			.linkDc("txline", "tx",{fields:[
				{childField:"transactionId", parentField:"id"}, {childField:"fromInventoryId", parentField:"fromInventoryId"}, {childField:"toInventoryId", parentField:"toInventoryId"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("tx", {name:"txFilter", height:110, xtype:"md_tx_inventory_dc_InvTransaction$Filter"})
			.addDcGridView("tx", {name:"txList", xtype:"md_tx_inventory_dc_InvTransaction$List"})
			.addDcGridView("txline", {name:"txlineList", height:200, xtype:"md_tx_inventory_dc_InvTransactionLine$List"})
			.addDcFormView("txline", {name:"txlineCtxFormView", height:40, xtype:"md_tx_inventory_dc_InvTransactionLine$CtxFormView"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["txFilter", "txList", "txlineList"], ["north", "center", "south"])
			.addToolbarTo("canvas1", "tlbTxList")
			.addToolbarTo("txlineList", "tlbTxlineEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTxList", {dc: "tx"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Transactions"})
			.end()
			.beginToolbar("tlbTxlineEditList", {dc: "txline"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Items"})
			.end()
			;
	}

});
