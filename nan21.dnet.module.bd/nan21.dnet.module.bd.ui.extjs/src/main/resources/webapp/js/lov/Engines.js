Ext.define("net.nan21.dnet.module.bd.elem.lovs.Engines", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_elem_lovs_Engines",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.elem.frame.ElementBaseData_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		tocElement: "canvasEngine",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.elem.ds.model.EngineLovDs",
	_dataProviderName_:"EngineLovDs"
	
});
