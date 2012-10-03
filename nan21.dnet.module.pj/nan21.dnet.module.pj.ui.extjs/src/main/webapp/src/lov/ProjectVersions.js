Ext.define("net.nan21.dnet.module.pj.md.lovs.ProjectVersions", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_md_lovs_ProjectVersions",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.pj.md.frame.Projects_UI",
		bundle:"nan21.dnet.module.pj.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectVersionLovDs",
	_dataProviderName_:"ProjectVersionLovDs"
	
});
