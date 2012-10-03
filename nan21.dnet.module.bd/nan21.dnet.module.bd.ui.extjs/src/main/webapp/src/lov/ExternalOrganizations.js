Ext.define("net.nan21.dnet.module.bd.org.lovs.ExternalOrganizations", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_org_lovs_ExternalOrganizations",

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
		tocElement: "canvasOrg",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.ExternalOrganizationLovDs",
	_dataProviderName_:"ExternalOrganizationLovDs"
	
});
