/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.pj.md.frame.IssuesMnt_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.pj.md.frame.IssuesMnt_UI",
	_name_: "net.nan21.dnet.module.pj.md.frame.IssuesMnt_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("issue", new net.nan21.dnet.module.pj.md.dc.IssueMnt({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("issue", {name:"issueFilter", xtype:"pj_md_dc_IssueMnt$Filter"})
			.addDcEditGridView("issue", {name:"issueList", xtype:"pj_md_dc_IssueMnt$EditList", frame:true})
			.addDcFormView("issue", {name:"issueViewText", title:"Description", height:120, xtype:"pj_md_dc_IssueMnt$EditText", collapsible:true, collapsed:true
			})
			.addPanel({name:"main", layout:"border", defaults:{split:true}})
			;
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["issueFilter", "issueList", "issueViewText"], ["north", "center", "south"])
			.addToolbarTo("main", "tlbIssueList")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbIssueList", {dc: "issue"}).addQuery().addSave().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Issue maintenance"})
			.end()
			;
	}

});
