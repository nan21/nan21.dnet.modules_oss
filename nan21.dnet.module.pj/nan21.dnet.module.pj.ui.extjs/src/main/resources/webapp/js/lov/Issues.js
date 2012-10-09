Ext.define("net.nan21.dnet.module.pj.md.lovs.Issues", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_md_lovs_Issues",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {summary}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.pj.md.frame.Issues_UI",
		bundle:"nan21.dnet.module.pj.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueLovDs",
	_dataProviderName_:"IssueLovDs"
	
});
