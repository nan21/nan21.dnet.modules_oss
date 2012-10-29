/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.md.acc.dc.Account", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.md.acc.ds.model.AccountDs",
	filterModel: "net.nan21.dnet.module.md.acc.ds.model.AccountDsFilter",
	paramModel: "net.nan21.dnet.module.md.acc.ds.param.AccountDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.md.acc.dc.Account$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.md_acc_dc_Account$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"md_acc_lovs_AccSchemas", name:"accSchema", dataIndex:"accSchema", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "accSchemaId"} 
				]})
			.addCombo({ xtype:"combo", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				store:[ "D", "C", "N"]
			})
			.addBooleanField({ name:"summary", dataIndex:"summary", anchor:"-20"})
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
			.addChildrenTo("col1", ["name", "code"])
			.addChildrenTo("col2", ["accSchema", "type"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.md.acc.dc.Account$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.md_acc_dc_Account$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"accSchema", dataIndex:"accSchema", width:100})
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"type", dataIndex:"type", width:60})
			.addBooleanColumn({ name:"summary", dataIndex:"summary"})
			.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addNumberColumn({ name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.md.acc.dc.Account$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.md_acc_dc_Account$EditList",
	_bulkEditFields_: ["accSchema","type","summary","active"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"accSchema", dataIndex:"accSchema", xtype:"gridcolumn", width:100,
					editor:{xtype:"md_acc_lovs_AccSchemas", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accSchemaId"} 
						]}})
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"code", dataIndex:"code", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addComboColumn({name:"type", dataIndex:"type", width:60,
					editor:{xtype:"combo", mode: 'local', selectOnFocus:true, triggerAction:'all', forceSelection:true, store:[ "D", "C", "N"]}})
			.addBooleanColumn({name:"summary", dataIndex:"summary"})
			.addTextColumn({name:"notes", dataIndex:"notes", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addBooleanColumn({name:"active", dataIndex:"active"})
			.addNumberColumn({name:"accSchemaId", dataIndex:"accSchemaId", hidden:true, align:"right", width:70, format:"0",
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.md.acc.dc.Account$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.md_acc_dc_Account$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextField({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addTextField({ name:"accSchema", dataIndex:"accSchema", anchor:"-20", maxLength:32})
			.addCombo({ xtype:"combo", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				store:[ "D", "C", "N"]
			})
			.addBooleanField({ name:"summary", dataIndex:"summary", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "code", "active", "notes"])
			.addChildrenTo("col2", ["accSchema", "type", "summary"])
		;
	}});
