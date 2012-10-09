Ext.define("net.nan21.dnet.module.sd.opportunity.lovs.OpportunityStatuses", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.sd_opportunity_lovs_OpportunityStatuses",

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
		tocElement: "canvasStatus",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityStatusLovDs",
	_dataProviderName_:"OpportunityStatusLovDs"
	
});
