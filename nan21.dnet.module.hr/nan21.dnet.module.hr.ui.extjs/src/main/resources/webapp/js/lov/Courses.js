Ext.define("net.nan21.dnet.module.hr.training.lovs.Courses", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_training_lovs_Courses",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.training.frame.Course_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.training.ds.model.CourseLovDs",
	_dataProviderName_:"CourseLovDs"
	
});
