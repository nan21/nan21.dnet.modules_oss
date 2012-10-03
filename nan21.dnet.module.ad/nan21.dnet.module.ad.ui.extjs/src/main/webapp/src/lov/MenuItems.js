Ext.define("net.nan21.dnet.module.ad.usr.lovs.MenuItems", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_usr_lovs_MenuItems",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.usr.frame.Menu_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		tocElement: "canvasItem",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.MenuItemLovDs",
	_dataProviderName_:"MenuItemLovDs"
	
});
