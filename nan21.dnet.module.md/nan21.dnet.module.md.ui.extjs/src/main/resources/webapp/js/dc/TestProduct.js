/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductDs",
	filterModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.prod.ds.param.ProductDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_mm_prod_dc_TestProduct$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"storable", dataIndex:"storable", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"showInCatalog", dataIndex:"showInCatalog", anchor:"-20"})
			.addLov({xtype:"md_mm_prod_lovs_ProductManufacturers", name:"manufacturerCode", dataIndex:"manufacturerCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "manufacturerId"} 
				]})
			.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", anchor:"-20", maxLength:32})
			.addLov({xtype:"bd_attr_lovs_AttributeSet", name:"attributeSet", dataIndex:"attributeSet", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "attributeSetId"} 
				]})
			.addLov({xtype:"md_mm_prod_lovs_ProductCategories", name:"productCategory", paramIndex:"productCategory", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "productCategoryId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:150, layout:"form", defaults:{labelAlign:"right", labelWidth:70}})
			.addPanel({ name:"col3", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "code", "manufacturerCode", "manufacturerProductNo"])
			.addChildrenTo("col2", ["storable", "active", "showInCatalog"])
			.addChildrenTo("col3", ["attributeSet", "productCategory"])
		;
	}});


/* ================= FILTER: FilterPG ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct$FilterPG", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.md_mm_prod_dc_TestProduct$FilterPG",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"storable", dataIndex:"storable", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"showInCatalog", dataIndex:"showInCatalog", anchor:"-20"})
			.addNumberField({name:"manufacturerId", dataIndex:"manufacturerId", anchor:"-20"})
			.addLov({xtype:"md_mm_prod_lovs_ProductManufacturers", name:"manufacturerCode", dataIndex:"manufacturerCode", anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.md.mm.prod.lovs.ProductManufacturers", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "manufacturerId"} 
					]}})
			.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", anchor:"-20", maxLength:32})
			.addLov({xtype:"bd_attr_lovs_AttributeSet", name:"attributeSet", dataIndex:"attributeSet", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.bd.attr.lovs.AttributeSet", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "attributeSetId"} 
					]}})
			.addLov({xtype:"md_mm_prod_lovs_ProductCategories", name:"productCategory", paramIndex:"productCategory", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.md.mm.prod.lovs.ProductCategories", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsParam: "productCategoryId"} 
					]}})
		;
	},

});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_mm_prod_dc_TestProduct$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addBooleanColumn({ name:"active", dataIndex:"active", width:60})
			.addBooleanColumn({ name:"storable", dataIndex:"storable", width:60})
			.addBooleanColumn({ name:"showInCatalog", dataIndex:"showInCatalog", width:60})
			.addNumberColumn({ name:"defaultUomId", dataIndex:"defaultUomId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"defaultUomCode", dataIndex:"defaultUomCode", width:100})
			.addTextColumn({ name:"attributeSet", dataIndex:"attributeSet", width:120})
			.addNumberColumn({ name:"manufacturerId", dataIndex:"manufacturerId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"manufacturerCode", dataIndex:"manufacturerCode", width:100})
			.addTextColumn({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", hidden:true, width:100})
			.addNumberColumn({ name:"weight", dataIndex:"weight", decimals:2})
			.addNumberColumn({ name:"weightUomId", dataIndex:"weightUomId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"weightUomCode", dataIndex:"weightUomCode", width:100})
			.addNumberColumn({ name:"volume", dataIndex:"volume", hidden:true, decimals:2})
			.addNumberColumn({ name:"volumeUomId", dataIndex:"volumeUomId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"volumeUomCode", dataIndex:"volumeUomCode", hidden:true, width:100})
			.addNumberColumn({ name:"dimWidth", dataIndex:"dimWidth", hidden:true, decimals:2})
			.addNumberColumn({ name:"dimHeight", dataIndex:"dimHeight", hidden:true, decimals:2})
			.addNumberColumn({ name:"dimDepth", dataIndex:"dimDepth", hidden:true, decimals:2})
			.addNumberColumn({ name:"dimUomId", dataIndex:"dimUomId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"dimUomCode", dataIndex:"dimUomCode", hidden:true, width:100})
			.addTextColumn({ name:"iconUrl", dataIndex:"iconUrl", hidden:true, width:100})
			.addTextColumn({ name:"imageUrl", dataIndex:"imageUrl", hidden:true, width:100})
			.addDefaults();
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_mm_prod_dc_TestProduct$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"code", dataIndex:"code", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active", width:60})
			.addBooleanColumn({name:"storable", dataIndex:"storable", width:60})
			.addBooleanColumn({name:"showInCatalog", dataIndex:"showInCatalog", width:60})
			.addNumberColumn({name:"defaultUomId", dataIndex:"defaultUomId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"defaultUomCode", dataIndex:"defaultUomCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_uom_lovs_UnitsOfMeasure", selectOnFocus:true, allowBlank:false,
						retFieldMapping: [
							{lovField:"id", dsField: "defaultUomId"} 
						]}})
			.addTextColumn({name:"attributeSet", dataIndex:"attributeSet", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"manufacturerId", dataIndex:"manufacturerId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addTextColumn({name:"manufacturerCode", dataIndex:"manufacturerCode", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", hidden:true, width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"weight", dataIndex:"weight", align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"weightUomId", dataIndex:"weightUomId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addTextColumn({name:"weightUomCode", dataIndex:"weightUomCode", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"volume", dataIndex:"volume", hidden:true, align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"volumeUomId", dataIndex:"volumeUomId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addTextColumn({name:"volumeUomCode", dataIndex:"volumeUomCode", hidden:true, width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"dimWidth", dataIndex:"dimWidth", hidden:true, align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"dimHeight", dataIndex:"dimHeight", hidden:true, align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"dimDepth", dataIndex:"dimDepth", hidden:true, align:"right", decimals:2,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"dimUomId", dataIndex:"dimUomId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addTextColumn({name:"dimUomCode", dataIndex:"dimUomCode", hidden:true, width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"iconUrl", dataIndex:"iconUrl", hidden:true, width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"imageUrl", dataIndex:"imageUrl", hidden:true, width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_mm_prod_dc_TestProduct$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"showInCatalog", dataIndex:"showInCatalog", anchor:"-20"})
			.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", anchor:"-20", maxLength:32})
			.addLov({xtype:"md_mm_prod_lovs_ProductManufacturers", name:"manufacturerCode", dataIndex:"manufacturerCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "manufacturerId"} 
				]})
			.addLov({xtype:"bd_attr_lovs_AttributeSet", name:"attributeSet", dataIndex:"attributeSet", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "attributeSetId"} 
				]})
			.addLov({xtype:"bd_uom_lovs_UnitsOfMeasure", name:"defaultUomCode", dataIndex:"defaultUomCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "defaultUomId"} 
				]})
			.addBooleanField({ name:"storable", dataIndex:"storable", anchor:"-20"})
			.addNumberField({name:"weight", dataIndex:"weight", anchor:"-20"})
			.addLov({xtype:"bd_uom_lovs_UomMass", name:"weightUomCode", dataIndex:"weightUomCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "weightUomId"} 
				]})
			.addNumberField({name:"volume", dataIndex:"volume", anchor:"-20"})
			.addNumberField({name:"volumeUomId", dataIndex:"volumeUomId", disabled:true , anchor:"-20"})
			.addLov({xtype:"bd_uom_lovs_UomVolume", name:"volumeUomCode", dataIndex:"volumeUomCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "volumeUomId"} 
				]})
			.addNumberField({name:"dimWidth", dataIndex:"dimWidth", anchor:"-20"})
			.addNumberField({name:"dimHeight", dataIndex:"dimHeight", anchor:"-20"})
			.addNumberField({name:"dimDepth", dataIndex:"dimDepth", anchor:"-20"})
			.addNumberField({name:"dimUomId", dataIndex:"dimUomId", disabled:true , anchor:"-20"})
			.addLov({xtype:"bd_uom_lovs_UomLength", name:"dimUomCode", dataIndex:"dimUomCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "dimUomId"} 
				]})
			.addTextField({ name:"iconUrl", dataIndex:"iconUrl", anchor:"-20"})
			.addTextField({ name:"imageUrl", dataIndex:"imageUrl", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "code", "defaultUomCode", "attributeSet", "manufacturerCode", "manufacturerProductNo"])
			.addChildrenTo("col2", ["storable", "weight", "weightUomCode", "volume", "volumeUomCode", "dimWidth", "dimHeight", "dimDepth", "dimUomCode"])
			.addChildrenTo("col3", ["active", "showInCatalog", "iconUrl", "imageUrl"])
		;
	}});


/* ================= EDITOR: EditPG ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.TestProduct$EditPG", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.md_mm_prod_dc_TestProduct$EditPG",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"showInCatalog", dataIndex:"showInCatalog", anchor:"-20"})
			.addTextField({ name:"manufacturerProductNo", dataIndex:"manufacturerProductNo", anchor:"-20", maxLength:32})
			.addLov({xtype:"md_mm_prod_lovs_ProductManufacturers", name:"manufacturerCode", dataIndex:"manufacturerCode", anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.md.mm.prod.lovs.ProductManufacturers", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "manufacturerId"} 
					]}})
			.addLov({xtype:"bd_attr_lovs_AttributeSet", name:"attributeSet", dataIndex:"attributeSet", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.bd.attr.lovs.AttributeSet", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "attributeSetId"} 
					]}})
			.addNumberField({name:"defaultUomId", dataIndex:"defaultUomId", anchor:"-20"})
			.addLov({xtype:"bd_uom_lovs_UnitsOfMeasure", name:"defaultUomCode", dataIndex:"defaultUomCode", allowBlank:false, anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", selectOnFocus:true, allowBlank:false,
					retFieldMapping: [
						{lovField:"id", dsField: "defaultUomId"} 
					]}})
			.addBooleanField({ name:"storable", dataIndex:"storable", anchor:"-20"})
			.addNumberField({name:"weight", dataIndex:"weight", anchor:"-20"})
			.addLov({xtype:"bd_uom_lovs_UomMass", name:"weightUomCode", dataIndex:"weightUomCode", anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.bd.uom.lovs.UomMass", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "weightUomId"} 
					]}})
			.addNumberField({name:"volume", dataIndex:"volume", anchor:"-20"})
			.addNumberField({name:"volumeUomId", dataIndex:"volumeUomId", disabled:true , anchor:"-20"})
			.addLov({xtype:"bd_uom_lovs_UomVolume", name:"volumeUomCode", dataIndex:"volumeUomCode", anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.bd.uom.lovs.UomVolume", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "volumeUomId"} 
					]}})
			.addNumberField({name:"dimWidth", dataIndex:"dimWidth", anchor:"-20"})
			.addNumberField({name:"dimHeight", dataIndex:"dimHeight", anchor:"-20"})
			.addNumberField({name:"dimDepth", dataIndex:"dimDepth", anchor:"-20"})
			.addNumberField({name:"dimUomId", dataIndex:"dimUomId", disabled:true , anchor:"-20"})
			.addLov({xtype:"bd_uom_lovs_UomLength", name:"dimUomCode", dataIndex:"dimUomCode", anchor:"-20", maxLength:32,
				editor:{_fqn_:"net.nan21.dnet.module.bd.uom.lovs.UomLength", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "dimUomId"} 
					]}})
			.addTextField({ name:"iconUrl", dataIndex:"iconUrl", anchor:"-20"})
			.addTextField({ name:"imageUrl", dataIndex:"imageUrl", anchor:"-20"})
		;
	},

});
