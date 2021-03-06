/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.inventory.frame.InvTxTypes_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.tx.inventory.frame.InvTxTypes_UI",
	_name_: "net.nan21.dnet.module.md.tx.inventory.frame.InvTxTypes_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("txtype", new net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionType({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("txtype", {name:"txtypeFilter", height:120, xtype:"md_tx_inventory_dc_InvTransactionType$Filter"})
			.addDcEditGridView("txtype", {name:"txtypeEditList", xtype:"md_tx_inventory_dc_InvTransactionType$EditList", frame:true})
			.addPanel({name:"main", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["txtypeFilter", "txtypeEditList"], ["north", "center"])
			.addToolbarTo("main", "tlbTxtypeEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTxtypeEditList", {dc: "txtype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Inventory transaction types"})
			.end()
			;
	}

});
