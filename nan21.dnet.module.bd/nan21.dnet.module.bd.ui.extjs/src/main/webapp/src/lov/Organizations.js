Ext.define("net.nan21.dnet.module.bd.org.lovs.Organizations", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_org_lovs_Organizations",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.org.frame.Org_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationLovDs",
	_dataProviderName_:"OrganizationLovDs"
	
});
