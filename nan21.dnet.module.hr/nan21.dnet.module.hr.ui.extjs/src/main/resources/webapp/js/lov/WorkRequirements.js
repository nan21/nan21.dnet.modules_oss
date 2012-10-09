Ext.define("net.nan21.dnet.module.hr.job.lovs.WorkRequirements", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_job_lovs_WorkRequirements",

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
		tocElement: "canvasWr",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.WorkRequirementLovDs",
	_dataProviderName_:"WorkRequirementLovDs"
	
});
