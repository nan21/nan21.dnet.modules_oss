Ext.define("net.nan21.dnet.module.md.mm.price.lovs.PriceListSales", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_mm_price_lovs_PriceListSales",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.mm.price.frame.PriceList_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.mm.price.ds.model.PriceListSalesLovDs",
	_dataProviderName_:"PriceListSalesLovDs"
	
});
