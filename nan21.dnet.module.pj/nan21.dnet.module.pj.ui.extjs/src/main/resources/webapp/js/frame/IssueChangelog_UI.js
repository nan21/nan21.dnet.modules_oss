/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.pj.md.frame.IssueChangelog_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.pj.md.frame.IssueChangelog_UI",
	_name_: "net.nan21.dnet.module.pj.md.frame.IssueChangelog_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("issue", new net.nan21.dnet.module.pj.md.dc.IssueChangelog({}))
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
			
			.addDcFilterFormView("issue", {name:"issueFilter", height:80, xtype:"pj_md_dc_IssueChangelog$Filter"})
			.addDcGridView("issue", {name:"issueList", xtype:"pj_md_dc_IssueChangelog$List"})
			.addDcFormView("issueInfo", {name:"infoView", height:200, xtype:"pj_md_dc_Issue$View"})
			.addPanel({name:"main", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["issueFilter", "issueList", "infoView"], ["north", "center", "south"])
			.addToolbarTo("main", "tlbIssueList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbIssueList", {dc: "issue"}).addQuery()
			.addSeparator().addSeparator().addButtons([this._elems_.get("btnIssueUi") ]).addReports().addSeparator().addSeparator().addTitle({text: "Changelog"})
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
				issue.setFilterValue("fixedInVersionId", params.fixedInVersionId );
				issue.setFilterValue("fixedInVersion", params.fixedInVersion );
				issue.setFilterValue("projectId", params.projectId );
				issue.setFilterValue("project", params.project );
				issue.doQuery();
	}
});
