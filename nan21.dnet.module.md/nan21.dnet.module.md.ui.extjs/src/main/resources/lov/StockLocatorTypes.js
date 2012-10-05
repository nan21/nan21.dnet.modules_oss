Ext.define("net.nan21.dnet.module.md.org.lovs.StockLocatorTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_org_lovs_StockLocatorTypes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.org.frame.StockLocatorTypes_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.org.ds.model.StockLocatorTypeLovDs",
	_dataProviderName_:"StockLocatorTypeLovDs"
	
});
