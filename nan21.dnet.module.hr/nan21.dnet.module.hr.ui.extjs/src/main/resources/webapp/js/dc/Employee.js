/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeDs",
	filterModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeDsFilter",
	paramModel: "net.nan21.dnet.module.hr.employee.ds.param.EmployeeDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.hr_employee_dc_Employee$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addTextField({ name:"firstName", dataIndex:"firstName", anchor:"-20"})
			.addTextField({ name:"lastName", dataIndex:"lastName", anchor:"-20"})
			.addCombo({ xtype:"combo", name:"gender", dataIndex:"gender", anchor:"-20",
				store:[ "male", "female"]
			})
			.addCombo({ xtype:"combo", name:"maritalStatus", dataIndex:"maritalStatus", anchor:"-20",
				store:[ "single", "married", "divorced", "widow", "other"]
			})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"employerCode", dataIndex:"employerCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "employerId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:220, layout:"form"})
			.addPanel({ name:"col2", width:220, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["employerCode", "firstName", "lastName", "code"])
			.addChildrenTo("col2", ["gender", "maritalStatus"])
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.hr_employee_dc_Employee$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"employerCode", dataIndex:"employerCode", width:100})
			.addTextColumn({ name:"code", dataIndex:"code", width:100})
			.addTextColumn({ name:"firstName", dataIndex:"firstName", width:100})
			.addTextColumn({ name:"middleName", dataIndex:"middleName", width:200})
			.addTextColumn({ name:"lastName", dataIndex:"lastName", width:100})
			.addTextColumn({ name:"gender", dataIndex:"gender", width:60})
			.addTextColumn({ name:"maritalStatus", dataIndex:"maritalStatus", width:60})
			.addDateColumn({ name:"currentHireDate", dataIndex:"currentHireDate", format: Dnet.DATE_FORMAT})
			.addDateColumn({ name:"firstHireDate", dataIndex:"firstHireDate", format: Dnet.DATE_FORMAT})
			.addTextColumn({ name:"officeEmail", dataIndex:"officeEmail", width:100})
			.addTextColumn({ name:"citizenshipCode", dataIndex:"citizenshipCode", hidden:true, width:100})
			.addDateColumn({ name:"birthdate", dataIndex:"birthdate", format: Dnet.DATE_FORMAT})
			.addDefaults();
	}});


/* ================= EDITOR: EditMain ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee$EditMain", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.hr_employee_dc_Employee$EditMain",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"firstName", dataIndex:"firstName", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"lastName", dataIndex:"lastName", allowBlank:false, anchor:"-20"})
			.addTextField({ name:"middleName", dataIndex:"middleName", anchor:"-20"})
			.addTextField({ name:"code", _sharedLabel_:true, dataIndex:"code", anchor:"-20", maxLength:32})
			.addLov({xtype:"bd_org_lovs_LegalEntityOrganizations", name:"employerCode", dataIndex:"employerCode", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "employerId"} 
				]})
			.addDateField({name:"birthdate", dataIndex:"birthdate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addCombo({ xtype:"combo", name:"gender", dataIndex:"gender", anchor:"-20",
				store:[ "male", "female"]
			})
			.addCombo({ xtype:"combo", name:"maritalStatus", dataIndex:"maritalStatus", anchor:"-20",
				store:[ "single", "married", "divorced", "widow", "other"]
			})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
			.addPanel({ name:"col3", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["lastName", "firstName", "middleName"])
			.addChildrenTo("col2", ["employerCode", "code"])
			.addChildrenTo("col3", ["gender", "birthdate", "maritalStatus"])
		;
	}});


/* ================= EDITOR: EditOther ================= */


Ext.define("net.nan21.dnet.module.hr.employee.dc.Employee$EditOther", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.hr_employee_dc_Employee$EditOther",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addDateField({name:"firstHireDate", dataIndex:"firstHireDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addDateField({name:"currentHireDate", dataIndex:"currentHireDate", anchor:"-20", format:Ext.DATE_FORMAT})
			.addTextField({ name:"officeEmail", dataIndex:"officeEmail", anchor:"-20"})
			.addBooleanField({ name:"hasDisability", dataIndex:"hasDisability", anchor:"-20"})
			.addLov({xtype:"bd_geo_lovs_Countries", name:"citizenshipCode", dataIndex:"citizenshipCode", anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "citizenshipId"} 
				]})
			.addTextField({ name:"passportNo", dataIndex:"passportNo", anchor:"-20", maxLength:32})
			.addTextField({ name:"sinNo", dataIndex:"sinNo", anchor:"-20", maxLength:32})
			.addTextField({ name:"ssnNo", dataIndex:"ssnNo", anchor:"-20", maxLength:32})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:300, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1"])
			.addChildrenTo("col1", ["citizenshipCode", "passportNo", "ssnNo", "sinNo", "officeEmail", "currentHireDate", "firstHireDate"])
		;
	}});
