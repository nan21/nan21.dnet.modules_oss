Ext.define("net.nan21.dnet.module.md.org.lovs.StockLocators", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_org_lovs_StockLocators",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.org.frame.SubInventories_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.org.ds.model.StockLocatorLovDs",
	_dataProviderName_:"StockLocatorLovDs"
	
});
