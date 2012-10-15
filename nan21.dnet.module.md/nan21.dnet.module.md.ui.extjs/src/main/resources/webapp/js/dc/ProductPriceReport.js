/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.price.dc.ProductPriceReport", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceReportDs",
	filterModel: "net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceReportDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.price.ds.param.ProductPriceReportDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.mm.price.dc.ProductPriceReport$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_mm_price_dc_ProductPriceReport$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"md_mm_price_lovs_PriceList", name:"priceList", dataIndex:"priceList", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priceListId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addLov({xtype:"md_mm_price_lovs_PriceListVersion", name:"priceListVersion", dataIndex:"priceListVersion", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priceListVersionId"} 
				],
				filterFieldMapping: [
					{lovField:"priceListId",dsField: "priceListId"} 
				]})
			.addDateField({name:"validAt", paramIndex:"validAt", anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"md_mm_prod_lovs_Products", name:"product", dataIndex:"product", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "productId"} 
				]})
			.addLov({xtype:"md_mm_prod_lovs_ProductCategories", name:"productCategory", paramIndex:"productCategory", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "productCategoryId"} 
				]})
			.addNumberField({name:"price", dataIndex:"price", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:180, layout:"form", defaults:{labelAlign:"right", labelWidth:70}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["priceList", "priceListVersion", "currency"])
			.addChildrenTo("col2", ["product", "productCategory"])
			.addChildrenTo("col3", ["validAt", "price"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.mm.price.dc.ProductPriceReport$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_mm_price_dc_ProductPriceReport$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"product", dataIndex:"product", width:150})
			.addTextColumn({ name:"productName", dataIndex:"productName", width:250})
			.addNumberColumn({ name:"price", dataIndex:"price", decimals:2})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:100})
			.addDateColumn({ name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"priceList", dataIndex:"priceList", width:120})
			.addTextColumn({ name:"priceListVersion", dataIndex:"priceListVersion", width:120})
			.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});
