Ext.define("net.nan21.dnet.module.pj.base.lovs.ProjectRoles", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_base_lovs_ProjectRoles",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.pj.base.frame.ProjectBaseData_UI",
		bundle:"nan21.dnet.module.pj.ui.extjs",
		tocElement: "canvasRole",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.ProjectRoleLovDs",
	_dataProviderName_:"ProjectRoleLovDs"
	
});
