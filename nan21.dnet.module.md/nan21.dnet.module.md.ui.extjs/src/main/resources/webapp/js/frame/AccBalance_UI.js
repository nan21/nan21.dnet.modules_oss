/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.acc.frame.AccBalance_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.tx.acc.frame.AccBalance_UI",
	_name_: "net.nan21.dnet.module.md.tx.acc.frame.AccBalance_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("balance", new net.nan21.dnet.module.md.tx.acc.dc.AccBalance({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("balance", {name:"balanceFilter", xtype:"md_tx_acc_dc_AccBalance$Filter"})
			.addDcGridView("balance", {name:"balanceList", xtype:"md_tx_acc_dc_AccBalance$List"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["balanceFilter", "balanceList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbBalanceList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbBalanceList", {dc: "balance"}).addQuery()
			.addReports()
			.end()
			;
	}

});
