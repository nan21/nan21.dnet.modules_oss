Ext.define("net.nan21.dnet.module.sd.opportunity.lovs.OpportunitySources", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.sd_opportunity_lovs_OpportunitySources",

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
		tocElement: "canvasSource",
		custom:false
	},
	recordModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunitySourceLovDs",
	_dataProviderName_:"OpportunitySourceLovDs"
	
});
