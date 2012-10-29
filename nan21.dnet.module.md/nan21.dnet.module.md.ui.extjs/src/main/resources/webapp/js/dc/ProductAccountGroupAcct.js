/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccountGroupAcct", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountGroupAcctDs",
	filterModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountGroupAcctDsFilter",
	paramModel: "net.nan21.dnet.module.md.mm.prod.ds.param.ProductAccountGroupAcctDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccountGroupAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_mm_prod_dc_ProductAccountGroupAcct$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"group", dataIndex:"group", anchor:"-20", maxLength:32})
			.addLov({xtype:"md_acc_lovs_AccSchemas", name:"accSchema", dataIndex:"accSchema", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "accSchemaId"} 
				]})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"expenseAccount", dataIndex:"expenseAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "expenseAccountId"} 
				]})
			.addLov({xtype:"md_acc_lovs_Accounts", name:"revenueAccount", dataIndex:"revenueAccount", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "revenueAccountId"} 
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
			.addChildrenTo("col1", ["group", "accSchema"])
			.addChildrenTo("col2", ["expenseAccount", "revenueAccount"])
		;
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.mm.prod.dc.ProductAccountGroupAcct$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_mm_prod_dc_ProductAccountGroupAcct$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accSchema", dataIndex:"accSchema", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_AccSchemas", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accSchemaId"} 
						]}})
			.addLov({name:"expenseAccount", dataIndex:"expenseAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "expenseAccountId"} ,{lovField:"name", dsField: "expenseAccountName"} 
						]}})
			.addTextColumn({name:"expenseAccountName", dataIndex:"expenseAccountName", width:200})
			.addLov({name:"revenueAccount", dataIndex:"revenueAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "revenueAccountId"} ,{lovField:"name", dsField: "revenueAccountName"} 
						]}})
			.addTextColumn({name:"revenueAccountName", dataIndex:"revenueAccountName", width:200})
			.addNumberColumn({name:"groupId", dataIndex:"groupId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"expenseAccountId", dataIndex:"expenseAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"revenueAccountId", dataIndex:"revenueAccountId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}});
