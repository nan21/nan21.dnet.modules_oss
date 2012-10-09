Ext.define("net.nan21.dnet.module.md.org.lovs.FinancialAccounts", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_org_lovs_FinancialAccounts",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}, {currency}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.org.frame.FinancialAccount_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.org.ds.model.FinancialAccountLovDs",
	_dataProviderName_:"FinancialAccountLovDs"
	
});
