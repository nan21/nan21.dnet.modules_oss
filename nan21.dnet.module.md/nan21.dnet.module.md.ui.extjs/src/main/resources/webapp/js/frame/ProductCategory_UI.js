/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.md.mm.prod.frame.ProductCategory_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.frame.ProductCategory_UI",
	_name_: "net.nan21.dnet.module.md.mm.prod.frame.ProductCategory_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("categ", new net.nan21.dnet.module.md.mm.prod.dc.ProductCategory({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnAsgnCategories", text:"Assign Products", tooltip:"Add products to selected category", disabled:true,
					handler: this.onBtnAsgnCategories, scope:this, stateManager:{name:"selected_one_clean", dc:"categ" , and: function(dc) {return ( !dc.record.data.folder );}}})
			
			.addDcFilterFormView("categ", {name:"categFilter", xtype:"md_mm_prod_dc_ProductCategory$Filter"})
			.addDcEditGridView("categ", {name:"categEditList", xtype:"md_mm_prod_dc_ProductCategory$EditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnAsgnCategories")]}]})
			.addDcFormView("categ", {name:"categView", width:200, xtype:"md_mm_prod_dc_ProductCategory$ViewIcon"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasCateg", title:"Categories", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasCateg"])
			.addChildrenTo("canvasCateg", ["categFilter", "categEditList", "categView"], ["north", "center", "east"])
			.addToolbarTo("canvasCateg", "tlbCateg")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCateg", {dc: "categ"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Categories"})
			.end()
			;
	}

	
	,onBtnAsgnCategories: function() {
		this.showAsgnWindow(net.nan21.dnet.module.md.mm.prod.asgn.ProductsOfCategory$Ui ,{dc: "categ", objectIdField: "id"});
	}
});
