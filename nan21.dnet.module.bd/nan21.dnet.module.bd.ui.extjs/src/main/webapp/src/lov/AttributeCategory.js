Ext.define("net.nan21.dnet.module.bd.attr.lovs.AttributeCategory", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_attr_lovs_AttributeCategory",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.attr.frame.AttributeBaseData_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		tocElement: "canvasCateg",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.attr.ds.model.AttributeCategoryLovDs",
	_dataProviderName_:"AttributeCategoryLovDs"
	
});
