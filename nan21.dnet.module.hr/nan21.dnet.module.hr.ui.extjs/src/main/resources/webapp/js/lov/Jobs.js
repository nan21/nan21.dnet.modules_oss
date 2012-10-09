Ext.define("net.nan21.dnet.module.hr.job.lovs.Jobs", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_job_lovs_Jobs",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {code}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.job.frame.Job_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.JobLovDs",
	_dataProviderName_:"JobLovDs"
	
});
