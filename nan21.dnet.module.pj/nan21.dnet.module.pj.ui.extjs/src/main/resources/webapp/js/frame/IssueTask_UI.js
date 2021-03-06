/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.pj.md.frame.IssueTask_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.pj.md.frame.IssueTask_UI",
	_name_: "net.nan21.dnet.module.pj.md.frame.IssueTask_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("task", new net.nan21.dnet.module.pj.md.dc.IssueTask({}))
			.addDc("issue", new net.nan21.dnet.module.pj.md.dc.Issue({}))
			.addDc("link", new net.nan21.dnet.module.pj.md.dc.IssueLink({multiEdit:true}))
			.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))
			.addDc("note", new net.nan21.dnet.module.ad.data.dc.Note({}))
	
			.linkDc("issue", "task",{fetchMode:"auto",fields:[
				{childField:"id", parentField:"issueId"}]}
			)
			.linkDc("link", "task",{fields:[
				{childField:"sourceIssueId", parentField:"issueId"}]}
			)
			.linkDc("atch", "issue",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"businessObject"}]}
			)
			.linkDc("note", "task",{fields:[
				{childField:"targetUuid", parentField:"issueUuId"}, {childField:"targetType", parentField:"issueClassName"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnViewAttachment", text:"View", tooltip:"View the selected attachment", iconCls:"icon-action-view", disabled:true,
					handler: this.onBtnViewAttachment, scope:this, stateManager:{name:"selected_one", dc:"atch" }})
			.addButton({name:"btnUploadAttachment", text:"Upload...", tooltip:"Upload attachment file.", disabled:true,
					handler: this.onBtnUploadAttachment, scope:this, stateManager:{name:"selected_one_clean", dc:"atch" }})
			.addButton({name:"btnIssueUi", text:"Edit issue", tooltip:"Show current issue in editor frame", disabled:true,
					handler: this.onBtnIssueUi, scope:this, stateManager:{name:"selected_one", dc:"issue" }})
			
			.addDcFilterFormView("task", {name:"taskFilter", height:180, xtype:"pj_md_dc_IssueTask$Filter"})
			.addDcGridView("task", {name:"taskList", xtype:"pj_md_dc_IssueTask$List"})
			.addDcFormView("task", {name:"taskEdit", height:180, xtype:"pj_md_dc_IssueTask$Edit"})
			.addDcFormView("issue", {name:"issueView", xtype:"pj_md_dc_Issue$View"})
			.addDcEditGridView("atch", {name:"atchEditList", title:"Issue attachments", xtype:"ad_data_dc_Attachment$CtxEditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnViewAttachment")]}]})
			.addDcGridView("note", {name:"noteList", width:300, xtype:"ad_data_dc_Note$List"})
			.addDcFormView("note", {name:"noteEdit", xtype:"ad_data_dc_Note$Edit"})
			.addDcFilterFormView("link", {name:"linkFilter", xtype:"pj_md_dc_IssueLink$Filter"})
			.addDcGridView("link", {name:"linkEditList", title:"Issue links", xtype:"pj_md_dc_IssueLink$CtxList"})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"taskDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addPanel({name:"issueInfoPanel", title:"Issue info", layout:"fit"})
			.addPanel({name:"notesPanel", title:"Comments", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["taskFilter", "taskList"], ["north", "center"])
			.addChildrenTo("canvas2", ["taskEdit", "taskDetailsTab"], ["north", "center"])
			.addChildrenTo("taskDetailsTab", ["issueInfoPanel", "atchEditList", "linkEditList", "notesPanel"])
			.addChildrenTo("issueInfoPanel", ["issueView"])
			.addChildrenTo("notesPanel", ["noteList", "noteEdit"], ["west", "center"])
			.addToolbarTo("canvas1", "tlbTaskList")
			.addToolbarTo("canvas2", "tlbTaskEdit")
			.addToolbarTo("linkEditList", "tlbLinkList")
			.addToolbarTo("atchEditList", "tlbAtchList")
			.addToolbarTo("noteList", "tlbNoteList")
			.addToolbarTo("noteEdit", "tlbNoteEdit")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTaskList", {dc: "task"}).addQuery().addEdit().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Issue tasks"})
			.end()
			.beginToolbar("tlbTaskEdit", {dc: "task"}).addBack().addSave().addCancel().addPrevRec().addNextRec()
			.addSeparator().addSeparator().addButtons([this._elems_.get("btnIssueUi") ]).addReports().addSeparator().addSeparator().addTitle({text: "Issue task"})
			.end()
			.beginToolbar("tlbLinkList", {dc: "link"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Links"})
			.end()
			.beginToolbar("tlbAtchList", {dc: "atch"}).addQuery()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Attachments"})
			.end()
			.beginToolbar("tlbNoteList", {dc: "note"}).addQuery()
			.addSeparator().addAutoLoad().addReports()
			.end()
			.beginToolbar("tlbNoteEdit", {dc: "note"}).addSave().addNew().addCancel()
			.addSeparator().addAutoLoad().addReports()
			.end()
			;
	}

	
	,onBtnIssueUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.Issues_UI";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
			code: this._getDc_("task").getRecord().get("issue"),
			projectId: this._getDc_("issue").getRecord().get("projectId"),
			project: this._getDc_("issue").getRecord().get("project")
			},
			callback: function (params) {
				this._when_called_to_edit_(params);
			}
		});
	}
	
	,onUploadSuccess: function() {	
		this._getDc_("atch").doQuery();
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
});
