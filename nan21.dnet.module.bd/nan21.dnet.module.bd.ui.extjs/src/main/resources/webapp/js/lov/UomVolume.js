Ext.define("net.nan21.dnet.module.bd.uom.lovs.UomVolume", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_uom_lovs_UomVolume",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.uom.frame.UomMD_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.uom.ds.model.UomVolumeLovDs",
	_dataProviderName_:"UomVolumeLovDs"
	
});
