Ext.define("net.nan21.dnet.module.bd.attr.lovs.AttributeSet", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_attr_lovs_AttributeSet",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.attr.frame.AttributeSet_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeSetLovDs",
	_dataProviderName_:"AttributeSetLovDs"
	
});
