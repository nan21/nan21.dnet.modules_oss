Ext.define("net.nan21.dnet.module.bd.elem.lovs.ElementTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_elem_lovs_ElementTypes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.elem.frame.ElementBaseData_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		tocElement: "canvasType",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.ElementTypeLovDs",
	_dataProviderName_:"ElementTypeLovDs"
	
});
