/* 
 * DNet eBusiness Suite
 * Copyright: Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define("net.nan21.dnet.module.sd.opportunity.dc.Opportunity", {
	extend: "dnet.core.dc.AbstractDc",

	recordModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityDs",
	filterModel: "net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityDsFilter",
	paramModel: "net.nan21.dnet.module.sd.opportunity.ds.param.OpportunityDsParam",

	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}
});


/* ================= FILTER: Filter ================= */


Ext.define("net.nan21.dnet.module.sd.opportunity.dc.Opportunity$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
	alias: "widget.sd_opportunity_dc_Opportunity$Filter",
	
	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", anchor:"-20"})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"account", dataIndex:"account", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "accountId"} 
				]})
			.addLov({xtype:"sd_opportunity_lovs_OpportunityStatuses", name:"status", _sharedLabel_:true, dataIndex:"status", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addLov({xtype:"sd_opportunity_lovs_OpportunityPriorities", name:"priority", dataIndex:"priority", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priorityId"} 
				]})
			.addLov({xtype:"sd_opportunity_lovs_OpportunityStages", name:"salesStage", dataIndex:"salesStage", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "salesStageId"} 
				]})
			.addLov({xtype:"sd_opportunity_lovs_OpportunitySources", name:"leadSource", dataIndex:"leadSource", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "leadSourceId"} 
				]})
			.addLov({xtype:"sd_opportunity_lovs_OpportunityResultReasons", name:"resultReason", dataIndex:"resultReason", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "resultReasonId"} 
				]})
			.addLov({xtype:"ad_usr_lovs_Assignables", name:"assignedTo", dataIndex:"assignedTo", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "assignedToId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:250, layout:"form"})
			.addPanel({ name:"col2", width:250, layout:"form"})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2"])
			.addChildrenTo("col1", ["name", "account", "assignedTo", "status", "priority"])
			.addChildrenTo("col2", ["salesStage", "leadSource", "resultReason"])
			.addAuditFilter()
		;
	}});


/* ================= GRID: List ================= */


Ext.define("net.nan21.dnet.module.sd.opportunity.dc.Opportunity$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias: "widget.sd_opportunity_dc_Opportunity$List",

	_defineColumns_: function() {
		this._getBuilder_()
			.addTextColumn({ name:"name", dataIndex:"name", width:150})
			.addTextColumn({ name:"account", dataIndex:"account", width:200})
			.addTextColumn({ name:"salesStage", dataIndex:"salesStage", width:90})
			.addDateColumn({ name:"closeDate", dataIndex:"closeDate", format: Dnet.DATE_FORMAT})
			.addNumberColumn({ name:"amount", dataIndex:"amount", decimals:2})
			.addTextColumn({ name:"currency", dataIndex:"currency", width:80})
			.addNumberColumn({ name:"probability", dataIndex:"probability", width:90, decimals:2})
			.addTextColumn({ name:"assignedTo", dataIndex:"assignedTo", width:90})
			.addTextColumn({ name:"status", dataIndex:"status", width:90})
			.addTextColumn({ name:"priority", dataIndex:"priority", width:90})
			.addTextColumn({ name:"leadSource", dataIndex:"leadSource", hidden:true, width:120})
			.addTextColumn({ name:"campaign", dataIndex:"campaign", hidden:true, width:200})
			.addTextColumn({ name:"resultReason", dataIndex:"resultReason", hidden:true, width:120})
			.addTextColumn({ name:"resultNote", dataIndex:"resultNote", hidden:true, width:200})
			.addNumberColumn({ name:"assignedToId", dataIndex:"assignedToId", hidden:true, width:70, format:"0"})
			.addNumberColumn({ name:"accountId", dataIndex:"accountId", hidden:true, width:70, format:"0"})
			.addDefaults();
	}});


/* ================= EDITOR: Edit ================= */


Ext.define("net.nan21.dnet.module.sd.opportunity.dc.Opportunity$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.sd_opportunity_dc_Opportunity$Edit",

	_defineElements_: function() {
		this._getBuilder_()
			/* controls */
			.addTextField({ name:"name", _sharedLabel_:true, dataIndex:"name", allowBlank:false, anchor:"-20"})
			.addTextArea({ name:"description", _sharedLabel_:true, dataIndex:"description", anchor:"-20"})
			.addLov({xtype:"md_bp_lovs_BusinessPartnersName", name:"account", dataIndex:"account", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "accountId"} 
				]})
			.addLov({xtype:"sd_opportunity_lovs_OpportunityStatuses", name:"status", _sharedLabel_:true, dataIndex:"status", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "statusId"} 
				]})
			.addLov({xtype:"sd_opportunity_lovs_OpportunityPriorities", name:"priority", dataIndex:"priority", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "priorityId"} 
				]})
			.addLov({xtype:"sd_opportunity_lovs_OpportunityStages", name:"salesStage", dataIndex:"salesStage", allowBlank:false, anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "salesStageId"} 
				]})
			.addLov({xtype:"sd_opportunity_lovs_OpportunitySources", name:"leadSource", dataIndex:"leadSource", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "leadSourceId"} 
				]})
			.addTextField({ name:"campaign", dataIndex:"campaign", anchor:"-20"})
			.addLov({xtype:"sd_opportunity_lovs_OpportunityResultReasons", name:"resultReason", dataIndex:"resultReason", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "resultReasonId"} 
				]})
			.addTextArea({ name:"resultNote", dataIndex:"resultNote", anchor:"-20"})
			.addDateField({name:"closeDate", dataIndex:"closeDate", allowBlank:false, anchor:"-20", format:Ext.DATE_FORMAT})
			.addNumberField({name:"probability", dataIndex:"probability", anchor:"-20"})
			.addNumberField({name:"amount", dataIndex:"amount", allowBlank:false, anchor:"-20"})
			.addLov({xtype:"bd_currency_lovs_Currencies", name:"currency", dataIndex:"currency", allowBlank:false, anchor:"-20", maxLength:32,
				retFieldMapping: [
					{lovField:"id", dsField: "currencyId"} 
				]})
			.addLov({xtype:"ad_usr_lovs_Assignables", name:"assignedTo", dataIndex:"assignedTo", anchor:"-20",
				retFieldMapping: [
					{lovField:"id", dsField: "assignedToId"} 
				]})
			/* containers */
			.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
					autoScroll:true, padding:"0 30 5 0"})
			.addPanel({ name:"col1", width:350, layout:"form", defaults:{labelAlign:"right", labelWidth:110}})
			.addPanel({ name:"col2", width:300, layout:"form"})
			.addPanel({ name:"col3", width:400, layout:"form", defaults:{labelAlign:"top"}})
		;
	},

	_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["col1", "col2", "col3"])
			.addChildrenTo("col1", ["name", "account", "salesStage", "amount", "currency", "closeDate"])
			.addChildrenTo("col2", ["assignedTo", "status", "priority", "leadSource", "campaign", "probability", "resultReason"])
			.addChildrenTo("col3", ["description", "resultNote"])
		;
	}});
