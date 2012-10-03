/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceListVersion", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.mm.price.ds.model.PriceListVersionDs",
	filterModel: "net.nan21.dnet.module.md.mm.price.ds.model.PriceListVersionDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.price.ds.param.PriceListVersionDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_mm_price_dc_PriceListVersion$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"md_mm_price_lovs_PriceList", name:"priceList", dataIndex:"priceList", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priceListId"} 
				]})
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
			.addChildrenTo("col1", ["name", "priceList"])
			.addChildrenTo("col2", ["active"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_mm_price_dc_PriceListVersion$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"priceListId", dataIndex:"priceListId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_mm_price_dc_PriceListVersion$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"priceList", dataIndex:"priceList", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_mm_price_lovs_PriceList", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "priceListId"} 
						]}})
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDateColumn({name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"priceListId", dataIndex:"priceListId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: CtxView ================= */


Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$CtxView", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_mm_price_dc_PriceListVersion$CtxView",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", disabled:true , anchor:"-20"})
			.addTextField({ name:"priceList", dataIndex:"priceList", disabled:true , anchor:"-20"})
			.addDateField({name:"validFrom", dataIndex:"validFrom", disabled:true , anchor:"-20", format:Ext.DATE_FORMAT})
			.addTextField({ name:"currency", dataIndex:"currency", disabled:true , anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:220, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "priceList"])
			.addChildrenTo("col2", ["validFrom", "currency"])
		;
	}});


/* ================= EDITOR: CopyProductsFromCategory ================= */


Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$CopyProductsFromCategory", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_mm_price_dc_PriceListVersion$CopyProductsFromCategory",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_mm_prod_lovs_ProductCategories", name:"productCategory", paramIndex:"productCategory", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "productCategoryId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["productCategory"])
		;
	}});
