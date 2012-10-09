Ext.define("net.nan21.dnet.module.pj.base.lovs.ProjectCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.pj_base_lovs_ProjectCategories",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.pj.base.frame.ProjectBaseData_UI",
		bundle:"nan21.dnet.module.pj.ui.extjs",
		tocElement: "canvasCategory",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.ProjectCategoryLovDs",
	_dataProviderName_:"ProjectCategoryLovDs"
	
});
