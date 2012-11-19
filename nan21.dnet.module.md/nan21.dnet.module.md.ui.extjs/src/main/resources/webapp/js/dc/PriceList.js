/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceList", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.mm.price.ds.model.PriceListDs",
	filterModel: "net.nan21.dnet.module.md.mm.price.ds.model.PriceListDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.price.ds.param.PriceListDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: FilterH ================= */


Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceList$FilterH", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_mm_price_dc_PriceList$FilterH",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"isDefault", dataIndex:"isDefault", anchor:"-20"})
			.addBooleanField({ name:"salesList", dataIndex:"salesList", anchor:"-20"})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
			.addPanel({ name:"col3", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "currency"])
			.addChildrenTo("col2", ["salesList"])
			.addChildrenTo("col3", ["isDefault", "active"])
		;
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.mm.price.dc.PriceList$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_mm_price_dc_PriceList$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"name", dataIndex:"name", width:120,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"description", dataIndex:"description", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addLov({name:"currency", dataIndex:"currency", xtype:"gridcolumn", width:100,
					editor:{xtype:"bd_currency_lovs_Currencies", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "currencyId"} 
						]}})
			.addBooleanColumn({name:"salesList", dataIndex:"salesList"})
			.addBooleanColumn({name:"isDefault", dataIndex:"isDefault"})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"currencyId", dataIndex:"currencyId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
