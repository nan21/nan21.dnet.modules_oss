/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.pj.md.frame.Issues_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.pj.md.frame.Issues_UI",
	_name_: "net.nan21.dnet.module.pj.md.frame.Issues_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("issue", new net.nan21.dnet.module.pj.md.dc.Issue({}))
			.addDc("link", new net.nan21.dnet.module.pj.md.dc.IssueLink({}))
			.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))
			.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
			.addDc("task", new net.nan21.dnet.module.pj.md.dc.IssueTaskCtx({}))
	
			.linkDc("link", "issue",{fields:[
				{childField:"sourceIssueId", parentField:"id"}]}
			)
			.linkDc("atch", "issue",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"entityFQN"}]}
			)
			.linkDc("note", "issue",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"entityFQN"}]}
			)
			.linkDc("task", "issue",{fields:[
				{childField:"issueId", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnViewAttachment", text:"View", tooltip:"View the selected attachment", iconCls:"icon-action-view", disabled:true,
					handler: this.onBtnViewAttachment, scope:this, stateManager:{name:"selected_one", dc:"atch" }})
			.addButton({name:"btnUploadAttachment", text:"Upload...", tooltip:"Upload attachment file.", disabled:true,
					handler: this.onBtnUploadAttachment, scope:this, stateManager:{name:"selected_one_clean", dc:"atch" }})
			.addButton({name:"btnAsgnAffectedVersions", text:"Affected versions", tooltip:"Add affected versions", disabled:true,
					handler: this.onBtnAsgnAffectedVersions, scope:this, stateManager:{name:"record_is_clean", dc:"issue" }})
			.addButton({name:"btnAsgnAffectedComps", text:"Affected components", tooltip:"Add affected components", disabled:true,
					handler: this.onBtnAsgnAffectedComps, scope:this, stateManager:{name:"record_is_clean", dc:"issue" }})
			.addButton({name:"btnSaveLink", text:"Save", tooltip:"Save link", disabled:true,
					handler: this.onBtnSaveLink, scope:this, stateManager:{name:"record_is_dirty", dc:"link" }})
			.addButton({name:"btnCancelLink", text:"Cancel", tooltip:"Cancel", disabled:true,
					handler: this.onBtnCancelLink, scope:this, stateManager:{name:"record_is_dirty", dc:"link" }})
			.addButton({name:"btnTaskUi", text:"Tasks editor", tooltip:"Open standalone task editor frame", disabled:false,
					handler: this.onBtnTaskUi, scope:this})
			.addButton({name:"btnRoadmapUi", text:"Roadmap", tooltip:"Open roadmap frame", disabled:false,
					handler: this.onBtnRoadmapUi, scope:this})
			.addButton({name:"btnChangelogUi", text:"Changelog", tooltip:"Open changelog frame", disabled:false,
					handler: this.onBtnChangelogUi, scope:this})
			
			.addDcFilterFormView("issue", {name:"issueFilter", xtype:"pj_md_dc_Issue$Filter"})
			.addDcGridView("issue", {name:"issueList", xtype:"pj_md_dc_Issue$List"})
			.addDcFormView("issue", {name:"issueEdit", height:240, xtype:"pj_md_dc_Issue$Edit", 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnAsgnAffectedVersions"), this._elems_.get("btnAsgnAffectedComps")]}]})
			.addDcFormView("issue", {name:"issueEditText", title:"Description", xtype:"pj_md_dc_Issue$EditText"})
			.addDcGridView("link", {name:"linkList", title:"Links", xtype:"pj_md_dc_IssueLink$CtxList"})
			.addDcFormView("link", {name:"linkCreate", xtype:"pj_md_dc_IssueLink$CtxCreate"})
			.addDcEditGridView("atch", {name:"atchEditList", title:"Attachments", xtype:"ad_data_dc_Attachment$CtxEditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnViewAttachment"), this._elems_.get("btnUploadAttachment")]}]})
			.addDcGridView("note", {name:"noteList", width:600, xtype:"ad_data_dc_Note$List"})
			.addDcFormView("note", {name:"noteEdit", xtype:"ad_data_dc_Note$Edit"})
			.addDcGridView("task", {name:"taskList", xtype:"pj_md_dc_IssueTaskCtx$List"})
			.addDcFormView("task", {name:"taskEdit", xtype:"pj_md_dc_IssueTaskCtx$Edit"})
			.addWindow({name:"wdwIssueLinkCreate", title:"Create link", width:400, height:150, closeAction:'hide', resizable:true, layout:"fit", modal:true,
				items:[this._elems_.get("linkCreate")], 
						dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
							items:[ this._elems_.get("btnSaveLink"), this._elems_.get("btnCancelLink")]}]})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}, onActivateDoLayoutFor:["issueDetailsTab"]})
			.addPanel({name:"issueDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"tasksPanel", title:"Tasks", layout:"card", activeItem:0})
			.addPanel({name:"taskEditWrapper", layout:"fit"})
			.addPanel({name:"notesPanel", title:"Notes", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["issueFilter", "issueList"], ["north", "center"])
			.addChildrenTo("canvas2", ["issueEdit", "issueDetailsTab"], ["north", "center"])
			.addChildrenTo("issueDetailsTab", ["issueEditText", "tasksPanel", "atchEditList", "linkList", "notesPanel"])
			.addChildrenTo("tasksPanel", ["taskList", "taskEditWrapper"])
			.addChildrenTo("taskEditWrapper", ["taskEdit"])
			.addChildrenTo("notesPanel", ["noteList", "noteEdit"], ["west", "center"])
			.addToolbarTo("canvas1", "tlbIssueList")
			.addToolbarTo("canvas2", "tlbIssueEdit")
			.addToolbarTo("linkList", "tlbLinkList")
			.addToolbarTo("atchEditList", "tlbAtchList")
			.addToolbarTo("noteList", "tlbNoteList")
			.addToolbarTo("noteEdit", "tlbNoteEdit")
			.addToolbarTo("taskList", "tlbTaskList")
			.addToolbarTo("taskEditWrapper", "tlbTaskEdit")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbIssueList", {dc: "issue"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Issues"})
			.end()
			.beginToolbar("tlbIssueEdit", {dc: "issue"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addSeparator().addSeparator().addButtons([this._elems_.get("btnTaskUi") ,this._elems_.get("btnChangelogUi") ,this._elems_.get("btnRoadmapUi") ]).addReports().addSeparator().addSeparator().addTitle({text: "Issue"})
			.end()
			.beginToolbar("tlbLinkList", {dc: "link"}).addQuery().addNew().addDeleteSelected()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Links"})
			.end()
			.beginToolbar("tlbAtchList", {dc: "atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Attachments"})
			.end()
			.beginToolbar("tlbNoteList", {dc: "note"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Notes"})
			.end()
			.beginToolbar("tlbNoteEdit", {dc: "note"}).addSave().addNew().addCancel()
			.addSeparator().addAutoLoad().addReports()
			.end()
			.beginToolbar("tlbTaskList", {dc: "task"}).addQuery(
			).addEdit(
			{inContainer:"tasksPanel",showView:"taskEditWrapper"}
			).addNew(
			).addCopy(
			).addDeleteSelected(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Tasks"})
			.end()
			.beginToolbar("tlbTaskEdit", {dc: "task"}).addBack(
			{inContainer:"tasksPanel",showView:"taskList"}
			).addSave(
			).addNew(
			).addCopy(
			).addCancel(
			).addPrevRec(
			).addNextRec(
			)
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Task"})
			.end()
			;
	}

	
	,onBtnAsgnAffectedVersions: function() {
		this.showAsgnWindow(net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions$Ui ,{dc: "issue", objectIdField: "id"});
	}
	
	,onBtnAsgnAffectedComps: function() {
		this.showAsgnWindow(net.nan21.dnet.module.pj.md.asgn.IssueAffectedComponents$Ui ,{dc: "issue", objectIdField: "id"});
	}
	
	,onBtnSaveLink: function() {
		this._getDc_("link").doSave();
	}
	
	,onBtnCancelLink: function() {
		this._getDc_("link").doCancel();
		this._getWindow_("wdwIssueLinkCreate").close();
	}
	
	,onBtnTaskUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.IssueTask_UI";
		getApplication().showFrameByName(bundle, frame);
	}
	
	,onBtnRoadmapUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.IssueRoadmap_UI";
		getApplication().showFrameByName(bundle, frame);
	}
	
	,onBtnChangelogUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.IssueChangelog_UI";
		getApplication().showFrameByName(bundle, frame);
	}
	
	,onUploadSuccess: function() {	
		this._getDc_("atch").doQuery();
	}
	
	,_whenCreateNewLink_: function() {	
		this._getWindow_("wdwIssueLinkCreate").show();
	}
	
	,onBtnUploadAttachment: function() {
		var w=new dnet.core.base.FileUploadWindow({
		    		_nameFieldValue_: this._getDc_("atch").getRecord().get("name"),
		    		_p1Value_: this._getDc_("atch").getRecord().get("id"),
		    		_uploadUrl_:"/nan21.dnet.core.web/upload/adDataAttachment",
		    		_succesCallbackFn_ : this.onUploadSuccess,
		    		_succesCallbackScope_: this
		    	});w.show();
	}
	
	,onBtnViewAttachment: function() {
		
				var url = this._getDc_("atch").getRecord().get("url");
				window.open(url, "Attachment", "location=1,status=1,scrollbars=1,width=500,height=400");
	}
	
	,_afterDefineDcs_: function() {
		this._getDc_("link").on("afterDoNew", this._whenCreateNewLink_, this);
	}
	
	,_when_called_to_edit_: function(params) {
		
				var issue = this._getDc_("issue");
				if (issue.isDirty()) {
					this._alert_dirty_();
					return;
				}
				issue.doClearQuery();
				issue.setFilterValue("code", params.code );
				issue.setFilterValue("projectId", params.projectId );
				issue.setFilterValue("project", params.project );
				issue.doQuery();
				this._showStackedViewElement_("main",1);
	}
});
