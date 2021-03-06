/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.pj.md.frame.Projects_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.pj.md.frame.Projects_UI",
	_name_: "net.nan21.dnet.module.pj.md.frame.Projects_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("project", new net.nan21.dnet.module.pj.md.dc.Project({}))
			.addDc("version", new net.nan21.dnet.module.pj.md.dc.ProjectVersion({multiEdit:true}))
			.addDc("component", new net.nan21.dnet.module.pj.md.dc.ProjectComponent({multiEdit:true}))
			.addDc("member", new net.nan21.dnet.module.pj.md.dc.ProjectMember({multiEdit:true}))
			.addDc("atch", new net.nan21.dnet.module.ad.data.dc.Attachment({multiEdit:true}))
	
			.linkDc("version", "project",{fields:[
				{childField:"projectId", parentField:"id"}]}
			)
			.linkDc("component", "project",{fields:[
				{childField:"projectId", parentField:"id"}]}
			)
			.linkDc("member", "project",{fields:[
				{childField:"projectId", parentField:"id"}]}
			)
			.linkDc("atch", "project",{fields:[
				{childField:"targetUuid", parentField:"uuid"}, {childField:"targetType", parentField:"entityFQN"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnViewAttachment", text:"View", tooltip:"View the selected attachment", iconCls:"icon-action-view", disabled:true,
					handler: this.onBtnViewAttachment, scope:this, stateManager:{name:"selected_one", dc:"atch" }})
			.addButton({name:"btnUploadAttachment", text:"Upload...", tooltip:"Upload attachment file.", disabled:true,
					handler: this.onBtnUploadAttachment, scope:this, stateManager:{name:"selected_one_clean", dc:"atch" }})
			.addButton({name:"btnRoadmapUi", text:"Roadmap", tooltip:"Show roadmap for selected version", disabled:true,
					handler: this.onBtnRoadmapUi, scope:this, stateManager:{name:"selected_one", dc:"version" }})
			.addButton({name:"btnChangelogUi", text:"Changelog", tooltip:"Show Changelog for selected version", disabled:true,
					handler: this.onBtnChangelogUi, scope:this, stateManager:{name:"selected_one", dc:"version" }})
			
			.addDcFilterFormView("project", {name:"projectFilter", height:80, xtype:"pj_md_dc_Project$Filter"})
			.addDcGridView("project", {name:"projectList", xtype:"pj_md_dc_Project$List"})
			.addDcFormView("project", {name:"projectEdit", height:160, xtype:"pj_md_dc_Project$Edit"})
			.addDcFilterFormView("version", {name:"versionFilter", xtype:"pj_md_dc_ProjectVersion$Filter"})
			.addDcEditGridView("version", {name:"versionEditList", title:"Versions", xtype:"pj_md_dc_ProjectVersion$CtxEditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnRoadmapUi"), this._elems_.get("btnChangelogUi")]}]})
			.addDcFilterFormView("component", {name:"componentFilter", xtype:"pj_md_dc_ProjectComponent$Filter"})
			.addDcEditGridView("component", {name:"componentEditList", title:"Components", xtype:"pj_md_dc_ProjectComponent$CtxEditList", frame:true})
			.addDcEditGridView("atch", {name:"atchEditList", title:"Attachments", xtype:"ad_data_dc_Attachment$CtxEditList", frame:true, 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnViewAttachment"), this._elems_.get("btnUploadAttachment")]}]})
			.addDcEditGridView("member", {name:"memberEditList", title:"Team", xtype:"pj_md_dc_ProjectMember$CtxEditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"projectDetailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1", "canvas2"])
			.addChildrenTo("canvas1", ["projectFilter", "projectList"], ["north", "center"])
			.addChildrenTo("canvas2", ["projectEdit", "projectDetailsTab"], ["north", "center"])
			.addChildrenTo("projectDetailsTab", ["memberEditList", "versionEditList", "componentEditList", "atchEditList"])
			.addToolbarTo("canvas1", "tlbProjectList")
			.addToolbarTo("canvas2", "tlbProjectEdit")
			.addToolbarTo("versionEditList", "tlbVersionEditList")
			.addToolbarTo("componentEditList", "tlbComponentEditList")
			.addToolbarTo("memberEditList", "tlbMemberEditList")
			.addToolbarTo("atchEditList", "tlbAtchList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProjectList", {dc: "project"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports().addSeparator().addSeparator().addTitle({text: "Projects"})
			.end()
			.beginToolbar("tlbProjectEdit", {dc: "project"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addReports().addSeparator().addSeparator().addTitle({text: "Project"})
			.end()
			.beginToolbar("tlbVersionEditList", {dc: "version"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Versions"})
			.end()
			.beginToolbar("tlbComponentEditList", {dc: "component"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Components"})
			.end()
			.beginToolbar("tlbMemberEditList", {dc: "member"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Team"})
			.end()
			.beginToolbar("tlbAtchList", {dc: "atch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Attachments"})
			.end()
			;
	}

	
	,onBtnRoadmapUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.IssueRoadmap_UI";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
			targetVersionId: this._getDc_("version").getRecord().get("id"),
			targetVersion: this._getDc_("version").getRecord().get("name"),
			projectId: this._getDc_("version").getRecord().get("projectId"),
			project: this._getDc_("version").getRecord().get("project")
			},
			callback: function (params) {
				this._when_called_to_query_(params);
			}
		});
	}
	
	,onBtnChangelogUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.IssueChangelog_UI";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
			fixedInVersion: this._getDc_("version").getRecord().get("id"),
			fixedInVersion: this._getDc_("version").getRecord().get("name"),
			projectId: this._getDc_("version").getRecord().get("projectId"),
			project: this._getDc_("version").getRecord().get("project")
			},
			callback: function (params) {
				this._when_called_to_query_(params);
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
