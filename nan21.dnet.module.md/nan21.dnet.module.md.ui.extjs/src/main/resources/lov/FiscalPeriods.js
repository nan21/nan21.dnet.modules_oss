Ext.define("net.nan21.dnet.module.md.base.period.lovs.FiscalPeriods", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_base_period_lovs_FiscalPeriods",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.base.period.frame.FiscalPeriod_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.base.period.ds.model.FiscalPeriodLovDs",
	_dataProviderName_:"FiscalPeriodLovDs"
	
});
