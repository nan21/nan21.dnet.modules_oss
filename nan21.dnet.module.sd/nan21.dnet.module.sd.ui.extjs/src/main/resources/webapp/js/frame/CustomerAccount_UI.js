/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/lov/WarehouseOrganizations", "nan21.dnet.module.md.ui.extjs/ds/CustomerGroupLovDs", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs", "nan21.dnet.module.md.ui.extjs/lov/PaymentTerm", "nan21.dnet.module.md.ui.extjs/ds/PaymentMethodLovDs", "nan21.dnet.module.sd.ui.extjs/ds/SalesTxAmountDs", "nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName", "nan21.dnet.module.md.ui.extjs/ds/TxDocTypeSOLovDs", "nan21.dnet.module.sd.ui.extjs/dc/CustomerAccountCtxInvoice", "nan21.dnet.module.bd.ui.extjs/ds/WarehouseOrganizationLovDs", "nan21.dnet.module.md.ui.extjs/lov/PaymentMethodIn", "nan21.dnet.module.md.ui.extjs/ds/PriceListSalesLovDs", "nan21.dnet.module.md.ui.extjs/ds/DeliveryMethodLovDs", "nan21.dnet.module.md.ui.extjs/lov/PriceListSales", "nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersCode", "nan21.dnet.module.bd.ui.extjs/lov/Currencies", "nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs", "nan21.dnet.module.md.ui.extjs/ds/FinancialAccountLovDs", "nan21.dnet.module.sd.ui.extjs/dc/CustomerAccountCtxPayment", "nan21.dnet.module.sd.ui.extjs/dc/SalesTxAmount", "nan21.dnet.module.md.ui.extjs/lov/FinancialAccounts", "nan21.dnet.module.md.ui.extjs/lov/TxDocTypesSO", "nan21.dnet.module.md.ui.extjs/lov/TxDocTypesSI", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceDs", "nan21.dnet.module.md.ui.extjs/lov/DeliveryMethods", "nan21.dnet.module.sd.ui.extjs/dc/PaymentInAmount", "nan21.dnet.module.md.ui.extjs/ds/TxDocTypeSILovDs", "nan21.dnet.module.sd.ui.extjs/ds/PaymentInDs", "nan21.dnet.module.md.ui.extjs/lov/CustomerGroup", "nan21.dnet.module.md.ui.extjs/ds/PaymentTermLovDs", "nan21.dnet.module.sd.ui.extjs/dc/CustomerAccountCtxOrder", "nan21.dnet.module.sd.ui.extjs/ds/PaymentInAmountDs", "nan21.dnet.module.sd.ui.extjs/dc/CustomerAccount", "nan21.dnet.module.sd.ui.extjs/ds/SalesOrderDs", "nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs", "nan21.dnet.module.sd.ui.extjs/ds/CustomerAccountDs", "nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations", "nan21.dnet.module.md.ui.extjs/lov/PaymentMethod", "nan21.dnet.module.md.ui.extjs/ds/PaymentMethodInLovDs"]);

Ext.define("net.nan21.dnet.module.sd.account.frame.CustomerAccount_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.sd.account.frame.CustomerAccount_UI",
	_name_: "net.nan21.dnet.module.sd.account.frame.CustomerAccount_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("account", new net.nan21.dnet.module.sd.account.dc.CustomerAccount({}))
			.addDc("txAmount", new net.nan21.dnet.module.sd.invoice.dc.SalesTxAmount({}))
			.addDc("payment", new net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxPayment({}))
			.addDc("payAmount", new net.nan21.dnet.module.sd.invoice.dc.PaymentInAmount({}))
			.addDc("invoice", new net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxInvoice({}))
			.addDc("order", new net.nan21.dnet.module.sd.account.dc.CustomerAccountCtxOrder({}))
	
			.linkDc("txAmount", "account",{fields:[
				{childField:"bpartnerId", parentField:"businessPartnerId"}, {childField:"orgId", parentField:"orgId"}]}
			)
			.linkDc("payment", "account",{fields:[
				{childField:"bpartnerId", parentField:"businessPartnerId"}, {childField:"orgId", parentField:"orgId"}]}
			)
			.linkDc("payAmount", "account",{fields:[
				{childField:"bpartnerId", parentField:"businessPartnerId"}, {childField:"orgId", parentField:"orgId"}]}
			)
			.linkDc("invoice", "account",{fields:[
				{childField:"customerId", parentField:"businessPartnerId"}, {childField:"supplierId", parentField:"orgId"}]}
			)
			.linkDc("order", "account",{fields:[
				{childField:"customerId", parentField:"businessPartnerId"}, {childField:"supplierId", parentField:"orgId"}]}
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
			
			.addDcFilterFormView("account", {name:"accountFilter", xtype:"sd_account_dc_CustomerAccount$Filter"})
			.addDcGridView("account", {name:"accountList", xtype:"sd_account_dc_CustomerAccount$List"})
			.addDcFormView("account", {name:"accountEdit", xtype:"sd_account_dc_CustomerAccount$Edit"})
			.addDcGridView("txAmount", {name:"txAmountList", title:"Receivables", xtype:"sd_invoice_dc_SalesTxAmount$List", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnShowInvoice2")]}]})
			.addDcFilterFormView("invoice", {name:"invoiceFilter", title:"Filter", width:300, xtype:"sd_account_dc_CustomerAccountCtxInvoice$Filter", collapsible:true
			})
			.addDcGridView("invoice", {name:"invoiceList", xtype:"sd_account_dc_CustomerAccountCtxInvoice$List", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnShowInvoice")]}]})
			.addPanel({name:"invoicePanel", title:"Invoices", layout:"border", defaults:{split:true}})
			.addDcFilterFormView("order", {name:"orderFilter", title:"Filter", width:300, xtype:"sd_account_dc_CustomerAccountCtxOrder$Filter", collapsible:true
			})
			.addDcGridView("order", {name:"orderList", xtype:"sd_account_dc_CustomerAccountCtxOrder$List", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnShowOrder")]}]})
			.addPanel({name:"orderPanel", title:"Sales orders", layout:"border", defaults:{split:true}})
			.addDcFilterFormView("payment", {name:"paymentFilter", title:"Filter", width:300, xtype:"sd_account_dc_CustomerAccountCtxPayment$Filter", collapsible:true
			})
			.addDcGridView("payment", {name:"paymentList", xtype:"sd_account_dc_CustomerAccountCtxPayment$List", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnShowPayment")]}]})
			.addPanel({name:"paymentPanel", title:"Payments", layout:"border", defaults:{split:true}})
			.addDcGridView("payAmount", {name:"payAmountList", title:"Payment distribution", xtype:"sd_invoice_dc_PaymentInAmount$List"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"accountDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("invoicePanel", ["invoiceFilter", "invoiceList"], ["west", "center"])
			.addChildrenTo("orderPanel", ["orderFilter", "orderList"], ["west", "center"])
			.addChildrenTo("paymentPanel", ["paymentFilter", "paymentList"], ["west", "center"])
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["accountFilter", "accountList"], ["north", "center"])
			.addChildrenTo("canvas2", ["accountEdit", "accountDetailsTab"], ["north", "center"])
			.addChildrenTo("accountDetailsTab", ["txAmountList", "orderPanel", "invoicePanel", "paymentPanel"])
			.addToolbarTo("canvas1", "tlbAccountList")
			.addToolbarTo("canvas2", "tlbAccountEdit")
			.addToolbarTo("txAmountList", "tlbTxAmountsList")
			.addToolbarTo("paymentList", "tlbPaymentsList")
			.addToolbarTo("invoiceList", "tlbInvoicesList")
			.addToolbarTo("orderList", "tlbOrdersList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAccountList", {dc: "account"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Customer accounts"})
			.end()
			.beginToolbar("tlbAccountEdit", {dc: "account"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Customer account"})
			.end()
			.beginToolbar("tlbTxAmountsList", {dc: "txAmount"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Receivables"})
			.end()
			.beginToolbar("tlbPaymentsList", {dc: "payment"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Payments"})
			.end()
			.beginToolbar("tlbInvoicesList", {dc: "invoice"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Invoices"})
			.end()
			.beginToolbar("tlbOrdersList", {dc: "order"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Sales orders"})
			.end()
			;
	}

	
	,onBtnShowInvoice: function() {
		var bundle = "nan21.dnet.module.sd.ui.extjs";
		var frame = "net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI";
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
		var bundle = "nan21.dnet.module.sd.ui.extjs";
		var frame = "net.nan21.dnet.module.sd.order.frame.SalesOrder_UI";
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
		var bundle = "nan21.dnet.module.sd.ui.extjs";
		var frame = "net.nan21.dnet.module.sd.invoice.frame.PaymentIn_UI";
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
		var bundle = "nan21.dnet.module.sd.ui.extjs";
		var frame = "net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI";
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
});
