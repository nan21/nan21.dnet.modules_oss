/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.uom.dc.UomConversion", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.uom.ds.model.UomConversionDs",
	filterModel: "net.nan21.dnet.module.bd.uom.ds.model.UomConversionDsFilter",
	paramModel: "net.nan21.dnet.module.bd.uom.ds.param.UomConversionDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.uom.dc.UomConversion$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_uom_dc_UomConversion$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_uom_lovs_UnitsOfMeasure", name:"sourceCode", dataIndex:"sourceCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "sourceId"} 
				]})
			.addLov({xtype:"bd_uom_lovs_UnitsOfMeasure", name:"targetCode", dataIndex:"targetCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "targetId"} 
				]})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
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
			.addChildrenTo("col1", ["sourceCode", "targetCode"])
			.addChildrenTo("col2", ["active"])
			.addAuditFilter()
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.uom.dc.UomConversion$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_uom_dc_UomConversion$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"sourceCode", dataIndex:"sourceCode", xtype:"gridcolumn", width:150,
					editor:{xtype:"bd_uom_lovs_UnitsOfMeasure", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "sourceId"} 
						]}})
			.addLov({name:"targetCode", dataIndex:"targetCode", xtype:"gridcolumn", width:150,
					editor:{xtype:"bd_uom_lovs_UnitsOfMeasure", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "targetId"} 
						]}})
			.addNumberColumn({name:"multiplyWith", dataIndex:"multiplyWith", align:"right", decimals:6,
					editor:{xtype:"numberfield" , decimalPrecision:6}})
			.addNumberColumn({name:"divideTo", dataIndex:"divideTo", align:"right", decimals:6,
					editor:{xtype:"numberfield" , decimalPrecision:6}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.bd.uom.dc.UomConversion$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_uom_dc_UomConversion$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"sourceCode", dataIndex:"sourceCode", width:150})
			.addLov({name:"targetCode", dataIndex:"targetCode", xtype:"gridcolumn", width:150,
					editor:{xtype:"bd_uom_lovs_UnitsOfMeasure", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "targetId"} 
						]}})
			.addNumberColumn({name:"multiplyWith", dataIndex:"multiplyWith", align:"right", decimals:6,
					editor:{xtype:"numberfield" , decimalPrecision:6}})
			.addNumberColumn({name:"divideTo", dataIndex:"divideTo", align:"right", decimals:6,
					editor:{xtype:"numberfield" , decimalPrecision:6}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addDefaults();
	}});
