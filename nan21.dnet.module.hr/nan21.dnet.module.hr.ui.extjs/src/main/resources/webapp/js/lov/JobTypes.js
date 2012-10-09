Ext.define("net.nan21.dnet.module.hr.job.lovs.JobTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_job_lovs_JobTypes",

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
		tocElement: "canvasJobType",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.JobTypeLovDs",
	_dataProviderName_:"JobTypeLovDs"
	
});
