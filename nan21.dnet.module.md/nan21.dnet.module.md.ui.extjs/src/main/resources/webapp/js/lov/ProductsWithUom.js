Ext.define("net.nan21.dnet.module.md.mm.prod.lovs.ProductsWithUom", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_mm_prod_lovs_ProductsWithUom",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}, {uom}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.mm.prod.frame.Product_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductWithUomLovDs",
	_dataProviderName_:"ProductWithUomLovDs"
	
});
