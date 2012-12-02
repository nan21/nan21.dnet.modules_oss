/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.payroll.dc.Payroll", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.payroll.dc.Payroll$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_payroll_dc_Payroll$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"periodType", dataIndex:"periodType", anchor:"-20",
				store:[ "calendar-month"]
			})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:170, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "periodType"])
			.addChildrenTo("col2", ["active"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.hr.payroll.dc.Payroll$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.hr_payroll_dc_Payroll$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:120})
			.addTextColumn({ name:"description", dataIndex:"description", width:200})
			.addTextColumn({ name:"periodType", dataIndex:"periodType", width:100})
			.addTextColumn({ name:"engine", dataIndex:"engine", width:120})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.hr.payroll.dc.Payroll$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.hr_payroll_dc_Payroll$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"bd_elem_lovs_Engines", name:"engine", dataIndex:"engine", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "engineId"} 
				]})
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"periodType", dataIndex:"periodType", allowBlank:false, anchor:"-20",
				store:[ "calendar-month"]
			})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:350, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "periodType", "engine", "active"])
			.addChildrenTo("col2", ["description"])
		;
	}
});
