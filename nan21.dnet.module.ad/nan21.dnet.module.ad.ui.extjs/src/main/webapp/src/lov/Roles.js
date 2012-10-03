Ext.define("net.nan21.dnet.module.ad.usr.lovs.Roles", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_usr_lovs_Roles",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.usr.frame.Role_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.RoleLovDs",
	_dataProviderName_:"RoleLovDs"
	
});
