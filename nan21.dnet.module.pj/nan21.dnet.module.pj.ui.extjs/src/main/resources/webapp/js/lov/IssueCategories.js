Ext.define("net.nan21.dnet.module.pj.base.lovs.IssueCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_base_lovs_IssueCategories",

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
		tocElement: "canvasCategory",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssueCategoryLovDs",
	_dataProviderName_:"IssueCategoryLovDs"
	
});
