Ext.define("net.nan21.dnet.module.ad.impex.lovs.ImportJob", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_impex_lovs_ImportJob",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.impex.frame.ImportJob_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.impex.ds.model.ImportJobLovDs",
	_dataProviderName_:"ImportJobLovDs"
	
});
