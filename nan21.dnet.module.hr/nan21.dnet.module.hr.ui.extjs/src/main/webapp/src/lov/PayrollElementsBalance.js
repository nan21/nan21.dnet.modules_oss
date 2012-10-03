Ext.define("net.nan21.dnet.module.hr.payroll.lovs.PayrollElementsBalance", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_payroll_lovs_PayrollElementsBalance",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.payroll.frame.PayrollElement_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementBalanceLovDs",
	_dataProviderName_:"PayrollElementBalanceLovDs"
	
});
