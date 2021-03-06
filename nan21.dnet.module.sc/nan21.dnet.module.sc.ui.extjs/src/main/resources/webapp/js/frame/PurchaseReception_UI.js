/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sc.order.frame.PurchaseReception_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.sc.order.frame.PurchaseReception_UI",
	_name_: "net.nan21.dnet.module.sc.order.frame.PurchaseReception_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("tx", new net.nan21.dnet.module.sc.order.dc.PurchaseReception({}))
			.addDc("txline", new net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionLine({multiEdit:true}))
	
			.linkDc("txline", "tx",{fields:[
				{childField:"transactionId", parentField:"id"}, {childField:"toInventoryId", parentField:"warehouseId"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnConfirm", text:"Confirm", tooltip:"Confirm reception.", iconCls:"icon-action-commit", disabled:true,
					handler: this.onBtnConfirm, scope:this, stateManager:{name:"selected_one_clean", dc:"tx" , and: function(dc) {return (dc.record && !dc.record.get("confirmed"));}}})
			.addButton({name:"btnUnConfirm", text:"Un-Confirm", tooltip:"Un-Confirm reception.", iconCls:"icon-action-rollback", disabled:true,
					handler: this.onBtnUnConfirm, scope:this, stateManager:{name:"selected_one_clean", dc:"tx" , and: function(dc) {return (dc.record && dc.record.get("confirmed")&& !dc.record.get("posted") );}}})
			
			.addDcFilterFormView("tx", {name:"txFilter", height:140, xtype:"sc_order_dc_PurchaseReception$Filter"})
			.addDcGridView("tx", {name:"txList", xtype:"sc_order_dc_PurchaseReception$List"})
			.addDcFormView("tx", {name:"txEdit", height:180, xtype:"sc_order_dc_PurchaseReception$Edit", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnConfirm"), this._elems_.get("btnUnConfirm")]}]})
			.addDcEditGridView("txline", {name:"txlineEditList", xtype:"md_tx_inventory_dc_InvTransactionLine$EditListTo", frame:true})
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

	
	,onBtnConfirm: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("tx").doService("confirm", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onBtnUnConfirm: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("tx").doService("unConfirm", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onAfterDefineDcs: function() {
				 
				this._getDc_("tx").on("afterDoServiceSuccess", 
				function() {this._syncReadOnlyStates_(); } , this );
				
				this._getDc_("tx").on("recordChange", this._syncReadOnlyStates_, this );
	}
	
	,_syncReadOnlyStates_: function() {
		
				var txRec = this._getDc_("tx").getRecord();
				if (!txRec) { return; }
				var itemsDc = this._getDc_("txline");
				if (txRec.get("confirmed")) {
					if (!itemsDc.isReadOnly()) {
						itemsDc.setReadOnly(true);
					}
				} else {
					if (itemsDc.isReadOnly()) {
						itemsDc.setReadOnly(false);
					}
				}
	}
	,_afterDefineDcs_: function() {
		this.onAfterDefineDcs();
	}
});
