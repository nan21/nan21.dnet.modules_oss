Ext.define("net.nan21.dnet.module.md.mm.prod.lovs.ProductCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_mm_prod_lovs_ProductCategories",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.mm.prod.frame.ProductCategory_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductCategoryLovDs",
	_dataProviderName_:"ProductCategoryLovDs"
	
});
