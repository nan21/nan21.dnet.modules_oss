/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.fi.asset.frame.AssetBaseData_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.fi.asset.frame.AssetBaseData_UI",
	_name_: "net.nan21.dnet.module.fi.asset.frame.AssetBaseData_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("categ", new net.nan21.dnet.module.fi.asset.dc.AssetCategory({multiEdit:true}))
			.addDc("acct", new net.nan21.dnet.module.fi.asset.dc.AssetCategoryAcct({multiEdit:true}))
	
			.linkDc("acct", "categ",{fields:[
				{childField:"assetCategoryId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("categ", {name:"categFilter", height:80, xtype:"fi_asset_dc_AssetCategory$Filter"})
			.addDcEditGridView("categ", {name:"categEditList", xtype:"fi_asset_dc_AssetCategory$EditList", frame:true})
			.addDcEditGridView("acct", {name:"acctEditList", height:220, xtype:"fi_asset_dc_AssetCategoryAcct$EditListCtx", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasCateg", title:"Categories", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasCateg"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasCateg"])
			.addChildrenTo("canvasCateg", ["categFilter", "categEditList", "acctEditList"], ["north", "center", "south"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasCateg", "tlbCategList")
			.addToolbarTo("acctEditList", "tlbAcctList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCategList", {dc: "categ"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Categories"})
			.end()
			.beginToolbar("tlbAcctList", {dc: "acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Accounting"})
			.end()
			;
	}

});
