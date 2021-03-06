Ext.define("net.nan21.dnet.module.ad.usr.lovs.UserGroups", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_usr_lovs_UserGroups",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.usr.frame.UserGroups_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.usr.ds.model.UserGroupLovDs",
	_dataProviderName_:"UserGroupLovDs"
	
});
