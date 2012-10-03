/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/ds/ProductDs", "nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure", "nan21.dnet.module.bd.ui.extjs/ds/UomLovDs", "nan21.dnet.module.md.ui.extjs/lov/ProductCategories", "nan21.dnet.module.bd.ui.extjs/lov/UomLength", "nan21.dnet.module.bd.ui.extjs/ds/UomMassLovDs", "nan21.dnet.module.md.ui.extjs/dc/TestProduct", "nan21.dnet.module.bd.ui.extjs/ds/UomVolumeLovDs", "nan21.dnet.module.md.ui.extjs/lov/ProductManufacturers", "nan21.dnet.module.bd.ui.extjs/lov/UomVolume", "nan21.dnet.module.md.ui.extjs/ds/ProductCategoryLovDs", "nan21.dnet.module.bd.ui.extjs/lov/AttributeSet", "nan21.dnet.module.md.ui.extjs/ds/ProductManufacturerLovDs", "nan21.dnet.module.bd.ui.extjs/lov/UomMass", "nan21.dnet.module.bd.ui.extjs/ds/UomLengthLovDs", "nan21.dnet.module.bd.ui.extjs/ds/AttributeSetLovDs"]);

Ext.define("net.nan21.dnet.module.md.mm.prod.frame.TestProduct_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.frame.TestProduct_UI",
	_name_: "net.nan21.dnet.module.md.mm.prod.frame.TestProduct_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("prod", new net.nan21.dnet.module.md.mm.prod.dc.TestProduct({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("prod", {name:"prodFilter", height:120, xtype:"md_mm_prod_dc_TestProduct$Filter"})	
			.addDcFilterFormView("prod", {name:"prodFilterPG", width:300, xtype:"md_mm_prod_dc_TestProduct$FilterPG"})	
			.addDcGridView("prod", {name:"prodList", title:"Grid", xtype:"md_mm_prod_dc_TestProduct$List"})	
			.addDcEditGridView("prod", {name:"prodEditList", title:"Edit-Grid", xtype:"md_mm_prod_dc_TestProduct$EditList", frame:true})	
			.addDcFormView("prod", {name:"prodEdit", height:120, xtype:"md_mm_prod_dc_TestProduct$Edit"})	
			.addDcFormView("prod", {name:"prodEditPG", width:300, xtype:"md_mm_prod_dc_TestProduct$EditPG"})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"gridTabs", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["prodFilter", "gridTabs", "prodEdit", "prodEditPG", "prodFilterPG"], ["north", "center", "south", "east", "west"])
			.addChildrenTo("gridTabs", ["prodList", "prodEditList"])
			.addToolbarTo("canvas1", "tlbList")
			.addToolbarTo("prodEdit", "tlbEdit")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbList", {dc: "prod"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Products"})
			.end()
			.beginToolbar("tlbEdit", {dc: "prod"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Product"})
			.end()
	}

});
