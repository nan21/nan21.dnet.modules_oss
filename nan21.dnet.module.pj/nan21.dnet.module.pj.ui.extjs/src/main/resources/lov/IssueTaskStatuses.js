Ext.define("net.nan21.dnet.module.pj.base.lovs.IssueTaskStatuses", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_base_lovs_IssueTaskStatuses",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.pj.base.frame.IssueBaseData_UI",
		bundle:"nan21.dnet.module.pj.ui.extjs",
		tocElement: "canvasTaskstatus",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssueTaskStatusLovDs",
	_dataProviderName_:"IssueTaskStatusLovDs"
	
});
