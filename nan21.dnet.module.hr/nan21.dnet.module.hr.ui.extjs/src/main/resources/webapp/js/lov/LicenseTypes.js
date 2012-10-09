Ext.define("net.nan21.dnet.module.hr.employee.lovs.LicenseTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_employee_lovs_LicenseTypes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		tocElement: "canvasLicType",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.LicenseTypeLovDs",
	_dataProviderName_:"LicenseTypeLovDs"
	
});
