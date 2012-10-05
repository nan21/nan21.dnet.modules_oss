Ext.define("net.nan21.dnet.module.bd.standards.lovs.ClassificationItems", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_standards_lovs_ClassificationItems",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.standards.frame.Classifications_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		tocElement: "canvasClasscode",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.standards.ds.model.ClassificationItemLovDs",
	_dataProviderName_:"ClassificationItemLovDs"
	
});
