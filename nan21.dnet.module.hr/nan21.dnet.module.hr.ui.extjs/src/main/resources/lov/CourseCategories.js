Ext.define("net.nan21.dnet.module.hr.training.lovs.CourseCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_training_lovs_CourseCategories",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.training.frame.CourseType_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		tocElement: "canvasCategory",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.training.ds.model.CourseCategoryLovDs",
	_dataProviderName_:"CourseCategoryLovDs"
	
});
