Ext.define("net.nan21.dnet.module.md.base.period.lovs.FiscalYears", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_base_period_lovs_FiscalYears",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.base.period.frame.FiscalYear_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.base.period.ds.model.FiscalYearLovDs",
	_dataProviderName_:"FiscalYearLovDs"
	
});
