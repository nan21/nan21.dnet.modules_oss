/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.pj.ui.extjs/ds/IssueTaskTypeDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueTaskStatus", "nan21.dnet.module.pj.ui.extjs/lov/IssueCategories", "nan21.dnet.module.pj.ui.extjs/ds/IssueCategoryLovDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueTaskType", "nan21.dnet.module.pj.ui.extjs/ds/IssueCategoryDs", "nan21.dnet.module.pj.ui.extjs/ds/IssueSeverityDs", "nan21.dnet.module.pj.ui.extjs/ds/IssueTypeDs", "nan21.dnet.module.pj.ui.extjs/ds/IssueResolutionDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueSeverity", "nan21.dnet.module.pj.ui.extjs/ds/IssueLinkTypeDs", "nan21.dnet.module.pj.ui.extjs/ds/IssueTaskStatusDs", "nan21.dnet.module.pj.ui.extjs/ds/IssueStatusDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueLinkType", "nan21.dnet.module.pj.ui.extjs/ds/IssuePriorityDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueCategory", "nan21.dnet.module.pj.ui.extjs/dc/IssueStatus", "nan21.dnet.module.pj.ui.extjs/dc/IssueResolution", "nan21.dnet.module.pj.ui.extjs/dc/IssueType", "nan21.dnet.module.pj.ui.extjs/dc/IssuePriority"]);

Ext.define("net.nan21.dnet.module.pj.base.frame.IssueBaseData_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.pj.base.frame.IssueBaseData_UI",
	_name_: "net.nan21.dnet.module.pj.base.frame.IssueBaseData_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("categ", new net.nan21.dnet.module.pj.base.dc.IssueCategory({multiEdit:true}))
			.addDc("type", new net.nan21.dnet.module.pj.base.dc.IssueType({multiEdit:true}))
			.addDc("status", new net.nan21.dnet.module.pj.base.dc.IssueStatus({multiEdit:true}))
			.addDc("priority", new net.nan21.dnet.module.pj.base.dc.IssuePriority({multiEdit:true}))
			.addDc("severity", new net.nan21.dnet.module.pj.base.dc.IssueSeverity({multiEdit:true}))
			.addDc("resolution", new net.nan21.dnet.module.pj.base.dc.IssueResolution({multiEdit:true}))
			.addDc("linktype", new net.nan21.dnet.module.pj.base.dc.IssueLinkType({multiEdit:true}))
			.addDc("tasktype", new net.nan21.dnet.module.pj.base.dc.IssueTaskType({multiEdit:true}))
			.addDc("taskstatus", new net.nan21.dnet.module.pj.base.dc.IssueTaskStatus({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("categ", {name:"categFilter", height:80, xtype:"pj_base_dc_IssueCategory$Filter"})
			.addDcEditGridView("categ", {name:"categEditList", xtype:"pj_base_dc_IssueCategory$EditList", frame:true})
			.addDcFilterFormView("type", {name:"typeFilter", height:80, xtype:"pj_base_dc_IssueType$Filter"})
			.addDcEditGridView("type", {name:"typeEditList", xtype:"pj_base_dc_IssueType$EditList", frame:true})
			.addDcFilterFormView("status", {name:"statusFilter", height:80, xtype:"pj_base_dc_IssueStatus$Filter"})
			.addDcEditGridView("status", {name:"statusEditList", xtype:"pj_base_dc_IssueStatus$EditList", frame:true})
			.addDcFilterFormView("priority", {name:"priorityFilter", height:80, xtype:"pj_base_dc_IssuePriority$Filter"})
			.addDcEditGridView("priority", {name:"priorityEditList", xtype:"pj_base_dc_IssuePriority$EditList", frame:true})
			.addDcFilterFormView("severity", {name:"severityFilter", height:80, xtype:"pj_base_dc_IssueSeverity$Filter"})
			.addDcEditGridView("severity", {name:"severityEditList", xtype:"pj_base_dc_IssueSeverity$EditList", frame:true})
			.addDcFilterFormView("resolution", {name:"resolutionFilter", height:80, xtype:"pj_base_dc_IssueResolution$Filter"})
			.addDcEditGridView("resolution", {name:"resolutionEditList", xtype:"pj_base_dc_IssueResolution$EditList", frame:true})
			.addDcFilterFormView("linktype", {name:"linktypeFilter", height:80, xtype:"pj_base_dc_IssueLinkType$Filter"})
			.addDcEditGridView("linktype", {name:"linktypeEditList", xtype:"pj_base_dc_IssueLinkType$EditList", frame:true})
			.addDcFilterFormView("tasktype", {name:"tasktypeFilter", height:80, xtype:"pj_base_dc_IssueTaskType$Filter"})
			.addDcEditGridView("tasktype", {name:"tasktypeEditList", xtype:"pj_base_dc_IssueTaskType$EditList", frame:true})
			.addDcFilterFormView("taskstatus", {name:"taskstatusFilter", height:80, xtype:"pj_base_dc_IssueTaskStatus$Filter"})
			.addDcEditGridView("taskstatus", {name:"taskstatusEditList", xtype:"pj_base_dc_IssueTaskStatus$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasCategory", title:"Issue category", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasType", title:"Issue type", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasStatus", title:"Issue status", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasPriority", title:"Issue priority", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasSeverity", title:"Issue severity", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasResolution", title:"Issue resolution", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasLinktype", title:"Issue link type", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasTasktype", title:"Task type", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasTaskstatus", title:"Task status", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasCategory","canvasType","canvasStatus","canvasPriority","canvasSeverity","canvasResolution","canvasLinktype","canvasTasktype","canvasTaskstatus"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasCategory", "canvasType", "canvasStatus", "canvasPriority", "canvasSeverity", "canvasResolution", "canvasLinktype", "canvasTasktype", "canvasTaskstatus"])
			.addChildrenTo("canvasCategory", ["categFilter", "categEditList"], ["north", "center"])
			.addChildrenTo("canvasType", ["typeFilter", "typeEditList"], ["north", "center"])
			.addChildrenTo("canvasStatus", ["statusFilter", "statusEditList"], ["north", "center"])
			.addChildrenTo("canvasPriority", ["priorityFilter", "priorityEditList"], ["north", "center"])
			.addChildrenTo("canvasSeverity", ["severityFilter", "severityEditList"], ["north", "center"])
			.addChildrenTo("canvasResolution", ["resolutionFilter", "resolutionEditList"], ["north", "center"])
			.addChildrenTo("canvasLinktype", ["linktypeFilter", "linktypeEditList"], ["north", "center"])
			.addChildrenTo("canvasTasktype", ["tasktypeFilter", "tasktypeEditList"], ["north", "center"])
			.addChildrenTo("canvasTaskstatus", ["taskstatusFilter", "taskstatusEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasCategory", "tlbCategEditList")
			.addToolbarTo("canvasType", "tlbTypeEditList")
			.addToolbarTo("canvasStatus", "tlbStatusEditList")
			.addToolbarTo("canvasPriority", "tlbPriorityEditList")
			.addToolbarTo("canvasSeverity", "tlbSeverityEditList")
			.addToolbarTo("canvasResolution", "tlbResolutionEditList")
			.addToolbarTo("canvasLinktype", "tlbLinktypeEditList")
			.addToolbarTo("canvasTasktype", "tlbTasktypeEditList")
			.addToolbarTo("canvasTaskstatus", "tlbTaskstatusEditList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCategEditList", {dc: "categ"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Issue category"})
			.end()
			.beginToolbar("tlbTypeEditList", {dc: "type"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Issue type"})
			.end()
			.beginToolbar("tlbStatusEditList", {dc: "status"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Issue status"})
			.end()
			.beginToolbar("tlbPriorityEditList", {dc: "priority"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Issue priority"})
			.end()
			.beginToolbar("tlbSeverityEditList", {dc: "severity"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Issue severity"})
			.end()
			.beginToolbar("tlbResolutionEditList", {dc: "resolution"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Issue resolution"})
			.end()
			.beginToolbar("tlbLinktypeEditList", {dc: "linktype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Issue link type"})
			.end()
			.beginToolbar("tlbTasktypeEditList", {dc: "tasktype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Task type"})
			.end()
			.beginToolbar("tlbTaskstatusEditList", {dc: "taskstatus"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Task status"})
			.end()
			;
	}

});
