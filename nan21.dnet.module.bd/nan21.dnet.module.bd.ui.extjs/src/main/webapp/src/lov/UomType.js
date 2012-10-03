Ext.define("net.nan21.dnet.module.bd.uom.lovs.UomType", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_uom_lovs_UomType",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.uom.frame.UomType_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.uom.ds.model.UomTypeLovDs",
	_dataProviderName_:"UomTypeLovDs"
	
});
