/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScaleRate", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateDs",
	filterModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateDsFilter",
	paramModel: "net.nan21.dnet.module.hr.grade.ds.param.PayScaleRateDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScaleRate$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_grade_dc_PayScaleRate$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addLov({xtype:"hr_grade_lovs_PayScales", name:"payScaleCode", dataIndex:"payScaleCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "payScaleId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currencyCode", dataIndex:"currencyCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:210, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "payScaleCode"])
			.addChildrenTo("col2", ["currencyCode"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScaleRate$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.hr_grade_dc_PayScaleRate$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:120})
			.addTextColumn({ name:"payScaleCode", dataIndex:"payScaleCode", width:100})
			.addTextColumn({ name:"payScaleName", dataIndex:"payScaleName", width:200})
			.addTextColumn({ name:"currencyCode", dataIndex:"currencyCode", width:100})
			.addTextColumn({ name:"description", dataIndex:"description", width:200})
			.addBooleanColumn({ name:"active", dataIndex:"active"})
			.addNumberColumn({ name:"payScaleId", dataIndex:"payScaleId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.hr.grade.dc.PayScaleRate$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.hr_grade_dc_PayScaleRate$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addBooleanField({ name:"active", _sharedLabel_:true, dataIndex:"active", anchor:"-20"})
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", width:300})
			.addLov({xtype:"hr_grade_lovs_PayScales", name:"payScaleCode", dataIndex:"payScaleCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "payScaleId"} 
				]})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currencyCode", dataIndex:"currencyCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
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
			.addChildrenTo("col1", ["name", "payScaleCode", "currencyCode"])
			.addChildrenTo("col2", ["description", "active"])
		;
	}});
