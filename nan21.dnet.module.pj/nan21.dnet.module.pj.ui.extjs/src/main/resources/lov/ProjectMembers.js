Ext.define("net.nan21.dnet.module.pj.md.lovs.ProjectMembers", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_md_lovs_ProjectMembers",

	displayField:"member",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{role}, {member}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.pj.md.frame.Projects_UI",
		bundle:"nan21.dnet.module.pj.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ProjectMemberLovDs",
	_dataProviderName_:"ProjectMemberLovDs"
	
});
