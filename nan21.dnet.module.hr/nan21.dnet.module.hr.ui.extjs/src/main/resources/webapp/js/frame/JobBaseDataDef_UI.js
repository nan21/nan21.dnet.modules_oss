/* 
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

Ext.define("net.nan21.dnet.module.hr.job.frame.JobBaseDataDef_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.hr.job.frame.JobBaseDataDef_UI",
	_name_: "net.nan21.dnet.module.hr.job.frame.JobBaseDataDef_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("jobType", new net.nan21.dnet.module.hr.job.dc.JobType({multiEdit:true}))
			.addDc("wrType", new net.nan21.dnet.module.hr.job.dc.WorkRequirementType({multiEdit:true}))
			.addDc("wr", new net.nan21.dnet.module.hr.job.dc.WorkRequirement({multiEdit:true}))
	
			;
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("jobType", {name:"jobTypeFilter", height:80, xtype:"hr_job_dc_JobType$Filter"})
			.addDcEditGridView("jobType", {name:"jobTypeEditList", xtype:"hr_job_dc_JobType$EditList", frame:true})
			.addDcFilterFormView("wrType", {name:"wrTypeFilter", height:80, xtype:"hr_job_dc_WorkRequirementType$Filter"})
			.addDcEditGridView("wrType", {name:"wrTypeEditList", xtype:"hr_job_dc_WorkRequirementType$EditList", frame:true})
			.addDcFilterFormView("wr", {name:"wrFilter", height:80, xtype:"hr_job_dc_WorkRequirement$Filter"})
			.addDcEditGridView("wr", {name:"wrEditList", xtype:"hr_job_dc_WorkRequirement$EditList", frame:true})
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvasJobType", title:"Job types", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasWrType", title:"Work requirement types", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"canvasWr", title:"Work requirement", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
						listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);  } }}
				})
			.addToc(["canvasJobType","canvasWr","canvasWrType"]);
			this._mainViewName_  = "_main_with_toc_";
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvasJobType", "canvasWr", "canvasWrType"])
			.addChildrenTo("canvasJobType", ["jobTypeFilter", "jobTypeEditList"], ["north", "center"])
			.addChildrenTo("canvasWrType", ["wrTypeFilter", "wrTypeEditList"], ["north", "center"])
			.addChildrenTo("canvasWr", ["wrFilter", "wrEditList"], ["north", "center"])
			.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
			.addToolbarTo("canvasJobType", "tlbJobType")
			.addToolbarTo("canvasWrType", "tlbWrType")
			.addToolbarTo("canvasWr", "tlbWr")
			;
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbJobType", {dc: "jobType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Job types"})
			.end()
			.beginToolbar("tlbWrType", {dc: "wrType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Work requirement types"})
			.end()
			.beginToolbar("tlbWr", {dc: "wr"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Work requirement"})
			.end()
			;
	}

});
