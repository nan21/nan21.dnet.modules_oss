Ext.define("net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_uom_lovs_UnitsOfMeasure",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.uom.frame.UomMD_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.uom.ds.model.UomLovDs",
	_dataProviderName_:"UomLovDs"
	
});
