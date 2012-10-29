/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.sc.ui.extjs/ds/PurchaseInvoiceItemTaxDs", "nan21.dnet.module.md.ui.extjs/lov/TxDocTypesPI", "nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseInvoiceDs", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseInvoiceItem", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs", "nan21.dnet.module.md.ui.extjs/lov/PaymentTerm", "nan21.dnet.module.md.ui.extjs/ds/ProductLovDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment", "nan21.dnet.module.bd.ui.extjs/ds/UomLovDs", "nan21.dnet.module.md.ui.extjs/ds/PaymentMethodOutLovDs", "nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseTxAmount", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseTxAmountDs", "nan21.dnet.module.md.ui.extjs/lov/Products", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseInvoiceItemDs", "nan21.dnet.module.md.ui.extjs/ds/TaxApplicableLovDs", "nan21.dnet.module.bd.ui.extjs/lov/Currencies", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseInvoiceItemTax", "nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs", "nan21.dnet.module.md.ui.extjs/ds/VendorLovDs", "nan21.dnet.module.md.ui.extjs/lov/AccSchemas", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseInvoiceTax", "nan21.dnet.module.md.ui.extjs/ds/FinancialAccountLovDs", "nan21.dnet.module.md.ui.extjs/lov/FinancialAccounts", "nan21.dnet.module.md.ui.extjs/dc/AccDocLineCtx", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseInvoice", "nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseInvoiceTaxDs", "nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure", "nan21.dnet.module.md.ui.extjs/ds/AccDocLineCtxDs", "nan21.dnet.module.md.ui.extjs/ds/TxDocTypePILovDs", "nan21.dnet.module.md.ui.extjs/lov/ProductsWithUom", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.md.ui.extjs/ds/PaymentTermLovDs", "nan21.dnet.module.md.ui.extjs/lov/VendorsName", "nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs", "nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations", "nan21.dnet.module.md.ui.extjs/lov/TaxApplicables", "nan21.dnet.module.md.ui.extjs/lov/PaymentMethodOut", "nan21.dnet.module.md.ui.extjs/ds/ProductWithUomLovDs"]);

Ext.define("net.nan21.dnet.module.sc.invoice.frame.PurchaseInvoice_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.sc.invoice.frame.PurchaseInvoice_UI",
	_name_: "net.nan21.dnet.module.sc.invoice.frame.PurchaseInvoice_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("inv", new net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice({}))
			.addDc("tax", new net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceTax({}))
			.addDc("item", new net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem({multiEdit:true}))
			.addDc("itemTax", new net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItemTax({}))
			.addDc("amount", new net.nan21.dnet.module.sc.invoice.dc.PurchaseTxAmount({multiEdit:true}))
			.addDc("accDocLine", new net.nan21.dnet.module.md.tx.acc.dc.AccDocLineCtx({}))
			.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
			.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))
	
			.linkDc("tax", "inv",{fields:[
				{childField:"purchaseInvoiceId", parentField:"id"}]}
			)
			.linkDc("item", "inv",{fields:[
				{childField:"purchaseInvoiceId", parentField:"id"}]}
			)
			.linkDc("itemTax", "item",{fields:[
				{childField:"purchaseInvoiceItemId", parentField:"id"}]}
			)
			.linkDc("amount", "inv",{fields:[
				{childField:"invoiceId", parentField:"id"}]}
			)
			.linkDc("accDocLine", "inv",{fields:[
				{childField:"docUuid", parentField:"uuid"}]}
			)
			.linkDc("note", "inv",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"className"}]}
			)
			.linkDc("atch", "inv",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"entityFQN"}]}
			)
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnViewAttachment", text:"View", tooltip:"View the selected attachment", iconCls:"icon-action-view", disabled:true,
					handler: this.onBtnViewAttachment, scope:this, stateManager:{name:"selected_one", dc:"atch" }})
			.addButton({name:"btnUploadAttachment", text:"Upload...", tooltip:"Upload attachment file.", disabled:true,
					handler: this.onBtnUploadAttachment, scope:this, stateManager:{name:"selected_one_clean", dc:"atch" }})
			.addButton({name:"btnConfirmInvoice", text:"Confirm", tooltip:"Confirm invoice.", iconCls:"icon-action-commit", disabled:true,
					handler: this.onBtnConfirmInvoice, scope:this, stateManager:{name:"selected_one_clean", dc:"inv" , and: function(dc) {return (dc.record && !dc.record.get("confirmed"));}}})
			.addButton({name:"btnUnConfirmInvoice", text:"Un-Confirm", tooltip:"Un-Confirm invoice.", iconCls:"icon-action-rollback", disabled:true,
					handler: this.onBtnUnConfirmInvoice, scope:this, stateManager:{name:"selected_one_clean", dc:"inv" , and: function(dc) {return (dc.record && dc.record.get("confirmed") && !dc.record.get("posted")  );}}})
			.addButton({name:"btnPostInvoice", text:"Post", tooltip:"Post invoice to accounting.", iconCls:"icon-action-commit", disabled:true,
					handler: this.onBtnPostInvoice, scope:this, stateManager:{name:"selected_one_clean", dc:"inv" , and: function(dc) {return (dc.record && dc.record.get("confirmed")&& !dc.record.get("posted"));}}})
			.addButton({name:"btnUnPostInvoice", text:"Un-Post", tooltip:"Un-Post invoice from accounting.", iconCls:"icon-action-rollback", disabled:true,
					handler: this.onBtnUnPostInvoice, scope:this, stateManager:{name:"selected_one_clean", dc:"inv" , and: function(dc) {return (dc.record && dc.record.get("confirmed") &&  dc.record.get("confirmed") && dc.record.get("posted") );}}})
			
			.addDcFilterFormView("inv", {name:"invFilter", height:140, xtype:"sc_invoice_dc_PurchaseInvoice$Filter"})
			.addDcGridView("inv", {name:"invList", xtype:"sc_invoice_dc_PurchaseInvoice$List"})
			.addDcFormView("inv", {name:"invEditMain", height:180, xtype:"sc_invoice_dc_PurchaseInvoice$EditMain", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnConfirmInvoice"), this._elems_.get("btnUnConfirmInvoice"), this._elems_.get("btnPostInvoice"), this._elems_.get("btnUnPostInvoice")]}]})
			.addDcFormView("inv", {name:"invEditDetails", title:"Details", xtype:"sc_invoice_dc_PurchaseInvoice$EditDetails"})
			.addDcEditGridView("amount", {name:"amountList", title:"Payment schedule", xtype:"sc_invoice_dc_PurchaseTxAmount$EditList", frame:true})
			.addDcGridView("tax", {name:"taxList", title:"Taxes", xtype:"sc_invoice_dc_PurchaseInvoiceTax$List"})
			.addDcGridView("accDocLine", {name:"accDocLineList", xtype:"md_tx_acc_dc_AccDocLineCtx$List"})
			.addDcFilterFormView("accDocLine", {name:"accDocLineFilter", title:"Filter", width:250, xtype:"md_tx_acc_dc_AccDocLineCtx$Filter", collapsible:true, collapsed:true
			})
			.addDcFilterFormView("item", {name:"itemFilter", title:"Filter", width:250, xtype:"sc_invoice_dc_PurchaseInvoiceItem$FilterCtx", collapsible:true, collapsed:true
			})
			.addDcGridView("item", {name:"itemList", xtype:"sc_invoice_dc_PurchaseInvoiceItem$CtxList"})
			.addDcFormView("item", {name:"itemEdit", xtype:"sc_invoice_dc_PurchaseInvoiceItem$EditForm"})
			.addDcGridView("itemTax", {name:"itemTaxList", title:"Item taxes", width:400, xtype:"sc_invoice_dc_PurchaseInvoiceItemTax$CtxList", collapsible:true, collapsed:true
			})
			.addDcGridView("note", {name:"noteList", width:300, xtype:"ad_data_dc_Note$List"})
			.addDcFormView("note", {name:"noteEdit", xtype:"ad_data_dc_Note$Edit"})
			.addDcEditGridView("atch", {name:"atchEditList", title:"Attachments", xtype:"ad_data_dc_Attachment$CtxEditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnViewAttachment"), this._elems_.get("btnUploadAttachment")]}]})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"invDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"accDocPanel", title:"Accounting", layout:"border", defaults:{split:true}})
			.addPanel({name:"linesPanel", title:"Items", layout:"border", defaults:{split:true}})
			.addPanel({name:"notesPanel", title:"Notes", layout:"border", defaults:{split:true}})
			.addPanel({name:"itemsPanel", layout:"card", activeItem:0})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["invFilter", "invList"], ["north", "center"])
			.addChildrenTo("canvas2", ["invEditMain", "invDetailsTab"], ["north", "center"])
			.addChildrenTo("invDetailsTab", ["invEditDetails", "linesPanel", "taxList", "amountList", "accDocPanel", "atchEditList", "notesPanel"])
			.addChildrenTo("accDocPanel", ["accDocLineFilter", "accDocLineList"], ["west", "center"])
			.addChildrenTo("linesPanel", ["itemFilter", "itemsPanel", "itemTaxList"], ["west", "center", "east"])
			.addChildrenTo("notesPanel", ["noteList", "noteEdit"], ["west", "center"])
			.addChildrenTo("itemsPanel", ["itemList", "itemEdit"])
			.addToolbarTo("canvas1", "tlbInvList")
			.addToolbarTo("canvas2", "tlbInvEdit")
			.addToolbarTo("taxList", "tlbTaxList")
			.addToolbarTo("accDocLineList", "tlbAccDocLineList")
			.addToolbarTo("itemList", "tlbItemList")
			.addToolbarTo("itemEdit", "tlbItemEdit")
			.addToolbarTo("itemTaxList", "tlbItemTaxList")
			.addToolbarTo("amountList", "tlbAmountList")
			.addToolbarTo("atchEditList", "tlbAtchList")
			.addToolbarTo("noteList", "tlbNoteList")
			.addToolbarTo("noteEdit", "tlbNoteEdit")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvList", {dc: "inv"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Purchase invoices"})
			.end()
			.beginToolbar("tlbInvEdit", {dc: "inv"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Purchase invoice"})
			.end()
			.beginToolbar("tlbTaxList", {dc: "tax"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Taxes"})
			.end()
			.beginToolbar("tlbAccDocLineList", {dc: "accDocLine"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounting"})
			.end()
			.beginToolbar("tlbItemList", {dc: "item"}).addQuery(
			).addEdit(
			{inContainer:"itemsPanel",showView:"itemEdit"}
			).addNew(
			).addCopy(
			).addDeleteSelected(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Items"})
			.end()
			.beginToolbar("tlbItemEdit", {dc: "item"}).addBack(
			{inContainer:"itemsPanel",showView:"itemList"}
			).addSave(
			).addNew(
			).addCopy(
			).addCancel(
			).addPrevRec(
			).addNextRec(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Item"})
			.end()
			.beginToolbar("tlbItemTaxList", {dc: "itemTax"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Item taxes"})
			.end()
			.beginToolbar("tlbAmountList", {dc: "amount"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Payment schedule"})
			.end()
			.beginToolbar("tlbAtchList", {dc: "atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Attachments"})
			.end()
			.beginToolbar("tlbNoteList", {dc: "note"}).addQuery()
			.addSeparator().addAutoLoad().addReports()
			.end()
			.beginToolbar("tlbNoteEdit", {dc: "note"}).addSave().addNew().addCancel()
			.addSeparator().addAutoLoad().addReports()
			.end()
	}

	,onBtnConfirmInvoice: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("inv").doService("confirm", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	,onBtnUnConfirmInvoice: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("inv").doService("unConfirm", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	,onBtnPostInvoice: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("inv").doService("post", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	,onBtnUnPostInvoice: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("inv").doService("unPost", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	,onUploadSuccess: function() {	
		this._getDc_("atch").doQuery();
	}
	,onBtnUploadAttachment: function() {
		var w=new dnet.core.base.FileUploadWindow({
		    		_nameFieldValue_: this._getDc_("atch").getRecord().get("name"),
		    		_p1Value_: this._getDc_("atch").getRecord().get("id"),
		    		_uploadUrl_:"/nan21.dnet.core.web/upload/adDataAttachment",
		    		_succesCallbackFn_ : this.onUploadSuccess,
		    		_succesCallbackScope_: this
		    	});w.show();
	}
	,onBtnViewAttachment: function() {
		
				var url = this._getDc_("atch").getRecord().get("url");
				window.open(url, "Attachment", "location=1,status=1,scrollbars=1,width=500,height=400");
	}
	,onAfterDefineDcs: function() {
		
				this._getDc_("item").on("afterDoSaveSuccess", 
				function() {
					this._getDc_("inv").doRefreshCurrent();
				} , this );
				
				this._getDc_("inv").on("afterDoServiceSuccess", 
				function() { this._applyStateAllButtons_(); this._syncReadOnlyStates_();  } , this );
				
				this._getDc_("inv").on("recordChange", this._syncReadOnlyStates_, this );
	}
	,_syncReadOnlyStates_: function() {
		
				var invRec = this._getDc_("inv").getRecord();
				if (!invRec) { return; }
				var itemsDc = this._getDc_("item");
				if (invRec.get("confirmed")) {
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
