Ext.define("net.nan21.dnet.module.bd.elem.lovs.ElementsCode", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_elem_lovs_ElementsCode",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.elem.frame.Element_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementLovDs",
	_dataProviderName_:"ElementLovDs"
	
});
