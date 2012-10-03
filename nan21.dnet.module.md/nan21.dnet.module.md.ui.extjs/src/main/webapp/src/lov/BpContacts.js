Ext.define("net.nan21.dnet.module.md.bp.lovs.BpContacts", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_bp_lovs_BpContacts",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.bp.frame.Contact_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.BpContactLovDs",
	_dataProviderName_:"BpContactLovDs"
	
});
