Ext.define("net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_org_lovs_LegalEntityOrganizations",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.org.frame.Org_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		tocElement: "canvasOrg",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.LegalEntityOrganizationLovDs",
	_dataProviderName_:"LegalEntityOrganizationLovDs"
	
});
