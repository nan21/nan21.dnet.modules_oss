/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.grade.dc.GradeRate", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.GradeRateDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.grade.dc.GradeRate$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_grade_dc_GradeRate$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currencyCode", dataIndex:"currencyCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
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
			.addChildrenTo("col1", ["name", "currencyCode"])
			.addChildrenTo("col2", ["active"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.hr.grade.dc.GradeRate$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.hr_grade_dc_GradeRate$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:120})
			.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, width:70, format:"0"})
			.addTextColumn({ name:"currencyCode", dataIndex:"currencyCode", width:100})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addTextColumn({ name:"description", dataIndex:"description", width:200})
			.addDefaults();
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.hr.grade.dc.GradeRate$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.hr_grade_dc_GradeRate$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", width:300})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currencyCode", dataIndex:"currencyCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:320, layout:"form", defaults:{labelAlign:"top"}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "currencyCode", "active"])
			.addChildrenTo("col2", ["description"])
		;
	}
});
