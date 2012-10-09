Ext.define("net.nan21.dnet.module.hr.employee.lovs.Employees", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_employee_lovs_Employees",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.employee.frame.Employee_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeLovDs",
	_dataProviderName_:"EmployeeLovDs"
	
});
