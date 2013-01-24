/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.sc.account.frame.VendorAccount_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.sc.account.frame.VendorAccount_UI",
	_name_: "net.nan21.dnet.module.sc.account.frame.VendorAccount_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("account", new net.nan21.dnet.module.sc.account.dc.VendorAccount({}))
			.addDc("txAmount", new net.nan21.dnet.module.sc.invoice.dc.PurchaseTxAmount({}))
			.addDc("payAmount", new net.nan21.dnet.module.sc.invoice.dc.PurchaseTxAmountPayment({}))
			.addDc("payment", new net.nan21.dnet.module.sc.account.dc.VendorAccountCtxPayment({}))
			.addDc("invoice", new net.nan21.dnet.module.sc.account.dc.VendorAccountCtxInvoice({}))
			.addDc("order", new net.nan21.dnet.module.sc.account.dc.VendorAccountCtxOrder({}))
	
			.linkDc("txAmount", "account",{fields:[
				{childField:"bpartnerId", parentField:"businessPartnerId"}, {childField:"orgId", parentField:"orgId"}]}
			)
			.linkDc("payAmount", "txAmount",{fields:[
				{childField:"txAmountId", parentField:"id"}]}
			)
			.linkDc("payment", "account",{fields:[
				{childField:"bpartnerId", parentField:"businessPartnerId"}, {childField:"orgId", parentField:"orgId"}]}
			)
			.linkDc("invoice", "account",{fields:[
				{childField:"supplierId", parentField:"businessPartnerId"}, {childField:"customerId", parentField:"orgId"}]}
			)
			.linkDc("order", "account",{fields:[
				{childField:"supplierId", parentField:"businessPartnerId"}, {childField:"customerId", parentField:"orgId"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnShowInvoice", text:"Show invoice", tooltip:"Show invoice", disabled:true,
					handler: this.onBtnShowInvoice, scope:this, stateManager:{name:"selected_one", dc:"invoice" }})
			.addButton({name:"btnShowOrder", text:"Show order", tooltip:"Show order", disabled:true,
					handler: this.onBtnShowOrder, scope:this, stateManager:{name:"selected_one", dc:"order" }})
			.addButton({name:"btnShowPayment", text:"Show payment", tooltip:"Show payment", disabled:true,
					handler: this.onBtnShowPayment, scope:this, stateManager:{name:"selected_one", dc:"payment" }})
			.addButton({name:"btnShowInvoice2", text:"Show invoice", tooltip:"Show invoice", disabled:true,
					handler: this.onBtnShowInvoice2, scope:this, stateManager:{name:"selected_one", dc:"txAmount" , and: function(dc) {return ( !Ext.isEmpty(dc.record.get("invoiceCode")));}}})
			.addButton({name:"btnShowPayment2", text:"Show payment", tooltip:"Show payment", disabled:true,
					handler: this.onBtnShowPayment2, scope:this, stateManager:{name:"selected_one", dc:"payAmount" }})
			
			.addDcFilterFormView("account", {name:"accountFilter", xtype:"sc_account_dc_VendorAccount$Filter"})
			.addDcGridView("account", {name:"accountList", xtype:"sc_account_dc_VendorAccount$List"})
			.addDcFormView("account", {name:"accountEdit", xtype:"sc_account_dc_VendorAccount$Edit"})
			.addDcGridView("txAmount", {name:"txAmountList", width:800, xtype:"sc_invoice_dc_PurchaseTxAmount$List", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnShowInvoice2")]}]})
			.addDcGridView("payAmount", {name:"payAmountList", xtype:"sc_invoice_dc_PurchaseTxAmountPayment$List", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnShowPayment2")]}]})
			.addPanel({name:"amountsPanel", title:"Payables", layout:"border", defaults:{split:true}})
			.addDcFilterFormView("invoice", {name:"invoiceFilter", title:"Filter", width:300, xtype:"sc_account_dc_VendorAccountCtxInvoice$Filter", collapsible:true
			})
			.addDcGridView("invoice", {name:"invoiceList", xtype:"sc_account_dc_VendorAccountCtxInvoice$List", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnShowInvoice")]}]})
			.addPanel({name:"invoicePanel", title:"Invoices", layout:"border", defaults:{split:true}})
			.addDcFilterFormView("order", {name:"orderFilter", title:"Filter", width:300, xtype:"sc_account_dc_VendorAccountCtxOrder$Filter", collapsible:true
			})
			.addDcGridView("order", {name:"orderList", xtype:"sc_account_dc_VendorAccountCtxOrder$List", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnShowOrder")]}]})
			.addPanel({name:"orderPanel", title:"Purchase orders", layout:"border", defaults:{split:true}})
			.addDcFilterFormView("payment", {name:"paymentFilter", title:"Filter", width:300, xtype:"sc_account_dc_VendorAccountCtxPayment$Filter", collapsible:true
			})
			.addDcGridView("payment", {name:"paymentList", xtype:"sc_account_dc_VendorAccountCtxPayment$List", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnShowPayment")]}]})
			.addPanel({name:"paymentPanel", title:"Payments", layout:"border", defaults:{split:true}})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"accountDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("amountsPanel", ["txAmountList", "payAmountList"], ["west", "center"])
			.addChildrenTo("invoicePanel", ["invoiceFilter", "invoiceList"], ["west", "center"])
			.addChildrenTo("orderPanel", ["orderFilter", "orderList"], ["west", "center"])
			.addChildrenTo("paymentPanel", ["paymentFilter", "paymentList"], ["west", "center"])
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["accountFilter", "accountList"], ["north", "center"])
			.addChildrenTo("canvas2", ["accountEdit", "accountDetailsTab"], ["north", "center"])
			.addChildrenTo("accountDetailsTab", ["amountsPanel", "orderPanel", "invoicePanel", "paymentPanel"])
			.addToolbarTo("canvas1", "tlbAccountList")
			.addToolbarTo("canvas2", "tlbAccountEdit")
			.addToolbarTo("txAmountList", "tlbTxAmountsList")
			.addToolbarTo("payAmountList", "tlbPayAmountList")
			.addToolbarTo("orderList", "tlbOrdersList")
			.addToolbarTo("invoiceList", "tlbInvoicesList")
			.addToolbarTo("paymentList", "tlbPaymentsList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAccountList", {dc: "account"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Vendor accounts"})
			.end()
			.beginToolbar("tlbAccountEdit", {dc: "account"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Vendor account"})
			.end()
			.beginToolbar("tlbTxAmountsList", {dc: "txAmount"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Payables"})
			.end()
			.beginToolbar("tlbPayAmountList", {dc: "payAmount"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Payments"})
			.end()
			.beginToolbar("tlbOrdersList", {dc: "order"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Purchase orders"})
			.end()
			.beginToolbar("tlbInvoicesList", {dc: "invoice"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Invoices"})
			.end()
			.beginToolbar("tlbPaymentsList", {dc: "payment"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Payments"})
			.end()
			;
	}

	
	,onBtnShowInvoice: function() {
		var bundle = "nan21.dnet.module.sc.ui.extjs";
		var frame = "net.nan21.dnet.module.sc.invoice.frame.PurchaseInvoice_UI";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
			code: this._getDc_("invoice").getRecord().get("code")
			},
			callback: function (params) {
				this._when_called_to_edit_(params);
			}
		});
	}
	
	,onBtnShowOrder: function() {
		var bundle = "nan21.dnet.module.sc.ui.extjs";
		var frame = "net.nan21.dnet.module.sc.order.frame.PurchaseOrder_UI";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
			code: this._getDc_("order").getRecord().get("code")
			},
			callback: function (params) {
				this._when_called_to_edit_(params);
			}
		});
	}
	
	,onBtnShowPayment: function() {
		var bundle = "nan21.dnet.module.sc.ui.extjs";
		var frame = "net.nan21.dnet.module.sc.invoice.frame.PaymentOut_UI";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
			code: this._getDc_("payment").getRecord().get("code")
			},
			callback: function (params) {
				this._when_called_to_edit_(params);
			}
		});
	}
	
	,onBtnShowInvoice2: function() {
		var bundle = "nan21.dnet.module.sc.ui.extjs";
		var frame = "net.nan21.dnet.module.sc.invoice.frame.PurchaseInvoice_UI";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
			code: this._getDc_("txAmount").getRecord().get("invoiceCode")
			},
			callback: function (params) {
				this._when_called_to_edit_(params);
			}
		});
	}
	
	,onBtnShowPayment2: function() {
		var bundle = "nan21.dnet.module.sc.ui.extjs";
		var frame = "net.nan21.dnet.module.sc.invoice.frame.PaymentOut_UI";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
			code: this._getDc_("payAmount").getRecord().get("paymentCode")
			},
			callback: function (params) {
				this._when_called_to_edit_(params);
			}
		});
	}
});
