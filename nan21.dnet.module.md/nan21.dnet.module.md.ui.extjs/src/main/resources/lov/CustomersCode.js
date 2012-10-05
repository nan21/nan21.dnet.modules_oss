Ext.define("net.nan21.dnet.module.md.bp.lovs.CustomersCode", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_bp_lovs_CustomersCode",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.bp.frame.BPartner_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.CustomerLovDs",
	_dataProviderName_:"CustomerLovDs"
	
});
