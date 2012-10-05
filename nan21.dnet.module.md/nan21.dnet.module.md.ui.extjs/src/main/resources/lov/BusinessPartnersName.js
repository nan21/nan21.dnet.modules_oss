Ext.define("net.nan21.dnet.module.md.bp.lovs.BusinessPartnersName", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_bp_lovs_BusinessPartnersName",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.bp.frame.BPartner_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.BusinessPartnerLovDs",
	_dataProviderName_:"BusinessPartnerLovDs"
	
});
