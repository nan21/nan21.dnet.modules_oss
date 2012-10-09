Ext.define("net.nan21.dnet.module.hr.time.lovs.AbsenceReasons", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_time_lovs_AbsenceReasons",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		tocElement: "canvasReason",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceReasonLovDs",
	_dataProviderName_:"AbsenceReasonLovDs"
	
});
