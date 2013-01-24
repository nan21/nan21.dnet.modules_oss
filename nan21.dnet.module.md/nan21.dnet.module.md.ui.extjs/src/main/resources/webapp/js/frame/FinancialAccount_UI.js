/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.org.frame.FinancialAccount_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.org.frame.FinancialAccount_UI",
	_name_: "net.nan21.dnet.module.md.org.frame.FinancialAccount_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("account", new net.nan21.dnet.module.md.org.dc.FinancialAccount({}))
			.addDc("acct", new net.nan21.dnet.module.md.org.dc.FinancialAccountAcct({multiEdit:true}))
			.addDc("paymethod", new net.nan21.dnet.module.md.org.dc.FinancialAccountMethod({multiEdit:true}))
	
			.linkDc("acct", "account",{fields:[
				{childField:"financialAccountId", parentField:"id"}]}
			)
			.linkDc("paymethod", "account",{fields:[
				{childField:"financialAccountId", parentField:"id"}, {childField:"financialAccountType", parentField:"type"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("account", {name:"accountFilter", height:120, xtype:"md_org_dc_FinancialAccount$Filter"})
			.addDcGridView("account", {name:"accountList", xtype:"md_org_dc_FinancialAccount$List"})
			.addDcFormView("account", {name:"accountEdit", height:140, xtype:"md_org_dc_FinancialAccount$Edit"})
			.addDcEditGridView("acct", {name:"acctEditList", title:"Accounting", xtype:"md_org_dc_FinancialAccountAcct$CtxEditList", frame:true})
			.addDcEditGridView("paymethod", {name:"paymethodEditList", title:"Payment methods", xtype:"md_org_dc_FinancialAccountMethod$CtxEditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"detailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["accountFilter", "accountList"], ["north", "center"])
			.addChildrenTo("canvas2", ["accountEdit", "detailsTab"], ["north", "center"])
			.addChildrenTo("detailsTab", ["paymethodEditList", "acctEditList"])
			.addToolbarTo("canvas1", "tlbAccountList")
			.addToolbarTo("canvas2", "tlbAccountEdit")
			.addToolbarTo("acctEditList", "tlbAcctEditList")
			.addToolbarTo("paymethodEditList", "tlbPaymethodEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAccountList", {dc: "account"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Financial accounts"})
			.end()
			.beginToolbar("tlbAccountEdit", {dc: "account"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Financial account"})
			.end()
			.beginToolbar("tlbAcctEditList", {dc: "acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounting"})
			.end()
			.beginToolbar("tlbPaymethodEditList", {dc: "paymethod"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Payment methods"})
			.end()
			;
	}

});
