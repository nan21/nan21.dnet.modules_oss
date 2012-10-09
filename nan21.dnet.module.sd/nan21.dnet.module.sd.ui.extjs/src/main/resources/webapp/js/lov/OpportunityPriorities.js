Ext.define("net.nan21.dnet.module.sd.opportunity.lovs.OpportunityPriorities", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.sd_opportunity_lovs_OpportunityPriorities",

	displayField:"name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250
	},
	_editDialog_: {
		name: "net.nan21.dnet.module.sd.opportunity.frame.OpportunityBaseData_UI",
		bundle:"nan21.dnet.module.sd.ui.extjs",
		tocElement: "canvasPriority",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityPriorityLovDs",
	_dataProviderName_:"OpportunityPriorityLovDs"
	
});
