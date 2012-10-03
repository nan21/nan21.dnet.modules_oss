Ext.define("net.nan21.dnet.module.bd.geo.lovs.Locations", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_geo_lovs_Locations",

	displayField:"asString",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{asString}</span>';
		},
		width:250
	},
	recordModel: "net.nan21.dnet.module.bd.geo.ds.model.LocationLovDs",
	_dataProviderName_:"LocationLovDs"
	
});
