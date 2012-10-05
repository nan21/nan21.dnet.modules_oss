Ext.define("net.nan21.dnet.module.ad.impex.lovs.ExportMaps", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_impex_lovs_ExportMaps",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.impex.frame.ExportMap_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ExportMapLovDs",
	_dataProviderName_:"ExportMapLovDs"
	
});
