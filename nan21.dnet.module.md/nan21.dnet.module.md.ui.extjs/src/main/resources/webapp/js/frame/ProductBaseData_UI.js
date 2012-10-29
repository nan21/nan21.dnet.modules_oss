/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.md.ui.extjs/dc/ProductManufacturer", "nan21.dnet.module.md.ui.extjs/ds/ProductManufacturerDs"]);

Ext.define("net.nan21.dnet.module.md.mm.prod.frame.ProductBaseData_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.md.mm.prod.frame.ProductBaseData_UI",
	_name_: "net.nan21.dnet.module.md.mm.prod.frame.ProductBaseData_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("manufact", new net.nan21.dnet.module.md.mm.prod.dc.ProductManufacturer({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("manufact", {name:"manufactFilter", height:80, xtype:"md_mm_prod_dc_ProductManufacturer$Filter"})
			.addDcEditGridView("manufact", {name:"manufactEditList", xtype:"md_mm_prod_dc_ProductManufacturer$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasManufact", title:"Manufacturers", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasManufact"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasManufact"])
			.addChildrenTo("canvasManufact", ["manufactFilter", "manufactEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasManufact", "tlbManufact")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbManufact", {dc: "manufact"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Manufacturers"})
			.end()
	}

});
