Ext.define("net.nan21.dnet.module.hr.grade.lovs.GradeRates", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_grade_lovs_GradeRates",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.grade.frame.GradeRate_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.GradeRateLovDs",
	_dataProviderName_:"GradeRateLovDs"
	
});
