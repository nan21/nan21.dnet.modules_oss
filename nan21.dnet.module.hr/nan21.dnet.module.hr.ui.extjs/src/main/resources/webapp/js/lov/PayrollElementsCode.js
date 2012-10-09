Ext.define("net.nan21.dnet.module.hr.payroll.lovs.PayrollElementsCode", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_payroll_lovs_PayrollElementsCode",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.payroll.frame.PayrollElement_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementLovDs",
	_dataProviderName_:"PayrollElementLovDs"
	
});
