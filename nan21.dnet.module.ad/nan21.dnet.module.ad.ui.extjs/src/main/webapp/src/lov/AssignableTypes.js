Ext.define("net.nan21.dnet.module.ad.usr.lovs.AssignableTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_usr_lovs_AssignableTypes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.usr.frame.Assignables_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		tocElement: "canvasType",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.AssignableTypeLovDs",
	_dataProviderName_:"AssignableTypeLovDs"
	
});
