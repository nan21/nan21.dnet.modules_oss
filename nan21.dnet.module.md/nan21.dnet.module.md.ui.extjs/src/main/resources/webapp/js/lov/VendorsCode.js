Ext.define("net.nan21.dnet.module.md.bp.lovs.VendorsCode", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_bp_lovs_VendorsCode",

	displayField:"code",
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
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.VendorLovDs",
	_dataProviderName_:"VendorLovDs"
	
});
