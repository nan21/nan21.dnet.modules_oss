/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sc.order.frame.PurchaseInventoryTransaction_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.sc.order.frame.PurchaseInventoryTransaction_UI",
	_name_: "net.nan21.dnet.module.sc.order.frame.PurchaseInventoryTransaction_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("tx", new net.nan21.dnet.module.sc.order.dc.PurchaseInventoryTransaction({}))
			.addDc("txline", new net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine({multiEdit:true}))
	
			.linkDc("txline", "tx",{fields:[
				{childField:"transactionId", parentField:"id"}, {childField:"fromInventoryId", parentField:"fromInventoryId"}, {childField:"toInventoryId", parentField:"toInventoryId"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("tx", {name:"txFilter", xtype:"sc_order_dc_PurchaseInventoryTransaction$Filter"})
			.addDcGridView("tx", {name:"txList", xtype:"sc_order_dc_PurchaseInventoryTransaction$List"})
			.addDcFormView("tx", {name:"txEdit", xtype:"sc_order_dc_PurchaseInventoryTransaction$Edit"})
			.addDcEditGridView("txline", {name:"txlineEditList", xtype:"md_tx_inventory_dc_InvTransactionLine$EditList", frame:true})
			.addDcFormView("txline", {name:"txlineCtxFormView", height:40, xtype:"md_tx_inventory_dc_InvTransactionLine$CtxFormView"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["txFilter", "txList"], ["north", "center"])
			.addChildrenTo("canvas2", ["txEdit", "txlineEditList", "txlineCtxFormView"], ["north", "center", "south"])
			.addToolbarTo("canvas1", "tlbTxList")
			.addToolbarTo("canvas2", "tlbTxEdit")
			.addToolbarTo("txlineEditList", "tlbTxlineEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTxList", {dc: "tx"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Receptions"})
			.end()
			.beginToolbar("tlbTxEdit", {dc: "tx"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Reception"})
			.end()
			.beginToolbar("tlbTxlineEditList", {dc: "txline"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Items"})
			.end()
			;
	}

});
