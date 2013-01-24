/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.mm.prod.frame.Product_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.frame.Product_UI",
	_name_: "net.nan21.dnet.module.md.mm.prod.frame.Product_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("prod", new net.nan21.dnet.module.md.mm.prod.dc.Product({}))
			.addDc("account", new net.nan21.dnet.module.md.mm.prod.dc.ProductAccount({multiEdit:true}))
			.addDc("acct", new net.nan21.dnet.module.md.mm.prod.dc.ProductAccountAcct({multiEdit:true}))
			.addDc("attr", new net.nan21.dnet.module.md.mm.prod.dc.ProductAttributeValue({multiEdit:true}))
			.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))
			.addDc("classific", new net.nan21.dnet.module.md.mm.prod.dc.ProdClassification({multiEdit:true}))
			.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
			.addDc("stock", new net.nan21.dnet.module.md.tx.inventory.dc.InvBalance({}))
	
			.linkDc("account", "prod",{fields:[
				{childField:"productId", parentField:"id"}]}
			)
			.linkDc("acct", "account",{fields:[
				{childField:"prodAccountId", parentField:"id"}]}
			)
			.linkDc("attr", "prod",{fields:[
				{childField:"productId", parentField:"id"}]}
			)
			.linkDc("atch", "prod",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"entityFQN"}]}
			)
			.linkDc("classific", "prod",{fields:[
				{childField:"productId", parentField:"id"}]}
			)
			.linkDc("note", "prod",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"className"}]}
			)
			.linkDc("stock", "prod",{fields:[
				{childField:"itemId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnViewAttachment", text:"View", tooltip:"View the selected attachment", iconCls:"icon-action-view", disabled:true,
					handler: this.onBtnViewAttachment, scope:this, stateManager:{name:"selected_one", dc:"atch" }})
			.addButton({name:"btnUploadAttachment", text:"Upload...", tooltip:"Upload attachment file.", disabled:true,
					handler: this.onBtnUploadAttachment, scope:this, stateManager:{name:"selected_one_clean", dc:"atch" }})
			.addButton({name:"btnAsgnCategories", text:"Assign categories", tooltip:"Add product to categories", disabled:true,
					handler: this.onBtnAsgnCategories, scope:this, stateManager:{name:"record_is_clean", dc:"prod" }})
			
			.addDcFilterFormView("prod", {name:"prodFilter", xtype:"md_mm_prod_dc_Product$Filter"})
			.addDcGridView("prod", {name:"prodList", xtype:"md_mm_prod_dc_Product$List"})
			.addDcFormView("prod", {name:"prodEdit", xtype:"md_mm_prod_dc_Product$Edit", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnAsgnCategories")]}]})
			.addDcFormView("prod", {name:"prodEditInfo", title:"Details", xtype:"md_mm_prod_dc_Product$EditInfo"})
			.addDcFormView("prod", {name:"prodCtxFormName", height:50, xtype:"md_mm_prod_dc_Product$CtxFormName"})
			.addDcEditGridView("account", {name:"accountEditList", width:600, xtype:"md_mm_prod_dc_ProductAccount$CtxEditList", frame:true})
			.addDcEditGridView("acct", {name:"acctEditList", xtype:"md_mm_prod_dc_ProductAccountAcct$CtxEditList", frame:true})
			.addDcFilterFormView("attr", {name:"attrFilter", title:"Filter", width:250, xtype:"md_mm_prod_dc_ProductAttributeValue$FilterCtx", collapsible:true
			})
			.addDcEditGridView("attr", {name:"attrEditList", xtype:"md_mm_prod_dc_ProductAttributeValue$CtxEditList", frame:true})
			.addDcGridView("stock", {name:"stockList", xtype:"md_tx_inventory_dc_InvBalance$CtxListProduct"})
			.addDcFilterFormView("stock", {name:"stockFilter", title:"Filter", width:250, xtype:"md_tx_inventory_dc_InvBalance$CtxFilterProduct", collapsible:true
			})
			.addDcEditGridView("atch", {name:"atchEditList", title:"Attachments", xtype:"ad_data_dc_Attachment$CtxEditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnViewAttachment"), this._elems_.get("btnUploadAttachment")]}]})
			.addDcEditGridView("classific", {name:"classificEdit", title:"Classifications", xtype:"md_mm_prod_dc_ProdClassification$CtxEditList", frame:true})
			.addDcGridView("note", {name:"noteList", width:550, xtype:"ad_data_dc_Note$List"})
			.addDcFormView("note", {name:"noteEdit", xtype:"ad_data_dc_Note$Edit"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}, onActivateDoLayoutFor:["prodDetailsTab"]})
			.addPanel({name:"prodDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"attrPanel", title:"Attributes", layout:"border", defaults:{split:true}})
			.addPanel({name:"stockPanel", title:"Stocks", layout:"border", defaults:{split:true}})
			.addPanel({name:"notesPanel", title:"Notes", layout:"border", defaults:{split:true}})
			.addPanel({name:"accountsPanel", title:"Accounts", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["prodFilter", "prodList", "prodCtxFormName"], ["north", "center", "south"])
			.addChildrenTo("canvas2", ["prodEdit", "prodDetailsTab"], ["north", "center"])
			.addChildrenTo("prodDetailsTab", ["prodEditInfo", "attrPanel", "accountsPanel", "classificEdit", "atchEditList", "notesPanel", "stockPanel"])
			.addChildrenTo("attrPanel", ["attrFilter", "attrEditList"], ["west", "center"])
			.addChildrenTo("stockPanel", ["stockFilter", "stockList"], ["west", "center"])
			.addChildrenTo("notesPanel", ["noteList", "noteEdit"], ["west", "center"])
			.addChildrenTo("accountsPanel", ["accountEditList", "acctEditList"], ["west", "center"])
			.addToolbarTo("canvas1", "tlbProdList")
			.addToolbarTo("canvas2", "tlbProdEdit")
			.addToolbarTo("accountEditList", "tlbAccountEditList")
			.addToolbarTo("acctEditList", "tlbAcctEditList")
			.addToolbarTo("attrPanel", "tlbAttrEditList")
			.addToolbarTo("atchEditList", "tlbAtchList")
			.addToolbarTo("classificEdit", "tlbClassific")
			.addToolbarTo("noteList", "tlbNoteList")
			.addToolbarTo("noteEdit", "tlbNoteEdit")
			.addToolbarTo("stockList", "tlbStockList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProdList", {dc: "prod"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Products"})
			.end()
			.beginToolbar("tlbProdEdit", {dc: "prod"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Product"})
			.end()
			.beginToolbar("tlbAccountEditList", {dc: "account"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounts"})
			.end()
			.beginToolbar("tlbAcctEditList", {dc: "acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounting"})
			.end()
			.beginToolbar("tlbAttrEditList", {dc: "attr"}).addQuery().addSave().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Attributes"})
			.end()
			.beginToolbar("tlbAtchList", {dc: "atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Attachments"})
			.end()
			.beginToolbar("tlbClassific", {dc: "classific"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Classifications"})
			.end()
			.beginToolbar("tlbNoteList", {dc: "note"}).addQuery()
			.addSeparator().addAutoLoad().addReports()
			.end()
			.beginToolbar("tlbNoteEdit", {dc: "note"}).addSave().addNew().addCancel()
			.addSeparator().addAutoLoad().addReports()
			.end()
			.beginToolbar("tlbStockList", {dc: "stock"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Stocks"})
			.end()
			;
	}

	
	,onBtnAsgnCategories: function() {
		this.showAsgnWindow(net.nan21.dnet.module.md.mm.prod.asgn.CategoriesOfProduct$Ui ,{dc: "prod", objectIdField: "id"});
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
});
