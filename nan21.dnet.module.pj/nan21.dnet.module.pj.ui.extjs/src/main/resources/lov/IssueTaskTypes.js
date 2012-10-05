Ext.define("net.nan21.dnet.module.pj.base.lovs.IssueTaskTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_base_lovs_IssueTaskTypes",

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
		tocElement: "canvasTasktype",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssueTaskTypeLovDs",
	_dataProviderName_:"IssueTaskTypeLovDs"
	
});
