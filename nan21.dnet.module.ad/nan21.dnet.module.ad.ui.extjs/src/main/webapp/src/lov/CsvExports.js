Ext.define("net.nan21.dnet.module.ad.impex.lovs.CsvExports", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_impex_lovs_CsvExports",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.impex.frame.CsvExport_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.CsvExportLovDs",
	_dataProviderName_:"CsvExportLovDs"
	
});
