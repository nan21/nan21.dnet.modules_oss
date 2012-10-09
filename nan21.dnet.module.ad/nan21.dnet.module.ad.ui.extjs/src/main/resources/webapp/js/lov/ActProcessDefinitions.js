Ext.define("net.nan21.dnet.module.ad.workflow.lovs.ActProcessDefinitions", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_workflow_lovs_ActProcessDefinitions",

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
		tocElement: "canvasProcess",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionLovDs",
	_dataProviderName_:"ActProcessDefinitionLovDs"
	
});
