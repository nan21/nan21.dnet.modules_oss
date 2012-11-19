/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.acc.dc.AccItemAcct", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.acc.ds.model.AccItemAcctDs",
	filterModel: "net.nan21.dnet.module.md.acc.ds.model.AccItemAcctDsFilter",
	paramModel: "net.nan21.dnet.module.md.acc.ds.param.AccItemAcctDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.acc.dc.AccItemAcct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_acc_dc_AccItemAcct$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"accItem", dataIndex:"accItem", anchor:"-20"})
			.addTextField({ name:"accSchema", dataIndex:"accSchema", anchor:"-20", maxLength:32})
			.addTextField({ name:"crAccount", dataIndex:"crAccount", anchor:"-20", maxLength:32})
			.addTextField({ name:"dbAccount", dataIndex:"dbAccount", anchor:"-20", maxLength:32})
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
			.addChildrenTo("col1", ["accItem", "accSchema"])
			.addChildrenTo("col2", ["crAccount", "dbAccount"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.acc.dc.AccItemAcct$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_acc_dc_AccItemAcct$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"accItem", dataIndex:"accItem", width:120})
			.addTextColumn({ name:"accSchema", dataIndex:"accSchema", width:100})
			.addTextColumn({ name:"crAccount", dataIndex:"crAccount", width:100})
			.addTextColumn({ name:"dbAccount", dataIndex:"dbAccount", width:100})
			.addNumberColumn({ name:"accItemId", dataIndex:"accItemId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"crAccountId", dataIndex:"crAccountId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"dbAccountId", dataIndex:"dbAccountId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: CtxEditList ================= */


Ext.define("net.nan21.dnet.module.md.acc.dc.AccItemAcct$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_acc_dc_AccItemAcct$CtxEditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accSchema", dataIndex:"accSchema", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_AccSchemas", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accSchemaId"} 
						]}})
			.addLov({name:"crAccount", dataIndex:"crAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "crAccountId"} 
						],
						filterFieldMapping: [
							{lovField:"accSchemaId",dsField: "accSchemaId"} 
						]}})
			.addLov({name:"dbAccount", dataIndex:"dbAccount", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_Accounts", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "dbAccountId"} 
						],
						filterFieldMapping: [
							{lovField:"accSchemaId",dsField: "accSchemaId"} 
						]}})
			.addNumberColumn({name:"accItemId", dataIndex:"accItemId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"crAccountId", dataIndex:"crAccountId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addNumberColumn({name:"dbAccountId", dataIndex:"dbAccountId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addDefaults();
	}});
