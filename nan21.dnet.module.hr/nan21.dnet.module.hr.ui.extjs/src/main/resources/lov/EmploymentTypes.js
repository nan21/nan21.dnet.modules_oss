Ext.define("net.nan21.dnet.module.hr.employee.lovs.EmploymentTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_employee_lovs_EmploymentTypes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		tocElement: "canvasAsgnType",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmploymentTypeLovDs",
	_dataProviderName_:"EmploymentTypeLovDs"
	
});
