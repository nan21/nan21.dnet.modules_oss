Ext.define("net.nan21.dnet.module.ad.usr.lovs.UserTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_usr_lovs_UserTypes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.usr.frame.UserTypes_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.UserTypeLovDs",
	_dataProviderName_:"UserTypeLovDs"
	
});
