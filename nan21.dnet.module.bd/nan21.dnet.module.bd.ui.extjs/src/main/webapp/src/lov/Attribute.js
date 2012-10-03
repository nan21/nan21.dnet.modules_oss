Ext.define("net.nan21.dnet.module.bd.attr.lovs.Attribute", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_attr_lovs_Attribute",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.attr.frame.Attributes_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeLovDs",
	_dataProviderName_:"AttributeLovDs"
	
});
