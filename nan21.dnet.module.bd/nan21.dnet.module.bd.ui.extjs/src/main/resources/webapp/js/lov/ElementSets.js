Ext.define("net.nan21.dnet.module.bd.elem.lovs.ElementSets", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_elem_lovs_ElementSets",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.elem.frame.ElementSet_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementSetLovDs",
	_dataProviderName_:"ElementSetLovDs"
	
});
