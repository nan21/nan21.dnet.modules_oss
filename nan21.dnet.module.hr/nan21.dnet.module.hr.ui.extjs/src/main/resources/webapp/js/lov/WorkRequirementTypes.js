Ext.define("net.nan21.dnet.module.hr.job.lovs.WorkRequirementTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_job_lovs_WorkRequirementTypes",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.job.frame.JobBaseDataDef_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		tocElement: "canvasWrType",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.WorkRequirementTypeLovDs",
	_dataProviderName_:"WorkRequirementTypeLovDs"
	
});
