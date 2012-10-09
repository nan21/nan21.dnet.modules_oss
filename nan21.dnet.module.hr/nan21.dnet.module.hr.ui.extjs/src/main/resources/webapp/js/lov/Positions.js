Ext.define("net.nan21.dnet.module.hr.job.lovs.Positions", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.hr_job_lovs_Positions",

	displayField:"code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.hr.job.frame.Position_UI",
		bundle:"nan21.dnet.module.hr.ui.extjs",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.hr.job.ds.model.PositionLovDs",
	_dataProviderName_:"PositionLovDs"
	
});
