/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductCategory", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductCategoryDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductCategory$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_mm_prod_dc_ProductCategory$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"folder", dataIndex:"folder", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "code"])
			.addChildrenTo("col2", ["folder", "active"])
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductCategory$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_mm_prod_dc_ProductCategory$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"code", dataIndex:"code", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"iconUrl", dataIndex:"iconUrl", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"folder", dataIndex:"folder"})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}
});


/* ================= EDITOR: ViewIcon ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductCategory$ViewIcon", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_mm_prod_dc_ProductCategory$ViewIcon",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addImage({ name:"iconLocation", dataIndex:"iconLocation", anchor:"-20", maxWidth:150})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["iconLocation"])
		;
	}
});
