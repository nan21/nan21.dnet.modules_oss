/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.sd.ui.extjs/ds/OpportunityStatusDs", "nan21.dnet.module.sd.ui.extjs/dc/OpportunityResultReason", "nan21.dnet.module.sd.ui.extjs/dc/OpportunityStatus", "nan21.dnet.module.sd.ui.extjs/ds/OpportunityResultReasonDs", "nan21.dnet.module.sd.ui.extjs/dc/OpportunityStage", "nan21.dnet.module.sd.ui.extjs/dc/OpportunitySource", "nan21.dnet.module.sd.ui.extjs/ds/OpportunityPriorityDs", "nan21.dnet.module.sd.ui.extjs/ds/OpportunityStageDs", "nan21.dnet.module.sd.ui.extjs/ds/OpportunitySourceDs", "nan21.dnet.module.sd.ui.extjs/dc/OpportunityPriority"]);

Ext.define("net.nan21.dnet.module.sd.opportunity.frame.OpportunityBaseData_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.sd.opportunity.frame.OpportunityBaseData_UI",
	_name_: "net.nan21.dnet.module.sd.opportunity.frame.OpportunityBaseData_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("priority", new net.nan21.dnet.module.sd.opportunity.dc.OpportunityPriority({multiEdit:true}))
			.addDc("status", new net.nan21.dnet.module.sd.opportunity.dc.OpportunityStatus({multiEdit:true}))
			.addDc("source", new net.nan21.dnet.module.sd.opportunity.dc.OpportunitySource({multiEdit:true}))
			.addDc("stage", new net.nan21.dnet.module.sd.opportunity.dc.OpportunityStage({multiEdit:true}))
			.addDc("result", new net.nan21.dnet.module.sd.opportunity.dc.OpportunityResultReason({multiEdit:true}))
	
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("priority", {name:"priorityFilter", height:80, xtype:"sd_opportunity_dc_OpportunityPriority$Filter"})	
			.addDcEditGridView("priority", {name:"priorityEditList", xtype:"sd_opportunity_dc_OpportunityPriority$EditList", frame:true})	
			.addDcFilterFormView("status", {name:"statusFilter", height:80, xtype:"sd_opportunity_dc_OpportunityStatus$Filter"})	
			.addDcEditGridView("status", {name:"statusEditList", xtype:"sd_opportunity_dc_OpportunityStatus$EditList", frame:true})	
			.addDcFilterFormView("source", {name:"sourceFilter", height:80, xtype:"sd_opportunity_dc_OpportunitySource$Filter"})	
			.addDcEditGridView("source", {name:"sourceEditList", xtype:"sd_opportunity_dc_OpportunitySource$EditList", frame:true})	
			.addDcFilterFormView("stage", {name:"stageFilter", height:80, xtype:"sd_opportunity_dc_OpportunityStage$Filter"})	
			.addDcEditGridView("stage", {name:"stageEditList", xtype:"sd_opportunity_dc_OpportunityStage$EditList", frame:true})	
			.addDcFilterFormView("result", {name:"resultFilter", height:80, xtype:"sd_opportunity_dc_OpportunityResultReason$Filter"})	
			.addDcEditGridView("result", {name:"resultEditList", xtype:"sd_opportunity_dc_OpportunityResultReason$EditList", frame:true})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasPriority", title:"Priority", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasStatus", title:"Status", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasSource", title:"Lead source", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasStage", title:"Sales stage", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasResult", title:"Result reason", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasPriority","canvasStatus","canvasSource","canvasStage","canvasResult"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasPriority", "canvasStatus", "canvasSource", "canvasStage", "canvasResult"])
			.addChildrenTo("canvasPriority", ["priorityFilter", "priorityEditList"], ["north", "center"])
			.addChildrenTo("canvasStatus", ["statusFilter", "statusEditList"], ["north", "center"])
			.addChildrenTo("canvasSource", ["sourceFilter", "sourceEditList"], ["north", "center"])
			.addChildrenTo("canvasStage", ["stageFilter", "stageEditList"], ["north", "center"])
			.addChildrenTo("canvasResult", ["resultFilter", "resultEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasPriority", "tlbPriorityEditList")
			.addToolbarTo("canvasStatus", "tlbStatusEditList")
			.addToolbarTo("canvasSource", "tlbSourceEditList")
			.addToolbarTo("canvasStage", "tlbStageEditList")
			.addToolbarTo("canvasResult", "tlbResultEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPriorityEditList", {dc: "priority"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Priority"})
			.end()
			.beginToolbar("tlbStatusEditList", {dc: "status"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Status"})
			.end()
			.beginToolbar("tlbSourceEditList", {dc: "source"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Lead source"})
			.end()
			.beginToolbar("tlbStageEditList", {dc: "stage"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Sales stage"})
			.end()
			.beginToolbar("tlbResultEditList", {dc: "result"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Result reason"})
			.end()
	}

});
