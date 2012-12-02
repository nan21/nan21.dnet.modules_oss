/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElementValue", {
	extend: "dnet.core.dc.AbstractDc",

	filterModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementValueDsFilter",
	paramModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementValueDsParam",
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementValueDs"
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElementValue$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_payroll_dc_PayrollElementValue$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"bd_elem_lovs_ElementSets", name:"elementSet", paramIndex:"elementSet", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsParam: "elementSetId"} 
				]})
			.addLov({xtype:"hr_payroll_lovs_PayrollElementsSource", name:"element", dataIndex:"element", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "elementId"} 
				]})
			.addLov({xtype:"hr_employee_lovs_Employees", name:"employeeName", dataIndex:"employeeName", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "employeeId"} 
				]})
			.addLov({xtype:"hr_payroll_lovs_PayrollPeriods", name:"period", dataIndex:"period", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "periodId"} 
				]})
			.addLov({xtype:"bd_elem_lovs_ElementTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"employer", dataIndex:"employer", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "employerId"} 
				]})
			.addDateField({name:"periodStart_From", dataIndex:"periodStart_From", emptyText:"From" })
			.addDateField({name:"periodStart_To", dataIndex:"periodStart_To", emptyText:"To" })
			.addFieldContainer({name: "periodStart", fieldLabel:"Period Start"})
				.addChildrenTo("periodStart",["periodStart_From", "periodStart_To"])
			.addDateField({name:"periodEnd_From", dataIndex:"periodEnd_From", emptyText:"From" })
			.addDateField({name:"periodEnd_To", dataIndex:"periodEnd_To", emptyText:"To" })
			.addFieldContainer({name: "periodEnd", fieldLabel:"Period End"})
				.addChildrenTo("periodEnd",["periodEnd_From", "periodEnd_To"])
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["employer", "period", "element"])
			.addChildrenTo("col2", ["type", "elementSet", "employeeName"])
			.addChildrenTo("col3", ["periodStart", "periodEnd"])
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElementValue$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.hr_payroll_dc_PayrollElementValue$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"employer", dataIndex:"employer", width:100})
			.addTextColumn({ name:"period", dataIndex:"period", width:120})
			.addDateColumn({ name:"periodStart", dataIndex:"periodStart", format: Dnet.DATE_FORMAT})
			.addDateColumn({ name:"periodEnd", dataIndex:"periodEnd", format: Dnet.DATE_FORMAT})
			.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", hidden:true})
			.addTextColumn({ name:"element", dataIndex:"element", width:100})
			.addTextColumn({ name:"elementName", dataIndex:"elementName", width:200})
			.addTextColumn({ name:"employeeName", dataIndex:"employeeName", width:200})
			.addTextColumn({ name:"value", dataIndex:"value", width:200})
			.addTextColumn({ name:"jobCode", dataIndex:"jobCode", width:100})
			.addTextColumn({ name:"positionCode", dataIndex:"positionCode", width:100})
			.addNumberColumn({ name:"periodId", dataIndex:"periodId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"employeeId", dataIndex:"employeeId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= GRID: CtxListBalance ================= */


Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElementValue$CtxListBalance", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.hr_payroll_dc_PayrollElementValue$CtxListBalance",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"element", dataIndex:"element", width:100})
			.addTextColumn({ name:"elementName", dataIndex:"elementName", width:200})
			.addTextColumn({ name:"employeeName", dataIndex:"employeeName", width:200})
			.addTextColumn({ name:"value", dataIndex:"value", width:200})
			.addTextColumn({ name:"jobCode", dataIndex:"jobCode", width:100})
			.addTextColumn({ name:"positionCode", dataIndex:"positionCode", width:100})
			.addNumberColumn({ name:"periodId", dataIndex:"periodId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"employeeId", dataIndex:"employeeId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"elementId", dataIndex:"elementId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= E-GRID: EditList ================= */


Ext.define("net.nan21.dnet.module.hr.payroll.dc.PayrollElementValue$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.hr_payroll_dc_PayrollElementValue$EditList",
	
	_defineColumns_: function() {
		this._getBuilder_()	
			.addTextColumn({name:"employer", dataIndex:"employer", width:100,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addTextColumn({name:"period", dataIndex:"period", width:120})
			.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right"})
			.addTextColumn({name:"element", dataIndex:"element", width:100})
			.addTextColumn({name:"elementName", dataIndex:"elementName", width:200})
			.addTextColumn({name:"employeeName", dataIndex:"employeeName", width:200})
			.addTextColumn({name:"value", dataIndex:"value", width:200,
					editor:{xtype:"textfield", selectOnFocus:true}})
			.addNumberColumn({name:"periodId", dataIndex:"periodId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"employeeId", dataIndex:"employeeId", hidden:true, align:"right", width:70, format:"0"})
			.addNumberColumn({name:"elementId", dataIndex:"elementId", hidden:true, align:"right", width:70, format:"0"})
			.addDefaults();
	}
});
