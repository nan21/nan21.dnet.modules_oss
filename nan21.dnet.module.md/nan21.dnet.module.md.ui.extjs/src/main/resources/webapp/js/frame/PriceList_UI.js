/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.mm.price.frame.PriceList_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.mm.price.frame.PriceList_UI",
	_name_: "net.nan21.dnet.module.md.mm.price.frame.PriceList_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("pricelist", new net.nan21.dnet.module.md.mm.price.dc.PriceList({multiEdit:true}))
			.addDc("version", new net.nan21.dnet.module.md.mm.price.dc.PriceListVersion({multiEdit:true}))
			.addDc("price", new net.nan21.dnet.module.md.mm.price.dc.ProductPrice({multiEdit:true}))
	
			.linkDc("version", "pricelist",{fields:[
				{childField:"priceListId", parentField:"id"}]}
			)
			.linkDc("price", "version",{fields:[
				{childField:"priceListVersionId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnShowCanvas2", text:"Product prices", tooltip:"Product prices", disabled:true,
					handler: this.onShowCanvas2, scope:this, stateManager:{name:"selected_one_clean", dc:"version" }})
			.addButton({name:"btnAddProdByCateg", text:"Add from category ", tooltip:"Add products from product category", disabled:false,
					handler: this.onBtnAddProdByCateg, scope:this})
			.addButton({name:"btnAddProdByCategExec", text:"OK", tooltip:"Add products from the selected product category", disabled:false,
					handler: this.onBtnAddProdByCategExec, scope:this})
			
			.addDcFilterFormView("pricelist", {name:"pricelistFilter", height:80, xtype:"md_mm_price_dc_PriceList$FilterH"})
			.addDcEditGridView("pricelist", {name:"pricelistEditList", xtype:"md_mm_price_dc_PriceList$EditList", frame:true})
			.addDcEditGridView("version", {name:"versionEditList", height:250, xtype:"md_mm_price_dc_PriceListVersion$CtxEditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnShowCanvas2")]}]})
			.addDcFormView("version", {name:"versionView", height:120, xtype:"md_mm_price_dc_PriceListVersion$CtxView", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnAddProdByCateg")]}]})
			.addDcFormView("version", {name:"versionCopyProdFromCateg", height:120, xtype:"md_mm_price_dc_PriceListVersion$CopyProductsFromCategory"})
			.addDcFilterFormView("price", {name:"priceFilter", title:"Filter", width:280, xtype:"md_mm_price_dc_ProductPrice$FilterCtx", collapsible:true
			})
			.addDcEditGridView("price", {name:"priceEditList", xtype:"md_mm_price_dc_ProductPrice$EditList", frame:true})
			.addWindow({name:"wdwVersionCopyProdFromCateg", title:"Select product category", width:400, height:120, closeAction:'hide', resizable:true, layout:"fit", modal:true,
				items:[this._elems_.get("versionCopyProdFromCateg")], 
						dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
							items:[ this._elems_.get("btnAddProdByCategExec")]}]})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"pricePanel", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["pricelistFilter", "pricelistEditList", "versionEditList"], ["north", "center", "south"])
			.addChildrenTo("canvas2", ["versionView", "pricePanel"], ["north", "center"])
			.addChildrenTo("pricePanel", ["priceFilter", "priceEditList"], ["west", "center"])
			.addToolbarTo("canvas1", "tlbPricelistEditList")
			.addToolbarTo("versionEditList", "tlbVersionEditList")
			.addToolbarTo("canvas2", "tlbVersionView")
			.addToolbarTo("pricePanel", "tlbPriceEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPricelistEditList", {dc: "pricelist"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Price lists"})
			.end()
			.beginToolbar("tlbVersionEditList", {dc: "version"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Price list versions"})
			.end()
			.beginToolbar("tlbVersionView", {dc: "version"}).addBack().addPrevRec().addNextRec()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Price list version"})
			.end()
			.beginToolbar("tlbPriceEditList", {dc: "price"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Product price"})
			.end()
			;
	}

	
	,onBtnAddProdByCateg: function() {
		this._getWindow_("wdwVersionCopyProdFromCateg").show();
	}
	
	,onBtnAddProdByCategExec: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) {
				this._getWindow_("wdwVersionCopyProdFromCateg").close();
				this._getDc_("price").doQuery();
			};
		s.callbacks['successFn'] = successFn;
		s.callbacks['successScope'] = this;
		try{
			this._getDc_("version").doService("addProductsFromCategory", s);
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}
	
	,onShowCanvas2: function() {
		this._getElement_("main").getLayout().setActiveItem(1);
	}
});
