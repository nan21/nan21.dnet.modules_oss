Ext.define("net.nan21.dnet.module.hr.payroll.lovs.PayrollPeriods", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_payroll_lovs_PayrollPeriods",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.payroll.frame.Payroll_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodLovDs",
	_dataProviderName_:"PayrollPeriodLovDs"
	
});
