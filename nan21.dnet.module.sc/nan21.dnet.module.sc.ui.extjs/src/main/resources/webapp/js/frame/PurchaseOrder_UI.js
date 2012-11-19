/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/ds/TxDocTypePOLovDs", "nan21.dnet.module.bd.ui.extjs/lov/WarehouseOrganizations", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs", "nan21.dnet.module.md.ui.extjs/lov/PaymentTerm", "nan21.dnet.module.md.ui.extjs/ds/ProductLovDs", "nan21.dnet.module.md.ui.extjs/ds/PaymentMethodLovDs", "nan21.dnet.module.ad.ui.extjs/dc/Attachment", "nan21.dnet.module.bd.ui.extjs/ds/UomLovDs", "nan21.dnet.module.md.ui.extjs/ds/PaymentMethodOutLovDs", "nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName", "nan21.dnet.module.md.ui.extjs/lov/TxDocTypesPO", "nan21.dnet.module.md.ui.extjs/lov/Products", "nan21.dnet.module.bd.ui.extjs/ds/WarehouseOrganizationLovDs", "nan21.dnet.module.md.ui.extjs/ds/TaxApplicableLovDs", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseOrderItemTaxDs", "nan21.dnet.module.md.ui.extjs/ds/DeliveryMethodLovDs", "nan21.dnet.module.bd.ui.extjs/lov/Currencies", "nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs", "nan21.dnet.module.md.ui.extjs/ds/VendorLovDs", "nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes", "nan21.dnet.module.ad.ui.extjs/ds/NoteDs", "nan21.dnet.module.md.ui.extjs/lov/PriceListPurchase", "nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseOrderItemDs", "nan21.dnet.module.md.ui.extjs/lov/DeliveryMethods", "nan21.dnet.module.md.ui.extjs/lov/ProductsWithUom", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs", "nan21.dnet.module.ad.ui.extjs/dc/Note", "nan21.dnet.module.ad.ui.extjs/ds/AttachmentDs", "nan21.dnet.module.md.ui.extjs/ds/PaymentTermLovDs", "nan21.dnet.module.md.ui.extjs/lov/VendorsName", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseOrderItemTax", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseOrderItem", "nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs", "nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations", "nan21.dnet.module.md.ui.extjs/ds/PriceListPurchaseLovDs", "nan21.dnet.module.md.ui.extjs/lov/PaymentMethod", "nan21.dnet.module.md.ui.extjs/lov/TaxApplicables", "nan21.dnet.module.sc.ui.extjs/ds/PurchaseOrderDs", "nan21.dnet.module.md.ui.extjs/lov/PaymentMethodOut", "nan21.dnet.module.md.ui.extjs/ds/ProductWithUomLovDs", "nan21.dnet.module.sc.ui.extjs/dc/PurchaseOrder"]);

Ext.define("net.nan21.dnet.module.sc.order.frame.PurchaseOrder_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.sc.order.frame.PurchaseOrder_UI",
	_name_: "net.nan21.dnet.module.sc.order.frame.PurchaseOrder_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("order", new net.nan21.dnet.module.sc.order.dc.PurchaseOrder({}))
			.addDc("item", new net.nan21.dnet.module.sc.order.dc.PurchaseOrderItem({}))
			.addDc("itemTax", new net.nan21.dnet.module.sc.order.dc.PurchaseOrderItemTax({}))
			.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
			.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))
	
			.linkDc("item", "order",{fields:[
				{childField:"purchaseOrderId", parentField:"id"}]}
			)
			.linkDc("itemTax", "item",{fields:[
				{childField:"purchaseOrderItemId", parentField:"id"}]}
			)
			.linkDc("note", "order",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"className"}]}
			)
			.linkDc("atch", "order",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"entityFQN"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnViewAttachment", text:"View", tooltip:"View the selected attachment", iconCls:"icon-action-view", disabled:true,
					handler: this.onBtnViewAttachment, scope:this, stateManager:{name:"selected_one", dc:"atch" }})
			.addButton({name:"btnUploadAttachment", text:"Upload...", tooltip:"Upload attachment file.", disabled:true,
					handler: this.onBtnUploadAttachment, scope:this, stateManager:{name:"selected_one_clean", dc:"atch" }})
			.addButton({name:"btnConfirm", text:"Confirm", tooltip:"Confirm order.", iconCls:"icon-action-commit", disabled:true,
					handler: this.onBtnConfirm, scope:this, stateManager:{name:"selected_one_clean", dc:"order" , and: function(dc) {return (dc.record && !dc.record.get("confirmed"));}}})
			.addButton({name:"btnUnConfirm", text:"Un-Confirm", tooltip:"Un-Confirm order.", iconCls:"icon-action-rollback", disabled:true,
					handler: this.onBtnUnConfirm, scope:this, stateManager:{name:"selected_one_clean", dc:"order" , and: function(dc) {return (dc.record && dc.record.get("confirmed") );}}})
			
			.addDcFilterFormView("order", {name:"orderFilter", height:160, xtype:"sc_order_dc_PurchaseOrder$Filter"})
			.addDcGridView("order", {name:"orderList", xtype:"sc_order_dc_PurchaseOrder$List"})
			.addDcFormView("order", {name:"orderEdit", height:200, xtype:"sc_order_dc_PurchaseOrder$EditMain", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnConfirm"), this._elems_.get("btnUnConfirm")]}]})
			.addDcFormView("order", {name:"orderEditDetails", title:"Details", xtype:"sc_order_dc_PurchaseOrder$EditDetails"})
			.addDcFilterFormView("item", {name:"itemFilter", title:"Filter", width:250, xtype:"sc_order_dc_PurchaseOrderItem$FilterCtx", collapsible:true, collapsed:true
			})
			.addDcGridView("item", {name:"itemList", xtype:"sc_order_dc_PurchaseOrderItem$CtxList"})
			.addDcFormView("item", {name:"itemEdit", xtype:"sc_order_dc_PurchaseOrderItem$EditForm"})
			.addDcGridView("itemTax", {name:"itemTaxList", title:"Item taxes", width:400, xtype:"sc_order_dc_PurchaseOrderItemTax$CtxList", collapsible:true, collapsed:true
			})
			.addDcGridView("note", {name:"noteList", width:550, xtype:"ad_data_dc_Note$List"})
			.addDcFormView("note", {name:"noteEdit", xtype:"ad_data_dc_Note$Edit"})
			.addDcEditGridView("atch", {name:"atchEditList", title:"Attachments", xtype:"ad_data_dc_Attachment$CtxEditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnViewAttachment"), this._elems_.get("btnUploadAttachment")]}]})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"orderDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"notesPanel", title:"Notes", layout:"border", defaults:{split:true}})
			.addPanel({name:"linesPanel", title:"Items", layout:"border", defaults:{split:true}})
			.addPanel({name:"itemsPanel", layout:"card", activeItem:0})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["orderFilter", "orderList"], ["north", "center"])
			.addChildrenTo("canvas2", ["orderEdit", "orderDetailsTab"], ["north", "center"])
			.addChildrenTo("orderDetailsTab", ["orderEditDetails", "linesPanel", "atchEditList", "notesPanel"])
			.addChildrenTo("notesPanel", ["noteList", "noteEdit"], ["west", "center"])
			.addChildrenTo("linesPanel", ["itemFilter", "itemsPanel", "itemTaxList"], ["west", "center", "east"])
			.addChildrenTo("itemsPanel", ["itemList", "itemEdit"])
			.addToolbarTo("canvas1", "tlbOrderList")
			.addToolbarTo("canvas2", "tlbOrderEdit")
			.addToolbarTo("itemList", "tlbItemList")
			.addToolbarTo("itemEdit", "tlbItemEdit")
			.addToolbarTo("itemTaxList", "tlbItemTaxList")
			.addToolbarTo("atchEditList", "tlbAtchList")
			.addToolbarTo("noteList", "tlbNoteList")
			.addToolbarTo("noteEdit", "tlbNoteEdit")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOrderList", {dc: "order"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Purchase orders"})
			.end()
			.beginToolbar("tlbOrderEdit", {dc: "order"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Purchase order"})
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
			.beginToolbar("tlbAtchList", {dc: "atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Attachments"})
			.end()
			.beginToolbar("tlbNoteList", {dc: "note"}).addQuery()
			.addSeparator().addAutoLoad().addReports()
			.end()
			.beginToolbar("tlbNoteEdit", {dc: "note"}).addSave().addNew().addCancel()
			.addSeparator().addAutoLoad().addReports()
			.end()
			;
	}

	
	,onBtnConfirm: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("order").doService("confirm", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onBtnUnConfirm: function() {
		var s={modal:true, callbacks:{} };
		try{
			this._getDc_("order").doService("unConfirm", s);
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
					this._getDc_("order").doRefreshCurrent();
				} , this );
				
				this._getDc_("order").on("afterDoServiceSuccess", 
				function() { this._applyStateAllButtons_(); this._syncReadOnlyStates_();  } , this );
				
				this._getDc_("order").on("recordChange", this._syncReadOnlyStates_, this );
				
	}
	
	,_syncReadOnlyStates_: function() {
		
				var orderRec = this._getDc_("order").getRecord();
				if (!orderRec) { return; }
				var itemsDc = this._getDc_("item");
				if (orderRec.get("confirmed")) {
					if (!itemsDc.isReadOnly()) {
						itemsDc.setReadOnly(true);
					}
				} else {
					if (itemsDc.isReadOnly()) {
						itemsDc.setReadOnly(false);
					}
				}
	}
	
	,_when_called_to_edit_: function(params) {
		
		var order = this._getDc_("order");
		if (order.isDirty()) {
			this._alert_dirty_();
			return;
		}
		order.doClearQuery();
		order.setFilterValue("code", params.code );
		order.doQuery();
		this._showStackedViewElement_("main",1);
	}
	,_afterDefineDcs_: function() {
		this.onAfterDefineDcs();
	}
});
