/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.bd.currency.dc.CurrencyXRate", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateDs",
	filterModel: "net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateDsFilter",
	paramModel: "net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.bd_currency_dc_CurrencyXRate$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"sourceCode", dataIndex:"sourceCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "sourceId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"targetCode", dataIndex:"targetCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "targetId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_CurrencyXRateProviders", name:"providerCode", dataIndex:"providerCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "providerId"} 
				]})
			.addDateField({name:"validAt", dataIndex:"validAt", anchor:"-20", format:Ext.DATE_FORMAT})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["sourceCode", "targetCode"])
			.addChildrenTo("col2", ["providerCode", "validAt"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.bd.currency.dc.CurrencyXRate$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.bd_currency_dc_CurrencyXRate$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"sourceCode", dataIndex:"sourceCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_currency_lovs_Currencies", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "sourceId"} 
						]}})
			.addLov({name:"targetCode", dataIndex:"targetCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_currency_lovs_Currencies", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "targetId"} 
						]}})
			.addDateColumn({name:"validAt", dataIndex:"validAt", format: Dnet.DATE_FORMAT
				,editor:{xtype:"datefield", format: Dnet.DATE_FORMAT }
			})
			.addNumberColumn({name:"value", dataIndex:"value", align:"right", decimals:6,
					editor:{xtype:"numberfield" , decimalPrecision:6}})
			.addNumberColumn({name:"providerId", dataIndex:"providerId", hidden:true, align:"right", width:70, format:"0"})
			.addLov({name:"providerCode", dataIndex:"providerCode", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_currency_lovs_CurrencyXRateProviders", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "providerId"} 
						]}})
			.addDefaults();
	}});
