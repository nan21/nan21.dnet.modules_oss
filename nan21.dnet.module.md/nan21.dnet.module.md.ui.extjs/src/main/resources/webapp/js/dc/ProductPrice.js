/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.price.dc.ProductPrice", {
	extend: "dnet.core.dc.AbstractDc",

	paramModel: "net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceDsParam",
	recordModel: "net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.mm.price.dc.ProductPrice$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_mm_price_dc_ProductPrice$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_mm_prod_lovs_Products", name:"product", dataIndex:"product", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "productId"} 
				]})
			.addNumberField({name:"price", dataIndex:"price", anchor:"-20", decimals:2})
			.addLov({xtype:"md_mm_prod_lovs_ProductCategories", name:"productCategory", paramIndex:"productCategory", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "productCategoryId"} 
				]})
			.addLov({xtype:"bd_uom_lovs_UnitsOfMeasureCode", name:"uom", dataIndex:"uom", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "uomId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:280, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["product", "productCategory"])
			.addChildrenTo("col2", ["uom"])
		;
	}
});


/* ================= FILTER: FilterCtx ================= */


Ext.define("net.nan21.dnet.module.md.mm.price.dc.ProductPrice$FilterCtx", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.md_mm_price_dc_ProductPrice$FilterCtx",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_mm_prod_lovs_Products", name:"product", dataIndex:"product", anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.md.mm.prod.lovs.Products", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "productId"} 
					]}})
			.addNumberField({name:"price", dataIndex:"price", anchor:"-20", decimals:2})
			.addLov({xtype:"md_mm_prod_lovs_ProductCategories", name:"productCategory", paramIndex:"productCategory", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.mm.prod.lovs.ProductCategories", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsParam: "productCategoryId"} 
					]}})
			.addLov({xtype:"bd_uom_lovs_UnitsOfMeasureCode", name:"uom", dataIndex:"uom", anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasureCode", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "uomId"} 
					]}})
		;
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.mm.price.dc.ProductPrice$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_mm_price_dc_ProductPrice$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"product", dataIndex:"product", xtype:"gridcolumn", width:150,
					editor:{xtype:"md_mm_prod_lovs_ProductsWithUom", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "productId"} ,{lovField:"name", dsField: "productName"} ,{lovField:"uomId", dsField: "uomId"} ,{lovField:"uom", dsField: "uom"} 
						]}})
			.addTextColumn({name:"productName", dataIndex:"productName", width:250})
			.addLov({name:"uom", dataIndex:"uom", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_uom_lovs_UnitsOfMeasureCode", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "uomId"} 
						]}})
			.addNumberColumn({name:"price", dataIndex:"price", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"productId", dataIndex:"productId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
