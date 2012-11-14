/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs", "nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs", "nan21.dnet.module.fi.ui.extjs/dc/AssetAcct", "nan21.dnet.module.md.ui.extjs/ds/ProductLovDs", "nan21.dnet.module.fi.ui.extjs/ds/AssetCategoryLovDs", "nan21.dnet.module.md.ui.extjs/ds/AccountLovDs", "nan21.dnet.module.fi.ui.extjs/ds/AmortizationDs", "nan21.dnet.module.fi.ui.extjs/ds/AssetAcctDs", "nan21.dnet.module.md.ui.extjs/lov/Products", "nan21.dnet.module.md.ui.extjs/lov/Accounts", "nan21.dnet.module.fi.ui.extjs/lov/AssetCategories", "nan21.dnet.module.fi.ui.extjs/dc/Amortization", "nan21.dnet.module.fi.ui.extjs/ds/AssetDs", "nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations", "nan21.dnet.module.fi.ui.extjs/dc/Asset", "nan21.dnet.module.bd.ui.extjs/lov/Currencies", "nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs", "nan21.dnet.module.md.ui.extjs/lov/AccSchemas"]);

Ext.define("net.nan21.dnet.module.fi.asset.frame.Asset_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.fi.asset.frame.Asset_UI",
	_name_: "net.nan21.dnet.module.fi.asset.frame.Asset_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("asset", new net.nan21.dnet.module.fi.asset.dc.Asset({}))
			.addDc("amort", new net.nan21.dnet.module.fi.asset.dc.Amortization({multiEdit:true}))
			.addDc("acct", new net.nan21.dnet.module.fi.asset.dc.AssetAcct({multiEdit:true}))
	
			.linkDc("amort", "asset",{fields:[
				{childField:"assetId", parentField:"id"}]}
			)
			.linkDc("acct", "asset",{fields:[
				{childField:"assetId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnCreateAmortization", text:"Create amortization", tooltip:"Create amortization plan for current asset.", iconCls:"icon-action-commit", disabled:true,
					handler: this.onBtnCreateAmortization, scope:this, stateManager:{name:"selected_one_clean", dc:"asset" }})
			
			.addDcFilterFormView("asset", {name:"assetFilter", height:120, xtype:"fi_asset_dc_Asset$Filter"})
			.addDcGridView("asset", {name:"assetList", xtype:"fi_asset_dc_Asset$List"})
			.addDcFormView("asset", {name:"assetEdit", height:150, xtype:"fi_asset_dc_Asset$Edit", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnCreateAmortization")]}]})
			.addDcFormView("asset", {name:"assetEditDeprec", title:"Details", xtype:"fi_asset_dc_Asset$EditDeprec"})
			.addDcEditGridView("amort", {name:"amortEditList", title:"Amortizations", xtype:"fi_asset_dc_Amortization$EditListCtxAsset", frame:true})
			.addDcEditGridView("acct", {name:"acctEditList", title:"Accounting", xtype:"fi_asset_dc_AssetAcct$EditListCtx", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"detailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["assetFilter", "assetList"], ["north", "center"])
			.addChildrenTo("canvas2", ["assetEdit", "detailsTab"], ["north", "center"])
			.addChildrenTo("detailsTab", ["assetEditDeprec", "acctEditList", "amortEditList"])
			.addToolbarTo("canvas1", "tlbAssetList")
			.addToolbarTo("canvas2", "tlbAssetEdit")
			.addToolbarTo("amortEditList", "tlbAmortEditList")
			.addToolbarTo("acctEditList", "tlbAcctList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAssetList", {dc: "asset"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Assets"})
			.end()
			.beginToolbar("tlbAssetEdit", {dc: "asset"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Asset"})
			.end()
			.beginToolbar("tlbAmortEditList", {dc: "amort"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Amortization"})
			.end()
			.beginToolbar("tlbAcctList", {dc: "acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounting"})
			.end()
			;
	}

	,onBtnCreateAmortization: function() {
		
				Ext.Msg.alert("Missing feature","This function is not implemented yet. However, amortization plan can be created manually.");
	}
});
