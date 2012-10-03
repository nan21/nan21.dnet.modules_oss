/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElement", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementDs",
	filterModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementDsFilter",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.param.PayrollElementDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElement$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_payroll_dc_PayrollElement$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"dataType", dataIndex:"dataType", anchor:"-20",
				store:[ "string", "number", "boolean", "date"]
			})
			.addCombo({ xtype:"combo", name:"calculation", dataIndex:"calculation", anchor:"-20",
				store:[ "manual", "formula"]
			})
			.addCombo({ xtype:"combo", name:"balanceFunction", dataIndex:"balanceFunction", anchor:"-20",
				store:[ "sum", "count", "avg"]
			})
			.addLov({xtype:"bd_elem_lovs_Engines", name:"engine", dataIndex:"engine", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "engineId"} 
				]})
			.addLov({xtype:"bd_elem_lovs_ElementTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				],
				filterFieldMapping: [
					{lovField:"engineId",dsField: "engineId"} 
				]})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"balance", dataIndex:"balance", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:210, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "code"])
			.addChildrenTo("col2", ["engine", "type", "dataType"])
			.addChildrenTo("col3", ["balance", "active"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElement$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.hr_payroll_dc_PayrollElement$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"engine", dataIndex:"engine", width:120})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"name", dataIndex:"name", width:200})
			.addTextColumn({ name:"type", dataIndex:"type", width:120})
			.addBooleanColumn({ name:"balance", dataIndex:"balance", width:70})
			.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", width:70})
			.addTextColumn({ name:"dataType", dataIndex:"dataType", width:80})
			.addTextColumn({ name:"calculation", dataIndex:"calculation", width:80})
			.addTextColumn({ name:"balanceFunction", dataIndex:"balanceFunction", width:100})
			.addTextColumn({ name:"sourceElement", dataIndex:"sourceElement", width:100})
			.addTextColumn({ name:"accItem", dataIndex:"accItem", width:120})
			.addBooleanColumn({ name:"active", dataIndex:"active", width:70})
			.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true, width:200})
			.addDefaults();
	}});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElement$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_payroll_dc_PayrollElement$EditList",
	_bulkEditFields_: ["calculation","engine","type","dataType","active"],
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addLov({name:"engine", dataIndex:"engine", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_elem_lovs_Engines", selectOnFocus:true, allowBlank:false,
						retFieldMapping: [
							{lovField:"id", dsField: "engineId"} 
						]}})
			.addTextColumn({name:"code", dataIndex:"code", width:100,
					editor:{xtype:"textfield", selectOnFocus:true, allowBlank:false}})
			.addTextColumn({name:"name", dataIndex:"name", width:200,
					editor:{xtype:"textfield", selectOnFocus:true, allowBlank:false}})
			.addLov({name:"type", dataIndex:"type", xtype:"gridcolumn", width:120,
					editor:{xtype:"bd_elem_lovs_ElementTypes", selectOnFocus:true, allowBlank:false,
						retFieldMapping: [
							{lovField:"id", dsField: "typeId"} 
						],
						filterFieldMapping: [
							{lovField:"engineId",dsField: "engineId"} 
						]}})
			.addBooleanColumn({name:"balance", dataIndex:"balance", width:70})
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70,
					editor:{xtype:"numberfield" , decimalPrecision:2}})
			.addLov({name:"sourceElement", dataIndex:"sourceElement", xtype:"gridcolumn", width:100,
					editor:{xtype:"hr_payroll_lovs_PayrollElementsSource", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "sourceElementId"} 
						],
						filterFieldMapping: [
							{lovField:"engineId",dsField: "engineId"} 
						]}})
			.addLov({name:"accItem", dataIndex:"accItem", xtype:"gridcolumn", width:120,
					editor:{xtype:"md_acc_lovs_AccItems", selectOnFocus:true,
						retFieldMapping: [
							{lovField:"id", dsField: "accItemId"} 
						]}})
			.addBooleanColumn({name:"active", dataIndex:"active", width:70})
			.addTextColumn({name:"notes", dataIndex:"notes", hidden:true, width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElement$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.hr_payroll_dc_PayrollElement$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", allowBlank:false, anchor:"-20", maxLength:32})
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addNumberField({name:"sequenceNo", dataIndex:"sequenceNo", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"calculation", dataIndex:"calculation", anchor:"-20",
				store:[ "manual", "formula"]
			})
			.addCombo({ xtype:"combo", name:"balanceFunction", dataIndex:"balanceFunction", anchor:"-20",
				store:[ "sum", "count", "avg"]
			})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addBooleanField({ name:"balance", dataIndex:"balance", anchor:"-20",listeners:{
				change:{scope:this, fn:this.onBalanceChange}
			}
			})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"dataType", dataIndex:"dataType", allowBlank:false, anchor:"-20",
				store:[ "string", "number", "boolean", "date"]
			})
			.addLov({xtype:"bd_elem_lovs_Engines", name:"engine", dataIndex:"engine", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "engineId"} 
				]})
			.addLov({xtype:"bd_elem_lovs_ElementTypes", name:"type", _sharedLabel_:true, dataIndex:"type", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				],
				filterFieldMapping: [
					{lovField:"engineId",dsField: "engineId"} 
				]})
			.addLov({xtype:"md_acc_lovs_AccItems", name:"accItem", dataIndex:"accItem", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "accItemId"} 
				]})
			.addLov({xtype:"hr_payroll_lovs_PayrollElementsSource", name:"sourceElement", dataIndex:"sourceElement", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "sourceElementId"} 
				],
				filterFieldMapping: [
					{lovField:"engineId",dsField: "engineId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:350, layout:"form"})
			.addPanel({ name:"colStack", layout:"card"})
			.addPanel({ name:"colStack_1", width:250, layout:"form"})
			.addPanel({ name:"colStack_2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "colStack"])
			.addChildrenTo("col1", ["name", "code", "engine", "type", "dataType"])
			.addChildrenTo("col2", ["notes", "active", "balance"])
			.addChildrenTo("colStack", ["colStack_1", "colStack_2"])
			.addChildrenTo("colStack_1", ["sequenceNo", "calculation"])
			.addChildrenTo("colStack_2", ["balanceFunction", "sourceElement", "accItem"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	onBalanceChange: function() {
		var r = this._getController_().getRecord();
				if (r.get("balance")) {
					r.set("calculation", "");            
				} else {
		            r.set("balanceFunction", "");             
				}
				this._doSwitchViews_(r.data.balance);;
	},
	
	_doSwitchViews_: function(balance) {
		if (balance) {
					this._showStackedViewElement_("colStack",1);			 
				} else {
					this._showStackedViewElement_("colStack",0);	 
				};
	},
	
	_afterBind_: function(record) {
		if (record) {
					this._doSwitchViews_(record.data.balance);
				};
	}
});
