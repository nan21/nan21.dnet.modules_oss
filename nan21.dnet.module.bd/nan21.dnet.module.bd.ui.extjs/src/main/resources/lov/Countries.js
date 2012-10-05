Ext.define("net.nan21.dnet.module.bd.geo.lovs.Countries", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_geo_lovs_Countries",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.geo.frame.CountryMD_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.CountryLovDs",
	_dataProviderName_:"CountryLovDs"
	
});
