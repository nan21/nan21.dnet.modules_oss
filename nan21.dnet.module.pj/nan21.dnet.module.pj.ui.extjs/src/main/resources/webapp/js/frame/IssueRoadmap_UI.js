/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.pj.ui.extjs/lov/ProjectVersions", "nan21.dnet.module.pj.ui.extjs/lov/IssueTypes", "nan21.dnet.module.pj.ui.extjs/ds/ProjectLovDs", "nan21.dnet.module.pj.ui.extjs/dc/IssueRoadmap", "nan21.dnet.module.pj.ui.extjs/ds/IssueRoadmapDs", "nan21.dnet.module.pj.ui.extjs/ds/IssueTypeLovDs", "nan21.dnet.module.pj.ui.extjs/ds/IssueStatusLovDs", "nan21.dnet.module.pj.ui.extjs/lov/Projects", "nan21.dnet.module.pj.ui.extjs/dc/Issue", "nan21.dnet.module.pj.ui.extjs/lov/IssueStatus", "nan21.dnet.module.pj.ui.extjs/ds/ProjectVersionLovDs", "nan21.dnet.module.pj.ui.extjs/ds/IssueDs"]);

Ext.define("net.nan21.dnet.module.pj.md.frame.IssueRoadmap_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.pj.md.frame.IssueRoadmap_UI",
	_name_: "net.nan21.dnet.module.pj.md.frame.IssueRoadmap_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("issue", new net.nan21.dnet.module.pj.md.dc.IssueRoadmap({}))
			.addDc("issueInfo", new net.nan21.dnet.module.pj.md.dc.Issue({}))
	
			.linkDc("issueInfo", "issue",{fetchMode:"auto",fields:[
				{childField:"id", parentField:"id"}]}
			)
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			.addButton({name:"btnIssueUi", text:"Edit issue", tooltip:"Show current issue in editor frame", disabled:true,
					handler: this.onBtnIssueUi, scope:this, stateManager:{name:"selected_one", dc:"issue" }})
			
			.addDcFilterFormView("issue", {name:"issueFilter", height:80, xtype:"pj_md_dc_IssueRoadmap$Filter"})
			.addDcGridView("issue", {name:"issueList", xtype:"pj_md_dc_IssueRoadmap$List"})
			.addPanel({name:"detailsTab", height:200, xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false})
			.addDcFormView("issueInfo", {name:"issueInfoView", title:"Issue Info", xtype:"pj_md_dc_Issue$View"})
			.addDcFormView("issueInfo", {name:"issueDescView", title:"Issue Description", xtype:"pj_md_dc_Issue$ViewDescription"})
			.addPanel({name:"main", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("detailsTab", ["issueInfoView", "issueDescView"])
			.addChildrenTo("main", ["issueFilter", "issueList", "detailsTab"], ["north", "center", "south"])
			.addToolbarTo("main", "tlbIssueList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbIssueList", {dc: "issue"}).addQuery()
			.addSeparator().addSeparator().addButtons([this._elems_.get("btnIssueUi") ]).addReports().addSeparator().addSeparator().addTitle({text: "Roadmap"})
			.end()
			;
	}

	
	,onBtnIssueUi: function() {
		var bundle = "nan21.dnet.module.pj.ui.extjs";
		var frame = "net.nan21.dnet.module.pj.md.frame.Issues_UI";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
			code: this._getDc_("issue").getRecord().get("code"),
			projectId: this._getDc_("issue").getRecord().get("projectId"),
			project: this._getDc_("issue").getRecord().get("project")
			},
			callback: function (params) {
				this._when_called_to_edit_(params);
			}
		});
	}
	
	,_when_called_to_query_: function(params) {
		
				var issue = this._getDc_("issue");
				issue.doClearQuery();
				issue.setFilterValue("targetVersionId", params.targetVersionId );
				issue.setFilterValue("targetVersion", params.targetVersion );
				issue.setFilterValue("projectId", params.projectId );
				issue.setFilterValue("project", params.project );
				issue.doQuery();
	}
});
