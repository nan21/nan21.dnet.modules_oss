/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/lov/FinancialAccounts", "nan21.dnet.module.sd.ui.extjs/dc/PaymentIn", "nan21.dnet.module.md.ui.extjs/dc/AccDocLineCtx", "nan21.dnet.module.sd.ui.extjs/dc/SalesTxAmountPaymentProposal", "nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs", "nan21.dnet.module.md.ui.extjs/lov/CustomersName", "nan21.dnet.module.md.ui.extjs/ds/AccDocLineCtxDs", "nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName", "nan21.dnet.module.sd.ui.extjs/dc/PaymentInAmount", "nan21.dnet.module.sd.ui.extjs/ds/PaymentInDs", "nan21.dnet.module.sd.ui.extjs/ds/PaymentInAmountDs", "nan21.dnet.module.sd.ui.extjs/ds/SalesTxAmountPaymentProposalDs", "nan21.dnet.module.md.ui.extjs/lov/PaymentMethodIn", "nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs", "nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations", "nan21.dnet.module.md.ui.extjs/ds/CustomerLovDs", "nan21.dnet.module.bd.ui.extjs/lov/Currencies", "nan21.dnet.module.md.ui.extjs/ds/PaymentMethodInLovDs", "nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs", "nan21.dnet.module.md.ui.extjs/lov/AccSchemas", "nan21.dnet.module.md.ui.extjs/ds/FinancialAccountLovDs"]);

Ext.define("net.nan21.dnet.module.sd.invoice.frame.PaymentIn_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.sd.invoice.frame.PaymentIn_UI",
	_name_: "net.nan21.dnet.module.sd.invoice.frame.PaymentIn_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("payment", new net.nan21.dnet.module.sd.invoice.dc.PaymentIn({}))
			.addDc("amount", new net.nan21.dnet.module.sd.invoice.dc.PaymentInAmount({}))
			.addDc("accDocLine", new net.nan21.dnet.module.md.tx.acc.dc.AccDocLineCtx({}))
			.addDc("proposal", new net.nan21.dnet.module.sd.invoice.dc.SalesTxAmountPaymentProposal({multiEdit:true}))
	
			.linkDc("amount", "payment",{fields:[
				{childField:"paymentId", parentField:"id"}]}
			)
			.linkDc("accDocLine", "payment",{fields:[
				{childField:"docUuid", parentField:"uuid"}]}
			)
			.linkDc("proposal", "payment",{fields:[
				{childField:"bpartnerId", parentField:"bpartnerId"}, {childField:"orgId", parentField:"orgId"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnConfirm", text:"Confirm", tooltip:"Confirm payment.", iconCls:"icon-action-commit", disabled:true,
					handler: this.onBtnConfirm, scope:this, stateManager:{name:"selected_one_clean", dc:"payment" , and: function(dc) {return (dc.record && !dc.record.get("confirmed"));}}})
			.addButton({name:"btnUnConfirm", text:"Un-Confirm", tooltip:"Un-Confirm payment.", iconCls:"icon-action-rollback", disabled:true,
					handler: this.onBtnUnConfirm, scope:this, stateManager:{name:"selected_one_clean", dc:"payment" , and: function(dc) {return (dc.record && dc.record.get("confirmed") && !dc.record.get("posted")  );}}})
			.addButton({name:"btnPost", text:"Post", tooltip:"Post payment to accounting.", iconCls:"icon-action-commit", disabled:true,
					handler: this.onBtnPost, scope:this, stateManager:{name:"selected_one_clean", dc:"payment" , and: function(dc) {return (dc.record && dc.record.get("confirmed")&& !dc.record.get("posted"));}}})
			.addButton({name:"btnUnPost", text:"Un-Post", tooltip:"Un-Post payment from accounting.", iconCls:"icon-action-rollback", disabled:true,
					handler: this.onBtnUnPost, scope:this, stateManager:{name:"selected_one_clean", dc:"payment" , and: function(dc) {return (dc.record && dc.record.get("confirmed") &&  dc.record.get("confirmed") && dc.record.get("posted") );}}})
			.addButton({name:"btnShowInvoice", text:"Show invoice", tooltip:"Show invoice", disabled:true,
					handler: this.onBtnShowInvoice, scope:this, stateManager:{name:"selected_one", dc:"amount" , and: function(dc) {return ( !Ext.isEmpty(dc.record.get("invoiceCode")));}}})
			
			.addDcFilterFormView("payment", {name:"paymentFilter", height:130, xtype:"sd_invoice_dc_PaymentIn$Filter"})
			.addDcGridView("payment", {name:"paymentList", xtype:"sd_invoice_dc_PaymentIn$List"})
			.addDcFormView("payment", {name:"paymentInfo", xtype:"sd_invoice_dc_PaymentIn$ViewInfo"})
			.addDcFormView("payment", {name:"paymentEdit", height:180, xtype:"sd_invoice_dc_PaymentIn$Edit", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnConfirm"), this._elems_.get("btnUnConfirm")]}]})
			.addDcGridView("amount", {name:"amountList", title:"Amounts", xtype:"sd_invoice_dc_PaymentInAmount$List", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnShowInvoice")]}]})
			.addDcGridView("accDocLine", {name:"accDocLineList", xtype:"md_tx_acc_dc_AccDocLineCtx$List"})
			.addDcFilterFormView("accDocLine", {name:"accDocLineFilter", title:"Filter", width:250, xtype:"md_tx_acc_dc_AccDocLineCtx$Filter", collapsible:true, collapsed:true
			})
			.addDcFilterFormView("proposal", {name:"proposalFilter", xtype:"sd_invoice_dc_SalesTxAmountPaymentProposal$Filter"})
			.addDcEditGridView("proposal", {name:"proposalEditList", xtype:"sd_invoice_dc_SalesTxAmountPaymentProposal$EditList", frame:true})
			.addPanel({name:"proposalPanel", width:950, height:450, layout:"border", defaults:{split:true}})
			.addWindow({name:"wdwProposal", title:"Payment details", closeAction:'hide', resizable:true, layout:"fit", modal:true,
				items:[this._elems_.get("proposalPanel")]})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"paymentDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"accDocPanel", title:"Accounting", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("proposalPanel", ["proposalFilter", "proposalEditList"], ["north", "center"])
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["paymentFilter", "paymentList"], ["north", "center"])
			.addChildrenTo("canvas2", ["paymentEdit", "paymentDetailsTab"], ["north", "center"])
			.addChildrenTo("paymentDetailsTab", ["amountList", "accDocPanel"])
			.addChildrenTo("accDocPanel", ["accDocLineFilter", "accDocLineList"], ["west", "center"])
			.addToolbarTo("canvas1", "tlbPaymentList")
			.addToolbarTo("canvas2", "tlbPaymentEdit")
			.addToolbarTo("amountList", "tlbAmountList")
			.addToolbarTo("accDocLineList", "tlbAccDocLineList")
			.addToolbarTo("proposalPanel", "tlbProposalFilter")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPaymentList", {dc: "payment"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Payments In"})
			.end()
			.beginToolbar("tlbPaymentEdit", {dc: "payment"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Payment In"})
			.end()
			.beginToolbar("tlbAmountList", {dc: "amount"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Amounts"})
			.end()
			.beginToolbar("tlbAccDocLineList", {dc: "accDocLine"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounting"})
			.end()
			.beginToolbar("tlbProposalFilter", {dc: "proposal"}).addQuery().addSave().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Due amounts"})
			.end()
			;
	}

	
	,onBtnConfirm: function() {
		this.openProposalWdw();
		this._getWindow_("wdwProposal").show();
	}
	
	,onBtnUnConfirm: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("payment").doService("unConfirm", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onBtnPost: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("payment").doService("post", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onBtnUnPost: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("payment").doService("unPost", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onBtnShowInvoice: function() {
		var bundle = "nan21.dnet.module.sd.ui.extjs";
		var frame = "net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
			code: this._getDc_("amount").getRecord().get("invoiceCode")
			},
			callback: function (params) {
				this._when_called_to_edit_(params);
			}
		});
	}
	
	,openProposalWdw: function() {
		  
		var paymentRec = this._getDc_("payment").getRecord();
		var proposalDc = this._getDc_("proposal");
		
		proposalDc.setParamValue("paymentId", paymentRec.get("id") );
		proposalDc.setParamValue("businessPartner", paymentRec.get("bpartner") );
		proposalDc.setParamValue("receivedAmount", paymentRec.get("amount"));
		proposalDc.setParamValue("unAllocatedAmount", 0);
		
		proposalDc.setParamValue("currency", paymentRec.get("currency"));
		proposalDc.doCancel();
		proposalDc.doQuery();
	}
	
	,onAfterDefineDcs: function() {
		  
		this._getDc_("payment").on("afterDoServiceSuccess", 
		function() { this._applyStateAllButtons_(); this._getDc_("amount").doQuery();  } , this );
		
		this._getDc_("proposal").on("afterDoSaveSuccess", 
		function() { 
			this._getDc_("payment").doReloadRecord();
			this._getElement_("wdwProposal").hide(); 
			this._getDc_("amount").doQuery();
		} , this );
	}
	
	,_when_called_to_edit_: function(params) {
		
		var payment = this._getDc_("payment");
		if (payment.isDirty()) {
			this._alert_dirty_();
			return;
		}
		payment.doClearQuery();
		payment.setFilterValue("code", params.code );
		payment.doQuery();
		this._showStackedViewElement_("main",1);
	}
	,_afterDefineDcs_: function() {
		this.onAfterDefineDcs();
	}
});
