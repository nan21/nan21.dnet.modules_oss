Ext.define("net.nan21.dnet.module.hr.employee.lovs.EmployeeContactRelationships", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_employee_lovs_EmployeeContactRelationships",

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
		tocElement: "canvasContactRel",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactRelationshipLovDs",
	_dataProviderName_:"EmployeeContactRelationshipLovDs"
	
});
