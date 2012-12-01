/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeAssignmentDs",
	filterModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeAssignmentDsFilter",
	paramModel: "net.nan21.dnet.module.hr.employee.ds.param.EmployeeAssignmentDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_employee_dc_EmployeeAssignment$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"employeeCode", dataIndex:"employeeCode", anchor:"-20", maxLength:32})
			.addTextField({ name:"firstName", dataIndex:"firstName", anchor:"-20"})
			.addTextField({ name:"lastName", dataIndex:"lastName", anchor:"-20"})
			.addDateField({name:"validAt", paramIndex:"validAt", anchor:"-20", format:Ext.DATE_FORMAT})
			.addLov({xtype:"hr_employee_lovs_Employees", name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "employeeId"} 
				]})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"employerCode", dataIndex:"employerCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "employerId"} 
				]})
			.addLov({xtype:"hr_employee_lovs_EmploymentTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			.addLov({xtype:"hr_job_lovs_Jobs", name:"job", dataIndex:"jobCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "jobId"} 
				]})
			.addLov({xtype:"hr_job_lovs_Positions", name:"position", dataIndex:"positionCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "positionId"} 
				]})
			.addLov({xtype:"hr_payroll_lovs_Payrolls", name:"payroll", dataIndex:"payroll", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "payrollId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:220, layout:"form"})
			.addPanel({ name:"col2", width:220, layout:"form"})
			.addPanel({ name:"col3", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["employerCode", "firstName", "lastName", "employeeCode"])
			.addChildrenTo("col2", ["type", "payroll", "validAt"])
			.addChildrenTo("col3", ["job", "position", "name"])
		;
	}
});


/* ================= FILTER: FilterCtx ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$FilterCtx", {
	extend: "dnet.core.dc.AbstractDcvFilterPropGrid",
	alias: "widget.hr_employee_dc_EmployeeAssignment$FilterCtx",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"hr_employee_lovs_EmploymentTypes", name:"type", _sharedLabel_:true, dataIndex:"type", anchor:"-20",
				editor:{_fqn_:"net.nan21.dnet.module.hr.employee.lovs.EmploymentTypes", selectOnFocus:true,
					retFieldMapping: [
						{lovField:"id", dsField: "typeId"} 
					]}})
			.addDateField({name:"validAt", dataIndex:"validFrom", anchor:"-20", format:Ext.DATE_FORMAT})
		;
	}
});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.hr_employee_dc_EmployeeAssignment$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"employeeCode", dataIndex:"employeeCode", width:100})
			.addTextColumn({ name:"firstName", dataIndex:"firstName", width:100})
			.addTextColumn({ name:"lastName", dataIndex:"lastName", width:100})
			.addTextColumn({ name:"employerCode", dataIndex:"employerCode", width:100})
			.addDateColumn({ name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT})
			.addDateColumn({ name:"validTo", dataIndex:"validTo", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"type", dataIndex:"type", width:120})
			.addTextColumn({ name:"positionCode", dataIndex:"positionCode", width:100})
			.addTextColumn({ name:"positionName", dataIndex:"positionName", hidden:true, width:200})
			.addTextColumn({ name:"org", dataIndex:"org", width:100})
			.addTextColumn({ name:"jobCode", dataIndex:"jobCode", width:100})
			.addTextColumn({ name:"jobName", dataIndex:"jobName", hidden:true, width:200})
			.addDefaults();
	}
});


/* ================= GRID: CtxList ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.hr_employee_dc_EmployeeAssignment$CtxList",

	_defineColumns_: function() {
		this._getBuilder_()
			.addDateColumn({ name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT})
			.addDateColumn({ name:"validTo", dataIndex:"validTo", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"type", dataIndex:"type", width:120})
			.addBooleanColumn({ name:"assignToPosition", dataIndex:"assignToPosition"})
			.addTextColumn({ name:"positionCode", dataIndex:"positionCode", width:100})
			.addTextColumn({ name:"positionName", dataIndex:"positionName", hidden:true, width:200})
			.addTextColumn({ name:"posOrg", dataIndex:"posOrg", width:100})
			.addTextColumn({ name:"jobCode", dataIndex:"jobCode", width:100})
			.addTextColumn({ name:"jobName", dataIndex:"jobName", hidden:true, width:200})
			.addTextColumn({ name:"org", dataIndex:"org", width:100})
			.addTextColumn({ name:"gradeCode", dataIndex:"gradeCode", width:100})
			.addTextColumn({ name:"payroll", dataIndex:"payroll", width:120})
			.addNumberColumn({ name:"baseSalary", dataIndex:"baseSalary", decimals:2})
			.addTextColumn({ name:"typeId", dataIndex:"typeId", hidden:true, width:70})
			.addNumberColumn({ name:"gradeId", dataIndex:"gradeId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"payrollId", dataIndex:"payrollId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"posOrgId", dataIndex:"posOrgId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= GRID: CtxListJobPos ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$CtxListJobPos", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.hr_employee_dc_EmployeeAssignment$CtxListJobPos",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"employerCode", dataIndex:"employerCode", width:100})
			.addTextColumn({ name:"type", dataIndex:"type", width:120})
			.addDateColumn({ name:"validFrom", dataIndex:"validFrom", format: Dnet.DATE_FORMAT})
			.addDateColumn({ name:"validTo", dataIndex:"validTo", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"firstName", dataIndex:"firstName", width:200})
			.addTextColumn({ name:"lastName", dataIndex:"lastName", width:200})
			.addTextColumn({ name:"employeeCode", dataIndex:"employeeCode", width:100})
			.addTextColumn({ name:"gradeCode", dataIndex:"gradeCode", width:100})
			.addTextColumn({ name:"payroll", dataIndex:"payroll", hidden:true, width:120})
			.addTextColumn({ name:"typeId", dataIndex:"typeId", hidden:true, width:70})
			.addNumberColumn({ name:"gradeId", dataIndex:"gradeId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"payrollId", dataIndex:"payrollId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}
});


/* ================= EDITOR: EditEmployee ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$EditEmployee", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.hr_employee_dc_EmployeeAssignment$EditEmployee",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addLov({xtype:"hr_employee_lovs_Employees", name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "employeeId"} ,{lovField:"name", dsField: "name"} ,{lovField:"code", dsField: "employeeCode"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:400, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["name"])
		;
	}
});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.EmployeeAssignment$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.hr_employee_dc_EmployeeAssignment$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDateField({name:"validFrom", dataIndex:"validFrom", allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"validTo", dataIndex:"validTo", anchor:"-20", format:Ext.DATE_FORMAT})
			.addBooleanField({ name:"assignToPosition", dataIndex:"assignToPosition", anchor:"-20",listeners:{
				change:{scope:this, fn:this.onAssignToPositionChange}
			}
			})
			.addLov({xtype:"hr_employee_lovs_EmploymentTypes", name:"type", _sharedLabel_:true, dataIndex:"type", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "typeId"} 
				]})
			.addLov({xtype:"hr_job_lovs_Positions", name:"positionCode", dataIndex:"positionCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "positionId"} ,{lovField:"name", dsField: "positionName"} 
				]})
			.addDisplayFieldText({ name:"positionName", dataIndex:"positionName", anchor:"-20"})
			.addLov({xtype:"hr_job_lovs_Jobs", name:"jobCode", dataIndex:"jobCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "jobId"} ,{lovField:"name", dsField: "jobName"} 
				]})
			.addDisplayFieldText({ name:"jobName", dataIndex:"jobName", anchor:"-20"})
			.addLov({xtype:"hr_grade_lovs_Grades", name:"gradeCode", dataIndex:"gradeCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "gradeId"} 
				]})
			.addLov({xtype:"bd_org_lovs_Organizations", name:"org", dataIndex:"org", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "orgId"} 
				]})
			.addNumberField({name:"baseSalary", dataIndex:"baseSalary", anchor:"-20", decimals:2})
			.addLov({xtype:"hr_payroll_lovs_Payrolls", name:"payroll", dataIndex:"payroll", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "payrollId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form", defaults:{labelAlign:"right", labelWidth:110}})
			.addPanel({ name:"col2", width:250, layout:"form", defaults:{labelAlign:"right", labelWidth:110}})
			.addPanel({ name:"col3", width:350, layout:"form", defaults:{labelAlign:"right", labelWidth:110}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["validFrom", "validTo", "type", "payroll", "baseSalary"])
			.addChildrenTo("col2", ["assignToPosition", "positionCode", "jobCode", "org"])
			.addChildrenTo("col3", ["gradeCode", "positionName", "jobName"])
		;
	},
	
	/* ==================== Business functions ==================== */
	
	onAssignToPositionChange: function() {
		var r = this._getController_().getRecord();
				if (r.get("assignToPosition")) {
					r.set("jobId", "");
		            r.set("jobCode", "");
		            r.set("jobName", "");
		
		            r.set("organizationId", "");
		            r.set("org", "");
		            r.set("organizationName", "");
				} else {
		            r.set("positionId", "");
		            r.set("positionCode", "");
		            r.set("positionName", "");
				}
				this._doEnableJobOrPosition_(r.data.assignToPosition);
	},
	
	_doEnableJobOrPosition_: function(enablePosition) {
		if (enablePosition) {
					this._getElement_("positionCode").enable();
					this._getElement_("jobCode").disable();
		            this._getElement_("org").disable();
				} else {
					this._getElement_("positionCode").disable();
					this._getElement_("jobCode").enable();
		            this._getElement_("org").enable();
				}
	},
	
	_afterBind_: function(record) {
		if (record) {
					this._doEnableJobOrPosition_(record.data.assignToPosition);
				}
	}

});
