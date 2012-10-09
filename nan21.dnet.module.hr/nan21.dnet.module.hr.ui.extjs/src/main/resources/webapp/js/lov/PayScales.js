Ext.define("net.nan21.dnet.module.hr.grade.lovs.PayScales", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_grade_lovs_PayScales",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.grade.frame.PayScale_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.PayScaleLovDs",
	_dataProviderName_:"PayScaleLovDs"
	
});
