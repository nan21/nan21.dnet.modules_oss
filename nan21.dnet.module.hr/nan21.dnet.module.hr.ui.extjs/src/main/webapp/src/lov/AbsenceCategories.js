Ext.define("net.nan21.dnet.module.hr.time.lovs.AbsenceCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_time_lovs_AbsenceCategories",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{description}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		tocElement: "canvasCateg",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceCategoryLovDs",
	_dataProviderName_:"AbsenceCategoryLovDs"
	
});
