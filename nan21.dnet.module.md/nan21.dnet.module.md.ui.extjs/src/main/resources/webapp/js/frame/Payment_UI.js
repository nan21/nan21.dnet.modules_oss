/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.tx.fin.frame.Payment_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.tx.fin.frame.Payment_UI",
	_name_: "net.nan21.dnet.module.md.tx.fin.frame.Payment_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("payment", new net.nan21.dnet.module.md.tx.fin.dc.Payment({}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("payment", {name:"paymentFilter", xtype:"md_tx_fin_dc_Payment$Filter"})
			.addDcGridView("payment", {name:"paymentList", xtype:"md_tx_fin_dc_Payment$List"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["paymentFilter", "paymentList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbPaymentList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPaymentList", {dc: "payment"}).addQuery()
			.addReports().addSeparator().addSeparator().addTitle({text: "Payments"})
			.end()
			;
	}

});
