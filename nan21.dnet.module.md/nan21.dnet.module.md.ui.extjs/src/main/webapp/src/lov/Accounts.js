Ext.define("net.nan21.dnet.module.md.acc.lovs.Accounts", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_acc_lovs_Accounts",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.acc.frame.Account_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.acc.ds.model.AccountLovDs",
	_dataProviderName_:"AccountLovDs"
	
});
