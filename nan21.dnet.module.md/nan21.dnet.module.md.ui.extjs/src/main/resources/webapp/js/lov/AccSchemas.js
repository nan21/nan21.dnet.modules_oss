Ext.define("net.nan21.dnet.module.md.acc.lovs.AccSchemas", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.md_acc_lovs_AccSchemas",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.md.acc.frame.AccSchema_UI",
		bundle:"nan21.dnet.module.md.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.md.acc.ds.model.AccSchemaLovDs",
	_dataProviderName_:"AccSchemaLovDs"
	
});
