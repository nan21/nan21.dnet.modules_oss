Ext.define("net.nan21.dnet.module.hr.grade.lovs.Grades", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_grade_lovs_Grades",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.grade.frame.Grade_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.GradeLovDs",
	_dataProviderName_:"GradeLovDs"
	
});
