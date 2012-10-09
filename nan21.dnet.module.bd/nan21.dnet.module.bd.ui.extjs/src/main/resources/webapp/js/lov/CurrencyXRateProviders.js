Ext.define("net.nan21.dnet.module.bd.currency.lovs.CurrencyXRateProviders", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_currency_lovs_CurrencyXRateProviders",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.currency.frame.CurrencyXrateProvider_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateProviderLovDs",
	_dataProviderName_:"CurrencyXRateProviderLovDs"
	
});
