Ext.define("net.nan21.dnet.module.md.base.tax.lovs.TaxCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_base_tax_lovs_TaxCategories",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.base.tax.frame.TaxCategories_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.base.tax.ds.model.TaxCategoryLovDs",
	_dataProviderName_:"TaxCategoryLovDs"
	
});
