Ext.define("net.nan21.dnet.module.md.mm.prod.lovs.ProductManufacturers", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_mm_prod_lovs_ProductManufacturers",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.mm.prod.frame.ProductBaseData_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		tocElement: "canvasManufact",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.mm.prod.ds.model.ProductManufacturerLovDs",
	_dataProviderName_:"ProductManufacturerLovDs"
	
});
