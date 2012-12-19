/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.base.tax.dc.Tax", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.base.tax.ds.model.TaxDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.base.tax.dc.Tax$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_base_tax_dc_Tax$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"summary", dataIndex:"summary", anchor:"-20"})
			.addLov({xtype:"md_base_tax_lovs_TaxCategories", name:"category", dataIndex:"category", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "categoryId"} 
				]})
			.addLov({xtype:"md_base_tax_lovs_Taxes", name:"parentTax", dataIndex:"parentTax", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "parentTaxId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "category", "parentTax"])
			.addChildrenTo("col2", ["summary", "active"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.base.tax.dc.Tax$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_base_tax_dc_Tax$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:120})
			.addTextColumn({ name:"description", dataIndex:"description", width:200})
			.addBooleanColumn({ name:"summary", dataIndex:"summary"})
			.addNumberColumn({ name:"rate", dataIndex:"rate", decimals:2})
			.addTextColumn({ name:"category", dataIndex:"category", width:120})
			.addTextColumn({ name:"parentTax", dataIndex:"parentTax", width:120})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addNumberColumn({ name:"categoryId", dataIndex:"categoryId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"parentTaxId", dataIndex:"parentTaxId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.base.tax.dc.Tax$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_base_tax_dc_Tax$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20", height:60})
			.addNumberField({name:"rate", dataIndex:"rate", anchor:"-20", decimals:2})
			.addBooleanField({ name:"summary", dataIndex:"summary", anchor:"-20"})
			.addLov({xtype:"md_base_tax_lovs_TaxCategories", name:"category", dataIndex:"category", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "categoryId"} 
				]})
			.addLov({xtype:"md_base_tax_lovs_Taxes", name:"parentTax", dataIndex:"parentTax", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "parentTaxId"} 
				],
				filterFieldMapping: [
					{lovField:"summary",value: "true"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:350, layout:"form"})
			.addPanel({ name:"col2", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "category", "description"])
			.addChildrenTo("col2", ["summary", "active", "rate", "parentTax"])
		;
	}
});
