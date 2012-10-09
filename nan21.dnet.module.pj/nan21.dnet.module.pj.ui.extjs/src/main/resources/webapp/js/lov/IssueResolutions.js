Ext.define("net.nan21.dnet.module.pj.base.lovs.IssueResolutions", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_base_lovs_IssueResolutions",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.pj.base.frame.IssueBaseData_UI",
		bundle:"nan21.dnet.module.pj.ui.extjs",
		tocElement: "canvasResolution",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssueResolutionLovDs",
	_dataProviderName_:"IssueResolutionLovDs"
	
});
