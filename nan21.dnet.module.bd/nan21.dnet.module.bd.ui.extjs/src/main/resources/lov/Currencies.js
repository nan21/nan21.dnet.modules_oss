Ext.define("net.nan21.dnet.module.bd.currency.lovs.Currencies", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.bd_currency_lovs_Currencies",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.bd.currency.frame.Currencies_UI",
		bundle:"nan21.dnet.module.bd.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.bd.currency.ds.model.CurrencyLovDs",
	_dataProviderName_:"CurrencyLovDs"
	
});
