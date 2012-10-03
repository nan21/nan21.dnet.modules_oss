Ext.define("net.nan21.dnet.module.md.mm.prod.lovs.ProductAccountGroups", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_mm_prod_lovs_ProductAccountGroups",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.mm.prod.frame.ProductAccountGroup_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountGroupLovDs",
	_dataProviderName_:"ProductAccountGroupLovDs"
	
});
