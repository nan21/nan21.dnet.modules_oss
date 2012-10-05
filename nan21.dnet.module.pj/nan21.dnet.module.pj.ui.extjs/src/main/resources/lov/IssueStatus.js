Ext.define("net.nan21.dnet.module.pj.base.lovs.IssueStatus", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_base_lovs_IssueStatus",

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
		tocElement: "canvasStatus",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssueStatusLovDs",
	_dataProviderName_:"IssueStatusLovDs"
	
});
