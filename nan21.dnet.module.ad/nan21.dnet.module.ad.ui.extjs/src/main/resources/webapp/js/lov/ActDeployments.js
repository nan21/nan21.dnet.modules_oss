Ext.define("net.nan21.dnet.module.ad.workflow.lovs.ActDeployments", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_workflow_lovs_ActDeployments",

	displayField:"fullName",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{fullName}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.ad.workflow.frame.WorkflowAdmin_UI",
		bundle:"nan21.dnet.module.ad.ui.extjs",
		tocElement: "canvasDeployment",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentLovDs",
	_dataProviderName_:"ActDeploymentLovDs"
	
});
