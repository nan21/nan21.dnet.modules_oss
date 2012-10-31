/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs", "nan21.dnet.module.md.ui.extjs/ds/PaymentMethodLovDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment", "nan21.dnet.module.md.ui.extjs/dc/BpClassification", "nan21.dnet.module.md.ui.extjs/dc/BpAccount", "nan21.dnet.module.bd.ui.extjs/dc/CommunicationChannel", "nan21.dnet.module.md.ui.extjs/ds/BpAccountDs", "nan21.dnet.module.md.ui.extjs/ds/CompanyLegalFormLovDs", "nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs", "nan21.dnet.module.md.ui.extjs/lov/AccSchemas", "nan21.dnet.module.bd.ui.extjs/lov/Countries", "nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes", "nan21.dnet.module.md.ui.extjs/ds/BpAccountAcctDs", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelDs", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs", "nan21.dnet.module.md.ui.extjs/ds/AccountLovDs", "nan21.dnet.module.md.ui.extjs/ds/PaymentTermLovDs", "nan21.dnet.module.md.ui.extjs/ds/BankLovDs", "nan21.dnet.module.md.ui.extjs/lov/Banks", "nan21.dnet.module.md.ui.extjs/dc/BpBankAccount", "nan21.dnet.module.md.ui.extjs/ds/CustomerGroupLovDs", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs", "nan21.dnet.module.md.ui.extjs/lov/PaymentTerm", "nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerDs", "nan21.dnet.module.bd.ui.extjs/lov/ClassificationItems", "nan21.dnet.module.bd.ui.extjs/ds/ClassificationItemLovDs", "nan21.dnet.module.md.ui.extjs/ds/ContactDs", "nan21.dnet.module.bd.ui.extjs/lov/CommunicationChannelTypes", "nan21.dnet.module.bd.ui.extjs/lov/ClassificationSystems", "nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs", "nan21.dnet.module.md.ui.extjs/lov/Accounts", "nan21.dnet.module.md.ui.extjs/ds/BpClassificationDs", "nan21.dnet.module.md.ui.extjs/dc/BusinessPartner", "nan21.dnet.module.bd.ui.extjs/ds/RegionLovDs", "nan21.dnet.module.bd.ui.extjs/lov/Currencies", "nan21.dnet.module.md.ui.extjs/ds/BpBankAccountDs", "nan21.dnet.module.bd.ui.extjs/lov/Regions", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.md.ui.extjs/dc/Contact", "nan21.dnet.module.md.ui.extjs/lov/CompanyLegalForms", "nan21.dnet.module.bd.ui.extjs/dc/Location", "nan21.dnet.module.bd.ui.extjs/ds/CommunicationChannelTypeLovDs", "nan21.dnet.module.bd.ui.extjs/ds/ClassificationSystemLovDs", "nan21.dnet.module.md.ui.extjs/ds/VendorGroupLovDs", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.md.ui.extjs/lov/VendorGroup", "nan21.dnet.module.md.ui.extjs/lov/CustomerGroup", "nan21.dnet.module.bd.ui.extjs/ds/LocationDs", "nan21.dnet.module.md.ui.extjs/ds/TxBalanceDs", "nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations", "nan21.dnet.module.md.ui.extjs/dc/TxBalance", "nan21.dnet.module.md.ui.extjs/dc/BpAccountAcct", "nan21.dnet.module.md.ui.extjs/lov/PaymentMethod"]);

Ext.define("net.nan21.dnet.module.md.bp.frame.BPartner_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.bp.frame.BPartner_UI",
	_name_: "net.nan21.dnet.module.md.bp.frame.BPartner_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("bp", new net.nan21.dnet.module.md.bp.dc.BusinessPartner({}))
			.addDc("balance", new net.nan21.dnet.module.md.tx.fin.dc.TxBalance({}))
			.addDc("account", new net.nan21.dnet.module.md.bp.dc.BpAccount({}))
			.addDc("acct", new net.nan21.dnet.module.md.bp.dc.BpAccountAcct({multiEdit:true}))
			.addDc("bpContact", new net.nan21.dnet.module.md.bp.dc.Contact({multiEdit:true}))
			.addDc("address", new net.nan21.dnet.module.bd.geo.dc.Location({}))
			.addDc("classific", new net.nan21.dnet.module.md.bp.dc.BpClassification({multiEdit:true}))
			.addDc("bpBankAcct", new net.nan21.dnet.module.md.bp.dc.BpBankAccount({multiEdit:true}))
			.addDc("bpPhone", new net.nan21.dnet.module.bd.contact.dc.CommunicationChannel({multiEdit:true}))
			.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
			.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))
	
			.linkDc("balance", "bp",{fields:[
				{childField:"businessPartnerId", parentField:"id"}]}
			)
			.linkDc("account", "bp",{fields:[
				{childField:"businessPartnerId", parentField:"id"}]}
			)
			.linkDc("acct", "account",{fields:[
				{childField:"bpAccountId", parentField:"id"}]}
			)
			.linkDc("bpContact", "bp",{fields:[
				{childField:"bpartnerId", parentField:"id"}]}
			)
			.linkDc("address", "bp",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"className"}]}
			)
			.linkDc("classific", "bp",{fields:[
				{childField:"businessPartnerId", parentField:"id"}, {childField:"businessPartnerBO", parentField:"businessObject"}]}
			)
			.linkDc("bpBankAcct", "bp",{fields:[
				{childField:"bpartnerId", parentField:"id"}]}
			)
			.linkDc("bpPhone", "bp",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"className"}]}
			)
			.linkDc("note", "bp",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"className"}]}
			)
			.linkDc("atch", "bp",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"businessObject"}]}
			)
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnCreateBpContinue", text:"Continue", tooltip:"Continue", disabled:false,
					handler: this.onBtnCreateBpContinue, scope:this})
			.addButton({name:"btnViewAttachment", text:"View", tooltip:"View the selected attachment", iconCls:"icon-action-view", disabled:true,
					handler: this.onBtnViewAttachment, scope:this, stateManager:{name:"selected_one", dc:"atch" }})
			.addButton({name:"btnUploadAttachment", text:"Upload...", tooltip:"Upload attachment file.", disabled:true,
					handler: this.onBtnUploadAttachment, scope:this, stateManager:{name:"selected_one_clean", dc:"atch" }})
			.addButton({name:"btnShowAccounts", text:"Accounting", tooltip:"Accounting", disabled:false,
					handler: this.onBtnShowAccounts, scope:this})
			
			.addDcFilterFormView("bp", {name:"bpFilter", xtype:"md_bp_dc_BusinessPartner$Filter"})
			.addDcGridView("bp", {name:"bpList", xtype:"md_bp_dc_BusinessPartner$List"})
			.addDcFormView("bp", {name:"bpCreate", xtype:"md_bp_dc_BusinessPartner$Create"})
			.addDcFormView("bp", {name:"bpEdit", height:160, xtype:"md_bp_dc_BusinessPartner$Edit"})
			.addDcGridView("account", {name:"accountList", xtype:"md_bp_dc_BpAccount$List"})
			.addDcFormView("account", {name:"accountEdit", xtype:"md_bp_dc_BpAccount$EditCtx", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnShowAccounts")]}]})
			.addDcEditGridView("acct", {name:"acctEditList", xtype:"md_bp_dc_BpAccountAcct$EditList", frame:true})
			.addDcGridView("balance", {name:"balanceList", title:"Balance", xtype:"md_tx_fin_dc_TxBalance$CtxList"})
			.addDcEditGridView("bpContact", {name:"bpContactEditList", title:"Contact", xtype:"md_bp_dc_Contact$CtxEditList", frame:true})
			.addDcGridView("address", {name:"addressList", xtype:"bd_geo_dc_Location$ListCtx"})
			.addDcFormView("address", {name:"addressEdit", xtype:"bd_geo_dc_Location$EditCtx"})
			.addDcEditGridView("bpBankAcct", {name:"bpBankAccountEditList", title:"Bank account", xtype:"md_bp_dc_BpBankAccount$CtxEditList", frame:true})
			.addDcEditGridView("bpPhone", {name:"bpPhoneEditList", title:"Communication", xtype:"bd_contact_dc_CommunicationChannel$EditList", frame:true})
			.addDcEditGridView("classific", {name:"classificEdit", title:"Classifications", xtype:"md_bp_dc_BpClassification$CtxEditList", frame:true})
			.addDcGridView("note", {name:"noteList", width:300, xtype:"ad_data_dc_Note$List"})
			.addDcFormView("note", {name:"noteEdit", xtype:"ad_data_dc_Note$Edit"})
			.addDcEditGridView("atch", {name:"atchEditList", title:"Attachments", xtype:"ad_data_dc_Attachment$CtxEditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnViewAttachment"), this._elems_.get("btnUploadAttachment")]}]})
			.addWindow({name:"wdwBpCreate", title:"Select type", closeAction:'hide', resizable:true, layout:"fit", modal:true,
				items:[this._elems_.get("bpCreate")], 
						dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
							items:[ this._elems_.get("btnCreateBpContinue")]}]})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}, onActivateDoLayoutFor:["bpEdit", "bpDetailsTab"]})
			.addPanel({name:"bpDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"notesPanel", title:"Notes", layout:"border", defaults:{split:true}})
			.addPanel({name:"addressPanel", title:"Address", layout:"card", activeItem:0})
			.addPanel({name:"addressEditWrapper", layout:"fit"})
			.addPanel({name:"accountPanel", title:"Account", layout:"card", activeItem:0})
			.addPanel({name:"accountEditWrapper", layout:"fit"})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["bpFilter", "bpList"], ["north", "center"])
			.addChildrenTo("canvas2", ["bpEdit", "bpDetailsTab"], ["north", "center"])
			.addChildrenTo("bpDetailsTab", ["accountPanel", "bpPhoneEditList", "addressPanel", "bpContactEditList", "bpBankAccountEditList", "classificEdit", "balanceList", "atchEditList", "notesPanel"])
			.addChildrenTo("notesPanel", ["noteList", "noteEdit"], ["west", "center"])
			.addChildrenTo("addressPanel", ["addressList", "addressEditWrapper"])
			.addChildrenTo("addressEditWrapper", ["addressEdit"])
			.addChildrenTo("accountPanel", ["accountList", "accountEditWrapper", "acctEditList"])
			.addChildrenTo("accountEditWrapper", ["accountEdit"])
			.addToolbarTo("canvas1", "tlbBpList")
			.addToolbarTo("canvas2", "tlbBpEdit")
			.addToolbarTo("accountList", "tlbAccountList")
			.addToolbarTo("accountEditWrapper", "tlbAccountEdit")
			.addToolbarTo("acctEditList", "tlbAcctList")
			.addToolbarTo("bpContactEditList", "tlbBpContactList")
			.addToolbarTo("addressList", "tlbAddressList")
			.addToolbarTo("addressEditWrapper", "tlbAddressEdit")
			.addToolbarTo("bpBankAccountEditList", "tlbBpBankAccountList")
			.addToolbarTo("bpPhoneEditList", "tlbBpPhoneNumber")
			.addToolbarTo("classificEdit", "tlbClassific")
			.addToolbarTo("atchEditList", "tlbAtchList")
			.addToolbarTo("balanceList", "tlbBalanceList")
			.addToolbarTo("noteList", "tlbNoteList")
			.addToolbarTo("noteEdit", "tlbNoteEdit")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbBpList", {dc: "bp"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Business partners"})
			.end()
			.beginToolbar("tlbBpEdit", {dc: "bp"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Business partner"})
			.end()
			.beginToolbar("tlbAccountList", {dc: "account"}).addQuery(
			).addEdit(
			{inContainer:"accountPanel",showView:"accountEditWrapper"}
			).addNew(
			).addCopy(
			).addDeleteSelected(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounts"})
			.end()
			.beginToolbar("tlbAccountEdit", {dc: "account"}).addBack(
			{inContainer:"accountPanel",showView:"accountList"}
			).addSave(
			).addNew(
			).addCopy(
			).addCancel(
			).addPrevRec(
			).addNextRec(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Account"})
			.end()
			.beginToolbar("tlbAcctList", {dc: "acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addBack({inContainer:"accountPanel",showView:"accountEditWrapper"})
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounting"})
			.end()
			.beginToolbar("tlbBpContactList", {dc: "bpContact"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Contact"})
			.end()
			.beginToolbar("tlbAddressList", {dc: "address"}).addQuery(
			).addEdit(
			{inContainer:"addressPanel",showView:"addressEditWrapper"}
			).addNew(
			).addCopy(
			).addDeleteSelected(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Addresses"})
			.end()
			.beginToolbar("tlbAddressEdit", {dc: "address"}).addBack(
			{inContainer:"addressPanel",showView:"addressList"}
			).addSave(
			).addNew(
			).addCopy(
			).addCancel(
			).addPrevRec(
			).addNextRec(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Address"})
			.end()
			.beginToolbar("tlbBpBankAccountList", {dc: "bpBankAcct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Bank account"})
			.end()
			.beginToolbar("tlbBpPhoneNumber", {dc: "bpPhone"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Communication"})
			.end()
			.beginToolbar("tlbClassific", {dc: "classific"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Classifications"})
			.end()
			.beginToolbar("tlbAtchList", {dc: "atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Attachments"})
			.end()
			.beginToolbar("tlbBalanceList", {dc: "balance"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Balance"})
			.end()
			.beginToolbar("tlbNoteList", {dc: "note"}).addQuery()
			.addSeparator().addAutoLoad().addReports()
			.end()
			.beginToolbar("tlbNoteEdit", {dc: "note"}).addSave().addNew().addCancel()
			.addSeparator().addAutoLoad().addReports()
			.end()
	}

	,onBtnCreateBpContinue: function() {
		this._getWindow_("wdwBpCreate").close();
	}
	,onBtnShowAccounts: function() {
	}
	,onUploadSuccess: function() {	
		this._getDc_("atch").doQuery();
	}
	,_whenCreateNewBp_: function() {	
		this._getWindow_("wdwBpCreate").show();
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
	,_afterDefineDcs_: function() {
		this._getDc_("bp").on("afterDoNew", this._whenCreateNewBp_, this);
	}
	,_selectBpEditorForm_: function() {
		this._getElement_("bpEdit").onRecordChange();
	}
	,onBtnViewAttachment: function() {
		
				var url = this._getDc_("atch").getRecord().get("url");
				window.open(url, "Attachment", "location=1,status=1,scrollbars=1,width=500,height=400");
	}
	,onBtnShowAccounts: function() {
		this._showStackedViewElement_("accountPanel", "acctEditList")
	}
});
