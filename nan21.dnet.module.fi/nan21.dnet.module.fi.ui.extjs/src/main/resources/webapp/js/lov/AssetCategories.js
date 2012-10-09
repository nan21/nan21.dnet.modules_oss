Ext.define("net.nan21.dnet.module.fi.asset.lovs.AssetCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.fi_asset_lovs_AssetCategories",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.fi.asset.frame.AssetBaseData_UI",
		bundle:"nan21.dnet.module.fi.ui.extjs",
		tocElement: "canvasCateg",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.fi.asset.ds.model.AssetCategoryLovDs",
	_dataProviderName_:"AssetCategoryLovDs"
	
});
