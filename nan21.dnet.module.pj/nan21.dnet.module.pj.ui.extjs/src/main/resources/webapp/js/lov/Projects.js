Ext.define("net.nan21.dnet.module.pj.md.lovs.Projects", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_md_lovs_Projects",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.pj.md.frame.Projects_UI",
		bundle:"nan21.dnet.module.pj.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectLovDs",
	_dataProviderName_:"ProjectLovDs"
	
});
