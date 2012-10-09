Ext.define("net.nan21.dnet.module.md.base.tax.lovs.Taxes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_base_tax_lovs_Taxes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.base.tax.frame.Tax_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.base.tax.ds.model.TaxLovDs",
	_dataProviderName_:"TaxLovDs"
	
});
