/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.inventory.frame.InvOperations_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.tx.inventory.frame.InvOperations_UI",
	_name_: "net.nan21.dnet.module.md.tx.inventory.frame.InvOperations_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("invop", new net.nan21.dnet.module.md.tx.inventory.dc.InvOperation({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("invop", {name:"invopFilter", height:140, xtype:"md_tx_inventory_dc_InvOperation$Filter"})
			.addDcGridView("invop", {name:"invopList", xtype:"md_tx_inventory_dc_InvOperation$List"})
			.addPanel({name:"main", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["invopFilter", "invopList"], ["north", "center"])
			.addToolbarTo("main", "tlbInvopList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvopList", {dc: "invop"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Inventory operations"})
			.end()
			;
	}

});
