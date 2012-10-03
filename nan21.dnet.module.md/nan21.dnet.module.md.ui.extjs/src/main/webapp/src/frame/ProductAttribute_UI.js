/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.bd.ui.extjs/lov/AttributeCategory", "nan21.dnet.module.bd.ui.extjs/lov/Attribute", "nan21.dnet.module.bd.ui.extjs/ds/AttributeLovDs", "nan21.dnet.module.md.ui.extjs/ds/ProductLovDs", "nan21.dnet.module.bd.ui.extjs/ds/AttributeCategoryLovDs", "nan21.dnet.module.md.ui.extjs/ds/ProductAttributeValueDs", "nan21.dnet.module.md.ui.extjs/dc/ProductAttributeValue", "nan21.dnet.module.md.ui.extjs/lov/Products"]);

Ext.define("net.nan21.dnet.module.md.mm.prod.frame.ProductAttribute_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.frame.ProductAttribute_UI",
	_name_: "net.nan21.dnet.module.md.mm.prod.frame.ProductAttribute_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("attr", new net.nan21.dnet.module.md.mm.prod.dc.ProductAttributeValue({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("attr", {name:"attrFilter", height:120, xtype:"md_mm_prod_dc_ProductAttributeValue$Filter"})	
			.addDcEditGridView("attr", {name:"attrEditList", xtype:"md_mm_prod_dc_ProductAttributeValue$EditList", frame:true})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["attrFilter", "attrEditList"], ["north", "center"])
			.addToolbarTo("canvas1", "tlbAttrEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAttrEditList", {dc: "attr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Product attributes values"})
			.end()
	}

});
