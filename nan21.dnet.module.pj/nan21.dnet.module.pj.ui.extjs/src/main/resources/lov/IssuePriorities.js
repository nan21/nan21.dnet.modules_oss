Ext.define("net.nan21.dnet.module.pj.base.lovs.IssuePriorities", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_base_lovs_IssuePriorities",

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
		tocElement: "canvasPriority",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssuePriorityLovDs",
	_dataProviderName_:"IssuePriorityLovDs"
	
});
