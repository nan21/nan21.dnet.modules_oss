Ext.define("net.nan21.dnet.module.ad.report.lovs.ReportServers", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_report_lovs_ReportServers",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.report.frame.ReportServers_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.report.ds.model.ReportServerLovDs",
	_dataProviderName_:"ReportServerLovDs"
	
});
