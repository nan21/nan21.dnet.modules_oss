/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.time.dc.Absence", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceDs",
	filterModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceDsFilter",
	paramModel: "net.nan21.dnet.module.hr.time.ds.param.AbsenceDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.time.dc.Absence$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_time_dc_Absence$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"employeeCode", dataIndex:"employeeCode", disabled:true , anchor:"-20", maxLength:32})
			.addLov({xtype:"hr_employee_lovs_Employees", name:"employee", dataIndex:"employee", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "employeeId"} 
				]})
			.addLov({xtype:"hr_time_lovs_AbsenceTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			.addLov({xtype:"hr_time_lovs_AbsenceReasons", name:"reason", dataIndex:"reason", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "reasonId"} 
				]})
			.addDateField({name:"eventDate", dataIndex:"eventDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addNumberField({name:"hours", dataIndex:"hours", anchor:"-20"})
			.addDateField({name:"from", paramIndex:"from", anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"to", paramIndex:"to", anchor:"-20", format:Ext.DATE_FORMAT})
			.addBooleanField({ name:"posted", dataIndex:"posted", anchor:"-20"})
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
			.addChildrenTo("col1", ["employee", "type", "reason"])
			.addChildrenTo("col2", ["from", "to", "posted"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.hr.time.dc.Absence$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.hr_time_dc_Absence$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"employeeCode", dataIndex:"employeeCode", width:100})
			.addTextColumn({ name:"employee", dataIndex:"employee", width:200})
			.addTextColumn({ name:"type", dataIndex:"type", width:120})
			.addTextColumn({ name:"reason", dataIndex:"reason", width:120})
			.addDateColumn({ name:"eventDate", dataIndex:"eventDate", format: Dnet.DATE_FORMAT})
			.addNumberColumn({ name:"hours", dataIndex:"hours"})
			.addTextColumn({ name:"notes", dataIndex:"notes", width:200})
			.addBooleanColumn({ name:"posted", dataIndex:"posted"})
			.addNumberColumn({ name:"employeeId", dataIndex:"employeeId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"typeId", dataIndex:"typeId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"reasonId", dataIndex:"reasonId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.hr.time.dc.Absence$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.hr_time_dc_Absence$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"hr_employee_lovs_Employees", name:"employee", dataIndex:"employee", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "employeeId"} 
				]})
			.addLov({xtype:"hr_time_lovs_AbsenceTypes", name:"type", _sharedLabel_:true, dataIndex:"type", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			.addLov({xtype:"hr_time_lovs_AbsenceReasons", name:"reason", dataIndex:"reason", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "reasonId"} 
				],
				filterFieldMapping: [
					{lovField:"typeId",dsField: "typeId"} 
				]})
			.addDateField({name:"eventDate", dataIndex:"eventDate", allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			.addNumberField({name:"hours", dataIndex:"hours", allowBlank:false, width:80})
			.addTextArea({ name:"notes", _sharedLabel_:true, dataIndex:"notes", anchor:"-20"})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:400, layout:"form", defaults:{labelAlign:"top"}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["employee", "type", "reason"])
			.addChildrenTo("col2", ["eventDate", "hours"])
			.addChildrenTo("col3", ["notes"])
		;
	}});
