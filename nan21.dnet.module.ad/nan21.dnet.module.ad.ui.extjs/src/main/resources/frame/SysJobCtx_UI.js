/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */

Dnet.doImport(["nan21.dnet.module.ad.ui.extjs/ds/SysTimerDs", "nan21.dnet.module.ad.ui.extjs/lov/SysJob", "nan21.dnet.module.ad.ui.extjs/dc/SysJobCtxParam", "nan21.dnet.module.ad.ui.extjs/ds/SysJobCtxDs", "nan21.dnet.module.ad.ui.extjs/dc/SysTimer", "nan21.dnet.module.ad.ui.extjs/dc/SysJobCtx", "nan21.dnet.module.ad.ui.extjs/ds/SysJobCtxParamDs", "nan21.dnet.module.ad.ui.extjs/ds/SysJobLovDs"]);

Ext.define("net.nan21.dnet.module.ad.system.frame.SysJobCtx_UI", {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.net.nan21.dnet.module.ad.system.frame.SysJobCtx_UI",
	_name_: "net.nan21.dnet.module.ad.system.frame.SysJobCtx_UI"

	,_defineDcs_: function() {
		this._getBuilder_()
			.addDc("job", new net.nan21.dnet.module.ad.system.dc.SysJobCtx({multiEdit:true}))
			.addDc("params", new net.nan21.dnet.module.ad.system.dc.SysJobCtxParam({multiEdit:true}))
			.addDc("schedule", new net.nan21.dnet.module.ad.system.dc.SysTimer({}))
	
			.linkDc("params", "job",{fields:[
				{childField:"jobCtxId", parentField:"id"}]}
			)
			.linkDc("schedule", "job",{fields:[
				{childField:"jobCtxId", parentField:"id"}]}
			)
	}

	,_defineElements_: function() {
		this._getBuilder_()
			
			.addDcFilterFormView("job", {name:"jobFilter", height:80, xtype:"ad_system_dc_SysJobCtx$Filter"})	
			.addDcEditGridView("job", {name:"jobEditList", xtype:"ad_system_dc_SysJobCtx$EditList", frame:true})	
			.addDcEditGridView("params", {name:"paramsEditList", title:"Parameter values", xtype:"ad_system_dc_SysJobCtxParam$CtxEditList", frame:true})	
			.addDcGridView("schedule", {name:"scheduleEditList", title:"Execution schedule", xtype:"ad_system_dc_SysTimer$CtxListJob"})	
			.addPanel({name:"main", layout:"card", activeItem:0})
			.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
			.addPanel({name:"theDetails", width:600, layout:"accordion", activeItem:0})
			
	}
	
	,_linkElements_: function() {
		this._getBuilder_()
			.addChildrenTo("main", ["canvas1"])
			.addChildrenTo("canvas1", ["jobFilter", "jobEditList", "theDetails"], ["north", "center", "east"])
			.addChildrenTo("theDetails", ["paramsEditList", "scheduleEditList"])
			.addToolbarTo("canvas1", "tlbJobEditList")
			.addToolbarTo("paramsEditList", "tlbParamsEditList")
			.addToolbarTo("scheduleEditList", "tlbScheduleEditList")
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbJobEditList", {dc: "job"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports().addSeparator().addSeparator().addTitle({text: "Job context"})
			.end()
			.beginToolbar("tlbParamsEditList", {dc: "params"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Parameter values"})
			.end()
			.beginToolbar("tlbScheduleEditList", {dc: "schedule"}).addQuery()
			.addDeleteSelected()
			.addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({text: "Execution schedule"})
			.end()
	}

});
