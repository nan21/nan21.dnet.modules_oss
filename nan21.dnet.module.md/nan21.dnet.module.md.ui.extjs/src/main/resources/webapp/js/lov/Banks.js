Ext.define("net.nan21.dnet.module.md.bp.lovs.Banks", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_bp_lovs_Banks",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.bp.frame.Bank_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.BankLovDs",
	_dataProviderName_:"BankLovDs"
	
});
